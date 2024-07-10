package med.voll.api.domain.consulta.validaciones;

import jakarta.validation.ValidationException;
import med.voll.api.domain.consulta.DatosAgendarConsulta;
import med.voll.api.domain.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PacienteActivo implements ValidadorDeConsultas {

    @Autowired
    private PacienteRepository pacienteRepository;

    public void validar(DatosAgendarConsulta datosAgendarConsulta) {
        if (datosAgendarConsulta.idPaciente() == null) {
            return;
        }

        Boolean pacienteActivo = pacienteRepository.findActivoById(datosAgendarConsulta.idPaciente());

        if (!pacienteActivo) {
            throw new ValidationException("Un paciente inactivo no puede agendar citas");
        }
    }
}
