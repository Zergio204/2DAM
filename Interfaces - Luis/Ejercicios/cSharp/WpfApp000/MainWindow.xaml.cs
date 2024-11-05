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

namespace WpfApp000
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        int n = 0;
        int x = 0;
        Button botoncito = new();
        StackPanel sp1 = new();
        public MainWindow()
        {
            InitializeComponent();
            //suscribo el evento .Click asociando un método
            boton1.Click += Boton1_Click;

            botoncito.HorizontalAlignment= HorizontalAlignment.Center;
            botoncito.VerticalAlignment= VerticalAlignment.Center;
            botoncito.Content = "extraer";
            botoncito.Padding= new Thickness(20);
            botoncito.Click += Botoncito_Click; ;
            Grid.SetRow(botoncito, 0);
            Grid.SetColumn(botoncito, 0);
            grid1.Children.Add(botoncito);

            Grid.SetColumn(sp1, 2);
            Grid.SetRow(sp1, 0);
            sp1.Background=new SolidColorBrush(Colors.Pink);
            sp1.Margin = new Thickness(3);
            sp1.Orientation = Orientation.Vertical;
            grid1.Children.Add(sp1);

        }

        private void Botoncito_Click(object sender, RoutedEventArgs e)
        {
            string? elemento;
            if (lbElementos.SelectedIndex >= 0)
            {
                elemento = lbElementos.SelectedItem.ToString();
                tblk1.Text = elemento;
            }
            else { tblk1.Text = "nada seleccionado"; }
            Button b=new Button();
            b.Margin = new Thickness(5);
            b.Content = $"Boton{x++}";
            b.Click += B_Click;
            sp1.Children.Add(b);
        }

        private void B_Click(object sender, RoutedEventArgs e)
        {
            Button bb=(Button)sender;
            String? cbb=bb.Content.ToString();
            bb.Margin=new Thickness(0);
            bb.Background = new SolidColorBrush(Colors.Yellow);
            MessageBox.Show(cbb);
        }

        private void Boton1_Click
            (object sender, RoutedEventArgs e)
        {
            lbElementos.Items.Add($"elemento{++n}");
            //tblk1.Text=lbElementos.Items[0].ToString();
        }

        private void Button_Click
            (object sender, RoutedEventArgs e)
        {
            Button boton = (Button)sender;
            MessageBoxResult resultado;
            resultado = MessageBox.Show
                ($"{boton.Content.ToString()},[{sender.GetType()}]",
                "Atención", MessageBoxButton.YesNo,
                MessageBoxImage.Information);
            if (resultado == MessageBoxResult.Yes)
            {
                App.Current.Shutdown();//terminar la aplicación
                //this.Close();
            }
        }
    }
}
