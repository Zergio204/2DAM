using MVVMColec.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MVVMColec.Services
{
    public class SociosService
    {
        List<Socio>? socios;
        public List<Socio> GetSocios()
        {
            if (socios?.Count > 0)
            {
                return socios;
            }
            socios = new List<Socio>
            {
                new Socio { NumSocio = 1, ApellidosSocio = "García López", NombreSocio = "Luis",
                    TelefonoSocio = "984653221", PagadoSocio = false,
                    ImagenSocio="https://picsum.photos/id/237/300/200"},
                new Socio { NumSocio = 2, ApellidosSocio = "Apellido López", NombreSocio = "Luisa",
                    TelefonoSocio = "659875421", PagadoSocio = true,
                    ImagenSocio="https://picsum.photos/id/238/300/200" },
                new Socio { NumSocio = 3, ApellidosSocio = "García Apellido", NombreSocio = "Alberta",
                    TelefonoSocio = "632154878", PagadoSocio = true,
                    ImagenSocio="https://picsum.photos/id/239/300/200" },
                new Socio { NumSocio = 4, ApellidosSocio = "López Apellido", NombreSocio = "Alberto",
                    TelefonoSocio = "677852010", PagadoSocio = false,
                    ImagenSocio="https://picsum.photos/id/236/300/200" }
            };
            socios.TrimExcess();
            return socios;
        }
    }
}
