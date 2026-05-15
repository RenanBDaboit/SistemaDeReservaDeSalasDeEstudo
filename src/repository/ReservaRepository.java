package repository;

import entity.Reserva;

import java.util.HashMap;

public class ReservaRepository {

    private final HashMap<Integer, Reserva> resservas = new HashMap<>();

    public HashMap<Integer, Reserva> getResservas() {
        return resservas;
    }
}
