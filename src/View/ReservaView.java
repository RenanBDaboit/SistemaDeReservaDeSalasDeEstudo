package View;

import Controller.ReservaController;
import model.entity.Reserva;
import model.entity.Sala;
import model.entity.Usuario;
import model.repository.ReservaRepository;
import model.repository.UsuarioRepository;
import model.repository.SalaRepository;

import java.util.Map;
import java.util.Scanner;

public class ReservaView {
    private final ReservaController controller;
    private final ReservaRepository reservaRepository;
    private final UsuarioRepository usuarioRepository;
    private final SalaRepository salaRepository;
    private final Scanner sc = new Scanner(System.in);

    public ReservaView(ReservaController controller, ReservaRepository reservaRepository, UsuarioRepository 
            usuarioRepository, SalaRepository salaRepository) {
        this.controller = controller;
        this.reservaRepository = reservaRepository; 
        this.usuarioRepository = usuarioRepository;
        this.salaRepository = salaRepository;
    }
    
    public void menuReserva(){
        int op;
        do{
            System.out.println("+=====================================+");
            System.out.println("|             MENU RESERVA            |");
            System.out.println("+=====================================+");
            System.out.println("| [1] Fazer reserva                   |");
            System.out.println("| [2] Listar reserva(s)               |");
            System.out.println("| [3] Atualizar reserva               |");
            System.out.println("| [4] Cancelar/Remover reserva        |");
            System.out.println("| [0] Sair                            |");
            System.out.println("+=====================================+");
            System.out.print("Escolha uma opção: ");
            op = Integer.parseInt(sc.nextLine());
            
            switch (op){
                case 1 ->{
                    fazerReserva();
                }
                
                case 2 ->{
                    listarReservas();
                }
                
                case 3 ->{
                    atualizarReservas();
                }
                
                case 4 ->{
                    cancelarRemoverReserva();
                }
                
                case 0 ->{
                    System.out.println("Saindo...");
                }
                
                default ->{
                    System.out.println("Opção incorreta");
                }
            }
        } while(op != 0);
    }
    
    private void fazerReserva(){
        System.out.print("ID da reserva: ");
        int id = Integer.parseInt(sc.nextLine());

        listarUsuarios();
        System.out.print("ID do usuário que vai fazer a reserva: ");
        int idUsuario = Integer.parseInt(sc.nextLine());

        System.out.print("Data da reserva (DD/MM/AAAA): ");
        String data = sc.nextLine();

        System.out.print("Horário da reserva: ");
        String horario = sc.nextLine();

        listarSalas();
        System.out.print("ID da sala que vai ser reservada: ");
        int idSala = Integer.parseInt(sc.nextLine());
        
        boolean sucesso = controller.cadastrar(id, idUsuario, idSala, data, horario);

        if (sucesso){
            System.out.println("Reserva feita com sucesso!");
        }
        else {
            System.out.println("Erro ao cadastrar reserva");
        }
    }
    
    private void listarReservas(){
        for(Reserva reserva : reservaRepository.listar().values()){
            System.out.println(reserva);
        }
    }

    private void listarUsuarios() {
        for (Usuario usuario : controller.listarUsuarios().values()){
            System.out.println(usuario);
        }
    }

    private void listarSalas(){
        for (Sala sala : controller.listarSalas().values()){
            System.out.println(sala);
        }
    }
    
    private void atualizarReservas(){

        listarReservas();
        System.out.print("ID da reserva que deseja atualizar: ");
        int id = Integer.parseInt(sc.nextLine());
        Reserva reserva = reservaRepository.buscar(id);
        
        if(reserva == null ){
            System.out.println("Reserva não encontrada!");
            return;
        }

        listarUsuarios();
        System.out.print("Novo usuário: ");
        int idUsuario = Integer.parseInt(sc.nextLine());
        Usuario usuario = usuarioRepository.buscar(idUsuario);

        System.out.print("Nova data (DD/MM/AAAA): ");
        String data = sc.nextLine();

        System.out.print("Novo horário: ");
        String horario = sc.nextLine();

        listarSalas();
        System.out.print("ID da sala que vai ser reservada: ");
        int idSala = Integer.parseInt(sc.nextLine());
        Sala sala = salaRepository.buscar(idSala);

        Reserva atualizar = new Reserva(id, usuario, data, horario, sala);
        reservaRepository.salvar(atualizar);
        System.out.println("Reserva atualizada com sucesso!");
    }
    
    private void cancelarRemoverReserva(){

        listarReservas();
        System.out.print("ID da reserva que deseja remover: ");
        int id = Integer.parseInt(sc.nextLine());
        
        Reserva reserva = reservaRepository.buscar(id);
        
        if(reserva == null){
            System.out.println("Reserva não encontrada!");
            return;
        }
        
        boolean sucesso = controller.remover(id);

        if (sucesso) {
            System.out.println("Reserva removida com sucesso!");
        }
        else {
            System.out.println("Erro ao remover reserva");
        }
    }
}
