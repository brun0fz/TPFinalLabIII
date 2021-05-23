package com.company;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Reserva {

    private Habitacion habitacion;
    private Pasajero pasajero;
    private LocalDate fechaIn;
    private LocalDate fechaOut;
    private Double precio;

    private List<Pasajero> pasajeroList = new ArrayList<>();

}
