package main.java.plataforma.model;

import main.java.plataforma.enums.EstadoAsiento;

public class Asiento {

        private String        idAsiento;
        private String        fila;
        private int           numero;
        private EstadoAsiento estado;

        public Asiento(String idAsiento, String fila, int numero) {
            this.idAsiento = idAsiento;
            this.fila      = fila;
            this.numero    = numero;
            this.estado    = EstadoAsiento.DISPONIBLE;
        }

        public void reservar() {
            if (estado != EstadoAsiento.DISPONIBLE)
                throw new IllegalStateException("El asiento no está disponible.");
            this.estado = EstadoAsiento.RESERVADO;
            System.out.println("Asiento " + getCodigo() + " → RESERVADO");
        }

        public void vender() {
            if (estado != EstadoAsiento.RESERVADO && estado != EstadoAsiento.DISPONIBLE)
                throw new IllegalStateException("El asiento no se puede vender. Estado: " + estado);
            this.estado = EstadoAsiento.VENDIDO;
            System.out.println("Asiento " + getCodigo() + " → VENDIDO");
        }

        public void bloquear() {
            this.estado = EstadoAsiento.BLOQUEADO;
            System.out.println("Asiento " + getCodigo() + " → BLOQUEADO");
        }

        public void liberar() {
            this.estado = EstadoAsiento.DISPONIBLE;
            System.out.println("Asiento " + getCodigo() + " → DISPONIBLE");
        }

        public void cambiarEstado(EstadoAsiento nuevoEstado) {
            this.estado = nuevoEstado;
        }

        public boolean estaDisponible() {
            return estado == EstadoAsiento.DISPONIBLE;
        }

        public String getCodigo() {
            return fila + numero;
        }

        public String        getIdAsiento() { return idAsiento; }
        public String        getFila()      { return fila; }
        public int           getNumero()    { return numero; }
        public EstadoAsiento getEstado()    { return estado; }

        @Override
        public String toString() {
            return String.format("Asiento[%s] Fila:%s Nro:%d Estado:%s",
                    idAsiento, fila, numero, estado);
        }
    }

