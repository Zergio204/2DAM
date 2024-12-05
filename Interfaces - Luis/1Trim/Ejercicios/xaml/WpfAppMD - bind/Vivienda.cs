using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;

namespace WpfAppMD
{
    public class Vivienda
    {
        public string Zona { get; set; } = null!;
        public string Foto { get; set; } = String.Empty;
        public string? Situacion { get; set; }
        public string? Descripcion { get; set; }
        public double Precio { get; set; }


        public static ObservableCollection<Vivienda> GetViviendas()
        {
            List<Vivienda> viviendas = new List<Vivienda>();
            viviendas.Add(new Vivienda { Zona = "zonaA", Foto = "fotos/f1.jpg", Situacion = "Calle uno", Descripcion = "Descripción uno...", Precio = 110000 });
            viviendas.Add(new Vivienda { Zona = "zonaA", Foto = "fotos/f2.jpg", Situacion = "Calle dos", Descripcion = "Descripción dos...", Precio = 120000 });
            viviendas.Add(new Vivienda { Zona = "zonaB", Foto = "fotos/f3.jpg", Situacion = "Calle tres", Descripcion = "Descripción tres...", Precio = 130000 });
            viviendas.Add(new Vivienda { Zona = "zonaC", Foto = "fotos/f4.jpg", Situacion = "Calle cuatro", Descripcion = "Descripción cuatro...", Precio = 140000 });
            viviendas.Add(new Vivienda { Zona = "zonaB", Foto = "fotos/f5.jpg", Situacion = "Calle cinco", Descripcion = "Descripción cinco...", Precio = 150000 });
            viviendas.Add(new Vivienda { Zona = "zonaB", Foto = "fotos/f6.jpg", Situacion = "Calle seis", Descripcion = "Descripción seis...", Precio = 160000 });
            viviendas.Add(new Vivienda { Zona = "zonaC", Foto = "fotos/f7.jpg", Situacion = "Calle siete", Descripcion = "Descripción siete...", Precio = 170000 });
            viviendas.Add(new Vivienda { Zona = "zonaC", Foto = "fotos/f8.jpg", Situacion = "Calle ocho", Descripcion = "Descripción ocho...", Precio = 180000 });
            viviendas.Add(new Vivienda { Zona = "zonaA", Foto = "fotos/f9.jpg", Situacion = "Calle nueve", Descripcion = "Descripción nueve...", Precio = 190000 });
            viviendas.Add(new Vivienda { Zona = "zonaB", Foto = "fotos/f10.jpg", Situacion = "Calle diez", Descripcion = "Descripción diez...", Precio = 200000 });

            return new ObservableCollection<Vivienda>(viviendas);
        }

    }
}

