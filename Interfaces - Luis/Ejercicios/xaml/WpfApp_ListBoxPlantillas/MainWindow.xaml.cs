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

namespace WpfApp_ListBoxPlantillas
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {

        public List<Persona> ListaPersona = new();

        public MainWindow()
        {
            InitializeComponent();
            CargarPersonas(); // servicio de recupersacion de datos
            LlenarListBox();
        }

        private void CargarPersonas()
        {
            ListaPersona.Add(new Persona { Nombre = "Mr. Bean", Telefono = "123456789", Foto = "Caricaturas/mrbean.jpg" });
            ListaPersona.Add(new Persona { Nombre = "Perro Sanxe", Telefono = "987654321", Foto = "Caricaturas/perro.jpg" });
            ListaPersona.Add(new Persona { Nombre = "Snoop Dog", Telefono = "567894321", Foto = "Caricaturas/snoopdog.jpg" });
            ListaPersona.Add(new Persona { Nombre = "Will Smith", Telefono = "543216789", Foto = "Caricaturas/will.jpg" });

        }

        private void LlenarListBox()
        {
            //listBoxPersonas.DisplayMemberPath = "Nombre";

            /*
            foreach (Persona persona in ListaPersona)
            {
                listBoxPersonas.Items.Add(persona);
            }
            */

            listBoxPersonas.ItemsSource = ListaPersona;

        }

        private void listBoxPersonas_SelectionChanged(object sender, SelectionChangedEventArgs e)
        {
            if (listBoxPersonas.SelectedIndex >= 0)
            {
                Persona persona = listBoxPersonas.SelectedItem as Persona;
                BitmapImage bitmapImage = new BitmapImage();
                bitmapImage.BeginInit();
                bitmapImage.UriSource = new Uri(persona.Foto, UriKind.Relative);
                bitmapImage.EndInit();
                imageFoto.Source = bitmapImage;
            }
        }
    }
}