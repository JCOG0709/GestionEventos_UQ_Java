package main.java.plataforma.model;

import java.util.HashMap;
import java.util.Map;

/**
 * CLASE: PanelMetrics
 *
 * Propósito: Administrar y calcular las métricas del sistema para el panel del administrador.
 * Cumple con RF-018 y RF-019 del proyecto (ventas por periodo, ocupación por zona,
 * ingresos por servicios, tasa de cancelación, top eventos).
 *
 * @author TuNombre
 */
public class PanelMetricas {
    // Almacena ventas agrupadas por periodo (ej: "2026-03" -> 15000.0)
    private Map<String, Double> ventasPorPeriodo;

    // Almacena ocupación por zona (ej: "VIP" -> 45 asientos ocupados)
    private Map<String, Integer> ocupacionPorZona;

    // Almacena ingresos por servicios adicionales
    private Map<String, Double> ingresosServicios;

    // Tasa de cancelación en porcentaje
    private double tasaCancelacion;

    // Top eventos más vendidos (nombre del evento -> cantidad vendida)
    private Map<String, Integer> topEventos;

    /**
     * Constructor: Inicializa todas las estructuras de datos vacías.
     */
    public PanelMetricas() {
        this.ventasPorPeriodo = new HashMap<>();
        this.ocupacionPorZona = new HashMap<>();
        this.ingresosServicios = new HashMap<>();
        this.topEventos = new HashMap<>();
        this.tasaCancelacion = 0.0;
    }

    // ========== MÉTODOS DE CÁLCULO ==========

    public void calcularVentasPorPeriodo(Map<String, Double> ventas) {
        this.ventasPorPeriodo = ventas;
    }

    public void calcularOcupacionPorZona(Map<String, Integer> ocupacion) {
        this.ocupacionPorZona = ocupacion;
    }

    public void calcularIngresosServicios(Map<String, Double> ingresos) {
        this.ingresosServicios = ingresos;
    }

    /**
     * Calcula la tasa de cancelación como porcentaje.
     * @param totalCompras Total de compras realizadas
     * @param cancelaciones Número de compras canceladas
     */
    public void calcularTasaCancelacion(int totalCompras, int cancelaciones) {
        if (totalCompras > 0) {
            this.tasaCancelacion = (cancelaciones * 100.0) / totalCompras;
        }
    }

    public void calcularTopEventos(Map<String, Integer> eventos) {
        this.topEventos = eventos;
    }

    // ========== GETTERS ==========

    public Map<String, Double> getVentasPorPeriodo() { return ventasPorPeriodo; }
    public Map<String, Integer> getOcupacionPorZona() { return ocupacionPorZona; }
    public Map<String, Double> getIngresosServicios() { return ingresosServicios; }
    public double getTasaCancelacion() { return tasaCancelacion; }
    public Map<String, Integer> getTopEventos() { return topEventos; }

    /**
     * Genera un resumen legible de todas las métricas.
     * @return String con el resumen formateado
     */
    public String generarResumen() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== PANEL DE MÉTRICAS ===\n");
        sb.append(" Tasa de cancelación: ").append(String.format("%.2f", tasaCancelacion)).append("%\n");
        sb.append(" Top eventos: ").append(topEventos).append("\n");
        sb.append(" Ventas por periodo: ").append(ventasPorPeriodo).append("\n");
        sb.append(" Ocupación por zona: ").append(ocupacionPorZona).append("\n");
        return sb.toString();
    }

    @Override
    public String toString() {
        return generarResumen();
    }
}