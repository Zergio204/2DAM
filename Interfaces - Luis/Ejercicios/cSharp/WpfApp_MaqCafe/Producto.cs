using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace WpfApp_MaqCafe
{
    internal class Producto
    {
        private String nombreProducto;
        private Double precioProducto;

        public Producto(String NombreProducto, Double PrecioProducto)
        {
            this.nombreProducto = NombreProducto;
            this.precioProducto = PrecioProducto;
        }

        public String NombreProducto 
        {
            get { return nombreProducto; } 
            set { nombreProducto = value; }
        }

        public Double PrecioProducto 
        { 
            get { return precioProducto; }
            set {  precioProducto = value; }
        }

    }
}
