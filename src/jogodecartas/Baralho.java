package jogodecartas;

import java.util.Random;

public class Baralho {

    private static Carta[] CARTAS; 
    private Carta[] NAIPESALVO, FACESALVA;
    private final Random ALEATORIO;
    private static int contador, qtdCartas;

    public Baralho() {
        ALEATORIO = new Random();
        CARTAS = new Carta[52];
        String[] face = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", 
            "11", "12", "13"};
        String[] naipe = {"copas", "espadas", "ouros", "paus"};

        int cont = 0;
        for (int i = 0; i < naipe.length; i++) {
            for (int j = 0; j < face.length; j++) {
                CARTAS[cont++] = new Carta(face[j], naipe[i]);
            }
        }
    }

    public void embaralhar() { //Embaralha as cartas
        int num, num2;
        Carta temp;
        for (int i = 0; i < CARTAS.length; i++) {
            num = ALEATORIO.nextInt(CARTAS.length);
            num2 = ALEATORIO.nextInt(CARTAS.length);
            temp = CARTAS[num];
            CARTAS[num] = CARTAS[num2];
            CARTAS[num2] = temp;
        }
    }

    public Carta[] distribuirCartas(int qtdCartas) { // Distribui as cartas
        System.out.println("------------DISTRIBUINDO BARALHO-----------------");
        this.qtdCartas = qtdCartas;
            
        Carta[] cartasJogador = new Carta[qtdCartas];

        for (int i = 0; i < qtdCartas; i++) {
            cartasJogador[i] = CARTAS[contador];
            contador++;
        }
        
        return cartasJogador;
    }
 
    public void mostrarBaralho() { //Apresenta o baralho já embaralhado
        System.out.println("------------APRESENTANDO BARALHO-----------------");
        for (Carta carta : CARTAS) {
            System.out.println(carta.toString());
        }
    }
    
    public static Carta puxarCarta(){ // Puxa a carta do baralho(sendo essa carta, a próxima do baralho)
        System.out.println("Carta puxada: " + CARTAS[++contador]); //++contador incrementa a próxima carta
        
        return CARTAS[contador]; // Retorna a carta na posição do contador(carta seguinte)
    }
   
}