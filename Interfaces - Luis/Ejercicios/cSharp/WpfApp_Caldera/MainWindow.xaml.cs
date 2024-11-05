using System.Drawing;
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

namespace WpfApp_Caldera
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        Caldera caldera = new Caldera();
        
        public MainWindow()
        {
            InitializeComponent();
            caldera.Temperatura_Change += Caldera_Temperatura_Change;
            caldera.Correcto += Caldera_Correcto;
            caldera.Alerta += Caldera_Alerta;
            caldera.Alarma += Caldera_Alarma;
            caldera.Apagar += Caldera_Apagar;

            iniciarCaldera();
        }

        private void Caldera_Temperatura_Change(object? sender, EventArgs e)
        {
            txtbTemperatura.Text = slider1.Value.ToString();
        }

        private void Caldera_Apagar(object? sender, EventArgs e)
        {
            lbInforme.Items.Add($"Apagar, {DateTime.Now}");
            slider1.Visibility = Visibility.Hidden;
            txtbTemperatura.Background = Brushes.Black;
            txtbTemperatura.Foreground = Brushes.White;
            MessageBox.Show("Maquina Apagada","Peligro", MessageBoxButton.OK, MessageBoxImage.Stop);
        }

        private void Caldera_Alarma(object? sender, EventArgs e)
        {
            lbInforme.Items.Add($"      Alarma: {caldera.Temperatura}º, {DateTime.Now}");
            txtbTemperatura.Background = Brushes.Red;
        }

        private void Caldera_Alerta(object? sender, EventArgs e)
        {
            lbInforme.Items.Add($"      Alerta: {caldera.Temperatura}º, {DateTime.Now}");
            txtbTemperatura.Background = Brushes.Gold;
        }

        private void Caldera_Correcto(object? sender, EventArgs e)
        {
            lbInforme.Items.Add($"      Correcta: {caldera.Temperatura}º, {DateTime.Now}");
            txtbTemperatura.Background = Brushes.Green;
        }

        private void slider1_ValueChanged(object sender, RoutedPropertyChangedEventArgs<double> e)
        {
            caldera.Temperatura = slider1.Value;

        }
        private void iniciarCaldera()
        {
            lbInforme.Items.Clear();
            lbInforme.Items.Add($"Inicio: {DateTime.Now}");
        }

        private void pararCaldera()
        {
            lbInforme.Items.Add($"Apagar: {DateTime.Now}");
            slider1.Visibility = Visibility.Hidden;
        }
    }
}