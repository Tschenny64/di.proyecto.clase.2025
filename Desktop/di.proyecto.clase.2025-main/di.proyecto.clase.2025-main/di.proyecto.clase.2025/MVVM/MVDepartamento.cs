using di.proyecto.clase._2025.Backend.Modelos;
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
    public class MVDepartamento : MVBase
    {
        private DepartamentoRepository _departamentoRepository;
        private List<Departamento> _listaDepartamentos;

        public List<Departamento> listaDepartamentos => _listaDepartamentos;
        public MVDepartamento(DepartamentoRepository departamentoRepository)
        {
            _departamentoRepository = departamentoRepository;
        }

        public async Task Inicializa()
        {
            try
            {
                _listaDepartamentos = await _departamentoRepository.GetAllAsync();
            }
            catch (Exception ex)
            {
                MensajeError.Mostrar("ADMINISTRACION", "Error al cargar los Departamentos \n" +
                    "No puedo conectar con la base de datos", 0);
            }
        }
    }
}
