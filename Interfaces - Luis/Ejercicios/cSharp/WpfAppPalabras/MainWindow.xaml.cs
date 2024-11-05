using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace WpfAppPalabras
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
            int n;
            string palabra;
            string solucion;

            public MainWindow()
            {
                InitializeComponent();

                //cargar lbPalabras (ListBox) con los elementos del array palabras
                foreach (string palabrita in palabras)
                    lbPalabras.Items.Add(palabrita);
            }

            private void botSiguiente_Click(object sender, RoutedEventArgs e)
            {
                n = n % palabras.Length; //valores de 0 a longitud-1 de aPalabras (% => resto de la division entera)
                lbPalabras.SelectedIndex = n; //seleccionar el elemento "n" en el listBox
                lbPalabras.ScrollIntoView(lbPalabras.SelectedItem); //desplaza la lista para visualizar el elemento seleccionado
                palabra = palabras[n].ToLower();
                solucion = string.Empty.PadLeft(palabras[n].Length, '-'); //completa una cadena con un número de guiones igual a la lingitud de la palabra
                n++;
                tbkPalabra.Text = solucion;
            }

            private void botA_Click(object sender, RoutedEventArgs e)
            {
                string letra = tbxLetra.Text;
                if (letra.Length > 0)
                {
                    int j = palabra.IndexOf(letra); //posición de la letra en palabra
                    while (j >= 0) // si j es -1 la letra no está en la palabra
                    {
                        solucion = solucion.Remove(j, 1); //elimina la letra en la posición j
                        solucion = solucion.Insert(j, letra); //inserta la letra en la posición j
                        tbkPalabra.Text = solucion;
                        j = palabra.IndexOf(letra, j + 1); //continúa buscando la letra en la siguiente posición
                    }
                    tbxLetra.Text = string.Empty;
                    if (solucion == palabra) MessageBox.Show("Vaya suerte, has acertado");
                }
            }
        }
    }

