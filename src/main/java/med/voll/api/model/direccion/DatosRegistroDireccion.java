package med.voll.api.model.direccion;

public record DatosRegistroDireccion(
        String calle,
        String distrito,
        String ciudad,
        String numero,
        String complemento
) {
}
