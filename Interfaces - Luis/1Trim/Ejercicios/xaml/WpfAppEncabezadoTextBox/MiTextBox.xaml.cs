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

namespace WpfAppEncabezadoTextBox
{
    /// <summary>
    /// Lógica de interacción para MiTextBox.xaml
    /// </summary>
    public partial class MiTextBox : UserControl
    {
        public MiTextBox()
        {
            InitializeComponent();
        }

        // Propiedad de dependencia para longitud máxima del texto
        public string MaxTexto
        {
            get { return (string)GetValue(TextoProperty); }
            set { SetValue(TextoProperty, value); }
        }
        // Registro la propiedad de dependencia
        public static readonly DependencyProperty TextoProperty =
            DependencyProperty.Register("MaxTexto", typeof(string), typeof(MiTextBox), new PropertyMetadata(string.Empty));
    }
}
