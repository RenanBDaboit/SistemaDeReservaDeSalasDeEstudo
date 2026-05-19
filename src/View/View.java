package View;

import Controller.ReservaController;
import Controller.SalaController;
import Controller.UsuarioController;
import model.repository.ReservaRepository;
import model.repository.SalaRepository;
import model.repository.UsuarioRepository;
import java.util.Scanner;

public class View {
    private Scanner sc = new Scanner(System.in);

    private final ReservaRepository reservaRepository = new ReservaRepository();
    private final SalaRepository salaRepository = new SalaRepository();
    private final UsuarioRepository usuarioRepository = new UsuarioRepository();
    
    private final ReservaController reservaController = new ReservaController(reservaRepository);
    private final SalaController salaController = new SalaController(salaRepository);
    private final UsuarioController usuarioController = new UsuarioController(usuarioRepository);

    private final ReservaView reservaView = new ReservaView(reservaController, reservaRepository, usuarioRepository, salaRepository);
    private final SalaView salaView = new SalaView(salaController);
    private final UsuarioView usuarioView = new UsuarioView(usuarioController);
    
    public void menuPrincipal(){
        int op;
        do{
            System.out.println("+=====================================+");
            System.out.println("|            MENU PRINCIPAL           |");
            System.out.println("+=====================================+");
            System.out.println("| [1] Reservas                        |");
            System.out.println("| [2] Salas                           |");
            System.out.println("| [3] Usuários                        |");
            System.out.println("| [0] Sair                            |");
            System.out.println("+=====================================+");
            System.out.print("Escolha uma opção: ");
            op = Integer.parseInt(sc.nextLine());
            
            switch (op){
                case 1 ->{
                    reservaView.menuReserva();
                }
                
                case 2 ->{
                    salaView.menuSala();
                }
                
                case 3 ->{
                    usuarioView.menuUsuario();
                }
                
                case 0 ->{
                    System.out.println("Saindo...");
                }
                
                
                default -> {
                    System.out.println("Opção incorreta!");
                }
            }
        } while(op != 0);
    }
}
