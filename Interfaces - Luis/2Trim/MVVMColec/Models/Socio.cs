using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MVVMColec.Models
{
    public class Socio

    {
        public int NumSocio { get; set; }
        public string? ApellidosSocio { get; set; }
        public string? NombreSocio { get; set; }
        public string? TelefonoSocio { get; set; }
        public bool PagadoSocio { get; set; } // cierto si está al corriente del pago de las cuotas
        public string? ImagenSocio { get; set; }

    }
}
