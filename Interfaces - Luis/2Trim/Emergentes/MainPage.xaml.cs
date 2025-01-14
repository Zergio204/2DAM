using System.Diagnostics;

namespace Emergentes
{
    public partial class MainPage : ContentPage
    {

        public MainPage()
        {
            InitializeComponent();
        }


        private async void Alert_Clicked(object sender, EventArgs e)
        {
            bool answer = await DisplayAlert("Question?", "Would you like to play a game", "Yes", "No");
            labelAlert.Text=$"Answer: {answer}";
        }

        private async void ActionSheet_Clicked(object sender, EventArgs e)
        {
            string action = await DisplayActionSheet("ActionSheet: Send to?", "Cancel", null, "Email", "Twitter", "Facebook");
            labelActionSheet.Text = action;
            //string action = await DisplayActionSheet("ActionSheet: SavePhoto?", "Cancel", "Delete", "Photo Roll", "Email");
            //Debug.WriteLine("Action: " + action);
        }

        private async void PromptAsync_Clicked(object sender, EventArgs e)
        {
            string result = await DisplayPromptAsync("Question 2", "What's 5 + 5?", initialValue: "10", maxLength: 2, keyboard: Keyboard.Numeric);
            labelPropmtAsync.Text = result;
        }

        private async void BotonModal_Clicked(object sender, EventArgs e)
        {
            await Navigation.PushModalAsync(new NewPage1());
        }
    }

}
