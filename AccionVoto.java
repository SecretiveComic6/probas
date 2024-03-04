package Cliente;

import java.io.Serializable;

public class AccionVoto implements Serializable {
    private String accion;
    private Object datos;

    public AccionVoto(String accion, Object datos) {
        this.accion = accion;
        this.datos = datos;
    }

    public String getAccion() {
        return accion;
    }

    public Object getDatos() {
        return datos;
    }
}
