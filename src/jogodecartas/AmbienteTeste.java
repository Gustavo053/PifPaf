/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogodecartas;

/**
 *
 * @author Aluno
 */
public class AmbienteTeste {
    public static void main(String[] args) {
        Jogo executar = new Jogo();
        int i = 0;
        do{
            executar.iniciarJogo();
            executar.distribuirCartas(9);
            executar.mostrarCartas();
            executar.puxarCarta();
        }while(i < 8);
        
    }
}
