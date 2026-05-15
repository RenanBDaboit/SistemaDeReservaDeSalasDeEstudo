package repository;

import entity.Sala;

import java.util.HashMap;

public class SalaRepository {

    private final HashMap<Integer, Sala> salas = new HashMap<>();

    public HashMap<Integer, Sala> getSalas() {
        return salas;
    }
}
