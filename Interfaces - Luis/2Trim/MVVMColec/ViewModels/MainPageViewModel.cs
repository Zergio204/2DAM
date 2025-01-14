using CommunityToolkit.Mvvm.ComponentModel;
using CommunityToolkit.Mvvm.Input;
using MVVMColec.Models;
using MVVMColec.Services;
using MVVMColec.Views;
using System.Collections.ObjectModel;

namespace MVVMColec.ViewModels
{
    //Atención: partial class
    public partial class MainPageViewModel : ObservableObject
    {

        [ObservableProperty]
        private Socio currentSocio;

        public ObservableCollection<Socio> SocioList { get; }


        public Socio SocioSeleccionado { get; set; }
        public List<Socio> Socios { get; private set; }

        [RelayCommand]
        private async Task SelectionChanged()
        {
            var navigationParameters = new Dictionary<string, object>
            {
                { "Socio", CurrentSocio }
            };

            await Shell.Current.GoToAsync(nameof(Detalle), navigationParameters);
        }

        public MainPageViewModel(SociosService sociosService)
        {
            SocioList = new ObservableCollection<Socio>(sociosService.GetSocios());
        }

    }
}
