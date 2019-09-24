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

    public void iniciarJogo() { //Método usado para Inserir os dois usuários no jogo

        jogadores = new Jogador[2];
        
        
        for (int i = 0; i < jogadores.length; i++) {
            System.out.print("Jogador " + (i+1) + ", digite seu nome: ");
            jogadores[i] = new Jogador(entrada.next());
        }
    }
    
    public void distribuirCartas(int qtdCartas) { //Método usado para distribuir as cartas dos usuários
        for (Jogador jogadore : jogadores) {
            jogadore.setCartas(BARALHO.distribuirCartas(qtdCartas));
        }
    }

    public void mostrarCartas() { //Método usado para mostrar as cartas dos usuários
        for (Jogador jogadore : jogadores) {
            jogadore.mostrarCartas();
        }
    }
    
    
    public void puxarCarta(){ //Método usado para puxar a carta e escolher de onde a mesma será puxada
        for(Jogador jogadore: jogadores){
            int flag = 0;
            limparTela();
            jogadore.mostrarCartas(); //Mostra as cartas do jogador da vez
            System.out.println(" \n\n VEZ DO JOGADOR " + jogadore.getNome());
            int opcao;
            do{
                System.out.println("PUXAR MAÇO[1] - PUXAR LIXEIRA[2]: ");
                opcao = entrada.nextInt();
                switch(opcao){
                    case 1:
                        limparTela();
                        jogadore.mostrarCartas();
                        jogadore.puxarCartaMaco();
                        System.out.println("Digite o índice da carta de descarte: ");
                        int indice1 = entrada.nextInt();
                        jogadore.descartarCarta(indice1);
                        System.out.println("------------------------------");
                        limparTela();
                        jogadore.mostrarCartas();
                        System.out.println("------------------------------");
                        flag = 1;
                        break;
                    case 2:
                        limparTela();
                        jogadore.mostrarCartas();
                        jogadore.puxarCartaLixo();
                        System.out.println("Digite o índice da carta de descarte: ");
                        int indice2 = entrada.nextInt();
                        jogadore.descartarCarta(indice2);
                        System.out.println("------------------------------");
                        limparTela();
                        jogadore.mostrarCartas();
                        System.out.println("------------------------------");
                        flag = 1;
                        break;
                    default:
                        System.out.println("Por favor, digite uma opção válida");
                }
                if(flag == 1){
                    break;
                }
            }while(opcao != 1 || opcao != 2);
        }
    }
    public boolean fazerJogada(){ //Método para fazer a jogada e configurar qual será a mesma
        int flag = 0;
        for(Jogador jogadore: jogadores){
            int opcao1, opcao2, i1, i2, i3;
            do{
                limparTela();
                jogadore.mostrarCartas();
                System.out.print(jogadore.getNome() + ", VOCÊ DESEJA FAZER JOGO? [1] - SIM / "
                        + "[2] - NÃO: ");
                opcao1 = entrada.nextInt();
                if(opcao1 == 1){
                    System.out.print("[1] - TRINCA / [2] - SEQUÊNCIA: ");
                    opcao2 = entrada.nextInt();
                    switch(opcao2){
                        case 1:
                            limparTela();
                            jogadore.mostrarCartas();
                            System.out.println(jogadore.getNome() + ", digite os índices: ");
                            i1 = entrada.nextInt();
                            i2 = entrada.nextInt();
                            i3 = entrada.nextInt();
                            if(jogadore.trinca(i1, i2, i3)){
                                flag = 1;
                                break;
                            }
                            break;
                        case 2:
                            limparTela();
                            jogadore.mostrarCartas();
                            System.out.println(jogadore.getNome() + ", digite os índices: ");
                            i1 = entrada.nextInt();
                            i2 = entrada.nextInt();
                            i3 = entrada.nextInt();
                            if(jogadore.sequencia(i1, i2, i3)){
                                flag = 1;
                                break;
                            }
                            break;
                        default:
                            System.out.println("Por favor, " + jogadore.getNome() + ", digite uma"
                                    + " opcão válida");
                    }
                }else if(opcao1 == 2){
                    System.out.println("Ok!");
                }else{
                    System.out.println("Por favor, digite uma opção válida");
                }
            }while(opcao1 != 2);
        }
        if(flag == 1){
            return true;
        }else{
            return false;
        }
        
    }
    
    public boolean testarVencedor(){ //Método que testa se já houve um vencedor na partida
        int flag = 0;
        for(Jogador jogadore: jogadores){
            if(jogadore.maoVazia()){ //Se a mão do jogador estiver vazia(Se esse método retornar na true)
                System.out.println("PARABÉNS, " + jogadore.getNome() + ", VOCÊ VENCEU!");
                flag = 1;
            }
        }
        if(flag == 1){
            return true;
        }else{
            return false;
        }
    }
    
    public void limparTela(){ //GAMBIARRA UTILIZADA PARA LIMPAR A TELA. DESCULPA, LAURA. EU TE AMO! <3
        for(int i = 0; i < 50; i++){
            System.out.println("\n\n");
        }
    }
   
} 