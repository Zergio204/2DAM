using CommunityToolkit.Mvvm.ComponentModel;
using CommunityToolkit.Mvvm.Input;
using System.Collections.ObjectModel;

namespace MauiAppRestaurantesVM
{
    internal partial class MainPageViewModel : ObservableObject
    {
        private ObservableCollection<Restaurante> Restaurantes;
        private int indice;
        public int Indice
        {
            get { return indice; }
            set
            {
                if (value >= 0 && value <= Restaurantes.Count - 1)
                {
                    indice = value;
                    CurrentRestaurante = Restaurantes[indice];
                    Posicion = $"{indice + 1}/{Restaurantes.Count}";
                }
            }
        }

        [ObservableProperty]
        private Restaurante currentRestaurante;

        [ObservableProperty]
        [NotifyCanExecuteChangedFor(nameof(SiguienteCommand))]
        [NotifyCanExecuteChangedFor(nameof(AnteriorCommand))]
        private string posicion;

        [RelayCommand(CanExecute = nameof(PuedeSeguir))]
        private void Anterior()
        {
            Indice--;
        }

        [RelayCommand(CanExecute = nameof(PuedeSeguir))]
        private void Siguiente()
        {
            Indice++;
        }

        public MainPageViewModel()
        {
            if (Restaurantes == null)
            {
                Restaurantes = new()
            {
                new Restaurante{Titulo="UNO",
                    Nombre="restaurante uno",
                    Lema="el número 1",
                    Direccion="Calle del uno,11",
                    Localidad="San Cipriuno",
                    Provincia="Valladolid",
                    Foto="https://picsum.photos/id/10/300/300",
                    ColorBase=Colors.AliceBlue},
                new Restaurante{Titulo="DOS",
                    Nombre="restaurante dos",
                    Lema="el número 2",
                    Direccion="Calle del dos,22",
                    Localidad="Dosaguas",
                    Provincia="Palencia",
                    Foto="https://picsum.photos/id/11/300/300",
                    ColorBase=Colors.AntiqueWhite},
                new Restaurante{Titulo="TRES",
                    Nombre="restaurante tres",
                    Lema="el número 3",
                    Direccion="Calle del tres,33",
                    Localidad="Tres Pinares",
                    Provincia="Valladolid",
                    Foto="https://picsum.photos/id/12/300/300",
                    ColorBase = Colors.Aqua},
                new Restaurante{Titulo="CUATRO",
                    Nombre="restaurante cuatro",
                    Lema="el número 4",
                    Direccion="Calle del cuatro,44",
                    Localidad="VillaCuatro",
                    Provincia="Salamanca",
                    Foto="https://picsum.photos/id/13/300/300",
                    ColorBase=Colors.Aquamarine}
            };
                Indice = 0;
            }
        }

        private bool PuedeSeguir()
        {
            return (Indice < Restaurantes.Count) && (Indice >= 0);
        }
    }
}

