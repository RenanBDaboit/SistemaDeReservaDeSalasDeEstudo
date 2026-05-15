package model.entity;

public class Reserva {

    private int id;
    private Usuario usuario;
    private Sala sala;
    private String data;
    private String horario;
    private String status;

    public Reserva(int id, Usuario usuario, String data, String horario, Sala sala) {
        this.id = id;
        this.usuario = usuario;
        this.data = data;
        this.horario = horario;
        this.status = "Ativo";
        this.sala = sala;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
