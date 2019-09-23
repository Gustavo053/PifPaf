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
            System.out.println(" \n\n VEZ DO JOGADOR " + jogadore.getNome());
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
    public boolean testarVencedor(){
        System.out.println("VOCÊ DESEJA TESTAR O JOGO?");
        int flag1 = 0;
        int flag2 = 0;
        for (Jogador jogadore : jogadores) {
            System.out.println("Digite os índices: ");
            int i1, i2, i3;
            i1 = entrada.nextInt();
            i2 = entrada.nextInt();
            i3 = entrada.nextInt();
            if(jogadore.trincaTest(i1, i2, i3)){
                flag1 = 1;
            }
        }
        if(flag1 == 1){
            System.out.println("TRINCOU TRUE");
            return true;
        }else{
            System.out.println("NÃO TRINCOU FALSE");
            return false;
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