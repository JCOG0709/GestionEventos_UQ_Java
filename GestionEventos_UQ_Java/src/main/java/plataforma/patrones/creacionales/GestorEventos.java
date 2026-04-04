package main.java.plataforma.patrones.creacionales;

import main.java.plataforma.patrones.comportamiento.IObserver;
import main.java.plataforma.patrones.comportamiento.ISubject;
import java.util.ArrayList;
import java.util.List;

/**
 * CLASE: GestorEventos
 *
 * PATRONES:
 * - SINGLETON (Creacional) - Garantiza una única instancia
 * - OBSERVER (Comportamiento) - Gestiona suscriptores y notificaciones
 *
 * PROPÓSITO: Actúa como el Subject concreto que gestiona las notificaciones
 * de cambios en los eventos (publicación, pausa, cancelación, finalización).
 *
 * REQUISITO CUBIERTO: RF-017 (Registrar incidencias y cambios de estado)
 *
 * PROBLEMA QUE RESUELVE:
 * - Singleton: Centralizar la gestión de notificaciones en una única instancia global.
 * - Observer: Notificar automáticamente a múltiples suscriptores cuando ocurre un cambio.
 *
 *
 */
public class GestorEventos implements ISubject {

    // ========== SINGLETON ==========
    private static GestorEventos instancia;

    // ========== OBSERVER ==========
    private List<IObserver> observers;

    private GestorEventos() {
        this.observers = new ArrayList<>();
    }

    public static GestorEventos getInstancia() {
        if (instancia == null) {
            instancia = new GestorEventos();
        }
        return instancia;
    }

    // ========== MÉTODOS DEL OBSERVER ==========
    @Override
    public void suscribir(IObserver observer) {
        observers.add(observer);
        System.out.println(" Suscriptor agregado: " + observer.getClass().getSimpleName());
    }

    @Override
    public void desuscribir(IObserver observer) {
        observers.remove(observer);
        System.out.println(" Suscriptor removido: " + observer.getClass().getSimpleName());
    }

    @Override
    public void notificar(String mensaje) {
        System.out.println("\n NOTIFICACIÓN: " + mensaje);
        for (IObserver observer : observers) {
            observer.actualizar(mensaje);
        }
    }

    @Override
    public List<IObserver> getObservers() {
        return new ArrayList<>(observers);
    }
}