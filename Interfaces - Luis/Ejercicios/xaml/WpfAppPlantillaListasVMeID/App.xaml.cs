using System.Configuration;
using System.Data;
using System.Windows;
using Microsoft.Extensions.DependencyInjection;

namespace WpfAppPlantillaListas
{
    /// <summary>
    /// Interaction logic for App.xaml
    /// </summary>
    public partial class App : Application
    {

        public IServiceProvider? ServiceProvider { get; private set; }

        protected override void OnStartup(StartupEventArgs e)
        {
            base.OnStartup(e);

            // Configuración del contenedor de servicios
            var serviceCollection = new ServiceCollection();
            ConfigureServices(serviceCollection);

            ServiceProvider = serviceCollection.BuildServiceProvider();

            // Crear la ventana principal y pasarle el ViewModel con DI
            var mainWindow = new MainWindow
            {
                DataContext = ServiceProvider.GetRequiredService<MainWindowViewModel>()
            };

            mainWindow.Show();
        }

        private static void ConfigureServices(IServiceCollection services)
        {
            // Registrar ServicioDatos y MainWindowViewModel
            services.AddSingleton<ServicioDatos>();
            services.AddTransient<MainWindowViewModel>();
        }
    }

}
