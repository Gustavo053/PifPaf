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
        executar.iniciarJogo();
        executar.distribuirCartas(9);
        do{
            executar.mostrarCartas();
            executar.puxarCarta();
            if(executar.testarVencedor()){
                System.out.println("Deu certo a trinca");
                break;
            }
        }while(i < 15);
        executar.mostrarCartas();
        
    }
}
