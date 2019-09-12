package jogodecartas;
import java.util.ArrayList;

public class Jogador {

    private final String NOME;
    private ArrayList<Carta> cartas;
    private static int cartaDescarte;
    private static Carta cartaDescartada;
    private Carta cartasVencedor;

    public Jogador(String nome) {
        this.NOME = nome;
    }
    public String getNome(){
        return this.NOME;
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
        cartas.add(Baralho.puxarCarta());
    }
    public void descartarCarta(int i){
        cartaDescarte = i;
        System.out.println("Carta removida: " + cartas.get(i));
        cartaDescartada = cartas.get(i);
        cartas.remove(i);
    }
    public void puxarCartaLixo(){
        System.out.println("Carta puxada: " + cartaDescartada);
        cartas.add(cartaDescartada);
    }
    
    public ArrayList<Carta> cartasNaMao(){
        ArrayList<Carta> cartasJogador = new ArrayList<>();
        for(int i = 0; i < cartasJogador.size(); i++){
            cartasJogador.add(cartas.get(i));
        }
        return cartasJogador;
    }
    
    public boolean trinca(ArrayList<Carta> cartasJogador){
        Carta carta1 = new Carta("Sem face", "Sem naipe");
        Carta carta2 = new Carta("Sem face", "Sem naipe");
        Carta carta3 = new Carta("Sem face", "Sem naipe");
        for(int i = 0; i < cartasJogador.size()-1; i++){
            if(cartasJogador.get(i).getFace().equalsIgnoreCase(cartasJogador.get(i+1).getFace())){
                carta1 = cartasJogador.get(i);
                carta2 = cartasJogador.get(i+1);
            }
        }
        for(int i = 0; i < cartasJogador.size()-1; i++){
            if(carta2.getFace().equalsIgnoreCase(cartasJogador.get(i+1).getFace())){
                carta3 = cartasJogador.get(i+1);
            }
        }
        
        //se der erro essa comparação, mudar para comaparar a face só com o ==, sem o método
        if(carta1.getFace().equalsIgnoreCase(carta2.getFace()) && 
                carta2.getFace().equalsIgnoreCase(carta3.getFace())){
            System.out.println("TRINCA");
            return true;
        }else{
            System.out.println("NÃO TRINCA");
            return false;
        }
    }
    
    public boolean sequencia(ArrayList<Carta> cartasJogador){
        Carta carta1 = new Carta("Sem face", "Sem naipe");
        Carta carta2 = new Carta("Sem face", "Sem naipe");
        Carta carta3 = new Carta("Sem face", "Sem naipe");
        for(int i = 0; i < cartasJogador.size()-1; i++){
            if(cartasJogador.get(i).getNaipe().equalsIgnoreCase(cartasJogador.get(i+1).getNaipe())){
                carta1 = cartasJogador.get(i);
                carta2 = cartasJogador.get(i+1);
            }
        }
        for(int i = 0; i < cartasJogador.size()-1; i++){
            if(carta2.getNaipe().equalsIgnoreCase(cartasJogador.get(i+1).getNaipe())){
                carta3 = cartasJogador.get(i+1);
            }
        }
        return
    }
    
}
