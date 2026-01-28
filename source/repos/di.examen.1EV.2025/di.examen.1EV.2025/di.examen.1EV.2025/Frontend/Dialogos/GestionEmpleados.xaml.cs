using Castle.Core.Logging;
using di.examen._1EV._2025.Backend.Modelos;
using di.examen._1EV._2025.Backend.Repositorios;
using Microsoft.Extensions.Logging;
using Microsoft.VisualBasic;
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
using System.Windows.Shapes;

namespace di.examen._1EV._2025.Frontend.Dialogos
{
    /// <summary>
    /// Interaction logic for GestionEmpleados.xaml
    /// </summary>
    public partial class GestionEmpleados : Window
    {

        private JardineriaContext _contexto;
        private OficinaRepository _oficinaRepository;
        private EmpleadoRepository _empleadoRepository;
        public GestionEmpleados()
        {
            InitializeComponent();
        }

        private async void gestionEmpleado_Loaded(object sender, RoutedEventArgs e)
        {
            _contexto = new JardineriaContext();
            _oficinaRepository = new OficinaRepository(_contexto);

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

        private async void btnCancelarEmpleado_Click(object sender, RoutedEventArgs e)
        {
            DialogResult = false;
        }

        private async void btnGuardarEmpleado_Click(object sender, RoutedEventArgs e)
        {
            Empleado empleado = new Empleado();
            RecogerDatos(empleado);
            try
            {
                await _empleadoRepository.AddAsync(empleado);
                await _contexto.SaveChangesAsync();
                DialogResult = true;
            }
            catch (Exception ex)
            {
                MessageBox.Show("Error al guardar el artículo: " + ex.Message +
                    (ex.InnerException != null ? "\nDetalles: " + ex.InnerException.Message : ""));
            }
        }

        private void RecogerDatos(Empleado empleado)
        {
            if(cmbOficina.SelectedItem is Oficina oficina)
            {
                Oficina oficinaseleccionada = (Oficina)cmbOficina.SelectedItem;
                oficina.CodigoOficina = oficinaseleccionada.CodigoOficina;
                
            }
            empleado.Nombre = txtNombre.Text;
            empleado.Apellido1 = txtPrimerApellido.Text;
            empleado.Apellido2 = txtSegundoApellido.Text;
            empleado.Email = txtCorreo.Text;
            empleado.Extension = txtExtension.Text;
            empleado.Puesto = txtPuesto.Text;
           
        }
    }
}
