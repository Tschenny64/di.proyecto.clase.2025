
using di.proyecto.clase._2025.Backend.Modelos;

namespace di.proyecto.clase._2025.MVVM
{
    public class ListCollectionView<T>
    {
        private List<Modeloarticulo> listaModelosArticulos;

        public ListCollectionView(List<Modeloarticulo> listaModelosArticulos)
        {
            this.listaModelosArticulos = listaModelosArticulos;
        }

        internal void Refresh()
        {
            throw new NotImplementedException();
        }
    }
}