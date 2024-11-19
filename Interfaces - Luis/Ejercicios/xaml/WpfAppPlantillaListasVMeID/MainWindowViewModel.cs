using CommunityToolkit.Mvvm.Input;
using System.Collections.ObjectModel;
using System.Windows.Input;
using static System.Runtime.InteropServices.JavaScript.JSType;

//paquete Nuget: CommunityToolkit.MVVM
namespace WpfAppPlantillaListas
{
    public class MainWindowViewModel
    {
        private readonly ServicioDatos _servicioDatos;
        public ObservableCollection<Persona> Personas { get; private set; }
        public ICommand AddCommand { get; }
        public MainWindowViewModel(ServicioDatos servicioDatos)
        {
            _servicioDatos = servicioDatos;
            Personas = new ObservableCollection<Persona>();
            _=CargarPersonasAsync();
            AddCommand = new RelayCommand(AddPersona);
        }
        private void AddPersona()
        {
            Persona persona = new()
            {
                Nombre = "Elvi Txo",
                Telefono = "654986521",
                Foto = "caricaturas/4.png"
            };
            Personas.Add(persona);
        }

        public async Task CargarPersonasAsync()
        {
            var personas = await _servicioDatos.RecuperarDatos();
            Personas.Clear();
            foreach (var persona in personas)
            {
                Personas.Add(persona);
            }
        }
    }
}
