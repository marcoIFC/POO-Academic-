package models;
import java.util.UUID;

public class Atividade {
    private String codigo;
    private String nome;
    private int dificuldade; //(1-easy, 2-medium, 3-hard)
    private int tempo;
    private int consumoDeCalorias; // escolher como fazer por tipo de dificuldade


    public Atividade(){
        this.codigo = this.gerarCodigo();
        this.nome = "n/a";
        this.dificuldade = 0;
        this.tempo = 0;
        this.consumoDeCalorias = 0;
    }

    public Atividade(String nome){
        this.codigo = this.gerarCodigo();
        this.nome = nome;
        this.dificuldade = 0;
        this.tempo = 0;
        this.consumoDeCalorias = 0;
    }

    public Atividade(Atividade x){
        this.codigo = this.gerarCodigo();
        this.nome = x.nome;
        this.dificuldade = x.dificuldade;
        this.tempo = x.tempo;
        this.consumoDeCalorias = x.consumoDeCalorias;
    }
    public Atividade clone(){
        return new Atividade(this);
    }

    public String getcodigo(){
        return this.codigo;
    }

    public void setcodigo(String codigo){
        this.codigo = codigo;
    }

    public String getnome(){
        return this.nome;
    }

    public void setnome(String nome){
        this.nome = nome;
    }

    public int getdificuldade(){
        return this.dificuldade;
    }

    public void setdificuldade(int dificuldade){
        this.dificuldade = dificuldade;
    }

    public int gettempo(){
        return this.tempo;
    }

    public void settempo(int tempo){
        this.tempo = tempo;
    }

    public int getconsumoDeCalorias(){
        return this.consumoDeCalorias;
    }

    public void setconsumoDeCalorias(int calorias){
        this.consumoDeCalorias = calorias;
    }

    public String toString () {
        StringBuilder sb = new StringBuilder();

        sb.append("Atividade:: {\n");
        sb.append("  Nome da atividade: " + this.nome + "\n");
        sb.append("  Código: " + this.codigo + "\n");
        String dificulty = "";
        switch(this.dificuldade){
            case 1: dificulty = "Easy";
                break;
            case 2: dificulty = "Medium";
                break;
            case 3: dificulty = "Hard";
                break;
        }
        sb.append("  Dificuldade: " + dificulty + "\n"); // tempo, consumocalorias
        sb.append("  Tempo: " + this.tempo + "horas\n");
        sb.append("  Calorias consumidas: " + this.consumoDeCalorias + "\n");
        sb.append("}\n");

        return sb.toString();
    }


    public String gerarCodigo() {
        return UUID.randomUUID().toString();
    }

}
