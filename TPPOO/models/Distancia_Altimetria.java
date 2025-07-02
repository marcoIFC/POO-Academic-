package models;
import java.util.UUID;


public class Distancia_Altimetria extends Atividade{
    private String codigo;
    private String nome;
    private int dificuldade;
    private int distancia;
    private int altitude;
    private int tempo;
    private int consumoDeCalorias;



    public Distancia_Altimetria(){
        super();
        this.distancia = 0;
        this.altitude = 0;
    }

    public Distancia_Altimetria(String nome){
        super(nome);
        this.distancia = 0;
        this.altitude = 0;
    }

    public Distancia_Altimetria(Distancia_Altimetria x){
        super(x);
        this.distancia = x.distancia;
        this.altitude = x.altitude;
    }

    public Distancia_Altimetria clone(){
        return new Distancia_Altimetria(this);
    }


    public void randomActivity(){
        this.codigo = gerarCodigo();
    }

    public int calculocalorias(Distancia_Altimetria activity,Utilizador user){
        int consumo =(int) (0.01* user.getfrequenciaCardiaca()) * (user.gettipo() * user.getpeso() * 40/user.getidade())*
                (activity.getdificuldade() * activity.getdistancia() * activity.getaltitude() * activity.gettempo());
        return consumo;
    }

    public void geraAtividade(Distancia_Altimetria activity, Utilizador user){
        int distanciaaltura = (int) ( activity.consumoDeCalorias
                        /2*(0.01 * user.getfrequenciaCardiaca())*
                        ( (user.gettipo() * user.getpeso() * 40) /user.getidade())
                        *(activity.getdificuldade() * activity.gettempo()));
        activity.setDistancia(distanciaaltura);
        activity.setAltitude(distanciaaltura);
    }

    public int getdistancia(){
        return this.distancia;
    }

    public int getaltitude(){
        return this.altitude;
    }

    public void setDistancia(int distancia){
        this.distancia = distancia;
    }

    public void setAltitude(int altitude){
        this.altitude = altitude;
    }

}
