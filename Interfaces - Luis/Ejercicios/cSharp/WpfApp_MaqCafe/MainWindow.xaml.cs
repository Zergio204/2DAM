using System.Collections;
using System.Text;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace WpfApp_MaqCafe
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        Cajetin cajetin = new Cajetin();
        List<Producto> listaProductos = new List<Producto>();
        Double[] monedas = { 3, 2, 1, 0.5, 0.2, 0.3, 0.1 };
        public MainWindow()
        {
            InitializeComponent();
            generarListaProductos();
            colocarBotones();
            cajetin.TotalChange += Cajetin_TotalChange;
            cajetin.MonedaNoValida += Cajetin_MonedaNoValida;
            tbDispensador.MouseDown += TbDispensador_MouseDown;
            tbVuelta.MouseDown += TbVuelta_MouseDown;
        }

        private void TbVuelta_MouseDown(object sender, MouseButtonEventArgs e)
        {
            tbDisplay.Text = "";
            tbVuelta.Text = "";
            tbDispensador.Text = "";
        }

        private void TbDispensador_MouseDown(object sender, MouseButtonEventArgs e)
        {
            tbDisplay.Text = "";
            tbVuelta.Text = "";
            tbDispensador.Text = "";
        }

        private void Cajetin_MonedaNoValida(object? sender, EventArgs e)
        {
            tbVuelta.Text = cajetin.Devolver().ToString();
        }

        private void Cajetin_TotalChange(object? sender, EventArgs e)
        {
            tbDisplay.Text = cajetin.Total.ToString();
        }

        private void generarListaProductos()
        {
            Producto cafeSolo = new Producto("Cafe Solo", 0.8);
            Producto cafeCortado = new Producto("Cafe Cortado", 1);
            Producto chocolate = new Producto("Chocolate", 1);
            Producto te = new Producto("Té", 1.2);
            listaProductos.Add(cafeSolo);
            listaProductos.Add(cafeCortado);
            listaProductos.Add(chocolate);
            listaProductos.Add(te);

        }

        private void colocarBotones()
        {
            foreach (var producto in listaProductos)
            {
                Button b = new Button();
                b.Content = producto.NombreProducto;
                b.Height = 30;
                b.Width = 100;
                b.Click += bProducto_Click;

                spProductos.Children.Add(b);
            }

            foreach (var moneda in monedas)
            {
                Button b = new Button();
                b.Content = moneda;
                b.Height = 50;
                b.Width= 50;
                if (!cajetin.MonedasValidas.Contains(moneda))
                {
                    b.Foreground = Brushes.Red;
                }
                b.Click += bMoneda_Click;

                spMonedas.Children.Add(b);
            }

        }

        private void bProducto_Click(object sender, RoutedEventArgs e)
        {

            Button button = (Button)sender;
            Producto prodActual;

            foreach(var producto in listaProductos)
            {
                if (producto.NombreProducto == button.Content)
                {
                    prodActual = producto;

                    if (cajetin.Dispensar(prodActual.PrecioProducto))
                    {
                        tbDispensador.Text = prodActual.NombreProducto.ToString();
                        cajetin.Vuelta = cajetin.Total - prodActual.PrecioProducto;
                        tbVuelta.Text = cajetin.Devolver().ToString();
                        cajetin.Iniciar();
                    }


                    break;
                }
            }            

        }

        private void bMoneda_Click(object sender, RoutedEventArgs e)
        {
            Button b = (Button)sender;
            cajetin.Acumular((Double)b.Content);
        }
    }
}