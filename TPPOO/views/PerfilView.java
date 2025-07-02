package views;
import models.Utilizador;
import views.MainView;
import java.util.Scanner;
import java.util.ArrayList;
import models.Historico;
import controllers.AppController;

public class PerfilView {
    private AppController appController;

    public PerfilView(AppController appController){
        this.appController = appController;
    }

    public void viewPerfil(Utilizador u1){
        boolean voltar = false;
        while(!voltar){
            Scanner obj = new Scanner(System.in);
            System.out.println("--------Perfil--------");
            System.out.println("Nome: " + u1.getnome());
            System.out.println("E-mail: " + u1.getemail());
            System.out.println("Morada: " + u1.getmorada());
            switch(u1.gettipo()){
                case 1 : System.out.println("Desportista: Ocasional");
                    break;
                case 2 : System.out.println("Desportista: Amador");
                    break;
                case 3 : System.out.println("Desportista: Profissional");
                    break;
            }
            System.out.println("Objetivos: " + u1.getObjetivos());
            System.out.println("----------------------");
            System.out.println("[1] Historico  [2] Alterar Perfil  [3] Voltar");
            int opc = obj.nextInt();
            switch (opc){
                case 1: viewHistorico(u1);
                    break;
                case 2: System.out.println("-----ALTERAR PERFIL-----");
                    obj.nextLine();
                    System.out.println("Nome: ");
                    String nome= obj.nextLine();
                    System.out.println("Morada: ");
                    String morada= obj.nextLine();
                    System.out.println("Peso: ");
                    int peso= obj.nextInt();
                    System.out.println("Idade: ");
                    int idade = obj.nextInt();
                    System.out.println("Frequencia Cardiaca Media: ");
                    int frequenciaCardiacaMedia= obj.nextInt();
                    System.out.println("Desportista: [1]Ocasional [2]Amador [3]Profissional ");
                    int tipo= obj.nextInt();
                    appController.registar(nome,morada,"inalterado",tipo,peso,idade,frequenciaCardiacaMedia);
                    u1 = this.appController.getUser();
                    System.out.println("Perfil alterado com sucesso");
                    break;

                case 3:
                    voltar = true;
                    break;
            }
        }

    }
    public void viewHistorico(Utilizador user){
        if(!user.gethistorico().isEmpty()){
            System.out.println("------Historico------");
            for(int i = 0; i< user.gethistorico().size(); i++){
                System.out.println("---------------------");
                System.out.println(user.gethistorico().get(i).getData().toString());
                System.out.println(user.gethistorico().get(i).getAtividade().toString());
                System.out.println("---------------------");
            }
        }
        else{
            System.out.println("O histórico ainda está vazio.");
        }
    }
}
