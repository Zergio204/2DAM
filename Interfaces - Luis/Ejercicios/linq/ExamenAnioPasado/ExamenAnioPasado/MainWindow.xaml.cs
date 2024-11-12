using System.Windows;

namespace ExamenAnioPasado{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window{
        public MainWindow(){
            var importeGeneral = 0.0;
            InitializeComponent();
            var informes = from c in Datos.GetClientes()
                           join i in Datos.GetIntervenciones() on c.IdCliente equals i.IdCliente
                           join s in Datos.GetServicios() on i.IdServicio equals s.IdServicio
                           select new{
                               Apellidos = c.Apellidos,
                               Nombre = c.Nombre,
                               Domicilio = c.Domicilio,
                               FechaIntervencion = i.Fecha,
                               DescripcionServicio = s.Descripcion,
                               TiempoMinutos = i.TiempoMinutos,
                               Importe = i.TiempoMinutos.TotalMinutes * s.Precio
                           } into consulta
                           group consulta by new { consulta.Apellidos, consulta.Nombre, consulta.Domicilio};

            foreach (var i in informes){
                var importeLocal = 0.0;
                lb.Items.Add($"{i.Key.Apellidos}, {i.Key.Nombre} \t ({i.Key.Domicilio})");
                foreach (var fila in i){
                    importeLocal += fila.Importe;
                    lb.Items.Add($"\t \t{fila.FechaIntervencion.ToShortDateString()}\t{fila.DescripcionServicio}\t\t\t{fila.TiempoMinutos}\t\t\t{fila.Importe:C}");
                }
                lb.Items.Add($"\tTotal... {importeLocal:C}");
                importeGeneral += importeLocal;
            }
            lb.Items.Add($"Total final... {importeGeneral:C}");
        }
    }
}