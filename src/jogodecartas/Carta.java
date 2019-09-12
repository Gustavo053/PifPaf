package jogodecartas;

public class Carta {

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
        return "Carta " + FACE + " de " + NAIPE;
    }
}
