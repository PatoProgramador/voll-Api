package med.voll.api.domain.consulta.validaciones;

import jakarta.validation.ValidationException;
import med.voll.api.domain.consulta.ConsultaRepository;
import med.voll.api.domain.consulta.DatosAgendarConsulta;

public class MedicoConConsulta {

    private ConsultaRepository consultaRepository;

    public void validar(DatosAgendarConsulta agendarConsulta) {
        if (agendarConsulta.idMedico() == null) {
            return;
        }
        Boolean medicoConConsulta = consultaRepository.existsByMedicoIdAndFecha(agendarConsulta.idMedico(), agendarConsulta.fecha());

        if (medicoConConsulta) {
            throw new ValidationException("Este medico ya tiene una consulta asignada en este horario");
        }
    }
}
