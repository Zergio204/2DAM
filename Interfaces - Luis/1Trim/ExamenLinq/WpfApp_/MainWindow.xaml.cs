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


namespace WpfApp_
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
                var impGeneral = 0.0;
                InitializeComponent();
                var informes = from clien in Datos.GetClientes()
                               join inte in Datos.GetIntervenciones() on clien.IdCliente equals inte.IdCliente
                               join serv in Datos.GetServicios() on inte.IdServicio equals serv.IdServicio
                               orderby clien.Apellidos, clien.Nombre
                               select new
                               {
                                   Apellidos = clien.Apellidos,
                                   Nombre = clien.Nombre,
                                   Domicilio = clien.Domicilio,
                                   FechaIntervencion = inte.Fecha,
                                   DescripcionServicio = serv.Descripcion,
                                   TiempoMinutos = inte.TiempoMinutos,
                                   Importe = inte.TiempoMinutos.TotalMinutes * serv.Precio
                               } into consulta
                               group consulta by new { consulta.Apellidos, consulta.Nombre, consulta.Domicilio };


            //Con el ListBox
            foreach (var i in informes)
            {
                var impLocal = 0.0;
                lb.Items.Add($"{i.Key.Apellidos}, {i.Key.Nombre} \t ({i.Key.Domicilio})");
                foreach (var fila in i)
                {
                    impLocal += fila.Importe;
                    lb.Items.Add($"\t \t{fila.FechaIntervencion.ToShortDateString()}\t{fila.DescripcionServicio}\t\t\t{fila.TiempoMinutos}\t\t\t{fila.Importe:C}");
                }
                lb.Items.Add($"\tTotal... {impLocal:C}");
                impGeneral += impLocal;
            }
            lb.Items.Add($"Total final... {impGeneral:C}");


            //Con el RichTextBox
            var parrafo = new Paragraph();
            foreach (var i in informes)
            {
                var impLocal = 0.0;
                var run2 = new Run($"{i.Key.Apellidos}, {i.Key.Nombre} \t ({i.Key.Domicilio})\n");
                run2.FontSize = 14;
                run2.FontWeight = FontWeights.Bold;
                parrafo.Inlines.Add(run2);
                foreach (var fila in i)
                {
                    impLocal += fila.Importe;
                    var run3 = new Run($"\t \t{fila.FechaIntervencion.ToShortDateString()}\t{fila.DescripcionServicio}\t\t\t{fila.TiempoMinutos}\t\t\t{fila.Importe:C}\n");
                    parrafo.Inlines.Add(run3);
                }
                var run4 = new Run($"\tTotal... {impLocal:C}\n\n");
                run4.FontSize = 12;
                run4.FontWeight = FontWeights.Bold;
                run4.Foreground = Brushes.LightBlue;
                parrafo.Inlines.Add(run4);
                impGeneral += impLocal;
            }
            var run5 = new Run($"Total final... {impGeneral:C}\n");
            run5.FontSize = 16;
            run5.FontWeight = FontWeights.Bold;
            run5.Foreground = Brushes.Red;
            parrafo.Inlines.Add(run5);
            rtb.Document.Blocks.Add(parrafo);

        }
    }
}