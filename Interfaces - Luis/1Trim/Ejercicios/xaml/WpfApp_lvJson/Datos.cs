using Newtonsoft.Json.Linq;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace WpfApp_lvJson
{
    internal class Datos
    {
        public static ObservableCollection<Personaje>
            Personajes { get; set; } = new();
        public static void RecuperarDatos()
        {
            
            #region Consulta LINQ
            var personajes = from p in 
                             JObject.Parse
                             (File.ReadAllText("Datos/personajes.json"))
                             .SelectToken("personaje")
                             select new Personaje
                             {
                                 Nombre = (String?)p["nombre"],
                                 Puesto = (String?)p["puesto"],
                                 Foto = (String?)p["foto"]
                             };
            foreach (var p in personajes) { Personajes.Add(p); }
            #endregion

        }
    }
}
