using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace WpfApp_ExamenXaml
{
    internal class ServicioDatos
    {
        public ObservableCollection<Persona> Personas { get; set; }
        public ServicioDatos()
        {
            Personas = new ObservableCollection<Persona>(CargarDatos());
        }
        private List<Persona> CargarDatos()
        {
            List<Persona> aux = new List<Persona>
            {
                new Persona() { Nombre = "Juancito Pérez", Telefono = "983456789" },
                new Persona() { Nombre = "Rosa de los Vientos", Telefono = "6972125483" },
                new Persona() { Nombre = "Pedro Jiménez", Telefono = "984745698" },
                new Persona() { Nombre = "Manuela Gómez", Telefono = "926589547" }
            };
            return aux;
        }

    }
}
