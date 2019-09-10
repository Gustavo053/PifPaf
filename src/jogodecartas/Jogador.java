package jogodecartas;
import java.util.ArrayList;

public class Jogador {

    private final String NOME;
    private Baralho baralho;
    private ArrayList<Carta> cartas;

    public Jogador(String nome) {
        this.NOME = nome;
    }

    public void setCartas(Carta[] cartas) {
        this.cartas = new ArrayList<Carta>();
        for(Carta c: cartas){
            this.cartas.add(c);
        }
    }

    public void mostrarCartas() {
        System.out.println("-----------CARTAS DE " + NOME.toUpperCase() + "----"
                + "--------------");
        for(int i = 0; i < cartas.size(); i++){
            System.out.println("Carta[" + i + "]" + cartas.get(i).toString()); 
        }
    }
    
    public void puxarCartaMaco(){
        cartas.add(baralho.retornaCarta());
    }
}
