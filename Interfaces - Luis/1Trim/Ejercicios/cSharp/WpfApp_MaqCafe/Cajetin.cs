using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace WpfApp_MaqCafe
{
    internal class Cajetin
    {

        double total = 0;
        double vuelta = 0;
        double[] monedasValidas = [2, 1, 0.5, 0.2, 0.1];

        public event EventHandler TotalChange; //(se invocará cada vez que acumule una moneda válida)
        public event EventHandler MonedaNoValida; //(se invocará cuando se encuentre una moneda no válida)

        public void Acumular(double moneda)
        {
            if (monedasValidas.Contains(moneda))
            {
                total += moneda;
                TotalChange?.Invoke(this, new EventArgs());
            }
            else
            {
                vuelta = moneda;
                MonedaNoValida?.Invoke(this, new EventArgs());
            }
        }

        public bool Dispensar(double precio) //cierto si Total > precio
        {
            if (total > precio)
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        public double Devolver() //retorna el valor de la vuelta
        {
            return vuelta;
        }

        public void Iniciar() //Total=0
        {
            total = 0;
        }

        public double[] MonedasValidas 
        { 
            get {  return monedasValidas; } 
        }

        public double Total
        { 
            get { return total; }
        }

        public double Vuelta 
        { 
            set { vuelta = value; }
        }

    }
}
