package entity;

public class Usuario {

    private int id;
    private String nome;
    private String cpf;

    public Usuario(String nome, int id, String cpf) {
        this.nome = nome;
        this.id = id;
        this.cpf = cpf;
    }
        public String getNome () {
            return nome;
        }

        public void setNome (String nome){
            this.nome = nome;
        }

        public int getId () {
            return id;
        }

        public void setId ( int id){
            this.id = id;
        }

        public String getCpf () {
            return cpf;
        }

        public void setCpf (String cpf){
            this.cpf = cpf;

        }
    }

