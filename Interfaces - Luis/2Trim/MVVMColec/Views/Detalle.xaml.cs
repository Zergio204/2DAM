
using MVVMColec.ViewModels;
namespace MVVMColec.Views;

public partial class Detalle : ContentPage
{
    public Detalle(DetalleViewModel detalleViewModel)
    {
        InitializeComponent();
        this.BindingContext = detalleViewModel;
    }
}