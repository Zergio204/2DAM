using System.Collections.ObjectModel;

namespace Colecciones
{
    public partial class MainPage : ContentPage
    {
        private ObservableCollection<Persona> personas = new ObservableCollection<Persona>();
        public MainPage()
        {
            InitializeComponent();
            this.BindingContext= this;
            Personas.Add(new Persona { Nombre = "Juan Pérez", Telefono = "123456789" });
            Personas.Add(new Persona { Nombre = "Alicia Gómez", Telefono = "659874123" });
            Personas.Add(new Persona { Nombre = "Antonio López", Telefono = "612548732" });
        }

        public ObservableCollection<Persona> Personas { get => personas; set => personas = value; }
    }
    public class Persona
    {
        public string? Nombre { get; set; }
        public string? Telefono { get; set; }
    }
}
