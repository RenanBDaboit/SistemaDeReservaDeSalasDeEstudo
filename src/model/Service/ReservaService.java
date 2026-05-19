package model.Service;

import model.entity.Reserva;
import model.entity.Sala;
import model.entity.Usuario;
import model.repository.ReservaRepository;
import model.repository.SalaRepository;
import model.repository.UsuarioRepository;

public class ReservaService {

    public boolean cadastrar(int id, int idUsuario, int idSala, String data, String horario, UsuarioRepository usuarioRepository, SalaRepository salaRepository, ReservaRepository repository) {

        boolean idNaoExistente = true;
        boolean salaNaoExiste = true;
        boolean usuarioNaoExiste = true;

        Sala salaSalvar = null;
        Usuario usuarioSalvar = null;

        if (data.isBlank()) {
            return false;
        }
        if (horario.isBlank()) {
            return false;
        }

        for (Usuario usuario : usuarioRepository.listar().values()){
            if (usuario.getId() == idUsuario){
                usuarioNaoExiste = false;
                usuarioSalvar = usuario;
            }
        }

        for (Sala sala : salaRepository.listar().values()){
            if (sala.getId() == idSala){
                salaNaoExiste = false;
                salaSalvar = sala;
            }
        }

        for (Reserva r : repository.listar().values()) {
            if (r.getId() == id) {
                idNaoExistente = false;
            }
        }
        if (!idNaoExistente) {
            return false;
        }

        if (usuarioNaoExiste){
            return false;
        }

        if (salaNaoExiste){
            return false;
        }
        repository.salvar(new Reserva(id, usuarioSalvar, data, horario, salaSalvar));
        salaSalvar.setDisponivel(false);
        return true;
    }

    public boolean atualizar(int id, int idUsuario, int idSala, String data, String horario, UsuarioRepository usuarioRepository, SalaRepository salaRepository, ReservaRepository repository){
        boolean idNaoExistente = true;
        boolean salaNaoExiste = true;
        boolean usuarioNaoExiste = true;

        Sala salaAtualizar = null;
        Usuario usuarioAtualizar = null;

        if (data.isBlank()) {
            return false;
        }
        if (horario.isBlank()) {
            return false;
        }

        for (Usuario usuario : usuarioRepository.listar().values()){
            if (usuario.getId() == idUsuario){
                usuarioNaoExiste = false;
                usuarioAtualizar = usuario;
            }
        }

        for (Sala sala : salaRepository.listar().values()){
            if (sala.getId() == idSala){
                salaNaoExiste = false;
                salaAtualizar = sala;
            }
        }

        for (Reserva r : repository.listar().values()) {
            if (r.getId() == id) {
                idNaoExistente = false;
            }
        }
        if (!idNaoExistente) {
            return false;
        }

        if (usuarioNaoExiste){
            return false;
        }

        if (salaNaoExiste){
            return false;
        }

        repository.listar().get(id).getSala().setDisponivel(true);
        repository.atualizar(new Reserva(id, usuarioAtualizar, data, horario, salaAtualizar));
        salaAtualizar.setDisponivel(false);
        return true;
    }

    public boolean remover(int id, ReservaRepository repository){
        for (Reserva r : repository.listar().values()) {
            if (r.getId() == id) {
                r.getSala().setDisponivel(true);
                repository.remover(id);
                return true;
            }
        }
        return false;
    }
}
