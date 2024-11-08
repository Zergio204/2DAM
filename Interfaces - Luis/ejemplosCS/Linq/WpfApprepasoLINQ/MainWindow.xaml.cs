using System;
using System.Collections.Generic;
using System.Linq;
using System.Windows;
using System.Windows.Data;

namespace WpfApprepasoLINQ
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        int[] puntuaciones = { 90, 71, 82, 93, 75, 82 };
        //Datos Datos;
        //List<Cliente> TablaClientes;

        public MainWindow()
        {
            InitializeComponent();
        }



        private void Button_Click(object sender, RoutedEventArgs e)
        {
            var resultado =
                from puntuacion in puntuaciones
                where puntuacion > 80
                orderby puntuacion descending
                select $".....{puntuacion}";
            MostrarResultado(resultado);
        }

        /*
        void MostrarResultado(IEnumerable<string> resultado)
        {
            lbResultados.Items.Clear();
            foreach (string elemento in resultado)
                lbResultados.Items.Add(elemento);
        }*/
        void MostrarResultado<T>(IEnumerable<T> resultado)
        {
            lbResultados.Items.Clear();
            foreach (T elemento in resultado)
                lbResultados.Items.Add(elemento);
        }

        private void Button_Click_1(object sender, RoutedEventArgs e)
        {
            var Resultado = puntuaciones
                .Where<int>(p => p > 80)
                .OrderByDescending(p => p);
            MostrarResultado(Resultado);
        }

        private void Button_Click_2(object sender, RoutedEventArgs e)
        {
            var consulta =
                from cliente in Datos.GetClientes()
                select cliente;
            MostrarResultado (consulta);
        }

        private void Button_Click_3(object sender, RoutedEventArgs e)
        {
            int i = 0;
            var ConsultaClientes = from cliente in Datos.GetClientes()
                                   select new
                                   {
                                       Indice = ++i,
                                       Nombre = cliente.Nombre,
                                       TotalCompras = $"{cliente.TotalCompras:C}"
                                   };
            //MostrarResultado(ConsultaClientes);

            //var ConsultaNombreCuenta = TablaClientes.Select((c, i) =>
            //new { Indice = i, Nombre = c.Nombre, TotalCompras = c.TotalCompras.ToString("C") });

            lbResultados.Items.Clear();
            foreach (var vista in ConsultaClientes)
                lbResultados.Items.Add
                    ($"{vista.Indice} - {vista.Nombre} >> {vista.TotalCompras}");

        }

        private void Button_Click_4(object sender, RoutedEventArgs e)
        {
            var ConsultaNombreCuenta = from cliente in Datos.GetClientes()
                                       select $"{cliente.Nombre} >> {cliente.TotalCompras:C}";
            MostrarResultado(ConsultaNombreCuenta);

        }

        private void Button_Click_5(object sender, RoutedEventArgs e)
        {
            Double TotalCuentas = Datos.GetClientes().Sum<Cliente>(c => c.TotalCompras);
            Double Total = (from c in Datos.GetClientes()
                            select c.TotalCompras).Sum();
            tbResultado.Text = TotalCuentas.ToString("C") + "<=>" + Total.ToString("C");
        }

        private void Button_Click_6(object sender, RoutedEventArgs e) //Agrupar clientes por localidad
        {
            var ConsultaAgrupada = from c in Datos.GetClientes()
                                   group c by c.Localidad;
            lbResultados.Items.Clear();
            /* en el foreach string es la Localidad, 
               es decir la key del diccionario con el resultado de la consulta */
            foreach (IGrouping<string, Cliente> agrupacionLocalidad in ConsultaAgrupada)
            {
                lbResultados.Items.Add(agrupacionLocalidad.Key);
                foreach (Cliente cliente in agrupacionLocalidad)
                    lbResultados.Items.Add($"\t {cliente.Nombre}");
            }
        }

        private void Button_Click_7(object sender, RoutedEventArgs e) // Ordenar clientes por totalCompras
        {
            var r = from cliente in Datos.GetClientes()
                    orderby cliente.TotalCompras descending
                    select cliente;
            lbResultados.Items.Clear();
            foreach (Cliente c in r)
                lbResultados.Items.Add($"{c.Nombre,-10}\t{c.TotalCompras,+12:C}");

        }

        private void Button_Click_8(object sender, RoutedEventArgs e) //Totalizar compras por localidad (ordenadas)
        {
            lbResultados.Items.Clear();
            /*
            var r = (from c in Datos.GetClientes()
                     group c by c.Localidad into localidad
                     select new
                     {
                         Localidad = localidad.Key,
                         Total = localidad.Sum<Cliente>(l => l.TotalCompras)
                     } into x
                     orderby x.Total descending
                     select x);
            */
            var r = (from c in Datos.GetClientes()
                     group c by c.Localidad into agrupacionLocalidad
                     select new
                     {
                         Localidad = agrupacionLocalidad.Key,
                         Total = agrupacionLocalidad.Sum<Cliente>(l => l.TotalCompras)
                     }).OrderByDescending(x => x.Total);

            foreach (var cl in r)
                lbResultados.Items.Add($"{cl.Localidad,-10}\t{cl.Total,+12:C}");
        }

        private void Button_Click_9(object sender, RoutedEventArgs e) //detalle de pedidos
        {
            lbResultados.Items.Clear();
            var r = from p in Datos.GetPedidos()
                    join a in Datos.GetArticulos() on p.IdArticulo equals a.IdArticulo
                    join c in Datos.GetClientes() on p.IdCliente equals c.IdCliente
                    select new
                    {
                        Pedido = p.IdPedido,
                        Fecha = p.Fecha,
                        Cliente = c.Nombre,
                        c.IdCliente,
                        Descripcion = a.Descripcion,
                        Cantidad = p.Cantidad,
                        Importe = a.Precio * p.Cantidad,
                        Localidad = c.Localidad
                    } into consulta
                    group consulta by new { consulta.Localidad, consulta.Cliente };
            /*into agrupacion
                select new
                {
                    Grupo = agrupacion.Key,
                    Valores = agrupacion.ToList()
                };
            foreach (var x in r)
            {
                lbResultados.Items.Add(x.Grupo);
                foreach (var y in x.Valores)
                {
                    lbResultados.Items.Add($"\t{y.Fecha,35:D}:{y.Importe,10:C}");
                }
            }*/

            //mostrar el resultado agrupado:
            foreach (var grupo in r)
            {
                lbResultados.Items.Add($"{grupo.Key.Cliente} ({grupo.Key.Localidad})");
                foreach (var fila in grupo)
                    lbResultados.Items.Add($"\t{fila.Fecha,35:D}:{fila.Importe,10:C}");
            }

            //segunda forma:
            lbResultados.Items.Add("-------------------------");
            var r2 = from p in Datos.Pedidos
                     join a in Datos.Articulos on p.IdArticulo equals a.IdArticulo
                     join c in Datos.Clientes on p.IdCliente equals c.IdCliente
                     select new Vista
                     {
                         Fecha = p.Fecha,
                         Cliente = c.Nombre,
                         Importe = a.Precio * p.Cantidad,
                         Localidad = c.Localidad
                     } into nivel1
                     group nivel1 by nivel1.Localidad into grupoLocalidad
                     from nivel2 in (from nivel1 in grupoLocalidad group nivel1 by nivel1.Cliente)
                     group nivel2 by grupoLocalidad.Key;

            foreach (var grupo1 in r2)
            {
                lbResultados.Items.Add($"{grupo1.Key}");
                foreach (var nivel2 in grupo1)
                {
                    lbResultados.Items.Add($"\t{nivel2.Key}");
                    foreach (var fila in nivel2)
                        lbResultados.Items.Add($"\t\t{fila.Fecha:D}...{fila.Importe:C}");
                }
            }

            //tercera forma:
            lbResultados.Items.Add("-------------------------");


            var r3 = from p in Datos.Pedidos
                     join a in Datos.Articulos on p.IdArticulo equals a.IdArticulo
                     join c in Datos.Clientes on p.IdCliente equals c.IdCliente
                     orderby c.Localidad, c.Nombre
                     select new
                     {
                         Fecha = p.Fecha,
                         Cliente = c.Nombre,
                         Importe = a.Precio * p.Cantidad,
                         Localidad = c.Localidad
                     };
            foreach (var x in r3.GroupBy(x => x.Localidad))
            {
                lbResultados.Items.Add(x.Key);
                foreach (var y in x.GroupBy(y => y.Cliente))
                {
                    lbResultados.Items.Add($"\t{y.Key}");
                    foreach (var z in y)
                    {
                        lbResultados.Items.Add($"\t\t{z.Fecha:d} {z.Importe:c}");
                    }
                    lbResultados.Items.Add($"\tTotal...\t{y.Sum(a => a.Importe):c}");
                }
            }

            //utilizando el listView y la sintaxis de métodos:

            lvResultados.Visibility = Visibility.Visible;
            lvResultados.ItemsSource =
                Datos.Pedidos.Join
                    (Datos.Articulos, x => x.IdArticulo, y => y.IdArticulo,
                (x, y) => new
                {
                    Fecha = x.Fecha.ToShortDateString(),
                    Importe = x.Cantidad * y.Precio,
                    x.IdCliente
                }).
                Join(Datos.Clientes, a => a.IdCliente, b => b.IdCliente,
                (a, b) => new
                {
                    a.Fecha,
                    a.Importe,
                    b.Localidad,
                    Cliente = b.Nombre
                });

            CollectionView view = (CollectionView)CollectionViewSource.GetDefaultView(lvResultados.ItemsSource);
            PropertyGroupDescription groupDescription = new PropertyGroupDescription("Localidad");
            PropertyGroupDescription groupDescription2 = new PropertyGroupDescription("Cliente");
            view.GroupDescriptions.Add(groupDescription);
            view.GroupDescriptions.Add(groupDescription2);

        }

        private void Button_Click_10(object sender, RoutedEventArgs e) //totalizar importes de pedidos por cliente
        {

            lbResultados.Items.Clear();
            var r = from p in Datos.Pedidos
                    join a in Datos.Articulos on p.IdArticulo equals a.IdArticulo
                    join c in Datos.Clientes on p.IdCliente equals c.IdCliente
                    select new
                    {
                        p.IdPedido,
                        c.Nombre,
                        c.IdCliente,
                        Importe = p.Cantidad * a.Precio
                    } into pc
                    group pc by pc.IdCliente into grupo
                    select new
                    {
                        Id = grupo.Key,
                        Cliente = grupo.First(g => g.IdCliente==grupo.Key),
                        NombreCliente=grupo.Select(x=>x.Nombre).First(),
                        Values = grupo.ToArray(),
                        Total = grupo.Sum(g => g.Importe)
                    };

            foreach (var grupo in r)
            {
                lbResultados.Items.Add($"{grupo.NombreCliente}" +
                    $"({grupo.Cliente.Nombre})={grupo.Total}");
                foreach(var c in grupo.Values)
                    lbResultados.Items.Add(c);
            }

        }
    }
}
