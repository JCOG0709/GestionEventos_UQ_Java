package main.java.plataforma.enums

/**
 * ENUM: TipoReporte
 *
 * Propósito: Define los tipos de reportes que se pueden generar en la plataforma.
 * Se utiliza en conjunto con el patrón Builder para construir reportes específicos.
 *
 * @author TuNombre
 */
enum class TipoReporte(descripcion: String) {
    VENTAS_POR_PERIODO("Ventas por periodo"),
    OCUPACION_POR_ZONA("Ocupación por zona"),
    INGRESOS_SERVICIOS("Ingresos por servicios adicionales"),
    TASA_CANCELACION("Tasa de cancelación"),
    TOP_EVENTOS("Top eventos");

    // Getter
    val descripcion: String?

    // Constructor
    init {
        this.descripcion = descripcion
    }
}