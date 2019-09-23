package jogodecartas;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Jogador {

    private final String NOME;
    private ArrayList<Carta> cartas;
    private static Carta cartaDescartada;

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
        Collections.sort(cartas);
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
        for(int i = 0; i < cartas.size(); i++){
            cartasJogador.add(cartas.get(i));
        }
        return cartasJogador;
    }
    
    public boolean trincaTest(int i1, int i2, int i3){
        int flag = 0;
        if(cartas.get(i1).getFace().equals(cartas.get(i2).getFace()) 
                && cartas.get(i2).getFace().equals(cartas.get(i3).getFace())){
            flag = 1;
        }
        if(flag == 1){
            cartas.remove(i1);
            cartas.remove(i2);
            cartas.remove(i3);
            return true;
        }else{
            System.out.println("Trinca não aceita \n");
            return false;
        }
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
    
}
