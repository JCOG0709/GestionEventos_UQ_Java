package main.java.plataforma.estados;

import main.java.plataforma.model.Evento;
import main.java.plataforma.interfaces.IEstadoEvento;

public class EstadoFinalizado implements IEstadoEvento {

    @Override
    public void publicar(Evento ctx) {
        throw new IllegalStateException("El evento ya finalizó.");
    }

    @Override
    public void pausar(Evento ctx) {
        throw new IllegalStateException("El evento ya finalizó.");
    }

    @Override
    public void cancelar(Evento ctx) {
        throw new IllegalStateException("El evento ya finalizó.");
    }

    @Override
    public void finalizar(Evento ctx) {
        throw new IllegalStateException("El evento ya está finalizado.");
    }

    @Override
    public String getNombre() { return "FINALIZADO"; }
}
