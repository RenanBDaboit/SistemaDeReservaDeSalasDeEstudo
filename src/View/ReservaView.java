package View;

import Controller.ReservaController;
import model.entity.Reserva;
import model.entity.Sala;
import model.entity.Usuario;
import model.repository.ReservaRepository;
import model.repository.UsuarioRepository;
import model.repository.SalaRepository;
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
            System.out.println("Escolha uma opção: ");
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
        System.out.println("ID da reserva: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.println("ID do usuário que vai fazer a reserva: ");
        int idUsuario = sc.nextInt();
        Usuario usuario = usuarioRepository.buscar(idUsuario);

        System.out.println("Data da reserva (DD/MM/AAAA): ");
        String data = sc.nextLine();

        System.out.println("Horário da reserva: ");
        String horario = sc.nextLine();

        int idSala = sc.nextInt();
        Sala sala = salaRepository.buscar(idSala);
        
        Reserva reserva = new Reserva(id, usuario, data, horario, sala);
        reservaRepository.salvar(reserva);
        System.out.println("Reserva feita com sucesso!");
    }
    
    private void listarReservas(){
        for(Reserva reserva : reservaRepository.listar().values()){
            System.out.println(reserva);
        }
    }
    
    private void atualizarReservas(){
        System.out.println("ID da reserva que deseja atualizar: ");
        int id = sc.nextInt();
        Reserva reserva = reservaRepository.buscar(id);
        
        if(reserva == null ){
            System.out.println("Reserva não encontrada!");
            return;
        }

        System.out.println("Novo usuário: ");
        int idUsuario = sc.nextInt();
        Usuario usuario = usuarioRepository.buscar(idUsuario);

        System.out.println("Nova data (DD/MM/AAAA): ");
        String data = sc.nextLine();

        System.out.println("Novo horário: ");
        String horario = sc.nextLine();

        int idSala = sc.nextInt();
        Sala sala = salaRepository.buscar(idSala);

        Reserva atualizar = new Reserva(id, usuario, data, horario, sala);
        reservaRepository.salvar(atualizar);
        System.out.println("Reserva atualizada com sucesso!");
    }
    
    private void cancelarRemoverReserva(){
        System.out.println("ID da reserva que deseja remover: ");
        int id = sc.nextInt();
        
        Reserva reserva = reservaRepository.buscar(id);
        
        if(reserva == null){
            System.out.println("Reserva nao encontrada!");
            return;
        }
        
        reservaRepository.remover(id);
        System.out.println("Reserva removida com sucesso!");
    }
    
}
