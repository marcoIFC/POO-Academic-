package views;

import java.util.Scanner;
import models.AppTreinos;
import controllers.AppController;
import models.Atividade;
import models.Utilizador;

public class MainView {
    private PerfilView perfilview;
    //private PlanodeTreinoView planodetreinoview;
    private AppController appcontroller;

    private boolean sair;

    public MainView(AppController appcontroller){
        this.appcontroller = appcontroller;
        this.perfilview = new PerfilView(appcontroller);
        //this.planodetreinoview = new PlanodeTreinoView();
        this.sair = false;
    }

    public boolean Sair(){
        return this.sair;
    }

    private void paraSair(){
        this.sair = true;
    }

    public void menuInicial(Scanner scanner){
        System.out.println("-----MENU-----");
        System.out.println("[1] Login");
        System.out.println("[2] Registar");
        System.out.println("[3] Atividades");
        System.out.println("[4] Estatística");
        System.out.println("[0] Sair");
        System.out.println("--------------");
        System.out.println(" ");
        boolean check = true;
        while(check){
            int opc = scanner.nextInt(); // verificar que o input foi válido
            scanner.nextLine();
            if(opc == 1){
                System.out.println("-----LOGIN-----");
                System.out.println("E-MAIL: ");
                String email = scanner.nextLine();
                while(!appcontroller.login(email)){
                    System.out.println("Email invalido!");
                    email = scanner.nextLine();
                }
                menuLogged(scanner);
                check = false;
            }
            else if(opc == 2){
                System.out.println("-----REGISTAR-----");
                scanner.nextLine();
                System.out.println("Nome: ");
                String nome= scanner.nextLine();
                System.out.println("E-MAIL: ");
                String email= scanner.nextLine();
                System.out.println("Morada: ");
                String morada= scanner.nextLine();
                System.out.println("Peso: ");
                int peso= scanner.nextInt();
                scanner.nextLine();
                System.out.println("Idade: ");
                int idade= scanner.nextInt();
                scanner.nextLine();
                System.out.println("Frequencia Cardiaca Media: ");
                int frequenciaCardiacaMedia= scanner.nextInt();
                scanner.nextLine();
                System.out.println("Desportista: [1]Ocasional [2]Amador [3]Profissional ");
                int tipo= scanner.nextInt();
                scanner.nextLine();
                if(appcontroller.registar(nome,morada,email,tipo,peso,idade,frequenciaCardiacaMedia)){
                    System.out.println("Perfil criado com sucesso");
                    menuLogged(scanner);
                    check = false;
                }
                else{
                    System.out.println("Perfil ja existe!");
                    System.out.println("[0] Voltar");
                    boolean var = true;
                    while(var){
                        opc = scanner.nextInt();
                        scanner.nextLine();
                        if (opc == 0){
                            menuInicial(scanner); var = false;
                        }
                        else System.out.println("Para voltar é \"0\".");
                    }
                }
            }
            else if(opc == 3){
                atividadesnotloggedView(scanner);
                check = false;
            }
            else if(opc == 4){
                estatistica(scanner);
                check = false;
            }
            else if(opc == 0){
                paraSair();
                check = false;
            }
            else{
                System.out.println("INPUT ERRADO");
            }
        }
    }

    public Utilizador escolheruser(Scanner scanner){
        System.out.println("Qual utilizador?");
        appcontroller.listausers();
        System.out.println("Escreva o email do escolhido.");
        String emailescolhido = scanner.nextLine();
        while(!appcontroller.getapp().getUsers().containsKey(emailescolhido)){
            System.out.println("Email inválido, tente outra vez.");
            emailescolhido = scanner.nextLine();
        }
        return appcontroller.getapp().getUsers().get(emailescolhido);
    }
    public void estatistica(Scanner scanner){
        System.out.println("-----ESTATISTICA-----");
        System.out.println("[1] Utilizador que mais calorias gastou.");
        System.out.println("[2] Utilizador que mais atividades realizou.");
        System.out.println("[3] Qual o tipo de atividade mais praticada.");
        System.out.println("[4] Quantos kms é que um utilizador percorreu.");
        System.out.println("[5] Quantos metros de altimetria é que um utilizador realizou.");
        System.out.println("[6] Todas as atividades de um utilizador.");
        System.out.println("[0] Sair");
        Utilizador userescolhido;
        int opc = scanner.nextInt();
        scanner.nextLine();
        switch(opc){
            case 1:
                appcontroller.usermaiscaloriasgastas();
                break;
            case 2:
                appcontroller.usermaisatividadesfeitas();
                break;
            case 3:
                appcontroller.tipoatividademaispraticada();
                break;
            case 4:
                userescolhido = escolheruser(scanner);
                appcontroller.kmspercorridos(userescolhido);
                break;
            case 5:
                userescolhido = escolheruser(scanner);
                appcontroller.metrosaltitudeuser(userescolhido);
                break;
            case 6:
                userescolhido = escolheruser(scanner);
                appcontroller.todasatividades(userescolhido);
                break;
            case 0:
                break;
            default:
                System.out.println("Opcao inválida");

        }
    }

    public void showAtividades(){
        System.out.println("-------ATIVIDADES-------");
        System.out.println("DISTANCIA/ALTIMETRIA:");
        System.out.println("-Corrida_de_Estrada");
        System.out.println("-Trail");
        System.out.println("-Bicicleta_de_Estrada");
        System.out.println("-Bicicleta_de_Montanha");
        System.out.println(" ");
        System.out.println("DISTANCIA:");
        System.out.println("-Corrida_em_Pista");
        System.out.println("-Remo");
        System.out.println("-Natacao");
        System.out.println("-Patinagem");
        System.out.println(" ");
        System.out.println("SERIES COM REPETICOES:");
        System.out.println("-Flexoes");
        System.out.println("-Agachamentos");
        System.out.println("-Afundos");
        System.out.println("-Prancha");
        System.out.println("-Flexoes_de_Triceps");
        System.out.println(" ");
        System.out.println("SERIES COM PESOS:");
        System.out.println("-Deadlifts");
        System.out.println("-Biceps_Curls");
        System.out.println("-Shoulder_Press");
        System.out.println("-Row's");
        System.out.println("-Agachamento_com_Pesos");
        System.out.println("------------------------");
        System.out.println(" ");
    }

    public void escolherAtividade(Scanner scanner){
        showAtividades();
        System.out.println("Escreva o nome da atividade que quer, escolha entre estas opcoes:");
        String nomeact = scanner.nextLine();

        while(!this.appcontroller.verificanomeatividade(nomeact)){
            System.out.println("Essa atividade nao existe ou esta mal escrita, escreva outra vez: ");
            nomeact = scanner.nextLine();
        }

        System.out.println("Qual o nivel de esforco(dificuldade)?");
        System.out.println("  [1] Easy\n  [2] Medium\n  [3] Hard");
        int dificuldadeact = scanner.nextInt();
        scanner.nextLine();

        while(!(0<dificuldadeact && dificuldadeact<4)){
            System.out.println("Valor errado, tenta outra vez.");
            dificuldadeact = scanner.nextInt();
            scanner.nextLine();
        }

        System.out.println("Durante quantas horas? (apenas 1 ou 2)");
        int tempoact = scanner.nextInt();
        scanner.nextLine();

        while(!(0<tempoact && tempoact<3)){
            System.out.println("Valor errado.");
            tempoact = scanner.nextInt();
            scanner.nextLine();
        }

        System.out.println("So faltam as calorias que quer gastar.");
        System.out.println("Insira um valor entre 500 e 2000.");
        int calorias = scanner.nextInt();
        scanner.nextLine();

        while(!(499<calorias && calorias<2001)){
            System.out.println("Valor errado.");
            calorias= scanner.nextInt();
            scanner.nextLine();
        }
        this.appcontroller.fazerAtividade(nomeact, dificuldadeact, tempoact, calorias);
        System.out.println("Bom treino!");

    }
    public void fazerPlanoDeTreino(Scanner scanner){
        System.out.println("Para fazer um plano de treino só precisamos de quantas calorias queres gastar!");
        System.out.println("Diz um número entre 500 e 10000.");
        int caloriasdesejadas = scanner.nextInt();
        scanner.nextLine();

        while(!(499<caloriasdesejadas && caloriasdesejadas<10001)){
            System.out.println("Valor errado.");
            caloriasdesejadas= scanner.nextInt();
            scanner.nextLine();
        }
        while(caloriasdesejadas>0){
            escolherAtividade(scanner);
            caloriasdesejadas = caloriasdesejadas - this.appcontroller.getUser()
                    .gethistorico().getLast().getAtividade().getconsumoDeCalorias();
        }
    }

    public void atividadesnotloggedView(Scanner scanner) {
        showAtividades();
        System.out.println("[0] Voltar");
        while(0 != scanner.nextInt());
        scanner.nextLine();
        menuInicial(scanner);
    }
    public void atividadesView(Scanner scanner) {
        showAtividades();
        System.out.println("[0] Voltar");
        while(0 != scanner.nextInt());
        scanner.nextLine();
        menuLogged(scanner);
    }
    public void menuLogged(Scanner scanner){
        boolean flag = true;
        while(flag){
            System.out.println("-----MENU-----");
            System.out.println("[1] Perfil");
            System.out.println("[2] Plano de Treino");
            System.out.println("[3] Atividades");
            System.out.println("[4] Fazer Atividade");
            System.out.println("[5] Terminar Sessao");
            System.out.println("--------------");
            System.out.println(" ");
            int opc = scanner.nextInt();
            scanner.nextLine();
            switch (opc) {
                case 1:
                    this.perfilview.viewPerfil(appcontroller.getUser());
                    break;
                case 2:
                    fazerPlanoDeTreino(scanner);
                    //flag = false; é suposto voltar ao menulogged depois de fazer um plano de treino.
                    break;
                case 3:
                    atividadesView(scanner);
                    flag = false;
                    break;
                case 4:
                    escolherAtividade(scanner);
                    //flag = false; é suposto no fim de fazer a atividade voltar ao menulogged.
                    break;
                case 5 :
                    menuInicial(scanner);
                    flag = false;
                    break;
                default:
                    System.out.println("Input Invalido");
                    break;
            }
        }
    }
}
