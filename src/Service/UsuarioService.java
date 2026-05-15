package Service;

import entity.Usuario;
import repository.UsuarioRepository;

public class UsuarioService {

    public boolean cadastrar(int id, String cpf, String nome, UsuarioRepository repository) {

        boolean cpfDuplicado = false;

        for (Usuario u : repository.listar().values()) {
            if (u.getCpf().equals(cpf)) {
                cpfDuplicado = true;
            }
        }
        if (cpfDuplicado) {
            return false;
        }
        boolean idDuplicado = false;
        for (Usuario u : repository.listar().values()) {
            if (u.getId() == id) {
                idDuplicado = true;
            }
        }
            if (idDuplicado || id <= 0) {
                return false;
            }
            if (nome.isBlank()) {
                return false;
            }

            repository.salvar(new Usuario(nome, id, cpf));
            return true;
        }
    }
