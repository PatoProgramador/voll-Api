package med.voll.api.model.medico;

import med.voll.api.model.direccion.DatosRegistroDireccion;

public record DatosRegistroMedico(
        String nombre,
        String email,
        String documento,
        Especialidad especialidad,
        DatosRegistroDireccion direccion
) {
}
