package models;

import java.util.ArrayList;
import java.util.UUID;
import java.util.HashMap;
import java.util.stream.Collectors;
import models.Historico;
import models.Objetivo;
import models.AppTreinos;

public class Utilizador {
    private AppTreinos app;
    private String codigo;
    private String nome;
    private String morada;
    private String email;
    private int peso;
    private int idade;
    private int tipo; // profissional(3), amador(2), ocasional(1), null(0);
    private ArrayList<Historico> historico; // atividade e data
    private ArrayList<Objetivo> objetivos; //tipo de exercicio & calorias a gastar
    private int frequenciaCardiaca;

    public Utilizador(){
        this.codigo = this.gerarCodigo();
        this.nome = "n/a";
        this.morada = "n/a";
        this.email = "n/a";
        this.peso = 0;
        this.idade = 0;
        this.tipo = 0;
        this.historico = new ArrayList<Historico>();
        this.frequenciaCardiaca = 0;
        this.objetivos = new ArrayList<Objetivo>();
    }

    public Utilizador(String nome, String morada, String email, int tipo, int peso, int idade,
                      int frequenciaCardiaca){
        this.codigo = this.gerarCodigo();
        this.nome = nome;
        this.peso = peso;
        this.idade = idade;
        this.morada = morada;
        this.email = email;
        this.tipo = tipo;
        this.historico = new ArrayList<Historico>();
        this.frequenciaCardiaca = frequenciaCardiaca;
        this.objetivos = new ArrayList<Objetivo>();
    }

    public Utilizador(Utilizador x){
        this.codigo = this.getcodigo();
        this.nome = x.getnome();
        this.peso = x.peso;
        this.idade = x.idade;
        this.morada = x.getmorada();
        this.email = x.getemail();
        this.tipo = x.gettipo();
        this.historico = x.gethistorico();
        this.frequenciaCardiaca = x.getfrequenciaCardiaca();
        this.objetivos = x.getObjetivos();
    }



    public int gettipo(){
        return this.tipo;
    }

    public String getnome(){
        return this.nome;
    }

    public String getcodigo(){
        return this.codigo;
    }

    public int getpeso(){
        return this.peso;
    }

    public int getidade(){
        return this.idade;
    }

    public String getmorada(){
        return this.morada;
    }

    public String getemail(){
        return this.email;
    }

    public ArrayList<Historico> gethistorico(){
        return this.historico;
    }

    public Integer getfrequenciaCardiaca(){
        return this.frequenciaCardiaca;
    }

    public ArrayList<Objetivo> getObjetivos(){
        return this.objetivos.stream().map(Objetivo::clone).collect(Collectors.toCollection(ArrayList::new));
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public void setTipo(int tipo){
        this.tipo = tipo;
    }
    public void setPeso(int peso) {
        this.peso = peso;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFrequenciaCardiaca(int frequenciaCardiaca) {
        this.frequenciaCardiaca = frequenciaCardiaca;
    }

    public void setHistorico(ArrayList<Historico> historico) {
        this.historico = historico;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }


    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Utilizador:: {\n");
        sb.append("  Nome: " + this.nome + "\n");
        sb.append("  Código: " + this.codigo + "\n");
        sb.append("  Morada: " + this.morada + "\n");
        sb.append("  Email: " + this.email + "\n");
        sb.append("  Peso: " + this.peso + "\n");
        sb.append("  Idade: " + this.idade + "\n");
        String tipo = "";
        switch(this.tipo){
            case 1: tipo = "Ocasional";
                break;
            case 2: tipo = "Amador";
                break;
            case 3: tipo = "Profissional";
                break;
        }
        sb.append("  Tipo: " + tipo + "\n"); // tempo, consumocalorias
        sb.append("  Frequencia cardíaca: " + this.frequenciaCardiaca + "bpm\n");
        sb.append("}\n");

        return sb.toString();
    }

    public void setObjetivos(ArrayList<Objetivo> objetivos){
        this.objetivos = objetivos;
    }

    public String gerarCodigo() {
        return UUID.randomUUID().toString();
    }
}
