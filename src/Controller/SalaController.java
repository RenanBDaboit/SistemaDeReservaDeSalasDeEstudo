package Controller;

import model.Service.SalaService;
import model.repository.SalaRepository;

public class SalaController {

    private final SalaService service = new SalaService();
    private final SalaRepository repository;

    public SalaController(SalaRepository repository) {
        this.repository = repository;
    }

    public boolean cadastrar(int id, int numero, int capacidade){
        return service.cadastrar(id, numero, capacidade, repository);
    }
}
