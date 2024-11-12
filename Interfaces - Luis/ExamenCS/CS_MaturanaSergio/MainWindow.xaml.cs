using System;
using System.Diagnostics;
using System.Drawing;
using System.Runtime.ConstrainedExecution;
using System.Text;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Controls.Primitives;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Animation;
using System.Windows.Media.Imaging;
using System.Windows.Media.Media3D;
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace CS_MaturanaSergio
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {

        private Surtidor surtidor;

        public MainWindow()
        {
            InitializeComponent();
            surtidor = new Surtidor(1.4, 0.005);
            buttonDesColgar.IsEnabled = false;
            buttonSurtir.IsEnabled = false;
            buttonMas10.IsEnabled = false;
            buttonMas1.IsEnabled = false;
            surtidor.CambioLitros += Surtidor_CambioLitros;
            surtidor.TopeAlcanzado += Surtidor_TopeAlcanzado;
            buttonSurtir.Click += buttonSurtir_Click;
        }

        private void Surtidor_TopeAlcanzado(object? sender, EventArgs e)
        {
            buttonSurtir.IsEnabled = false;
            buttonDesColgar.IsChecked = false;
        }

        private void Surtidor_CambioLitros(object? sender, EventArgs e)
        {
            textBoxLitros.Text = $"{surtidor.Litros} l.";
            textBoxImporte.Text = $"{surtidor.Importe:C}";
        }

        private void buttonIniciar_Click(object sender, RoutedEventArgs e)
        {
            surtidor = new Surtidor(1.4, 0.005);
            surtidor.Iniciar();
            textBoxPrecio.Text = $"{surtidor.Precio:C}/l.";
            buttonDesColgar.IsEnabled = true;
            buttonMas10.IsEnabled = true;
            buttonMas1.IsEnabled = true;
            buttonIniciar.IsEnabled = false;
            
        }

        private void buttonDesColgar_Checked(object sender, RoutedEventArgs e)
        {
            buttonSurtir.IsEnabled = true;
            buttonDesColgar.Content = "Colgar";

        }

        private void buttonDesColgar_Unchecked(object sender, RoutedEventArgs e)
        {
            buttonSurtir.IsEnabled = false;
            buttonDesColgar.Content = "Descolgar";
        }

        private void buttonSurtir_Click(object sender, RoutedEventArgs e)
        {
            surtidor.Surtir();
            Surtidor_CambioLitros(null, null);
            if (surtidor.Importe >= surtidor.Tope)
            {
                Surtidor_TopeAlcanzado(null, null);
            }
        }

        private void buttonMas1_Click(object sender, RoutedEventArgs e)
        {
            surtidor.Tope += 1;
            textBoxImporte.Text = $"{surtidor.Tope:C}";

        }

        private void buttonMas10_Click(object sender, RoutedEventArgs e)
        {
            surtidor.Tope += 10;
            textBoxImporte.Text = $"{surtidor.Tope:C}";
        }
    }
}