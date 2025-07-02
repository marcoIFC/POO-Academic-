package controllers;

import models.*;

import java.time.LocalDateTime;


public class AppController {
    private AppTreinos app;

    public AppController(AppTreinos app) {

        this.app = app;
    }

    public Utilizador getUser(){
        return app.getUser();
    }

    public boolean login(String email) {
        Utilizador user = this.app.getUsers().get(email);
        if (user == null) {
            return false;
        }

        this.app.setUser(user); // coloca o utilizador na AppTreinos para poder fazer operações com ele

        return true;
    }

    public boolean registar(String nome, String morada, String email,int tipo,int peso, int idade, int frequenciaCardiacaMedia) {
        boolean emailExists = this.app.getUsers().containsKey(email);
        if (emailExists) {
            return false;
        }

        if (email == "inalterado"){  //...
            String email_aux = this.app.getUser().getemail();
            Utilizador user = new Utilizador(nome,morada,email_aux,tipo,peso,idade,frequenciaCardiacaMedia);
            this.app.setUser(user);
            this.app.getUsers().replace(email_aux, user);
        }
        else{
            Utilizador user = new Utilizador(nome,morada,email,tipo,peso,idade,frequenciaCardiacaMedia);
            this.app.addUtilizador(user);
            this.app.setUser(user);
        }

        return true;
    }

    public Utilizador getUser(String email){
        return this.app.getUsers().get(email);
    }

    public AppTreinos getapp(){
        return this.app;
    }

    public boolean verificanomeatividade(String nomeAtividade){
        if(this.app.getAtividades().containsKey(nomeAtividade)){
            return true;
        }
        else{
            return false;
        }
    }

    public Atividade escolheratividade (Atividade atividade){
        Atividade escolhida = this.app.getAtividades().get(atividade.getnome()).clone(); //.clone
        return escolhida;
    }

    public void listausers(){
        for (String key: app.getUsers().keySet()) {
            System.out.println("Email: " + key);
            System.out.println("Nome : " + app.getUsers().get(key).getnome());
        }
    }
 // ESTATÍSTICA
    public void todasatividades(Utilizador userescolhido){
        System.out.println("Estas são todas as atividades que o " + userescolhido.getnome() + "já fez:\n");
        for(int i = 0; i < userescolhido.gethistorico().size();i++){
            System.out.println(userescolhido.gethistorico().get(i).getAtividade().toString());
            System.out.println("------------------------");
        }
    }
    public void usermaiscaloriasgastas(){
        int maiscaloriasgastas = 0;
        Utilizador ogajo = null;
        for(String key:app.getUsers().keySet()){
            int caloriasgastas = 0;
            for(int i = 0;i < app.getUsers().get(key).gethistorico().size();i++){
                caloriasgastas = caloriasgastas +
                        app.getUsers().get(key).gethistorico().get(i).getAtividade().getconsumoDeCalorias();
            }
            if(caloriasgastas > maiscaloriasgastas){
                maiscaloriasgastas = caloriasgastas;
                ogajo = app.getUsers().get(key);
            }
        }
        System.out.println("O utilizador com mais calorias gastas desde sempre é:");
        System.out.println(ogajo.toString());
        System.out.println("Com " + maiscaloriasgastas + "calorias gastas");
    }

    public void metrosaltitudeuser(Utilizador userescolhido){
        int kms = 0;
        for(int i = 0; i < userescolhido.gethistorico().size();i++){
            if (userescolhido.gethistorico().get(i).getAtividade() instanceof Distancia_Altimetria) {
                Distancia_Altimetria gaja2 = (Distancia_Altimetria) userescolhido.gethistorico().get(i).getAtividade();
                kms = kms + gaja2.getaltitude();
            }
        }
        System.out.println("O utilizador " + userescolhido.getnome() + "já subiu " + kms + "metros de altura");
    }
    public void kmspercorridos(Utilizador userescolhido){
        int kms = 0;
        for(int i = 0; i < userescolhido.gethistorico().size();i++){
            if(userescolhido.gethistorico().get(i).getAtividade() instanceof Distancia){
                Distancia gaja = (Distancia) userescolhido.gethistorico().get(i).getAtividade();
                kms = kms + gaja.getdistancia();
            } else if (userescolhido.gethistorico().get(i).getAtividade() instanceof Distancia_Altimetria) {
                Distancia_Altimetria gaja2 = (Distancia_Altimetria) userescolhido.gethistorico().get(i).getAtividade();
                kms = kms + gaja2.getdistancia();
            }
        }
        System.out.println("O utilizador " + userescolhido.getnome() + "já percorreu " + kms + "kms");
    }

    public void tipoatividademaispraticada(){
        int countDistancia = 0;
        int countDistancia_Altimetria = 0;
        int countSeries_Pesos = 0;
        int countSeries_Repeticoes = 0;
        for(String key:app.getUsers().keySet()){
            for(int i = 0;i < app.getUsers().get(key).gethistorico().size();i++) {
                if(app.getUsers().get(key).gethistorico().get(i).getAtividade() instanceof Distancia){
                    countDistancia++;
                } else if (app.getUsers().get(key).gethistorico().get(i).getAtividade()
                        instanceof Distancia_Altimetria) {
                    countDistancia_Altimetria++;
                } else if (app.getUsers().get(key).gethistorico().get(i).getAtividade()
                        instanceof Series_Pesos) {
                    countSeries_Pesos++;
                } else if (app.getUsers().get(key).gethistorico().get(i).getAtividade()
                        instanceof Series_Repeticoes) {
                    countSeries_Repeticoes++;
                }
            }
        }
        int maior = countDistancia;
        String atividademaispraticada = "Distancia";

        if(maior < countDistancia_Altimetria){
            maior = countDistancia_Altimetria;
            atividademaispraticada = "Distancia_Altimetria";
        }
        if(maior < countSeries_Pesos){
            maior = countSeries_Pesos;
            atividademaispraticada = "Series_Pesos";
        }
        if(maior < countSeries_Repeticoes){
            maior = countSeries_Repeticoes;
            atividademaispraticada = "Series_Repeticoes";
        }
        System.out.println("O tipo de atividade mais praticada é " + atividademaispraticada +
                "com " + maior + "vezes.");

    }

    public void usermaisatividadesfeitas(){
        int maisatividadesfeitas = 0;
        Utilizador ogajo = null;
        for(String key:app.getUsers().keySet()){
            int atividadesfeitas = app.getUsers().get(key).gethistorico().size();

            if(atividadesfeitas > maisatividadesfeitas){
                maisatividadesfeitas = atividadesfeitas;
                ogajo = app.getUsers().get(key);
            }
        }
        System.out.println("O utilizador com mais atividades feitas desde sempre é:");
        System.out.println(ogajo.toString());
        System.out.println("Com " + maisatividadesfeitas + "atividades feitas");

    }

    public void fazerAtividade(String nomeact, int dificuldadeact, int tempoact, int calorias){
        int tipoact = this.getapp().checkactivitytype(nomeact);
        switch(tipoact){
            case 1:
                Distancia escolhida1 = new Distancia(nomeact);
                escolhida1.setdificuldade(dificuldadeact);
                escolhida1.settempo(tempoact);
                escolhida1.setconsumoDeCalorias(calorias);
                escolhida1.geraAtividade(escolhida1, this.getUser());
                Historico novohistorial1 = new Historico(escolhida1, LocalDateTime.now());
                this.getUser().gethistorico().add(novohistorial1);
                break;
            case 2:
                Distancia_Altimetria escolhida2 = new Distancia_Altimetria(nomeact);
                escolhida2.setdificuldade(dificuldadeact);
                escolhida2.settempo(tempoact);
                escolhida2.setconsumoDeCalorias(calorias);
                escolhida2.geraAtividade(escolhida2, this.getUser());
                Historico novohistorial2 = new Historico(escolhida2, LocalDateTime.now());
                this.getUser().gethistorico().add(novohistorial2);
                break;
            case 3:
                Series_Repeticoes escolhida3 = new Series_Repeticoes(nomeact);
                escolhida3.setdificuldade(dificuldadeact);
                escolhida3.settempo(tempoact);
                escolhida3.setconsumoDeCalorias(calorias);
                escolhida3.geraAtividade(escolhida3, this.getUser());
                Historico novohistorial3 = new Historico(escolhida3, LocalDateTime.now());
                this.getUser().gethistorico().add(novohistorial3);
                break;
            case 4:
                Series_Pesos escolhida4 = new Series_Pesos(nomeact);
                escolhida4.setdificuldade(dificuldadeact);
                escolhida4.settempo(tempoact);
                escolhida4.setconsumoDeCalorias(calorias);
                escolhida4.geraAtividade(escolhida4, this.getUser());
                Historico novohistorial4 = new Historico(escolhida4, LocalDateTime.now());
                this.getUser().gethistorico().add(novohistorial4);
                break;
            case 0:
                System.out.println("erro  no checkactivitytype");
                break;
        }
    }

}
