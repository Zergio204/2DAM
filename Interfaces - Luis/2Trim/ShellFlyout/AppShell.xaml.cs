namespace ShellFlyout
{
    public partial class AppShell : Shell
    {
        public AppShell()
        {
            InitializeComponent();
        }

        private async void Button_Clicked(object sender, EventArgs e)
        {
            if (await DisplayAlert("Salir","Desea salir de la aplicación","Sí","No"))
                Environment.Exit(0);
        }
    }
}
