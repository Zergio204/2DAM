using CommunityToolkit.Mvvm.Input;
using System.Collections.ObjectModel;
using System.Windows.Input;

//paquete Nuget: CommunityToolkit.MVVM
namespace WpfAppPlantillaListas
{
    //que herede de ServicioDatos.cs
    public class MainWindowViewModel
    {
        public static ObservableCollection<Persona> Personas { get; set; } = new();
        public ICommand AddCommand { get; }
        public MainWindowViewModel()
        {
            Personas = ServicioDatos.RecuperarDatos();
            AddCommand = new RelayCommand(AddPersona);
        }
        private void AddPersona()
        {
            ServicioDatos.AgregarPersona("Elvi Txo", "659875421", "caricaturas/4.png");
        }
    }
}
