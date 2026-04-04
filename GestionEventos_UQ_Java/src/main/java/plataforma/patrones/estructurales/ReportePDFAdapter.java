package main.java.plataforma.patrones.estructurales;

import main.java.plataforma.patrones.creacionales.Reporte;

/**
 * CLASE: ReportePDFAdapter
 *
 * PATRÓN: ADAPTER (Estructural) - ConcreteAdapter
 *
 * PROPÓSITO: Adapta un objeto Reporte al formato PDF.
 * Simula la estructura de un archivo PDF con la información del reporte.
 *
 * NOTA: En una implementación real, se usaría una librería como Apache PDFBox
 * o iText para generar el PDF correctamente.
 *
 * @author TuNombre
 */
public class ReportePDFAdapter implements IReporteAdapter {

    @Override
    public String exportar(Reporte reporte) {
        StringBuilder pdfSimulado = new StringBuilder();
        pdfSimulado.append("%PDF-1.4\n");
        pdfSimulado.append("1 0 obj\n<< /Type /Catalog /Pages 2 0 R >>\nendobj\n");
        pdfSimulado.append("2 0 obj\n<< /Type /Pages /Kids [3 0 R] /Count 1 >>\nendobj\n");
        pdfSimulado.append("3 0 obj\n<< /Type /Page /Parent 2 0 R /Resources << /Font << /F1 4 0 R >> >> /MediaBox [0 0 612 792] /Contents 5 0 R >>\nendobj\n");
        pdfSimulado.append("4 0 obj\n<< /Type /Font /Subtype /Type1 /BaseFont /Helvetica >>\nendobj\n");
        pdfSimulado.append("5 0 obj\n<< /Length 6 0 R >>\nstream\n");
        pdfSimulado.append("BT /F1 24 Tf 100 700 Td (REPORTE DE GESTION DE EVENTOS) Tj ET\n");
        pdfSimulado.append("BT /F1 12 Tf 100 670 Td (ID: ").append(reporte.getIdReporte()).append(") Tj ET\n");
        pdfSimulado.append("BT /F1 12 Tf 100 650 Td (Tipo: ").append(reporte.getTipo().getDescripcion()).append(") Tj ET\n");
        pdfSimulado.append("BT /F1 12 Tf 100 630 Td (Fecha: ").append(reporte.getFechaGeneracion()).append(") Tj ET\n");
        pdfSimulado.append("BT /F1 12 Tf 100 610 Td (Rango: ").append(reporte.getRangoFechas()).append(") Tj ET\n");
        pdfSimulado.append("BT /F1 12 Tf 100 590 Td (Resumen: ").append(reporte.getDatosResumen()).append(") Tj ET\n");
        pdfSimulado.append("endstream\nendobj\n");
        pdfSimulado.append("6 0 obj\n").append(pdfSimulado.length()).append("\nendobj\nxref\n0 7\n...\n%%EOF\n");

        System.out.println("📑 Reporte exportado a PDF (simulado)");
        return pdfSimulado.toString();
    }

    @Override
    public byte[] exportarBytes(Reporte reporte) {
        return exportar(reporte).getBytes();
    }

    @Override
    public String getFormatoSoportado() {
        return "PDF";
    }
}
