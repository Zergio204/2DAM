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

namespace WpfApp_Agua
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {

        Deposito deposito = new Deposito();

        public MainWindow()
        {
            InitializeComponent();
            deposito.Cantidad_Changed += Deposito_Cantidad_Changed;
            deposito.DepositoVacio += Deposito_DepositoVacio;
            deposito.Llenar(10);
        }

        private void Deposito_DepositoVacio(object? sender, EventArgs e)
        {
            botonBeber.IsEnabled = false;
        }

        private void Deposito_Cantidad_Changed(object? sender, EventArgs e)
        {
            pbDeposito.Value = deposito.Cantidad;
        }

        private void botonBeber_Click(object sender, RoutedEventArgs e)
        {
            deposito.Cantidad--;
        }

        private void botonLlenar_Click(object sender, RoutedEventArgs e)
        {
            deposito.Llenar(10);
            botonBeber.IsEnabled = true;
        }
    }
}