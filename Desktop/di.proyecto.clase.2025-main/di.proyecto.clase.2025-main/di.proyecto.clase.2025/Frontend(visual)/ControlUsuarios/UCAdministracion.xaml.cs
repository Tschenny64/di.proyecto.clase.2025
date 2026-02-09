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

namespace di.proyecto.clase._2025.Frontend_visual_.ControlUsuarios
{
    /// <summary>
    /// Interaction logic for UCAdministracion.xaml
    /// </summary>
    public partial class UCAdministracion : UserControl
    {
        private UCArbolEspacio _ucArbolEspacio;
        private UCArbolDepartamentos _ucDepartamentos;

        public UCAdministracion(UCArbolEspacio ucArbolEspacio, UCArbolDepartamentos ucDepartamentos)
        {
            InitializeComponent();
            _ucArbolEspacio = ucArbolEspacio;
            _ucDepartamentos = ucDepartamentos;
        }

        private void btnArbolEspacios_Click(object sender, RoutedEventArgs e)
        {
            panelCentral.Children.Clear();
            panelCentral.Children.Add(_ucArbolEspacio);
        }

        private void btnAddEspacios_Click(object sender, RoutedEventArgs e)
        {

        }

        private void btnDepartamentos_Click(object sender, RoutedEventArgs e)
        {
            panelCentral.Children.Clear();
            panelCentral.Children.Add(_ucDepartamentos);

        }
    }
}
