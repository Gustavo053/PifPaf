package jogodecartas;

public class Jogador {

    private final String NOME;
    private Carta[] cartas;

    public Jogador(String nome) {
        this.NOME = nome;
    }

    public void setCartas(Carta[] cartas) {
        this.cartas = cartas;
    }

    public void mostrarCartas() {
        System.out.println("-----------CARTAS DE " + NOME.toUpperCase() + "----"
                + "--------------");
        for(int i = 0; i < cartas.length; i++){
            System.out.println(cartas[i] + "[" + i + "]"); 
        }
    }
}
