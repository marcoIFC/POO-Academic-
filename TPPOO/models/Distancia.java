package models;
import java.util.UUID;

public class Distancia extends Atividade{
    private String codigo;
    private String nome;
    private int dificuldade;
    private int distancia;
    private int tempo;
    private int consumoDeCalorias;


    public Distancia(){
        super();
        this.distancia = 0;
    }

    public Distancia( String nome){
        super(nome);
        this.distancia = 0;
    }

    public Distancia(Distancia x){
        super(x);
        this.distancia = x.distancia;
    }

    public Distancia clone(){
        return new Distancia(this);
    }


    public int getdistancia(){
        return this.distancia;
    }

    public void setdistancia(int distancia){
        this.distancia = distancia;
    }

    public int calculocalorias(Distancia activity,Utilizador user){
        int consumo =(int) (0.01* user.getfrequenciaCardiaca()) * (user.gettipo() * user.getpeso() * 40/user.getidade())*
                ((activity.getdificuldade() * activity.getdistancia())* activity.gettempo());
        return consumo;
    }
    public void geraAtividade(Distancia activity, Utilizador user){
        int distancia = (int) ( activity.consumoDeCalorias/
                        (0.01 * user.getfrequenciaCardiaca()) *( (user.gettipo() * user.getpeso() *
                        40) /user.getidade())*(activity.getdificuldade() * activity.gettempo()));
        activity.setdistancia(distancia);
    }
}
