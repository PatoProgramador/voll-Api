package med.voll.api.model.direccion;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Direccion {
    private String calle;
    private Integer numero;
    private String complemento;
    private String distrito;
    private String ciudad;

    public Direccion(DatosRegistroDireccion direccion) {
        this.calle = direccion.calle();
        this.numero = Integer.valueOf(direccion.numero());
        this.distrito = direccion.distrito();
        this.complemento = direccion.complemento();
        this.ciudad = direccion.ciudad();
    }
}
