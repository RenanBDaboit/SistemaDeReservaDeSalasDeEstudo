package repository;

import entity.Sala;

import java.util.HashMap;

public class SalaRepository {

    private final HashMap<Integer, Sala> salas = new HashMap<>();

    public void salvar(Sala sala){
        salas.put(sala.getId(), sala);
    }

    public Sala buscar(int id){
        return salas.get(id);
    }

    public HashMap<Integer, Sala> listar() {
        return salas;
    }

    public void remover(int id){
        salas.remove(id);
    }
}
