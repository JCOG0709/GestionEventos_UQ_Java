package main.java.plataforma.estados;

import main.java.plataforma.model.Evento;
import main.java.plataforma.interfaces.IEstadoEvento;

public class EstadoBorrador implements IEstadoEvento {

    @Override
    public void publicar(Evento ctx) {
        ctx.setEstado(new EstadoPublicado());
        System.out.println("Evento PUBLICADO.");
    }

    @Override
    public void pausar(Evento ctx) {
        throw new IllegalStateException("No se puede pausar un Borrador.");
    }

    @Override
    public void cancelar(Evento ctx) {
        throw new IllegalStateException("No se puede cancelar un Borrador.");
    }

    @Override
    public void finalizar(Evento ctx) {
        throw new IllegalStateException("No se puede finalizar un Borrador.");
    }

    @Override
    public String getNombre() { return "BORRADOR"; }
}
