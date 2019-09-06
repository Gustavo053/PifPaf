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
public class Maco {
    Baralho baralhoMaco;
    Carta[] cartaMaco;
    
    public Maco(){
        cartaMaco = new Carta[baralhoMaco.resto()];
        baralhoMaco.embaralhar();
    }
    
    public Carta[] mostrarCartasMaco(){
        return cartaMaco;
    }
}
