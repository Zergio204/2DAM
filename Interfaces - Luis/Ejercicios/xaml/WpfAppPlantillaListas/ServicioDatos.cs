using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using static System.Runtime.InteropServices.JavaScript.JSType;

namespace WpfAppPlantillaListas
{
    public class ServicioDatos
    {
        private static ObservableCollection<Persona> Personas { get; set; } = new();
        //ObservableCollection notifica automáticamente sus cambios a las "Vistas" (interfaces de usuario) enlazadas 

        public ServicioDatos()
        {
            RecuperarDatos();
        }
        public static ObservableCollection<Persona> RecuperarDatos()
        {
            if (Personas.Count == 0)
            {
                Personas.Add(new Persona { Nombre = "Serena Güilians", Telefono = "123456789", Foto = "caricaturas/1.jpg" });
                Personas.Add(new Persona { Nombre = "Rafa Nalda", Telefono = "654987123", Foto = "caricaturas/2.png" });
                Personas.Add(new Persona { Nombre = "Noshtoi Segûrof", Telefono = "32165489", Foto = "caricaturas/3.jpg" });
            }
            return Personas;
        }
        public static void AgregarPersona(string nombre, string telefono, string foto)
        {
            Persona persona = new Persona { Nombre = nombre, Telefono = telefono, Foto = foto };
            Personas.Add(persona);
        }
    }
}
