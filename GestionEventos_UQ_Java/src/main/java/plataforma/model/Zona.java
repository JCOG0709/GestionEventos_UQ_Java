package main.java.plataforma.model;

import main.java.plataforma.enums.EstadoAsiento;

import java.util.ArrayList;
import java.util.List;

    public class Zona {

        private String        idZona;
        private String        nombre;
        private int           capacidad;
        private double        precioBase;
        private boolean       tieneAsientos;
        private List<Asiento> asientos;

        public Zona(String idZona, String nombre, int capacidad,
                    double precioBase, boolean tieneAsientos) {
            this.idZona        = idZona;
            this.nombre        = nombre;
            this.capacidad     = capacidad;
            this.precioBase    = precioBase;
            this.tieneAsientos = tieneAsientos;
            this.asientos      = new ArrayList<>();
        }

        public void agregarAsiento(Asiento asiento) {
            if (asientos.size() >= capacidad)
                throw new IllegalStateException("La zona " + nombre + " está llena.");
            asientos.add(asiento);
        }

        public void eliminarAsiento(String idAsiento) {
            asientos.removeIf(a -> a.getIdAsiento().equals(idAsiento));
        }

        public Asiento buscarAsiento(String idAsiento) {
            return asientos.stream()
                    .filter(a -> a.getIdAsiento().equals(idAsiento))
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException(
                            "Asiento no encontrado: " + idAsiento));
        }

        public void habilitarAsientos() {
            asientos.forEach(Asiento::liberar);
            System.out.println("Asientos de zona '" + nombre + "' habilitados.");
        }

        public void bloquearAsientos() {
            asientos.forEach(Asiento::bloquear);
            System.out.println("Asientos de zona '" + nombre + "' bloqueados.");
        }

        public int consultarOcupacion() {
            return (int) asientos.stream()
                    .filter(a -> a.getEstado() == EstadoAsiento.VENDIDO
                            || a.getEstado() == EstadoAsiento.RESERVADO)
                    .count();
        }

        public int calcularDisponibles() {
            if (!tieneAsientos) return capacidad - consultarOcupacion();
            return (int) asientos.stream()
                    .filter(Asiento::estaDisponible)
                    .count();
        }

        public String  getIdZona()       { return idZona; }
        public String  getNombre()       { return nombre; }
        public int     getCapacidad()    { return capacidad; }
        public double  getPrecioBase()   { return precioBase; }
        public boolean isTieneAsientos() { return tieneAsientos; }
        public List<Asiento> getAsientos() { return asientos; }

        public void setPrecioBase(double precioBase) { this.precioBase = precioBase; }
        public void setCapacidad(int capacidad)       { this.capacidad = capacidad; }

        @Override
        public String toString() {
            return String.format("Zona[%s] %s | Cap:%d | Precio:$%.2f | Disponibles:%d",
                    idZona, nombre, capacidad, precioBase, calcularDisponibles());
        }
    }

