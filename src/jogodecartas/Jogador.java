package jogodecartas;
import java.util.ArrayList;

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
        int flag = 0;
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
        
        ArrayList<Carta> x = new ArrayList();
        x.add(carta1);
        x.add(carta2);
        x.add(carta3);
        int y1, y2, y3;
        if(carta1.getNaipe().equalsIgnoreCase(carta2.getNaipe()) &&
                carta2.getNaipe().equalsIgnoreCase(carta3.getNaipe())){
            switch(carta1.getFace()){
                case "A":
                    y1 = 1;
                    break;
                case "J":
                    y1 = 11;
                    break;
                case "Q":
                    y1 = 12;
                    break;
                case "K":
                    y1 = 13;
                    break;
                default:
                    y1 = Integer.parseInt(carta1.getFace()); //Converte String para Integer
            }
            switch(carta2.getFace()){
                case "A":
                    y2 = 1;
                    break;
                case "J":
                    y2 = 11;
                    break;
                case "Q":
                    y2 = 12;
                    break;
                case "K":
                    y2 = 13;
                    break;
                default:
                    y2 = Integer.parseInt(carta2.getFace()); //Converte String para Integer
            }
            switch(carta3.getFace()){
                case "A":
                    y3 = 1;
                    break;
                case "J":
                    y3 = 11;
                    break;
                case "Q":
                    y3 = 12;
                    break;
                case "K":
                    y3 = 13;
                    break;
                default:
                    y3 = Integer.parseInt(carta3.getFace()); //Converte String para Integer
            }
            
            /*for(int i = 0; i < x.size(); i++){
                switch(x.get(i).getFace()){
                    case "A":
                        y = 1;
                        break;
                    case "J":
                        y = 11;
                        break;
                    case "Q":
                        y = 12;
                        break;
                    case "K":
                        y = 13;
                        break;
                    default:
                        y = Integer.decode(x.get(i).getFace()); //Converte String para Integer
                }
            }*/
            if(y1 == y2 && y2 == y3){
                flag = 1;
            }
        }
        if(flag == 1){
            System.out.println("Sequência TRUE");
            return true;
        }else{
            System.out.println("SEQUENCIA FALSE");
            return false;
        }          
    }
    
}
