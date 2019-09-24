/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogodecartas;

/**
 *
 * @author Gustavo
 */
public class JogarJogo {
    public static void main(String[] args) {
        Jogo executar = new Jogo(); //Instancia um novo objeto de jogo para executar o jogo
        int i = 0;
        executar.iniciarJogo(); //Insere os jogadores
        executar.distribuirCartas(9); //Distribui as cartas dos mesmos
        do{
            executar.puxarCarta(); //Puxa a carta
            executar.fazerJogada(); //Faz a jogada para fazer trinca ou sequência
            if(executar.testarVencedor()){ //Quando essa função retornar true, o laço é interrompido
                break;
            }
        }while(true); //Laço infinito que só será interrompido quando houver vencedor
    }
}
