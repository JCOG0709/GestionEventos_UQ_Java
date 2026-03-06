package plataforma.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import plataforma.service.EstadoCompra;

public class Compra {
    private String idCompra;
    private String idUsuario;
    private LocalDateTime fechaCompra;
    private double valorCompra;
    private EstadoCompra estado;

}
