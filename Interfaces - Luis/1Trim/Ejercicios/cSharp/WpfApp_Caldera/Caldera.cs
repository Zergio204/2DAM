using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace WpfApp_Caldera
{
    internal class Caldera
    {
        public event EventHandler Temperatura_Change;
        public event EventHandler Correcto; //<60...Correcto(verde)
        public event EventHandler Alerta; //>=60...Alerta(amarillo)
        public event EventHandler Alarma; //>=80...Alarma(rojo)
        public event EventHandler Apagar;

        private int estado = 0;

        private double temperatura;

        public double Temperatura
        {
            get { return temperatura; }
            set 
            { 
                temperatura = value; 
                Temperatura_Change.Invoke(this, EventArgs.Empty);

                switch (temperatura)
                {
                    case <60:
                        if(estado != 0)
                        {
                            Correcto.Invoke(this, EventArgs.Empty);
                            estado = 0;
                        }
                        break;
                    case >=60 and <80:
                        if (estado != 1)
                        {
                            Alerta.Invoke(this, EventArgs.Empty);
                            estado = 1;
                        }
                        break;
                    case >=80 and <=99:
                        if (estado != 2)
                        {
                            Alarma.Invoke(this, EventArgs.Empty);
                            estado = 2;
                        }
                        break;
                    case >99:
                        if (estado != 3)
                        {
                            Apagar.Invoke(this, EventArgs.Empty);
                            estado = 3;
                        }
                        break;
                }


            }
        }
        

        }
}
