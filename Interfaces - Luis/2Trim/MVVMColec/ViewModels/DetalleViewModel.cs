using CommunityToolkit.Mvvm.ComponentModel;
using MVVMColec.Models;

namespace MVVMColec.ViewModels
{
    public partial class DetalleViewModel : ObservableObject, IQueryAttributable
    {

        [ObservableProperty]
        private Socio currentSocio;

        public void ApplyQueryAttributes(IDictionary<string, object> query)
        {
            if (query.ContainsKey("Socio"))
            {
                CurrentSocio = query["Socio"] as Socio;
            }
        }
    }
}
