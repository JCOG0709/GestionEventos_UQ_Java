package main.java.plataforma.model;

public abstract class Persona {

    protected String idPersona;
    protected String nombreCompleto;
    protected String correo;
    protected String telefono;

    public Persona(String idPersona, String nombreCompleto,
                   String correo, String telefono) {
        this.idPersona      = idPersona;
        this.nombreCompleto = nombreCompleto;
        this.correo         = correo;
        this.telefono       = telefono;
    }

    public String getNombre()   { return nombreCompleto; }
    public String getCorreo()   { return correo; }
    public String getTelefono() { return telefono; }
    public String getId()       { return idPersona; }

    public void setNombre(String nombre)     { this.nombreCompleto = nombre; }
    public void setCorreo(String correo)     { this.correo = correo; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    @Override
    public String toString() {
        return String.format("[%s] %s — %s", idPersona, nombreCompleto, correo);
    }
}
