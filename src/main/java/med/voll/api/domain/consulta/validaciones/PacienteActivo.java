package med.voll.api.domain.consulta.validaciones;

import jakarta.validation.ValidationException;
import med.voll.api.domain.consulta.DatosAgendarConsulta;
import med.voll.api.domain.paciente.Paciente;
import med.voll.api.domain.paciente.PacienteRepository;

public class PacienteActivo {

    private PacienteRepository pacienteRepository;

    public void validar(DatosAgendarConsulta datosAgendarConsulta) {
        if (datosAgendarConsulta.idPaciente() == null) {
            return;
        }

        Boolean pacienteActivo = pacienteRepository.findActivoById(datosAgendarConsulta.idPaciente());

        if (!pacienteActivo) {
            throw new ValidationException("El paciente ya tiene una consulta asignada para ese dia");
        }
    }
}
