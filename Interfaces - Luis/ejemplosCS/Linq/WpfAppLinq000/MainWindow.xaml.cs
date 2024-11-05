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

namespace WpfAppLinq000
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
            var names = new[] { "uno", "dos", "tres", "cuatro", "cinco", "seis" };

            var edades = new[] { 13, 26, 5, 28, 16, 34 };
            IEnumerable<(string Nombre, int Edad)> zip = names.Zip(edades);//une las dos tablas
            var chunked = ChunkBy(zip, 3);

            IEnumerable<IEnumerable<T>> ChunkBy<T>(IEnumerable<T> source, int chunkSize) //agrupa de 3 en 3 (chunkSize)
            {
                return source 
                    .Select((x, i) => new { Index = i, Value = x })
                    .GroupBy(x => x.Index / chunkSize)
                    .Select(x => x.Select(v => v.Value));
            }

            foreach (var grupo in chunked)
            {
                foreach (var item in grupo)
                {
                    tb1.Text += $"{item.Nombre} {item.Edad}, ";
                }
                tb1.Text = tb1.Text.Substring(0, tb1.Text.Length - 1) + "\n";
            }
        }
    }
}
