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
    
    public boolean trinca(int i1, int i2, int i3){
        int flag = 0;
        if(cartas.get(i1).getFace().equals(cartas.get(i2).getFace()) && cartas.get(i2).getFace().equals(cartas.get(i3).getFace())){
            flag = 1;
        }
        if(flag == 1){
            cartas.remove(i1);
            cartas.remove(i2-1);
            cartas.remove(i3-2);
            return true;
        }else{
            System.out.println("Trinca não aceita \n");
            return false;
        }
    }
    
    public boolean sequencia(int i1, int i2, int i3){
        int flag1 = 0, flag2 = 0, aux;
        int[] v = new int[3];
        
        v[0] = i1;
        v[1] = i2;
        v[2] = i3;
        
        Arrays.sort(v);
        
        i1 = v[0];
        i2 = v[1];
        i3 = v[2];
        
        if(cartas.get(i1).getNaipe().equals(cartas.get(i2).getNaipe()) && cartas.get(i2).getNaipe().equals(cartas.get(i3).getNaipe())){
            flag1 = 1;
        }
        if(flag1 == 1){
            if(cartas.get(i1).getValorNumero() == cartas.get(i2).getValorNumero() - 1 && 
                    cartas.get(i2).getValorNumero() == cartas.get(i3).getValorNumero() -1){
                
                cartas.remove(i1);
                cartas.remove(i2-1);
                cartas.remove(i3-2);
                flag2 = 1;
            }
        }
        if(flag2 == 1){
            return true;
        }else{
            System.out.println("Não pode fazer sequencia");
            return false;
        }
    }
    
    public Carta acessarCartaUnica(int indice){
        return cartas.get(indice);
    }
    
}
