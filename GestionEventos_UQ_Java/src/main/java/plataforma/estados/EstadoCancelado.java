package main.java.plataforma.estados;

import main.java.plataforma.model.Evento;
import main.java.plataforma.interfaces.IEstadoEvento;

public class EstadoCancelado implements IEstadoEvento {

    @Override
    public void publicar(Evento ctx) {
        throw new IllegalStateException("No se puede republicar un evento cancelado.");
    }

    @Override
    public void pausar(Evento ctx) {
        throw new IllegalStateException("No se puede pausar un evento cancelado.");
    }

    @Override
    public void cancelar(Evento ctx) {
        throw new IllegalStateException("El evento ya está cancelado.");
    }

    @Override
    public void finalizar(Evento ctx) {
        throw new IllegalStateException("No se puede finalizar un evento cancelado.");
    }

    @Override
    public String getNombre() { return "CANCELADO"; }
}