package main.java.plataforma.patrones.estructurales;

import main.java.plataforma.patrones.creacionales.Reporte;

/**
 * CLASE: ReporteXLSXAdapter
 *
 * PATRÓN: ADAPTER (Estructural) - ConcreteAdapter
 *
 * PROPÓSITO: Adapta un objeto Reporte al formato XLSX (Microsoft Excel).
 * Simula la estructura XML de un archivo Excel con la información del reporte.
 *
 * NOTA: En una implementación real, se usaría una librería como Apache POI.
 *
 * @author TuNombre
 */
public class ReporteXLSXAdapter implements IReporteAdapter {

    @Override
    public String exportar(Reporte reporte) {
        StringBuilder excelSimulado = new StringBuilder();
        excelSimulado.append("<?xml version=\"1.0\"?>\n");
        excelSimulado.append("<workbook xmlns=\"http://schemas.openxmlformats.org/spreadsheetml/2006/main\">\n");
        excelSimulado.append("  <sheets>\n");
        excelSimulado.append("    <sheet name=\"Reporte\">\n");
        excelSimulado.append("      <row>\n");
        excelSimulado.append("        <cell>ID Reporte</cell><cell>").append(reporte.getIdReporte()).append("</cell>\n");
        excelSimulado.append("      </row>\n");
        excelSimulado.append("      <row>\n");
        excelSimulado.append("        <cell>Tipo</cell><cell>").append(reporte.getTipo().getDescripcion()).append("</cell>\n");
        excelSimulado.append("      </row>\n");
        excelSimulado.append("      <row>\n");
        excelSimulado.append("        <cell>Formato</cell><cell>").append(reporte.getFormato()).append("</cell>\n");
        excelSimulado.append("      </row>\n");
        excelSimulado.append("      <row>\n");
        excelSimulado.append("        <cell>Fecha</cell><cell>").append(reporte.getFechaGeneracion()).append("</cell>\n");
        excelSimulado.append("      </row>\n");
        excelSimulado.append("      <row>\n");
        excelSimulado.append("        <cell>Rango</cell><cell>").append(reporte.getRangoFechas()).append("</cell>\n");
        excelSimulado.append("      </row>\n");
        excelSimulado.append("      <row>\n");
        excelSimulado.append("        <cell>Resumen</cell><cell>").append(reporte.getDatosResumen()).append("</cell>\n");
        excelSimulado.append("      </row>\n");
        excelSimulado.append("    </sheet>\n");
        excelSimulado.append("  </sheets>\n");
        excelSimulado.append("</workbook>\n");

        System.out.println("📊 Reporte exportado a XLSX (simulado)");
        return excelSimulado.toString();
    }

    @Override
    public byte[] exportarBytes(Reporte reporte) {
        return exportar(reporte).getBytes();
    }

    @Override
    public String getFormatoSoportado() {
        return "XLSX";
    }
}