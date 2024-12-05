using System.Windows;

namespace WpfAppMD
{
    /// <summary>
    /// Lógica de interacción para WindowFoto.xaml
    /// </summary>
    public partial class WindowFoto : Window
    {
        public WindowFoto()
        {
            InitializeComponent();
        }

        private void Image_MouseLeftButtonDown(object sender, System.Windows.Input.MouseButtonEventArgs e)
        {
            this.Close();
        }
    }
}
