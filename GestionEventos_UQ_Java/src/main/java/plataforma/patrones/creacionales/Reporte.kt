package main.java.plataforma.patrones.creacionales

import main.java.plataforma.enums.FormatoReporte
import main.java.plataforma.enums.TipoReporte
import java.time.LocalDateTime

/**
 * CLASE: Reporte
 *
 * PATRÓN: BUILDER (Creacional) - Producto
 *
 * PROPÓSITO: Representa el producto final construido por el Builder.
 * Contiene toda la información de un reporte operativo.
 *
 * REQUISITO CUBIERTO: RF-019 (Generador de Reportes Operativos - CSV/PDF)
 *
 *
 */
class Reporte internal constructor() {
    var idReporte: String? = null
    private var tipo: TipoReporte? = null
    var formato: FormatoReporte? = null
    var contenido: String? = null
    var fechaGeneracion: LocalDateTime? = null
    var rangoFechas: String? = null
    var datosResumen: String? = null

    fun getTipo(): TipoReporte {
        return tipo!!
    }

    fun setTipo(tipo: TipoReporte) {
        this.tipo = tipo
    }

    override fun toString(): String {
        return String.format(
            "Reporte[id=%s, tipo=%s, formato=%s, fecha=%s]",
            idReporte, tipo!!.descripcion, formato, fechaGeneracion
        )
    }
}