package Controller;

import model.Service.ReservaService;
import model.entity.Sala;
import model.entity.Usuario;
import model.repository.ReservaRepository;
import model.repository.SalaRepository;
import model.repository.UsuarioRepository;

import java.util.HashMap;

public class ReservaController {

    private final ReservaService service = new ReservaService();
    private final ReservaRepository repository;
    private final SalaRepository salaRepository;
    private final UsuarioRepository usuarioRepository;

    public ReservaController(ReservaRepository repository, SalaRepository salaRepository, UsuarioRepository usuarioRepository) {
        this.repository = repository;
        this.salaRepository = salaRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public boolean cadastrar(int id, int idUsuario, int idSala, String data, String horario){
        return service.cadastrar(id, idUsuario, idSala, data, horario, usuarioRepository, salaRepository, repository);
    }

    public HashMap<Integer, Sala> listarSalas(){
        return salaRepository.listar();
    }

    public HashMap<Integer, Usuario> listarUsuarios(){
        return usuarioRepository.listar();
    }

    public boolean atualizar(int id, int idUsuario, int idSala, String data, String horario){
        return service.atualizar(id, idUsuario, idSala, data, horario, usuarioRepository, salaRepository, repository);
    }

    public boolean remover(int id){
        repository.listar().get(id).getSala().setDisponivel(true);
        return service.remover(id, repository);
    }
}
