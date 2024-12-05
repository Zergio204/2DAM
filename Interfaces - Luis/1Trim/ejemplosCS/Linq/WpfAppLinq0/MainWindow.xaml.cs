using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace WpfAppLinq0
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();

            // Create the first data source.
            List<Student> students = new List<Student>()
        {
            new Student { First="Svetlana",
                Last="Omelchenko",
                ID=111,
                Street="123 Main Street",
                City="Seattle",
                Scores= new List<int> { 97, 92, 81, 60 } },
            new Student { First="Claire",
                Last="O’Donnell",
                ID=112,
                Street="124 Main Street",
                City="Redmond",
                Scores= new List<int> { 75, 84, 91, 39 } },
            new Student { First="Sven",
                Last="Mortensen",
                ID=113,
                Street="125 Main Street",
                City="Lake City",
                Scores= new List<int> { 88, 94, 65, 91 } },
            new Student
            {
                 City="Pucela",
                  First="Nicasio",
                   ID=8888,
                    Last="Pérez",
                     Street="C/ de la Calle, 64",
                      Scores=new List<int> {100,20,10}
            }
        };
            /*
            Student estudiante= new Student();
            estudiante.City = "Palencia";
            estudiante.First = "Anacleto";
            students.Add(estudiante);
            */
            // Create the second data source.
            List<Teacher> teachers = new List<Teacher>()
        {
            new Teacher { First="Ann", Last="Beebe", ID=945, City="Seattle" },
            new Teacher { First="Alex", Last="Robinson", ID=956, City="Redmond" },
            new Teacher { First="Michiyo", Last="Sato", ID=972, City="Tacoma" }
        };

            // Create the query.
            var peopleInSeattle = (from student in students
                                   where student.City == "Pucela"
                                   select student);

            // Execute the query.
            foreach (Student person in peopleInSeattle)
            {
                lbTodoSeattle.Items.Add(person);
            }

            

        }

        private void lbTodoSeattle_SelectionChanged(object sender, SelectionChangedEventArgs e)
        {
            if (lbTodoSeattle.SelectedIndex >= 0)
            {
                Student estudiante = (Student)lbTodoSeattle.SelectedItem;
                MessageBox.Show($"domicilio:\n {estudiante.Street}");
            }
            
        }
    }
    class Student
    {
        public string First { get; set; }
        public string Last { get; set; }
        public int ID { get; set; }
        public string Street { get; set; }
        public string City { get; set; }
        public List<int> Scores;
        public override string ToString()
        {
            return $"{this.Last}, {this.First}";
        }
    }

    class Teacher
    {
        public string First { get; set; }
        public string Last { get; set; }
        public int ID { get; set; }
        public string City { get; set; }
    }
}
