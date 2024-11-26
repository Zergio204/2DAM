using System;

namespace Surtidor
{
    class TipoSurtidor
    {
        public event EventHandler CambioLitros;
        public event EventHandler TopeAlcanzado;
        private double CAUDAL;
        private double litros;

        public TipoSurtidor(double precio, double caudal)
        {
            PRECIO = precio;
            CAUDAL = caudal;
            Iniciar();
        }
        public double PRECIO { get; }
        public double Tope { get; set; }

        public double Importe
        {
            get { return PRECIO * Litros; }
        }

        public double Litros
        {
            get { return litros; }
            set
            {
                litros = value;
                    CambioLitros?.Invoke(this, new EventArgs());
                if (Importe >= Tope)
                    TopeAlcanzado?.Invoke (this, new EventArgs());
            }
        }

        public void Iniciar() { Litros = 0; Tope = double.MaxValue; }
        public void Surtir() { Litros += CAUDAL; }

    }
}
