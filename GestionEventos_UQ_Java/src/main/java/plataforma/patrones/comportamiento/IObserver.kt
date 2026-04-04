package main.java.plataforma.patrones.comportamiento

/**
 * INTERFAZ: IObserver
 *
 * PATRÓN: OBSERVER (Comportamiento)
 *
 * PROPÓSITO: Define el contrato para los observadores/suscriptores que desean
 * recibir notificaciones cuando ocurran cambios en el sistema.
 *
 * REQUISITO CUBIERTO: RF-017 (Registrar incidencias y cambios de estado)
 *
 * PROBLEMA QUE RESUELVE: Notificar automáticamente a múltiples suscriptores
 * (usuarios, administradores) cuando un evento cambia de estado o ocurre una incidencia,
 * sin que el emisor necesite conocer los detalles de los receptores.
 *
 */
interface IObserver {
    /**
     * Método llamado por el Subject cuando ocurre un cambio.
     * @param mensaje Descripción del evento ocurrido
     */
    fun actualizar(mensaje: String?)
}