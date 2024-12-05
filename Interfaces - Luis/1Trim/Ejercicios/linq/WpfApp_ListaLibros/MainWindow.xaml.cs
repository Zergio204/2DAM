using System.IO;
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

namespace WpfApp_ListaLibros
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
            lvResultados.ItemsSource = LeerCSV();

            CollectionView view = (CollectionView)CollectionViewSource.GetDefaultView(lvResultados.ItemsSource);
            PropertyGroupDescription groupDescription = new PropertyGroupDescription("Autor");
            view.GroupDescriptions.Add(groupDescription);
        }

        private List<Libro> LeerCSV()
        {

            return (from l in File.ReadAllLines("Libros.csv")
                      let campos = l.Split(',')
                      select new Libro
                      {
                          ISBN = campos[0],
                          Titulo = campos[1],
                          Autor = campos[2],
                          Precio = campos[3]
                      }).OrderBy(Libro => Libro.Autor).ToList<Libro>();

            
        }

    }
}