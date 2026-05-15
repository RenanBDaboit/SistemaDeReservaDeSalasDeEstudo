package Service;

import entity.Sala;
import entity.Usuario;
import repository.SalaRepository;

public class SalaService {

    public boolean cadastrar(int id, int numero, int capacidade, SalaRepository repository){

        boolean idDuplicado = false;
        for (Sala s : repository.listar().values()) {
            if (s.getId() == id) {
                idDuplicado = true;
            }
        }
        if (idDuplicado || id <= 0) {
            return false;
        }
        boolean numeroDuplicado = false;
        for (Sala s : repository.listar().values()) {
            if (s.getNumero() == numero) {
                numeroDuplicado = true;
            }
        }
        if (numeroDuplicado || id <= 0) {
            return false;
        }
        if(capacidade <= 0){
            return false;
        }

        repository.salvar(new Sala(id, numero, capacidade));
        return true;
    }
}
