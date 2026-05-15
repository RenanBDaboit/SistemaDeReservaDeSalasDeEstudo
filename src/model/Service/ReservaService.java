package model.Service;

import model.entity.Reserva;
import model.entity.Sala;
import model.entity.Usuario;
import model.repository.ReservaRepository;

public class ReservaService {

    public boolean cadastrar(int id, Usuario usuario, Sala sala, String data, String horario, ReservaRepository repository) {

        boolean idDuplicado = false;

        for (Reserva r : repository.listar().values()) {
            if (r.getId() == id) {
                idDuplicado = true;
            }
        }
        if (idDuplicado || id <= 0) {
            return false;
        }
        if (data.isBlank()) {
            return false;
        }
        if (horario.isBlank()) {
            return false;
        }
        repository.salvar(new Reserva(id, usuario, data, horario, sala));

        return true;
    }
}
