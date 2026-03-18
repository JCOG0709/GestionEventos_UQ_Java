package main.java.plataforma.interfaces;

import main.java.plataforma.model.Evento;

public interface IEstadoEvento {
    void publicar(Evento ctx);
    void pausar(Evento ctx);
    void cancelar(Evento ctx);
    void finalizar(Evento ctx);
    String getNombre();
}
