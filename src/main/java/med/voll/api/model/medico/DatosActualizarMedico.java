package med.voll.api.model.medico;

import jakarta.validation.constraints.NotNull;
import med.voll.api.model.direccion.DatosRegistroDireccion;

public record DatosActualizarMedico(
        @NotNull
        Long id,
        String nombre,
        String documento,
        DatosRegistroDireccion direccion
) {
}
