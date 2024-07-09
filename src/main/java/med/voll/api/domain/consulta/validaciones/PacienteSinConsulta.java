package med.voll.api.domain.consulta.validaciones;

import jakarta.validation.ValidationException;
import med.voll.api.domain.consulta.ConsultaRepository;
import med.voll.api.domain.consulta.DatosAgendarConsulta;

import java.time.LocalDateTime;

public class PacienteSinConsulta {

    private ConsultaRepository consultaRepository;

    public void validar(DatosAgendarConsulta datosAgendarConsulta) {
        LocalDateTime primerHorario = datosAgendarConsulta.fecha().withHour(7);
        LocalDateTime ultimoHorario = datosAgendarConsulta.fecha().withHour(18);

        Boolean pacienteConsulta = consultaRepository.existsByPacienteIdAndFechaBetween(datosAgendarConsulta.idPaciente(), primerHorario, ultimoHorario);

        if (pacienteConsulta) {
            throw new ValidationException("Ya hay una cita programada a esta hora");
        }
    }
}
