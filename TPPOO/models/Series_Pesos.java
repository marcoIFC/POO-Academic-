package models;
import java.util.Random;
import java.util.UUID;

public class Series_Pesos extends Atividade{
    private String codigo;
    private String nome;
    private int dificuldade;
    private int tempo;
    private int repeticoes;
    private int peso;
    private int consumoDeCalorias;


    public Series_Pesos(){
        super();
        this.repeticoes = 0;
    }

    public Series_Pesos(String nome){
        super(nome);
        this.repeticoes = 0;
    }

    public Series_Pesos(Series_Pesos x){
        super(x);
        this.repeticoes = x.repeticoes;
    }

    public Series_Pesos clone(){
        return new Series_Pesos(this);
    }

    public void randomActivity(){
        this.codigo = gerarCodigo();
        String [] nomes = {"Deadlifts","Bicep Curls","Shoulder Press","Row's","Agachamento com Pesos"};
        Random random = new Random();
        int indice = random.nextInt(nomes.length);
        this.nome = nomes[indice];

        this.dificuldade = random.nextInt(3)+1;
        this.tempo = random.nextInt(2)+1;
        this.repeticoes = random.nextInt(15)+1;
    }

    public int getPeso(){
        return this.peso;
    }

    public void setPeso(int peso){
        this.peso = peso;
    }

    public int getRepeticoes() {
        return repeticoes;
    }

    public void setRepeticoes(int repeticoes) {
        this.repeticoes = repeticoes;
    }

    public int calculocalorias(Series_Pesos activity,Utilizador user){
        int consumo =(int) (0.01* user.getfrequenciaCardiaca()) * (user.gettipo() * user.getpeso() * 40/user.getidade())*
                (activity.getdificuldade() * activity.getPeso() * activity.getRepeticoes() * activity.gettempo());
        return consumo;
    }
    public void geraAtividade(Series_Pesos activity, Utilizador user){
        int repeticoespesos = (int) ( activity.consumoDeCalorias
                        /2*(0.01 * user.getfrequenciaCardiaca()) *( (user.gettipo() * user.getpeso() *
                        40) /user.getidade())*(activity.getdificuldade() * activity.gettempo()));
        activity.setRepeticoes(repeticoespesos);
        activity.setPeso(repeticoespesos);
    }
}
