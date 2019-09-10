package jogodecartas;

import java.util.Scanner;

public class Jogo {

    private final Scanner entrada = new Scanner(System.in);
    private final Baralho BARALHO;
    private Jogador[] jogadores;
    
    public Jogo() {
        BARALHO = new Baralho();
        BARALHO.mostrarBaralho();
        BARALHO.embaralhar();
        BARALHO.mostrarBaralho();
    }

    public void iniciarJogo() {

        jogadores = new Jogador[2];
        
        
        for (int i = 0; i < jogadores.length; i++) {
            System.out.print("Jogador " + (i+1) + ", digite seu nome: ");
            jogadores[i] = new Jogador(entrada.next());
        }
    }
    
    public void distribuirCartas(int qtdCartas) {
        for (Jogador jogadore : jogadores) {
            jogadore.setCartas(BARALHO.distribuirCartas(qtdCartas));
        }
    }

    public void mostrarCartas() {
        for (Jogador jogadore : jogadores) {
            jogadore.mostrarCartas();
        }
    }   
    
    
    public void puxarCarta(){
        for(Jogador jogadore: jogadores){
            System.out.println("PUXAR MAÇO[1] - PUXAR LIXEIRA[2]: ");
            int opcao = entrada.nextInt();
            switch(opcao){
                case 1:
                    jogadore.puxarCartaMaco();
                    System.out.println("Digite o índice da carta de descarte: ");
                    int indice1 = entrada.nextInt();
                    jogadore.descartarCarta(indice1);
                    System.out.println("------------------------------");
                    mostrarCartas();
                    System.out.println("------------------------------");
                    break;
                case 2:
                    jogadore.puxarCartaLixo();
                    System.out.println("Digite o índice da carta de descarte: ");
                    int indice2 = entrada.nextInt();
                    jogadore.descartarCarta(indice2);
                    System.out.println("------------------------------");
                    mostrarCartas();
                    System.out.println("------------------------------");
                    break;
                default:
                    System.out.println("Por favor, digite uma opção válida");
            }
        }
    }
   
    
} 
    /*
    public static void main(String[] args) {
        Jogo executar = new Jogo();
        executar.iniciarJogo();
        executar.distribuirCartas(9);
        executar.mostrarCartas();
    }
}
*/