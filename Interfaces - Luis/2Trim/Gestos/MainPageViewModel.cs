using CommunityToolkit.Mvvm.ComponentModel;
using CommunityToolkit.Mvvm.Input;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Input;

namespace Gestos
{
    public partial class MainPageViewModel : ObservableObject
    {
        [RelayCommand]
        private void SwipeL(Label arg)
        {
            arg.BackgroundColor = Colors.Red;
            arg.Text = "Notificación DESCARTADA";
        }

        [RelayCommand]
        private void SwipeR(Label arg)
        {
            arg.BackgroundColor = Colors.Green;
            arg.Text = "Notificación GUARDADA";
        }
        [RelayCommand]
        private void SwipeL2(Button arg)
        {
            arg.ZIndex = 99;
        }

        [RelayCommand]
        private void SwipeR2(Button arg)
        {
            arg.ZIndex = 99;
        }

        [RelayCommand]
        private void Delete(Label arg)
        {
            arg.BackgroundColor = Colors.Red;
            arg.Text = "Notificación DESCARTADA";
        }
        [RelayCommand]
        private void Favorite(Label arg)
        {
            arg.BackgroundColor = Colors.Green;
            arg.Text = "Notificación GUARDADA";
        }
        [RelayCommand]
        private void Guardar(Label label)
        {
            Shell.Current.DisplayAlert("NOTIFICACIÓN", "Notificación guardada", "Ok");
            label.Text = "Notificación procesada";
        }

        [RelayCommand]
        private void Borrar(Label label)
        {
            Shell.Current.DisplayAlert("NOTIFICACIÓN", "Notificación eliminada", "Ok");
            label.Text = "Notificación procesada";
        }

        [RelayCommand]
        private async Task DeleteElemento(Tarea elemento)
        {
            if (await Shell.Current.DisplayAlert("ELIMINAR", "Eliminar elemento", "Eliminar", "Cancelar"))
                ListaTareas.Remove(elemento);
        }
        public ObservableCollection<Tarea> ListaTareas { get; set; }

        public MainPageViewModel()
        {
            ListaTareas = Tareas();
        }

        private ObservableCollection<Tarea> Tareas()
        {
            return new ObservableCollection<Tarea>()
            {
                new Tarea{IdTarea=1,NombreTarea="esparragar",FechaTarea=DateTime.Today},
                new Tarea{IdTarea=2,NombreTarea="dormir",FechaTarea=DateTime.Today.AddDays(1)},
                new Tarea{IdTarea=3,NombreTarea="sofaning",FechaTarea=DateTime.Today.AddDays(2)},
            };
        }

    }
}
