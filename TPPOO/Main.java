import java.util.Scanner;

import controllers.AppController;
import models.AppTreinos;
import models.Utilizador;
import views.MainView;
import models.Distancia_Altimetria;
import models.Distancia;
import models.Series_Repeticoes;
import models.Series_Pesos;

public class Main {
    public static void loading(AppController appcontroller){

        Distancia_Altimetria CorridaEstrada = new Distancia_Altimetria("Corrida_de_Estrada");
        Distancia_Altimetria Trail = new Distancia_Altimetria("Trail");
        Distancia_Altimetria BicicletaEstrada = new Distancia_Altimetria("Bicicleta_de_Estrada");
        Distancia_Altimetria BicicletaMontanha = new Distancia_Altimetria("");
        Distancia CorridaPista = new Distancia("Corrida_de_Pista");
        Distancia Remo = new Distancia("Remo");
        Distancia Natacao = new Distancia("Natacao");
        Distancia Patinagem = new Distancia("Patinagem");
        Series_Repeticoes Flexoes = new Series_Repeticoes("Flexoes");
        Series_Repeticoes Agachamentos = new Series_Repeticoes("Agachamentos");
        Series_Repeticoes Afundo = new Series_Repeticoes("Afundo");
        Series_Repeticoes Prancha = new Series_Repeticoes("Prancha");
        Series_Repeticoes FlexoesTriceps = new Series_Repeticoes("Flexoes_de_Triceps");
        Series_Pesos Rows = new Series_Pesos("Row's");
        Series_Pesos BicepsCurls = new Series_Pesos("Biceps_de_Curls");
        Series_Pesos Deadlifts = new Series_Pesos("Deadlifts");
        Series_Pesos ShoulderPress = new Series_Pesos("Shoulder_Press");
        Series_Pesos AgachamentoPeso = new Series_Pesos("Agachamento_com_Peso");

        appcontroller.getapp().addAtividade(CorridaEstrada);
        appcontroller.getapp().addAtividade(Trail);
        appcontroller.getapp().addAtividade(BicicletaMontanha);
        appcontroller.getapp().addAtividade(BicicletaEstrada);
        appcontroller.getapp().addAtividade(CorridaPista);
        appcontroller.getapp().addAtividade(Remo);
        appcontroller.getapp().addAtividade(Natacao);
        appcontroller.getapp().addAtividade(Patinagem);
        appcontroller.getapp().addAtividade(Flexoes);
        appcontroller.getapp().addAtividade(Agachamentos);
        appcontroller.getapp().addAtividade(Afundo);
        appcontroller.getapp().addAtividade(Prancha);
        appcontroller.getapp().addAtividade(FlexoesTriceps);
        appcontroller.getapp().addAtividade(Rows);
        appcontroller.getapp().addAtividade(BicepsCurls);
        appcontroller.getapp().addAtividade(Deadlifts);
        appcontroller.getapp().addAtividade(ShoulderPress);
        appcontroller.getapp().addAtividade(AgachamentoPeso);

        Utilizador UserDefault = new Utilizador("teste", "Mondim de Basto",
                "teste", 1, 70, 22,90);
        Utilizador Uservazio = new Utilizador("uservazio","Rua algures em Braga",
                "uservazio",2,60,30,70);
        Utilizador Usercomcoisas = new Utilizador("usercomcoisas","",
                "usercomcoisas",3,55,22,80);

        appcontroller.getapp().addUtilizador(UserDefault);
        appcontroller.getapp().addUtilizador(Uservazio);
        appcontroller.getapp().addUtilizador(Usercomcoisas);

        // adicionar atividades ao user com coisas
        appcontroller.getapp().setUser(Usercomcoisas);
        appcontroller.fazerAtividade("Natacao", 2, 1, 1500);
        appcontroller.fazerAtividade("Remo", 2, 1, 1500);
        appcontroller.fazerAtividade("Corrida_de_Estrada", 1, 1, 1000);
        appcontroller.fazerAtividade("Prancha", 1, 1, 1000);
        appcontroller.fazerAtividade("Natacao", 3, 2, 2000);
        appcontroller.fazerAtividade("ShoulderPress", 1, 1, 1000);
        appcontroller.fazerAtividade("Natacao", 1, 1, 1000);
        appcontroller.fazerAtividade("Flexoes_de_Triceps", 1, 1, 1000);
        appcontroller.fazerAtividade("Natacao", 2, 2, 1800);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AppTreinos app = new AppTreinos();
        AppController appcontroller = new AppController(app);
        MainView view = new MainView(appcontroller);

        loading(appcontroller);
        while (!view.Sair()) {
            view.menuInicial(scanner);
        }
    }
}