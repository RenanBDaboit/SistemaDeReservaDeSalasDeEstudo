package View;

import Controller.UsuarioController;

import java.util.Scanner;

public class UsuarioView {
    private final UsuarioController controller;
    private final Scanner sc= new Scanner(System.in);

    public UsuarioView(UsuarioController controller) {
        this.controller = controller;
    }
    
    public void menuUsuario(){
        int op;
        do{
            System.out.println("+=====================================+");
            System.out.println("|             MENU USUÁRIO            |");
            System.out.println("+=====================================+");
            System.out.println("| [1] Cadastrar Usuário               |");
            System.out.println("| [0] Sair                            |");
            System.out.println("+=====================================+");
            System.out.print("Escolha uma opção: ");
            op = Integer.parseInt(sc.nextLine());
            
            switch (op){
                case 1 ->{
                    cadastrarUsuario();
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
    
    private void cadastrarUsuario(){
        System.out.print("Nome: ");
        String nome = sc.nextLine();

        System.out.print("ID: ");
        int id = Integer.parseInt(sc.nextLine());

        System.out.print("CPF:");
        String cpf = sc.nextLine();

        boolean sucesso = controller.cadastrar(id, nome, cpf);

        if (sucesso) {
            System.out.println("Usuário cadastrado com sucesso");
        }
        else {
            System.out.println("Erro ao cadastrar usuário");
        }
    }
    
}
