package View;

import Controller.SalaController;

import java.util.Scanner;

public class SalaView {
    private final SalaController controller;
    private final Scanner sc = new Scanner(System.in);

    public SalaView(SalaController controller) {
        this.controller = controller;
    }
    
    public void menuSala(){
        int op;
        do{
            System.out.println("+=====================================+");
            System.out.println("|              MENU SALA              |");
            System.out.println("+=====================================+");
            System.out.println("| [1] Cadastrar Sala                  |");
            System.out.println("| [0] Sair                            |");
            System.out.println("+=====================================+");
            System.out.print("Escolha uma opção: ");
            op = Integer.parseInt(sc.nextLine());
            
            switch (op){
                case 1 ->{
                   cadastrarSala(); 
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
    
    private void cadastrarSala(){
        int id;
        int numSala;
        int cap;

        System.out.print("ID: ");
        try {
            id = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Entre com um número");
            id = -1;
        }

        System.out.print("Número da Sala: ");
        try {
            numSala = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Entre com um número");
            numSala = -1;
        }
        System.out.print("Capacidade de alunos: ");
        try {
            cap = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Entre com um número");
            cap = -1;
        }

        boolean sucesso = controller.cadastrar(id, numSala, cap);

        if (sucesso) {
            System.out.println("Sala cadastrada com sucesso");
        }
        else {
            System.out.println("Erro ao cadastrar sala");
        }
    }
}
