package repository;

import entity.Usuario;

import java.util.HashMap;

public class UsuarioRepository {

    private final HashMap<Integer, Usuario> usuarios = new HashMap<>();

    public HashMap<Integer, Usuario> getUsuarios() {
        return usuarios;
    }
}