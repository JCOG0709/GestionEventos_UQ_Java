package main.java.plataforma.patrones.creacionales;

import main.java.plataforma.enums.TipoReporte;
import main.java.plataforma.enums.FormatoReporte;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * CLASE: ReporteBuilder
 *
 * PATRÓN: BUILDER (Creacional) - ConcreteBuilder
 *
 * PROPÓSITO: Implementación concreta del builder para construir reportes.
 * Permite una construcción fluida (method chaining) del objeto Reporte.
 *
 * EJEMPLO DE USO:
 * Reporte reporte = new ReporteBuilder()
 *     .setTipo(TipoReporte.VENTAS_POR_PERIODO)
 *     .setFormato(FormatoReporte.PDF)
 *     .setRangoFechas("2026-03-01", "2026-03-31")
 *     .build();
 *
 * @author TuNombre
 */
public class ReporteBuilder implements IReporteBuilder {
    private Reporte reporte;

    public ReporteBuilder() {
        this.reporte = new Reporte();
    }

    @Override
    public IReporteBuilder reset() {
        this.reporte = new Reporte();
        return this;
    }

    @Override
    public IReporteBuilder setIdReporte(String id) {
        reporte.setIdReporte(id);
        return this;
    }

    @Override
    public IReporteBuilder setTipo(TipoReporte tipo) {
        reporte.setTipo(tipo);
        return this;
    }

    @Override
    public IReporteBuilder setFormato(FormatoReporte formato) {
        reporte.setFormato(formato);
        return this;
    }

    @Override
    public IReporteBuilder setRangoFechas(String desde, String hasta) {
        reporte.setRangoFechas(desde + " - " + hasta);
        return this;
    }

    @Override
    public IReporteBuilder setDatosResumen(String resumen) {
        reporte.setDatosResumen(resumen);
        return this;
    }

    @Override
    public IReporteBuilder setContenido(String contenido) {
        reporte.setContenido(contenido);
        return this;
    }

    @Override
    public IReporteBuilder setFechaGeneracion(LocalDateTime fecha) {
        reporte.setFechaGeneracion(fecha);
        return this;
    }

    @Override
    public Reporte build() {
        if (reporte.getIdReporte() == null) {
            reporte.setIdReporte(UUID.randomUUID().toString());
        }
        if (reporte.getFechaGeneracion() == null) {
            reporte.setFechaGeneracion(LocalDateTime.now());
        }
        return reporte;
    }
}