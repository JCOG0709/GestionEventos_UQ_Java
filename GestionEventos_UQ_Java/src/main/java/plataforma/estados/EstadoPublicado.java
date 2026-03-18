package main.java.plataforma.estados;

import main.java.plataforma.model.Evento;
import main.java.plataforma.interfaces.IEstadoEvento;

public class EstadoPublicado implements IEstadoEvento {

    @Override
    public void publicar(Evento ctx) {
        throw new IllegalStateException("El evento ya está publicado.");
    }

    @Override
    public void pausar(Evento ctx) {
        ctx.setEstado(new EstadoPausado());
        System.out.println("Evento PAUSADO.");
    }

    @Override
    public void cancelar(Evento ctx) {
        ctx.setEstado(new EstadoCancelado());
        System.out.println("Evento CANCELADO.");
    }

    @Override
    public void finalizar(Evento ctx) {
        ctx.setEstado(new EstadoFinalizado());
        System.out.println("Evento FINALIZADO.");
    }

    @Override
    public String getNombre() { return "PUBLICADO"; }
}
