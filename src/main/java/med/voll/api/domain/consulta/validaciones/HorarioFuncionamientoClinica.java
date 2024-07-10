package med.voll.api.domain.consulta.validaciones;

import jakarta.validation.ValidationException;
import med.voll.api.domain.consulta.DatosAgendarConsulta;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;

@Component
public class HorarioFuncionamientoClinica implements ValidadorDeConsultas {
    public void validar(DatosAgendarConsulta datosAgendarConsulta) {
        Boolean domingo = DayOfWeek.SUNDAY.equals(datosAgendarConsulta.fecha().getDayOfWeek());
        Boolean antesApertura = datosAgendarConsulta.fecha().getHour() < 7;
        Boolean despuesCierre = datosAgendarConsulta.fecha().getHour() > 19;

        if (domingo || antesApertura || despuesCierre) {
            throw new ValidationException("El horario de atencion de la clinica es de lunes a sabado de 07:00 a 19:00 horas");
        }
    }
}
