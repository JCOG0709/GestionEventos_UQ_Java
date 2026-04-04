package main.java.plataforma.enums

/**
 * ENUM: FormatoReporte
 *
 * Propósito: Define los formatos de exportación disponibles para los reportes.
 * Se utiliza en el patrón Adapter para saber qué adaptador usar.
 *
 * @author TuNombre
 */
enum class FormatoReporte(mimeType: String) {
    CSV("text/csv"),
    PDF("application/pdf"),
    XLSX("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");

    // Getter
    val mimeType: String?

    // Constructor
    init {
        this.mimeType = mimeType
    }
}