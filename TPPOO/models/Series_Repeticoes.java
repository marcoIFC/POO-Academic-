package models;
import java.util.UUID;

public class Series_Repeticoes extends Atividade{
    private String codigo;
    private String nome;
    private int dificuldade;
    private int tempo;
    private int repeticoes;
    private int consumoDeCalorias;


    public Series_Repeticoes(){
        super();
        this.repeticoes = 0;
    }

    public Series_Repeticoes(String nome){
        super(nome);
        this.repeticoes = 0;
    }

    public Series_Repeticoes(Series_Repeticoes x){
        super(x);
        this.repeticoes = x.repeticoes;
    }

    public Series_Repeticoes clone(){
        return new Series_Repeticoes(this);
    }



    public int getRepeticoes() {
        return repeticoes;
    }

    public void setRepeticoes(int repeticoes) {
        this.repeticoes = repeticoes;
    }

    public int calculocalorias(Series_Repeticoes activity,Utilizador user){
        int consumo =(int) (0.01* user.getfrequenciaCardiaca()) * (user.gettipo() * user.getpeso() * 40/user.getidade())*
                (activity.getdificuldade() * activity.getRepeticoes() * activity.gettempo());
        return consumo;
    }

    public void geraAtividade(Series_Repeticoes activity, Utilizador user){
        int repeticoes = (int) ( activity.consumoDeCalorias
                        /(0.01 * user.getfrequenciaCardiaca()) *( (user.gettipo() * user.getpeso() *
                        40) /user.getidade())*(activity.getdificuldade() * activity.gettempo()));
        activity.setRepeticoes(repeticoes);
    }
}
