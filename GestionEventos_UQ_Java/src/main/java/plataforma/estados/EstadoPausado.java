package main.java.plataforma.estados;

import main.java.plataforma.model.Evento;
import main.java.plataforma.interfaces.IEstadoEvento;

public class EstadoPausado implements IEstadoEvento {

    @Override
    public void publicar(Evento ctx) {
        ctx.setEstado(new EstadoPublicado());
        System.out.println("Evento re-PUBLICADO.");
    }

    @Override
    public void pausar(Evento ctx) {
        throw new IllegalStateException("El evento ya está pausado.");
    }

    @Override
    public void cancelar(Evento ctx) {
        ctx.setEstado(new EstadoCancelado());
        System.out.println("Evento CANCELADO.");
    }

    @Override
    public void finalizar(Evento ctx) {
        throw new IllegalStateException("No se puede finalizar un evento pausado.");
    }

    @Override
    public String getNombre() { return "PAUSADO"; }
}
