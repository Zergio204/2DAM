using MVVMColec.ViewModels;

namespace MVVMColec
{
    public partial class MainPage : ContentPage
    {

        public MainPage(MainPageViewModel mainPageViewModel)
        {
            InitializeComponent();
            this.BindingContext = mainPageViewModel;
        }


    }

}
