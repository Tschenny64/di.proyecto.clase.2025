using di.proyecto.clase._2025.MVVM;
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
    /// Interaction logic for UCArbolEspacio.xaml
    /// </summary>
    public partial class UCArbolEspacio : UserControl
    {
        private MVEspacio _mvEspacio;
        public UCArbolEspacio(MVEspacio mvEspacio)
        {
            InitializeComponent();
            _mvEspacio = mvEspacio;
        }

        private async void ucArbolEspacios_Loaded(object sender, RoutedEventArgs e)
        {
            //CADA VEZ QUE PONEMOS AWAIT SE CAMBIA EL PRIVATE ASYNC A TASK, CORREGIRLO 
            await _mvEspacio.Inicializa();
            DataContext = _mvEspacio;

        }
    }
}
