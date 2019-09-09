package jogodecartas;

import java.util.Scanner;

public class Jogo {

    private final Scanner entrada = new Scanner(System.in);
    private final Baralho BARALHO;
    private Jogador[] jogadores;
    int puxar;
    
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
    
    
    
    
    
    public void puxarCartaMaco(){
        System.out.println("entrou pra puxar");
        
        for(int i = 0; i < jogadores.length; i++){
            System.out.println("jogador " + 1 + " puxando");
            jogadores[i].setCartas(BARALHO.retornaCarta());
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