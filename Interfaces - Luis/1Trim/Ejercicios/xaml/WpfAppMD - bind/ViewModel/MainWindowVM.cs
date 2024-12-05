using CommunityToolkit.Mvvm.ComponentModel;
using CommunityToolkit.Mvvm.Input;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Security.Policy;
using System.Text;
using System.Threading.Tasks;

namespace WpfAppMD.ViewModel
{
    public partial class MainWindowVM : ObservableObject
    {
        public ObservableCollection<String> Zonas { get; set; }
        public ObservableCollection<Vivienda> Viviendas { get; set; } = new();

        [ObservableProperty]
        private String? zonaSeleccionada;

        [ObservableProperty]
        private Vivienda? viviendaSeleccionada;

        [ObservableProperty]
        private String? fotoInmueble;

        public MainWindowVM()
        {
            Zonas = new ObservableCollection<string>(Vivienda.GetViviendas().Select(v => v.Zona).Distinct());
            Viviendas = Vivienda.GetViviendas();
        }

        partial void OnZonaSeleccionadaChanged(string? value)
        {
            Viviendas.Clear();
            var filtro = Vivienda.GetViviendas().Where(v => v.Zona == value);
            foreach (var vivienda in filtro)
            {
                Viviendas.Add(vivienda);
            }
        }

        partial void OnViviendaSeleccionadaChanged(Vivienda? value)
        {
            if (value != null)
            {
                WindowFoto ventanaFoto = new();
                ventanaFoto.DataContext= value;
                ventanaFoto.ShowDialog();
            }
        }

    }
}
