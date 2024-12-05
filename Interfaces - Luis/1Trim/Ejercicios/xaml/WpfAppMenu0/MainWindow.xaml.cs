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

namespace WpfAppMenu0
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
        }

        private void Button_Click(object sender, RoutedEventArgs e)
        {
            Application.Current.Shutdown();
        }

        private void BotonCerrarMenu_Click(object sender, RoutedEventArgs e)
        {
            BotonAbrirMenu.Visibility= Visibility.Visible;
            BotonCerrarMenu.Visibility= Visibility.Collapsed;
        }

        private void BotonAbrirMenu_Click(object sender, RoutedEventArgs e)
        {
            BotonCerrarMenu.Visibility = Visibility.Visible;
            BotonAbrirMenu.Visibility = Visibility.Collapsed;
        }
    }
}