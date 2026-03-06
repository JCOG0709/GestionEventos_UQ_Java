package plataforma.model;
import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String idUsuario;
    private String clave;
    private String nombreCompleto;
    private String email;
    private String telefono;
    private List<String> metodosPagosSimulados;

    public Usuario(String clave, String nombreCompleto, String email, String telefono) {
        this.idUsuario = java.util.UUID.randomUUID().toString();
        this.clave = clave;
        this.nombreCompleto = nombreCompleto;
        this.email = email;
        this.telefono = telefono;
        this.metodosPagosSimulados = new ArrayList<>();
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getClave() {return clave;}

    public void setClave(String clave) {this.clave = clave;}

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<String> getMetodosPagos() {
        return metodosPagosSimulados;
    }

    public void setMetodosPagos(List<String> metodosPagos) {
        this.metodosPagosSimulados = metodosPagos;
    }

    public List<Compra> consultarCompras(CompraServicio servicio) {
        return servicio.obtenerComprasPorUsuario(this.idUsuario);
    }

    public void agregarMetodosPagos(){}

    public boolean eliminarMetodosPagos(){}

    public List<String> listaMetodosPagos(){}

    public void actualizarDatos(String nombre, String email, String telefono){
        this.nombreCompleto = nombre;
        this.email = email;
        this.telefono = telefono;
    }

    public void validarCredenciales(String email, String clave){}






    @Override
    public String toString() {
        return "Usuario{" +
                "idUsuario='" + idUsuario + '\'' +
                ", nombreCompleto='" + nombreCompleto + '\'' +
                ", email='" + email + '\'' +
                ", telefono='" + telefono + '\'' +
                ", metodosPagosSimulados=" + metodosPagosSimulados +
                '}';
    }


}
