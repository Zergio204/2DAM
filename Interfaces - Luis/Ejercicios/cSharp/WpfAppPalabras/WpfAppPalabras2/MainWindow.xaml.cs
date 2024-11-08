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

namespace WpfApp_Palabras2
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        string[] palabras =  {
            "coliflor",
            "berenjena",
            "mosca",
            "baño",
            "estercolero",
            "zanahoria",
            "gusarapa",
            "pizza",
            "gaga",
            "estulticia",
            "cohecho" };
        Char[] alfabeto = { 'a','b','c','d','e','f','g','h','i','j','k','l','m','n','ñ','o','p','q','r','s','t','u','v','w','x','y','z' };
        int n = 0;
        String palabra;
        String solucion;
        StackPanel sp1;

        public MainWindow()
        {
            InitializeComponent();
            
            sp1 = new StackPanel
            {
                Orientation = Orientation.Horizontal,
                HorizontalAlignment = HorizontalAlignment.Center
            };


            grid1.Children.Add(sp1);

            foreach (var letra in alfabeto)
            {
                Button bLetra = new Button
                {
                    Content = letra.ToString(),
                    Margin = new Thickness(5),
                    Height = 30,
                    Width = 30
                };
                bLetra.Click += bLetra_Click;
                sp1.Children.Add(bLetra);
            }

        }

        private void botSiguiente_Click(object sender, RoutedEventArgs e)
        {
            n = n % palabras.Length;
            palabra = palabras[n].ToLower();
            solucion = new string('-', palabra.Length); // Cadena con guiones según la longitud de la palabra
            n++;

            tbPalabras.Text = solucion;

            //habilitar botones
            foreach (Button b in sp1.Children.OfType<Button>())
            {
                b.IsEnabled = true;
            }

        }

        private void bLetra_Click(object sender, RoutedEventArgs e)
        {
            Button b = sender as Button;
            string letra = b.Content.ToString().ToLower();

            b.IsEnabled = false;

            if (letra.Length > 0)
            {
                for (int i = 0; i < palabra.Length; i++)
                {
                    if (palabra[i] == letra[0])
                    {
                        solucion = solucion.Remove(i, 1).Insert(i, letra);
                    }
                }

                tbPalabras.Text = solucion;

                if (solucion == palabra)
                {
                    MessageBox.Show("¡Felicidades, has acertado!");
                }
            }
        }
    }
}