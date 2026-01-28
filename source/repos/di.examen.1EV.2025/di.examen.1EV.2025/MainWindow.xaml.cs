using di.examen._1EV._2025.Backend.Modelos;
using di.examen._1EV._2025.Frontend.Dialogos;
using System.Windows;

namespace di.examen._1EV._2025
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        private JardineriaContext _contexto;
        private GestionEmpleados mvGestionEmpleados;

        public MainWindow()
        {
            InitializeComponent();
        }

        private void btnGestionEmpleado_Click(object sender, RoutedEventArgs e)
        {
            GestionEmpleados gestionEmpleados = new GestionEmpleados();
            gestionEmpleados.ShowDialog();
        }

        private void Button_Click_Minimizar
            (object sender, RoutedEventArgs e)
        {
            WindowState state = WindowState.Minimized;
        }

        private void Button_Click_Maximizar(object sender, RoutedEventArgs e)
        {
            WindowState state = WindowState.Maximized;
        }
        private void Button_Click_Cerrar(object sender, RoutedEventArgs e)
        {
            this.Close();
        }
    }
}