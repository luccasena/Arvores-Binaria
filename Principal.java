
import java.util.Scanner;

public class Principal {
    public static void main(String []args){

        Scanner input = new Scanner(System.in);
        utilidades util = new utilidades();
        Arvore arvoreAlunos = new Arvore();

        util.adicionar_alunos_via_doc_txt(arvoreAlunos);

        int escolha;
        int rgm;

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

                            System.out.println("Digite o nome completo do usuário: ");
                            String nome = input.next();

                            input.nextLine(); // Limpando o Buffer do teclado

                            System.out.println("Digite o RGM do aluno:  ");
                            rgm = input.nextInt();

                            Aluno aluno = new Aluno(rgm, nome);

                            arvoreAlunos.inserirAluno(aluno);

                            util.limpar_tela();
                            System.out.println("Aluno "+nome+" adicionado com sucesso!");


                            break;
                        case 2:
                            System.out.println("[2] -  Remover Aluno;");
                            util.linhas();

                            System.out.println("Digite o RGM do aluno:  ");
                            rgm = input.nextInt();

                            arvoreAlunos = arvoreAlunos.removerAluno(rgm);
                            util.limpar_tela();
                            System.out.println("Aluno com RGM: "+rgm+" removido com sucesso!");

                            break;
                        case 3:
                            System.out.println("[3] -  Pesquisar Aluno por RGM;");
                            util.linhas();

                            System.out.println("Digite o RGM do aluno: ");
                            int rgmBusca =input.nextInt();

                            Aluno resultado = arvoreAlunos.buscarPorRgm(rgmBusca);
                            util.limpar_tela();

                            if(resultado != null){
                                System.out.println("Aluno Encontrado com sucesso!");
                                System.out.println("Nome: " + resultado.getNome());
                                System.out.println("RGM: " + resultado.getRgm());
                            } else {
                                System.out.println("Aluno com o RGM " + rgmBusca + "Não encontrado!");
                            }

                            break;
                        case 4:
                            System.out.println("[4] -  Esvaziar;");
                            util.linhas();

                            break;
                        case 5:
                            System.out.println("[5] -  Exibir Árvore;");
                            util.linhas();
                            arvoreAlunos.exibirArvore();
                            input.nextLine();


                            break;
                        default:
                            System.out.println("Limite de índices excedido! Tente novamente...");
                            util.linhas();

                    }
                }
                if(escolha == 0){
                    input.close();
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
