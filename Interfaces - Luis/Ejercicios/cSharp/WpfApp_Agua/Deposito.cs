using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace WpfApp_Agua
{
    class Deposito
    {
        //Declarar los eventos
        public event EventHandler Cantidad_Changed; //Cada vez que la cantidad de agua cambia
        public event EventHandler DepositoVacio; //Cuando la cantidad sea 0

        public Deposito() //Constructor
        {
            Cantidad = 10;
        }

        //prop
        //public int CantidadEjemplo { get; set; } //propiedades autoimplementadas


        //propfull
        private int cantidad;

        public int Cantidad
        {
            get { return cantidad; }
            set 
            {
                cantidad = value;
                Cantidad_Changed?.Invoke(this, EventArgs.Empty);
                if (cantidad == 0)
                {
                    DepositoVacio?.Invoke(this, new EventArgs());
                }
            }
        }


        public void Llenar(int valor)
        {
            cantidad = valor;
        }

    }
}
