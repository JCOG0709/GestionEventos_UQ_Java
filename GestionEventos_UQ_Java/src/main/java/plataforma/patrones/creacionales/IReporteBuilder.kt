package main.java.plataforma.patrones.creacionales

import main.java.plataforma.enums.FormatoReporte
import main.java.plataforma.enums.TipoReporte
import java.time.LocalDateTime

/**
 * INTERFAZ: IReporteBuilder
 *
 * PATRÓN: BUILDER (Creacional) - Builder
 *
 * PROPÓSITO: Define los métodos para construir un reporte paso a paso.
 * Permite crear diferentes tipos de reportes con la misma interfaz.
 *
 * REQUISITO CUBIERTO: RF-019 (Generador de Reportes Operativos)
 *
 * PROBLEMA QUE RESUELVE: Construir objetos complejos (Reporte) con muchos
 * atributos opcionales de manera legible y sin constructores con muchos parámetros.
 *
 * @author TuNombre
 */
interface IReporteBuilder {
    fun reset(): IReporteBuilder?
    fun setIdReporte(id: String?): IReporteBuilder?
    fun setTipo(tipo: TipoReporte?): IReporteBuilder?
    fun setFormato(formato: FormatoReporte?): IReporteBuilder?
    fun setRangoFechas(desde: String?, hasta: String?): IReporteBuilder?
    fun setDatosResumen(resumen: String?): IReporteBuilder?
    fun setContenido(contenido: String?): IReporteBuilder?
    fun setFechaGeneracion(fecha: LocalDateTime?): IReporteBuilder?
    fun build(): Reporte?
}