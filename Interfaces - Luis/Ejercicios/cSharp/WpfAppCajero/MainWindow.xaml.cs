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

namespace WpfAppCajero
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        Cajero cajero = new Cajero();
        String numIntroducido;
        int totalDinero;
        int[] billetes = {200, 100, 50, 20, 10};
        int[] cantidad = {10, 20, 30, 40, 50};
        int numCalculo;
        int dineroDisponible;

        public MainWindow()
        {
            InitializeComponent();
            botonRecoger.IsEnabled = false;
        }

        private void Digitos_Click(object sender, RoutedEventArgs e)
        {
            Button boton = sender as Button;

            String num = boton.Content.ToString();
            numIntroducido = numIntroducido + num;
            if (textBlockDisplay.Text.StartsWith("Introduzca su PIN: "))
            {
                textBlockDisplay.Text = textBlockDisplay.Text + "*";
            }
            else
            {
                textBlockDisplay.Text = textBlockDisplay.Text + num;
            }
        }

        private void botonBorrar_Click(object sender, RoutedEventArgs e)
        {
            if (textBlockDisplay.Text.StartsWith("Introduzca su PIN: "))
            {
                textBlockDisplay.Text = "Introduzca su PIN: ";
                numIntroducido = "";
            }
            else
            {
                textBlockDisplay.Text = "Introduzca Cantidad: ";
                numIntroducido = "";
                numCalculo = 0;
            }
        }

        private void botonOk_Click(object sender, RoutedEventArgs e)
        {
            if (textBlockDisplay.Text.StartsWith("Introduzca su PIN: "))
            {
                if (cajero.pin == numIntroducido)
                {
                    textBlockDisplay.Text = "Introduzca Cantidad: ";
                    numIntroducido = "";
                    lbBilletes.Items.Clear();
                    for (int j = 0; j < cantidad.Length; j++)
                    {
                        lbBilletes.Items.Add($"{cantidad[j]} de {billetes[j]}");
                    }
                }
                else
                {
                    numIntroducido = "";
                    textBlockDisplay.Text = "Introduzca su PIN: ";
                }
            }
            else
            {
                operacionDinero();
            }
        }

        private void operacionDinero()
        {
            numCalculo = int.Parse(numIntroducido);
            int numControl = numCalculo;
            int suma=0;
            int i = 0;
            int[] contBilletes = {0,0,0,0,0};
            dineroDisponible = calcDineroDisponible();

            if (dineroDisponible>=numCalculo && textBlockDisplay.Text.EndsWith('0'))
            {
                while (suma != numCalculo)
                {
                    dineroDisponible = calcDineroDisponible();

                    if (billetes[i] <= numControl && cantidad[i] > 0)
                    {
                        numControl = numControl - billetes[i];
                        suma = suma + billetes[i];
                        contBilletes[i]++;
                        cantidad[i]--;
                    }
                    else
                    {
                        i++;
                    }


                }
                numCalculo = 0;

                listBoxResultado.Items.Clear();
                for (int j = 0; j < contBilletes.Length; j++)
                {
                    listBoxResultado.Items.Add($"{contBilletes[j]} de {billetes[j]}");
                }

                lbBilletes.Items.Clear();
                for (int j = 0; j < cantidad.Length; j++)
                {
                    lbBilletes.Items.Add($"{cantidad[j]} de {billetes[j]}");
                }

                botonRecoger.IsEnabled = true;

            }
            else
            {
                listBoxResultado.Items.Clear();
                listBoxResultado.Items.Add("Cantidad NO disponible");
            }

        }

        private int calcDineroDisponible()
        {
            int[] billetes = { 200, 100, 50, 20, 10 };
            int[] cantidad = { 10, 20, 30, 40, 50 };
            int result = 0;

            for (int i = 0; i < billetes.Length; i++)
            {
                result = result + (billetes[i] * cantidad[i]);
            }

            return result;

        }

        private void botonRecoger_Click(object sender, RoutedEventArgs e)
        {

            listBoxResultado.Items.Clear();
            textBlockDisplay.Text = "Introduzca Cantidad: ";
            numIntroducido = "";

            botonRecoger.IsEnabled = false;

        }
    }
}