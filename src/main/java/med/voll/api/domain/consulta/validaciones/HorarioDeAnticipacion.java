package med.voll.api.domain.consulta.validaciones;

import jakarta.validation.ValidationException;
import med.voll.api.domain.consulta.DatosAgendarConsulta;

import java.time.Duration;
import java.time.LocalDateTime;

public class HorarioDeAnticipacion {
    public void validar(DatosAgendarConsulta agendarConsulta) {
        LocalDateTime ahora = LocalDateTime.now();
        LocalDateTime horaConsulta = agendarConsulta.fecha();

        Boolean diferencia30Min = Duration.between(ahora, horaConsulta).toMinutes() < 30;
        if (diferencia30Min) {
            throw new ValidationException("Las consultas deben tener al menos 30 minutos de anticipacion");
        }
    }
}