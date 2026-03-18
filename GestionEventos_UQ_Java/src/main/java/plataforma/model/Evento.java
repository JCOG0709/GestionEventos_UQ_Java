package main.java.plataforma.model;

import main.java.plataforma.enums.CategoriaEvento;
import main.java.plataforma.estados.EstadoBorrador;
import main.java.plataforma.interfaces.IEstadoEvento;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class Evento {

    private String          idEvento;
    private String          nombre;
    private CategoriaEvento categoria;
    private String          descripcion;
    private String          ciudad;
    private LocalDateTime   fechaHora;
    private String          politicaCancelacion;
    private String          politicaReembolso;
    private IEstadoEvento estado;
    private Recinto         recinto;

    public Evento(String idEvento, String nombre, CategoriaEvento categoria,
                  String descripcion, String ciudad,
                  LocalDateTime fechaHora, Recinto recinto) {
        this.idEvento            = idEvento;
        this.nombre              = nombre;
        this.categoria           = categoria;
        this.descripcion         = descripcion;
        this.ciudad              = ciudad;
        this.fechaHora           = fechaHora;
        this.recinto             = recinto;
        this.politicaCancelacion = "Cancelación gratuita hasta 48h antes";
        this.politicaReembolso   = "Reembolso del 80% antes del evento";
        this.estado              = new EstadoBorrador();
    }

    // Delega al estado actual (State Pattern)
    public void publicar()  { estado.publicar(this); }
    public void pausar()    { estado.pausar(this); }
    public void cancelar()  { estado.cancelar(this); }
    public void finalizar() { estado.finalizar(this); }

    public void setEstado(IEstadoEvento nuevoEstado) {
        this.estado = nuevoEstado;
    }

    public Map<String, Integer> consultarDisponibilidad() {
        Map<String, Integer> mapa = new HashMap<>();
        for (Zona z : recinto.getZonas()) {
            mapa.put(z.getNombre(), z.calcularDisponibles());
        }
        return mapa;
    }

    public String getNombreEstado() { return estado.getNombre(); }

    public String          getIdEvento()            { return idEvento; }
    public String          getNombre()              { return nombre; }
    public CategoriaEvento getCategoria()           { return categoria; }
    public String          getDescripcion()         { return descripcion; }
    public String          getCiudad()              { return ciudad; }
    public LocalDateTime   getFechaHora()           { return fechaHora; }
    public Recinto         getRecinto()             { return recinto; }
    public String          getPoliticaCancelacion() { return politicaCancelacion; }
    public String          getPoliticaReembolso()   { return politicaReembolso; }

    public void setNombre(String nombre)              { this.nombre = nombre; }
    public void setDescripcion(String descripcion)    { this.descripcion = descripcion; }
    public void setFechaHora(LocalDateTime fechaHora) { this.fechaHora = fechaHora; }
    public void setPoliticaCancelacion(String p)      { this.politicaCancelacion = p; }
    public void setPoliticaReembolso(String p)        { this.politicaReembolso = p; }

    @Override
    public String toString() {
        return String.format("Evento[%s] %s | %s | %s | Estado:%s",
                idEvento, nombre, categoria, ciudad, estado.getNombre());
    }
}
