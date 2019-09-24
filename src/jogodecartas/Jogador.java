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
    public String getNome(){ //Retorna o nome do jogador
        return this.NOME;
    }

    public void setCartas(Carta[] cartas) { //Seta as cartas na mão do jogador (ou seja, cria seu baralho)
        this.cartas = new ArrayList<Carta>();
        for(Carta c: cartas){
            this.cartas.add(c);
        }
    }

    public void mostrarCartas() { //Mostra as cartas do jogador
        Collections.sort(cartas);//Método usado para ordenadar a lista(Esse método usa o CompareTo())
        System.out.println("-----------CARTAS DE " + NOME.toUpperCase() + "----"
                + "--------------");
        for(int i = 0; i < cartas.size(); i++){
            System.out.println("Carta[" + i + "]" + cartas.get(i).toString()); 
        }
    }
    
    public void puxarCartaMaco(){ //Método usado para puxar a carta e adicioná-la no baralho do jogador
        cartas.add(Baralho.puxarCarta());
    }
    public void descartarCarta(int i){ //Método usado para descartar a carta que o usuário deseja
        System.out.println("Carta removida: " + cartas.get(i));
        cartaDescartada = cartas.get(i); //Essa variável recebe a carta que o usuário descartou para ser
        cartas.remove(i);                //usada nas cartas de descarte que o outro pode puxar
    }
    public void puxarCartaLixo(){ //Método usado para puxar a carta que o usuário anterior descartou
        System.out.println("Carta puxada: " + cartaDescartada);
        cartas.add(cartaDescartada);
    }
    
    public boolean trinca(int i1, int i2, int i3){ //Método para verificar a trinca do usuário de acordo com os índices passados pelo o mesmo
        int flag = 0;
        if(cartas.get(i1).getFace().equals(cartas.get(i2).getFace()) && cartas.get(i2).getFace().equals(cartas.get(i3).getFace())){
            flag = 1; //Se as faces forem iguais, então a flag = 1;
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
    
    public boolean sequencia(int i1, int i2, int i3){ //Método usado para verificar a sequência do usuário de acordo com os índices passados pelo mesmo
        int flag1 = 0, flag2 = 0, aux;
        int[] v = new int[3]; //Vetor criado para ordenar os números passados para facilitar na no teste condicional abaixo
        
        v[0] = i1;
        v[1] = i2;
        v[2] = i3;
        
        Arrays.sort(v); //Método da classe Arrays que ordena os valores
        
        i1 = v[0]; //As variáveis recebem agora os valores ordenados
        i2 = v[1];
        i3 = v[2];
        
        if(cartas.get(i1).getNaipe().equals(cartas.get(i2).getNaipe()) && cartas.get(i2).getNaipe().equals(cartas.get(i3).getNaipe())){
            flag1 = 1; //Se os naipes forem iguais, então a flag = 1
        }
        if(flag1 == 1){
            if(cartas.get(i1).getValorNumero() == cartas.get(i2).getValorNumero() - 1 && //getValorNumero está retornando a conversão da face, para ser usado no condiocional
                    cartas.get(i2).getValorNumero() == cartas.get(i3).getValorNumero() -1){
                
                cartas.remove(i1);
                cartas.remove(i2-1);
                cartas.remove(i3-2);
                flag2 = 1; //Se for uma sequencia, então flag2 = 1
            }
        }
        if(flag2 == 1){
            return true;
        }else{
            System.out.println("Não pode fazer sequencia");
            return false;
        }
    }
    
    public boolean maoVazia(){ // Método usado para saber se o usuário já fez jogo com todas as cartas
        if(cartas.isEmpty()){ //O isEmpty retorna se a NÃO contém elementos
            return true;
        }else{
            return false;
        }
    }
    
}
