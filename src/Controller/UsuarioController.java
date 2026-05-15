package Controller;

import model.Service.UsuarioService;
import model.repository.UsuarioRepository;

public class UsuarioController {

    private final UsuarioService service = new UsuarioService();
    private final UsuarioRepository repository;

    public UsuarioController(UsuarioRepository repository) {
        this.repository = repository;
    }

    public boolean cadastrar(int id, String nome, String cpf){
        return service.cadastrar(id, cpf, nome, repository);
    }
}
