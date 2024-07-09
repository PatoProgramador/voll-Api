package med.voll.api.infra.errors;

public class ValicacionDeIntegridad extends RuntimeException {
    public ValicacionDeIntegridad(String s) {
        super(s);
    }
}
