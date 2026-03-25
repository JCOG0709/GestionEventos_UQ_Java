package main.java.plataforma.model;
import main.java.plataforma.enums.EstadoCompra;
import java.time.LocalDateTime;

public class Compra {

    private String      idCompra;
    private Usuario     usuario;
    private Evento      evento;
    private double      total;
    private EstadoCompra estado;
    private LocalDateTime fechaCreacion;

    public Compra(String idCompra, Usuario usuario, Evento evento) {
        this.idCompra      = idCompra;
        this.usuario       = usuario;
        this.evento        = evento;
        this.total         = 0.0;
        this.estado        = EstadoCompra.CREADA;
        this.fechaCreacion = LocalDateTime.now();
    }

    public void confirmar() {
        if (estado != EstadoCompra.PAGADA)
            throw new IllegalStateException("Debe estar PAGADA para confirmarse.");
        this.estado = EstadoCompra.CONFIRMADA;
        System.out.println("Compra " + idCompra + " CONFIRMADA.");
    }

    public void cancelar() {
        if (estado == EstadoCompra.CANCELADA || estado == EstadoCompra.REEMBOLSADA)
            throw new IllegalStateException("La compra ya fue cancelada o reembolsada.");
        this.estado = EstadoCompra.CANCELADA;
        System.out.println("Compra " + idCompra + " CANCELADA.");
    }

    public void reembolsar() {
        if (estado != EstadoCompra.PAGADA && estado != EstadoCompra.CONFIRMADA)
            throw new IllegalStateException("Solo se reembolsan compras PAGADAS o CONFIRMADAS.");
        this.estado = EstadoCompra.REEMBOLSADA;
        System.out.println("Compra " + idCompra + " REEMBOLSADA.");
    }

    public void marcarIncidencia() {
        this.estado = EstadoCompra.INCIDENCIA;
        System.out.println("Compra " + idCompra + " marcada como INCIDENCIA.");
    }

    public String consultarDetalle() {
        return String.format("Compra[%s] Usuario:%s | Evento:%s | Total:$%.2f | Estado:%s",
                idCompra, usuario.getNombre(), evento.getNombre(), total, estado);
    }

    public String       getIdCompra()     { return idCompra; }
    public Usuario      getUsuario()      { return usuario; }
    public Evento       getEvento()       { return evento; }
    public double       getTotal()        { return total; }
    public EstadoCompra getEstado()       { return estado; }
    public LocalDateTime getFechaCreacion(){ return fechaCreacion; }

    public void setTotal(double total)        { this.total = total; }
    public void setEstado(EstadoCompra estado) { this.estado = estado; }

    @Override
    public String toString() { return consultarDetalle(); }
}
