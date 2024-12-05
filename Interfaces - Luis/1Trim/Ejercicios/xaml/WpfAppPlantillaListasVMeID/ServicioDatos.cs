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
        public async Task<ObservableCollection<Persona>> RecuperarDatos()
        {
            return new ObservableCollection<Persona>
            {
                new Persona { Nombre = "Serena Güilians", Telefono = "123456789", Foto = "caricaturas/1.jpg" },
                new Persona { Nombre = "Rafa Nalda", Telefono = "654987123", Foto = "caricaturas/2.png" },
                new Persona { Nombre = "Noshtoi Segûrof", Telefono = "32165489", Foto = "caricaturas/3.jpg" }
            };
        }
    }
}
