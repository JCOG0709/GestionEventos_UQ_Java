package main.java.plataforma.patrones.estructurales

import main.java.plataforma.patrones.creacionales.Reporte

/**
 * INTERFAZ: IReporteAdapter
 *
 * PATRÓN: ADAPTER (Estructural) - Target
 *
 * PROPÓSITO: Define el contrato que deben cumplir todos los adaptadores
 * de exportación de reportes. Actúa como el "Target" del patrón Adapter.
 *
 * REQUISITO CUBIERTO: RF-019 (Generador de Reportes Operativos - CSV/PDF/XLSX)
 *
 * PROBLEMA QUE RESUELVE: Unificar la interfaz para exportar reportes en
 * diferentes formatos (CSV, PDF, XLSX) sin que el cliente tenga que conocer
 * las implementaciones específicas de cada formato.
 *
 * @author TuNombre
 */
interface IReporteAdapter {
    fun exportar(reporte: Reporte?): String?
    fun exportarBytes(reporte: Reporte?): ByteArray?
    val formatoSoportado: String?
}