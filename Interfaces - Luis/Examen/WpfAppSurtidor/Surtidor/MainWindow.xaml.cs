using System;
using System.Windows;
using System.Windows.Threading;

namespace Surtidor
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();

            surtidor = new TipoSurtidor(1.4, 0.005); //(precio litro,caudal)
            surtidor.CambioLitros += surtidor_cambioLitros;
            surtidor.TopeAlcanzado += surtidor_TopeAlcanzado;

            buttonSurtir.IsEnabled = false;
            buttonIniciar_Click(buttonIniciar, null); //simular pulsar botón Iniciar
        }

        TipoSurtidor surtidor;

        private void buttonIniciar_Click(object sender, RoutedEventArgs e)
        {
            surtidor.Iniciar();
            textBoxPrecio.Text =$"{surtidor.PRECIO:C}/l.";
            buttonSurtir.Click += buttonSurtir_Click;
        }

        void surtidor_TopeAlcanzado(object sender, EventArgs e)
        {
            buttonSurtir.Click -= buttonSurtir_Click;
        }

        void surtidor_cambioLitros(object sender, EventArgs e)
        {
            textBoxLitros.Text = surtidor.Litros.ToString("00.00l");
            textBoxImporte.Text = surtidor.Importe.ToString("C");
        }

        private void buttonMas10_Click(object sender, RoutedEventArgs e)
        {
            if (surtidor.Tope == double.MaxValue) surtidor.Tope = 0;
            surtidor.Tope += 10;
            textBoxImporte.Text =$"{surtidor.Tope:C}";
        }

        private void buttonMas1_Click(object sender, RoutedEventArgs e)
        {
            if (surtidor.Tope == double.MaxValue) surtidor.Tope = 0;
            surtidor.Tope++;
            textBoxImporte.Text = $"{surtidor.Tope:C}";
        }

        private void buttonDesColgar_Checked(object sender, RoutedEventArgs e)
        {
            buttonDesColgar.Content = "Colgar";
            buttonIniciar.IsEnabled = false;
            buttonMas10.IsEnabled = false;
            buttonMas1.IsEnabled = false;
            buttonSurtir.IsEnabled = true;
        }

        private void buttonDesColgar_Unchecked(object sender, RoutedEventArgs e)
        {
            buttonDesColgar.Content = "Descolgar";
            buttonIniciar.IsEnabled = true;
            buttonMas10.IsEnabled = true;
            buttonMas1.IsEnabled = true;
            buttonSurtir.IsEnabled = false;
        }

        private void buttonSurtir_Click(object sender, RoutedEventArgs e)
        {
            surtidor.Surtir();
        }
    }
}
