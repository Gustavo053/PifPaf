package jogodecartas;

import java.util.Objects;

public class Carta implements Comparable<Carta>{ //Cria uma interface para comparar o objeto carta

    private final String FACE;
    private final String NAIPE;

    public Carta(String face, String naipe) {
        this.FACE = face;
        this.NAIPE = naipe;
    }
    
    public String getFace(){ //Retorna a face da carta
        return this.FACE;
    }
    public String getNaipe(){ // Retorna o naipe da carta
        return this.NAIPE;
    }

    @Override
    public String toString() { //Retorna a carta com seus devidos valores
        /*Esse toString está configurado para exibir determinados valores, como o
         ÁS. Ou seja, quando a carta tiver valor de faca 1, ele retornará ÁS + a FACE*/
        if(FACE.equals("1")){
            return "ÁS " + "de " + NAIPE;     
        }else if(FACE.equals("11")){
            return "J " + "de " + NAIPE;         
        }else if(FACE.equals("12")){
            return "Q " + "de " + NAIPE;
        }else if(FACE.equals("13")){
            return "K " + "de " + NAIPE;        
        }else{
            return FACE + " de " + NAIPE;       
        }
    }
    
    public int getValorNumero(){ //Esse método faz a conversão dos valores String para inteiro
        return Integer.decode(FACE); 
    }

    @Override
    public int hashCode() { //Método gerado automaticamente para manter o hash individual para cada objeto
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) { //Método de configuração do equals, onde o naipe é configurado
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Carta other = (Carta) obj;
        if (!Objects.equals(this.NAIPE, other.NAIPE)) { //Naipe sendo configurado aqui, para retornar a
            return false;                               //ordenação dos elementos da lista pelo neipe
        }
        return true;
    }

    @Override
    public int compareTo(Carta o) { //Método usado para comparar objetos de acordo com seu naipe e face
        if(this.NAIPE.equals(o.NAIPE)){ //e assim retornar os valores ordenados na lista de acordo com os
            return this.FACE.compareTo(o.FACE);//mesmos
        }else{
            return this.NAIPE.compareTo(o.NAIPE);
        }
    }
    
    
}
