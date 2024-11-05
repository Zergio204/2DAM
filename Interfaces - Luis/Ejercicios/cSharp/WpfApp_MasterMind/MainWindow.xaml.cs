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

namespace WpfApp_MasterMind
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
            generarSolucion();
            //Ver la solucion (Para hacer pruebas)
            //MessageBox.Show($"La solución es: {string.Join("", solucion)}");
        }

        
        Random r = new();
        int[] solucion = new int[4];


        //Seria mejor hacer una Cadena con los numeros del 0 al 9, desordenarla y coger los 4 primeros
        public void generarSolucion()
        {
            solucion = new int[4];
            for (int i=0; i < 4;)
            {
                int aleatorio=r.Next(1,10);
                if(!solucion.Contains(aleatorio))
                {
                    solucion[i]=aleatorio;
                    i++;
                }
            }
            
        }

        private void Button_Click(object sender, RoutedEventArgs e)
        {
            Button b = sender as Button;
            String textoBoton = b.Content.ToString();
            if(TbPropuesto.Text.Length < 4){
                b.IsEnabled = false;

                TbPropuesto.Text = TbPropuesto.Text + textoBoton;
            }
            
        }

        private void BotComprobar_Click(object sender, RoutedEventArgs e)
        {
            int i = 0;
            int numEnTexto = 0;
            int numEnPosicion = 0;
            String muertosHeridos = "";
            String herido = "😀";
            String muerto = "🤑";

            while (i < solucion.Length)
            {
                if (solucion.Contains(TbPropuesto.Text[i] - 48))
                {
                    numEnTexto++;
                    if (solucion[i] == TbPropuesto.Text[i] - 48)
                    {
                        numEnTexto--;
                        numEnPosicion++;
                    }
                }
                i++;
            }

            for (int j = 0; j < numEnTexto; j++)
            {
                muertosHeridos = muertosHeridos + herido;
            }
            for (int j = 0; j < numEnPosicion; j++)
            {
                muertosHeridos = muertosHeridos + muerto;
            }

            LbHistorial.Items.Add($"{TbPropuesto.Text} {muertosHeridos}");
            reiniciar_Botones();
            TbPropuesto.Text = "";

            if(numEnPosicion == 4)
            {
                MessageBox.Show("Felisidade","Mensaje Final",MessageBoxButton.OK,MessageBoxImage.Information);
                TbPropuesto.Text = "";
                reiniciar_Botones();
                LbHistorial.Items.Clear();
                generarSolucion();
            }
            
        }

        private void BotCancelar_Click(object sender, RoutedEventArgs e)
        {
            TbPropuesto.Text = "";
            reiniciar_Botones();
        }

        private void reiniciar_Botones()
        {
            for (int i = 0; i < 10; i++)
            {
                Button b = FindName("bot" + i) as Button;

                b.IsEnabled=true;
            }
        }

        private void BotOtro_Click(object sender, RoutedEventArgs e)
        {
            TbPropuesto.Text = "";
            reiniciar_Botones();
            LbHistorial.Items.Clear();
            generarSolucion();
        }

        //private void infoInicio()
        //{
        //    LbHistorial.Items.Add($"| Num |   | Herido |   | Muerto |");
        //}


    }
}