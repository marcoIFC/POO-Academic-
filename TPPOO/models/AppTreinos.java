package models;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.HashMap;

public class  AppTreinos {
    private LocalDateTime date = LocalDateTime.now();
    private LocalDateTime lastDateChange = LocalDateTime.now();

    private Utilizador user;
    private Atividade atividade;
    private HashMap<String, Utilizador> users; // email -> User
    private HashMap<String, Atividade> atividades;

    public AppTreinos(){
        this.user = new Utilizador();
        this.atividade = new Atividade();
        this.users = new HashMap<String, Utilizador>();
        this.atividades = new HashMap<String, Atividade>();
    }

    public void addUtilizador(Utilizador user) {
        users.put(user.getemail(), user);
    }
    public void removeUtilizador(Utilizador user){
        users.remove(user.getemail());
    }
    public HashMap<String,Atividade> getAtividades(){
        return this.atividades;
    }

    public void addAtividade(Atividade activity){
        atividades.put(activity.getnome(), activity);
    }

    public void removeAtividade(Atividade activity){
        atividades.remove(activity.getnome());
    }

    public int checkactivitytype(String nome){
        if(atividades.get(nome) instanceof Distancia){
            return 1;// Distancia
        }
        else if(atividades.get(nome) instanceof Distancia_Altimetria){
            return 2;// Distancia e Altimetria
        }
        else if(atividades.get(nome) instanceof Series_Repeticoes){
            return 3;// Séries
        }
        else if(atividades.get(nome) instanceof Series_Pesos){
            return 4;// Séries com Pesos
        }
        else return 0;
    }

    public Utilizador getUser(){
        return this.user;
    }

    public HashMap<String, Utilizador> getUsers() {
        return this.users;
    }
    public void setUsers(HashMap<String, Utilizador> users) {
        this.users = users;
    }
    public Utilizador getUtilizador(String email) {
        return this.users.get(email);
    }

    public void setUser(Utilizador user) {
        this.user = user;
    }

    public void setAtividade(Atividade atividade){
        this.atividade = atividade;
    }

    public Atividade getAtividade(){
        return this.atividade;
    }


    public LocalDateTime getdate() {
        long secondsDelta = LocalDateTime.now().toEpochSecond(ZoneOffset.UTC) - this.lastDateChange.toEpochSecond(ZoneOffset.UTC);

        return this.date.plusSeconds(secondsDelta);
    }

    public void setdate(LocalDateTime date) {
        this.date = date;
    }

    public LocalDateTime getLastDateChange() {
        return this.lastDateChange;
    }

    public void setLastDateChange(LocalDateTime lastChangeDate) {
        this.lastDateChange = lastChangeDate;
    }
}
