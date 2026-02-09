using di.proyecto.clase._2025.Backend.Modelos;
using di.proyecto.clase._2025.Backend.Servicios;
using di.proyecto.clase._2025.Backend.Servicios_Repositorio_;
using di.proyecto.clase._2025.Frontend.Mensajes;
using di.proyecto.clase._2025.Frontend.MVVM.Base;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace di.proyecto.clase._2025.MVVM
{
    public class MVEspacio : MVBase
    {
        private EspacioRepository _espacioRepository;
        private List<Espacio> _listaEspacios;
        public List<Espacio> listaEspacios => _listaEspacios;
        public MVEspacio(EspacioRepository espacioRepository) {
            _espacioRepository = espacioRepository;
        }

        public async Task Inicializa()
        {
            try
            {
                _listaEspacios = await _espacioRepository.GetAllAsync();
            }
            catch (Exception ex)
            {
                MensajeError.Mostrar("ADMINISTRACION", "Error al cargar los Espacios \n" +
                    "No puedo conectar con la base de datos", 0);
            }
        }
    }
}
