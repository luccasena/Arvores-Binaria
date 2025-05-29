
import java.util.Scanner;

public class Principal {
    public static void main(String []args){

        Scanner input = new Scanner(System.in);
        utilidades util = new utilidades();
        int escolha;
        Arvore arvoreAlunos = new Arvore();


        while(true){
            try {
                util.menu_principal();
                escolha = input.nextInt();

                if (escolha >= 0 || escolha <= 0){
                    util.limpar_tela();
                    switch(escolha){
                        case 0:
                            System.out.println("[0] -  Sair;");
                            util.linhas();

                            break;
                        case 1:
                            System.out.println("[1] -  Inserir Aluno;");
                            util.linhas();

                            break;
                        case 2:
                            System.out.println("[2] -  Remover Aluno;");
                            util.linhas();

                            break;
                        case 3:
                            System.out.println("[3] -  Pesquisar Aluno por RGM;");
                            util.linhas();

                            break;
                        case 4:
                            System.out.println("[4] -  Esvaziar;");
                            util.linhas();

                            break;
                        case 5:
                            System.out.println("[5] -  Exibir Árvore;");
                            util.linhas();

                            break;
                        default:
                            System.out.println("Limite de índices excedido! Tente novamente...");
                            util.linhas();

                    }
                }
                if(escolha == 0){
                    break;
                }
            }catch (Exception e){
                util.limpar_tela();
                input.nextLine();
                System.out.println("Opção Inválida! Tente novamente...");

            }

        }

    }

}
