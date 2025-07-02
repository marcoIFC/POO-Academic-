package models;

public class Objetivo {
    String atividade;
    Integer caloriasParaGastar;

    public Objetivo(){
        this.atividade = "n/a";
        this.caloriasParaGastar = 0;
    }

    public Objetivo(String atividade, Integer caloriasParaGastar){
        this.atividade = atividade;
        this.caloriasParaGastar = caloriasParaGastar;
    }

    public Objetivo(Objetivo x){
        this.atividade = x.atividade;
        this.caloriasParaGastar = x.caloriasParaGastar;
    }

    public Objetivo clone(){
        return new Objetivo(this);
    }

    public void setAtividade(String atividade){
        this.atividade = atividade;
    }

    public void setCaloriasParaGastar(Integer caloriasParaGastar){
        this.caloriasParaGastar = caloriasParaGastar;
    }

    public String getAtividade(){
        return atividade;
    }

    public Integer getCaloriasParaGastar(){
        return caloriasParaGastar;
    }
}
