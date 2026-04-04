package main.java.plataforma.patrones.comportamiento

/**
 * INTERFAZ: ISubject
 *
 * PATRÓN: OBSERVER (Comportamiento)
 *
 * PROPÓSITO: Define el contrato para el objeto observable (Subject) que mantiene
 * la lista de observadores y los notifica cuando ocurren cambios.
 *
 * @author TuNombre
 */
interface ISubject {
    /**
     * Agrega un observador a la lista de suscriptores.
     * @param observer El observador que desea suscribirse
     */
    fun suscribir(observer: IObserver?)

    /**
     * Elimina un observador de la lista de suscriptores.
     * @param observer El observador que desea desuscribirse
     */
    fun desuscribir(observer: IObserver?)

    /**
     * Notifica a todos los observadores suscritos con un mensaje.
     * @param mensaje El mensaje a enviar
     */
    fun notificar(mensaje: String?)

    /**
     * Obtiene la lista actual de observadores.
     * @return Lista de observadores
     */
    val observers: MutableList<IObserver?>?
}