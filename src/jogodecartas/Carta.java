package jogodecartas;

import java.util.Objects;

public class Carta implements Comparable<Carta>{

    private final String FACE;
    private final String NAIPE;

    public Carta(String face, String naipe) {
        this.FACE = face;
        this.NAIPE = naipe;
    }
    
    public String getFace(){
        return this.FACE;
    }
    public String getNaipe(){
        return this.NAIPE;
    }

    @Override
    public String toString() {
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
    
    public int getValorNumero(){
        return Integer.decode(FACE); 
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
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
        if (!Objects.equals(this.NAIPE, other.NAIPE)) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Carta o) {
        if(this.NAIPE.equals(o.NAIPE)){
            return this.FACE.compareTo(o.FACE);
        }else{
            return this.NAIPE.compareTo(o.NAIPE);
        }
    }
    
    
}
