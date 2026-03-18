package main.java.plataforma.model;
import java.util.ArrayList;
import java.util.List;

    public class Recinto {

        private String     idRecinto;
        private String     nombre;
        private String     direccion;
        private String     ciudad;
        private int        capacidadTotal;
        private List<Zona> zonas;

        public Recinto(String idRecinto, String nombre,
                       String direccion, String ciudad, int capacidadTotal) {
            this.idRecinto      = idRecinto;
            this.nombre         = nombre;
            this.direccion      = direccion;
            this.ciudad         = ciudad;
            this.capacidadTotal = capacidadTotal;
            this.zonas          = new ArrayList<>();
        }

        public void agregarZona(Zona zona) {
            zonas.add(zona);
            System.out.println("Zona '" + zona.getNombre() + "' agregada a " + nombre);
        }

        public void eliminarZona(String idZona) {
            boolean eliminado = zonas.removeIf(z -> z.getIdZona().equals(idZona));
            if (!eliminado)
                System.out.println("Zona no encontrada: " + idZona);
        }

        public Zona buscarZona(String idZona) {
            return zonas.stream()
                    .filter(z -> z.getIdZona().equals(idZona))
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException(
                            "Zona no encontrada: " + idZona));
        }

        public List<Zona> consultarZonas() {
            return new ArrayList<>(zonas);
        }

        public String     getIdRecinto()      { return idRecinto; }
        public String     getNombre()         { return nombre; }
        public String     getDireccion()      { return direccion; }
        public String     getCiudad()         { return ciudad; }
        public int        getCapacidadTotal() { return capacidadTotal; }
        public List<Zona> getZonas()          { return zonas; }

        public void setNombre(String nombre)   { this.nombre = nombre; }
        public void setDireccion(String dir)   { this.direccion = dir; }

        @Override
        public String toString() {
            return String.format("Recinto[%s] %s — %s, %s | Zonas:%d",
                    idRecinto, nombre, direccion, ciudad, zonas.size());
        }
    }
