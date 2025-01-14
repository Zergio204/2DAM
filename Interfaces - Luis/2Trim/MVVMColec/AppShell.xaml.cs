using MVVMColec.Views;

namespace MVVMColec
{
    public partial class AppShell : Shell
    {
        public AppShell()
        {
            InitializeComponent();

            Routing.RegisterRoute(nameof(Detalle), typeof(Detalle));
        }
    }
}
