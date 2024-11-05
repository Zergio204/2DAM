using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Net;
using System.Security.Policy;
using System.Text;
using System.Threading.Tasks;

namespace CS_MaturanaSergio
{
    internal class Surtidor
    { 
        private double caudal;
        private double litros;
        public event EventHandler CambioLitros;
        public event EventHandler TopeAlcanzado;
        public Surtidor(double precio, double caudal)
        {
            Precio = precio;
            this.caudal = caudal;
        }

        public double Importe
        {
            get
            {
                return litros * Precio;
            }
        }

        public double Precio
        {
            get;
            set;
        }

        public double Tope
        {
            get;
            set;
        }

        public double Litros
        {
            get
            {
                return litros;
            }
        }

        public void Iniciar()
        {
            litros = 0;
            Tope = 0;
        }

        public void Surtir()
        {
            litros = litros + caudal;
            CambioLitros?.Invoke(this, EventArgs.Empty);
            if (Importe >= Tope)
            {
                TopeAlcanzado?.Invoke(this, EventArgs.Empty);
            }
        }

    }
}
