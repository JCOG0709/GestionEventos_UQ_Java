package main.java.plataforma.model;
import main.java.plataforma.enums.TipoIncidencia;

import java.time.LocalDateTime;

public class Incidencia {

    private String         idIncidencia;
    private TipoIncidencia tipo;
    private String         descripcion;
    private LocalDateTime  fechaRegistro;
    private String         entidadAfectada;

    public Incidencia(String idIncidencia, TipoIncidencia tipo,
                      String descripcion, String entidadAfectada) {
        this.idIncidencia    = idIncidencia;
        this.tipo            = tipo;
        this.descripcion     = descripcion;
        this.entidadAfectada = entidadAfectada;
        this.fechaRegistro   = LocalDateTime.now();
    }

    public void registrar() {
        System.out.printf("Incidencia[%s] Tipo:%s — %s%n",
                idIncidencia, tipo, descripcion);
    }

    public String consultar() {
        return String.format("Incidencia[%s] | Tipo:%s | Entidad:%s | Desc:%s | Fecha:%s",
                idIncidencia, tipo, entidadAfectada, descripcion, fechaRegistro);
    }

    public void asociarEntidad(String idEntidad) {
        this.entidadAfectada = idEntidad;
    }

    public String         getIdIncidencia()    { return idIncidencia; }
    public TipoIncidencia getTipo()            { return tipo; }
    public String         getDescripcion()     { return descripcion; }
    public String         getEntidadAfectada() { return entidadAfectada; }
    public LocalDateTime  getFechaRegistro()   { return fechaRegistro; }

    @Override
    public String toString() { return consultar(); }
}
