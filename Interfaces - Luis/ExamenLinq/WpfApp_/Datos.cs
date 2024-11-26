using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace WpfApp_
{
    public class Datos
    {
        public static List<Cliente> GetClientes()
        {
            return new List<Cliente>()
            {
                new Cliente
                {
                IdCliente = 1,
                Nombre = "Juan",
                Apellidos = "Pérez Pí",
                Domicilio = "Calle Uno, 10",
                },
                new Cliente
                {
                IdCliente = 2,
                Nombre = "Juana",
                Apellidos = "García",
                Domicilio = "Calle Dos, 22",
                },
                new Cliente
                {
                IdCliente = 3,
                Nombre = "Alicia",
                Apellidos = "Gómez Pí",
                Domicilio = "Calle Tres, 3",
                },
                new Cliente
                {
                IdCliente = 4,
                Nombre = "Fulano",
                Apellidos = "de Tal",
                Domicilio = "Calle Cuatro, 4",
                }
            };
        }
        public static List<Servicio> GetServicios()
        {
            return new List<Servicio>()
            {
                new Servicio {IdServicio=1, Descripcion="servicio uno",Precio=10},
                new Servicio {IdServicio=2, Descripcion="servicio dos",Precio=200},
                new Servicio {IdServicio=3, Descripcion="servicio tres",Precio=30},
                new Servicio {IdServicio=4, Descripcion="servicio cuatro",Precio=40}
            };
        }
        public static List<Intervencion> GetIntervenciones()
        {
            return new List<Intervencion>()
            {
                new Intervencion{ IdIntervencion=1, IdCliente=2, IdServicio=1, TiempoMinutos=new TimeSpan(0,30,0), Fecha=new DateTime(2024,10,01 )},
                new Intervencion{ IdIntervencion=2, IdCliente=1, IdServicio=2, TiempoMinutos=new TimeSpan(1,0,0), Fecha=new DateTime(2024,10,02 )},
                new Intervencion{ IdIntervencion=3, IdCliente=3, IdServicio=1, TiempoMinutos=new TimeSpan(0,30,0), Fecha=new DateTime(2024,10,02 )},
                new Intervencion{ IdIntervencion=4, IdCliente=1, IdServicio=1, TiempoMinutos=new TimeSpan(0,45,0), Fecha=new DateTime(2024,10,02 )},
                new Intervencion{ IdIntervencion=5, IdCliente=4, IdServicio=3, TiempoMinutos=new TimeSpan(0,30,0), Fecha=new DateTime(2024,10,03 )},
                new Intervencion{ IdIntervencion=6, IdCliente=2, IdServicio=4, TiempoMinutos=new TimeSpan(1,10,0), Fecha=new DateTime(2024,10,03 )}
            };
        }
    }
    public class Intervencion
    {
        public int IdIntervencion { get; set; }
        public int IdServicio { get; set; }
        public int IdCliente { get; set; }
        public TimeSpan TiempoMinutos { get; set; }
        public DateTime Fecha { get; set; }
    }
    public class Servicio
    {
        public int IdServicio { get; set; }
        public String Descripcion { get; set; }
        public Double Precio { get; set; }
    }
    public class Cliente
    {
        public int IdCliente { get; set; }
        public string Nombre { get; set; }
        public string Apellidos { get; set; }
        public string Domicilio { get; set; }
    }


}
