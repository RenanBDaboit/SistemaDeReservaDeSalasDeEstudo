package Controller;

import model.Service.ReservaService;
import model.entity.Sala;
import model.entity.Usuario;
import model.repository.ReservaRepository;

public class ReservaController {

    private final ReservaService service = new ReservaService();
    private final ReservaRepository repository;

    public ReservaController(ReservaRepository repository) {
        this.repository = repository;
    }

    public boolean cadastrar(int id, Usuario usuario, Sala sala, String data, String horario){
        return service.cadastrar(id, usuario, sala, data, horario, repository);
    }
}
