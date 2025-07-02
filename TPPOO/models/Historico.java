package models;

import java.time.LocalDateTime;


public class Historico {
    Atividade atividade;
    LocalDateTime data;

    public Historico(){
        this.atividade = new Atividade();
        this.data = LocalDateTime.now();
    }
    public Historico(Atividade atividade, LocalDateTime data) {
        this.atividade = atividade;
        this.data = data;
    }
    public Historico(Historico x){
        this.atividade = x.atividade;
        this.data = x.data;
    }

    public Historico clone(){
        return new Historico(this);
    }

    public void setAtividade(Atividade atividade){
        this.atividade = atividade;
    }

    public Atividade getAtividade() {
        return atividade;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public LocalDateTime getData() {
        return data;
    }
}