using System;
using System.Text;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Ink;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace WpfApp_InkCanvas
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {

        private Random random = new Random();

        public MainWindow()
        {
            InitializeComponent();
        }

        private void clicRaton(object sender, MouseButtonEventArgs e)
        {
            if (e.RightButton == MouseButtonState.Pressed)
            {
                inkCanvas.Strokes.Clear();
            }
            else
            {
                var drawingAttributes = new DrawingAttributes
                {
                    Color = Color.FromRgb((byte)random.Next(256), (byte)random.Next(256), (byte)random.Next(256)),
                    Width = random.Next(1, 11),
                    Height = random.Next(1, 11)
                };
                inkCanvas.DefaultDrawingAttributes = drawingAttributes;
            }
        }
    }
}