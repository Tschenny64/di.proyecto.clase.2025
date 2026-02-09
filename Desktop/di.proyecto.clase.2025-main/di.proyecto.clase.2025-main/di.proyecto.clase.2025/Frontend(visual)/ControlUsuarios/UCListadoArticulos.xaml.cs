using di.proyecto.clase._2025.Frontend_visual_.Dialogo;
using di.proyecto.clase._2025.MVVM;
using Microsoft.Extensions.DependencyInjection;
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
    /// Interaction logic for UCListadoArticulos.xaml
    /// </summary>
    public partial class UCListadoArticulos : UserControl
    {
        private MVArticulo _mvArticulo;
        private readonly IServiceProvider _serviceProvider;
        private DialogoArticulo _dialogoArticulo;
        public UCListadoArticulos(MVArticulo mvArticulo, IServiceProvider serviceProvider)
        {
            InitializeComponent();
            _mvArticulo = mvArticulo;
            _serviceProvider = serviceProvider;
        }

        private async void ucListadoArticulos_Loaded(object sender, RoutedEventArgs e)
        {
            await _mvArticulo.Inicializa();
            this.DataContext = _mvArticulo;

        }

        private async void miEditarArticulo_Click(object sender, RoutedEventArgs e)
        {
            _dialogoArticulo = _serviceProvider.GetRequiredService<DialogoArticulo>();
            await _dialogoArticulo.Inicializa(_mvArticulo.articulo);
            _dialogoArticulo.ShowDialog();
            if (_dialogoArticulo.DialogResult == true)
            {
                // Refrescar la lista de artículos después de editar
                _mvArticulo.listaArticulos.Refresh();
            }
        }


        private void miBorrarArticulo_Click(object sender, RoutedEventArgs e)
        {
            // Lógica para borrar el artículo seleccionado
        }

        private void dpFechaInicial_SelectedDateChanged(object sender, SelectionChangedEventArgs e)
        {
            
        }

        private void dpFechaFinal_SelectedDateChanged(object sender, SelectionChangedEventArgs e)
        {
            
        }

        private void btnAplicarFiltroFechas_Click(object sender, RoutedEventArgs e)
        {
            _mvArticulo.FiltrarFechas();
        }

        private void txtNumeroSerie_TextChanged(object sender, TextChangedEventArgs e)
        {

        }

        private void cbEspacioArticulo_SelectionChanged(object sender, SelectionChangedEventArgs e)
        {

        }
    }
}
