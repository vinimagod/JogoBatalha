package batalhapersonagens.app;

import java.util.Scanner;
import java.util.ArrayList;

import batalhapersonagens.model.Mago;
import batalhapersonagens.model.Arqueiro;
import batalhapersonagens.model.Guerreiro;
import batalhapersonagens.model.JogoBatalha;
import batalhapersonagens.model.Personagem;

public class App {
    Scanner scan = new Scanner(System.in);
    ArrayList<Personagem> personagens = new ArrayList<>();
    JogoBatalha jogoBatalha = new JogoBatalha();

    public void escolhaPersonagens(){

        System.out.println("[1] Guerreiro ");
        System.out.println("[2] Arqueiro ");
        System.out.println("[3] Mago ");

        int option = scan.nextInt();
        scan.nextLine();
        String nome;
        switch (option) {
            case 1:
                System.out.println("-- GUERREIRO --");
                System.out.println("Informe o nome do guerreiro: ");
                nome = scan.nextLine();
                System.out.println("Seu guerreiro se chama: " + nome.toUpperCase());
                Guerreiro guerreiro = new Guerreiro(nome);
                personagens.add(guerreiro);
                break;
        
            case 2:
                System.out.println("-- ARQUEIRO --");
                System.out.println("Informe o nome do arqueiro: ");
                nome = scan.nextLine();
                System.out.println("Seu arqueiro se chama: " + nome.toUpperCase());
                Arqueiro arqueiro = new Arqueiro(nome);
                personagens.add(arqueiro);
            break;

            case 3:
                System.out.println("-- MAGO --");
                System.out.println("Informe o nome do mago: ");
                nome = scan.nextLine();
                System.out.println("Seu mago se chama: " + nome.toUpperCase());
                Mago mago = new Mago(nome);
                personagens.add(mago);
            break;

            default:
                System.out.println("OPÇÃO INVÁLIDA...");
            break;
        }
    }

    public void jogar(){
        jogoBatalha.setAtributos(personagens);
        jogoBatalha.atk(personagens.get(0), personagens.get(1));
        for (Personagem personagem : personagens) {
            System.out.println("=====");
            System.out.println(personagem.toString());
            System.out.println("=====");
        }
    }


    public void run(){
            Boolean personagens_escolhidos = false;
            while (true) {
            System.out.println("---BATALHA DE PERSONAGENS!---");
            System.out.println("______________________________\n");
            System.out.println("ESCOLHA UMA OPÇÃO: ");
            System.out.println("[1] Escolher Lutadores");
            System.out.println("[2] Jogar");
            System.out.println("[3] Sair");

            int option = scan.nextInt();
            scan.nextLine();
            switch (option) {
                case 1:  
                    if (!personagens_escolhidos){
                        System.out.println( "---ESCOLHA DE PERSONAGENS---");
                        System.out.println("______________________________\n");
                        System.out.println("Escolha o personagem de ataque:");
                        escolhaPersonagens();
                        System.out.println("Escolha o personagem de defesa:");
                        escolhaPersonagens();
                        personagens_escolhidos = true;    
                    }else{
                    System.out.println("Personagens já foram escolhidos");
                    }
                break;       
                
                case 2:
                    if (!personagens_escolhidos) {
                        System.out.println("Primeiro é necessário escolher os personagens! \n");
                    }
                    jogar();
                break;

                case 3:
                    System.out.println("Saindo...");
                return;

                default:
                    System.out.println("OPÇÃO INVÁLIDA...");
                break;
            }
            
        }

    }





    public static void main(String[] args) throws Exception {
        App app = new App();
        app.run();
    }
}