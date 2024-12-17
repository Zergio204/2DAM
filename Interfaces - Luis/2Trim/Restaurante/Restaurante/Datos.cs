using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Restaurante
{
    internal class Datos
    {

        public Datos()
        {
            MiRestaurante??= new Restaurante
            {
                Titulo = "Restaurante",
                Nombre = "Tía Molonia",
                Lema = "Desayunos & Meriendas",
                Direccion = "Calle del Paramo, 64",
                Localidad = "Medina de Rioseco",
                Provincia = "Valladolid",
                Foto = "chile.jpg"
            };
        }

        public Restaurante MiRestaurante { get; set; }

    }
}
