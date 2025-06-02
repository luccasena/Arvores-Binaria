
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

                            System.out.println("Digite o RGM do aluno:  ");
                            rgm = input.nextInt();

                            input.nextLine();
                        
                            if(arvoreAlunos.buscarPorRgm(rgm) != null){
                                System.out.println("RGM já cadastrado! Tente novamente...");
     
                            }else{

                                System.out.println("Digite o nome completo do usuário: ");
                                String nome = input.nextLine();

                                Aluno aluno = new Aluno(rgm, nome);
                                arvoreAlunos.inserirAluno(aluno);

                                util.limpar_tela();
                                System.out.println("Aluno "+nome+" adicionado com sucesso!");

                                String string_rgm = Integer.toString(rgm);
                                util.escrever_arquivo_txt(nome, string_rgm,"rgmscriados.txt");
                                

                        }


                            break;
                        case 2:
                            System.out.println("[2] -  Remover Aluno;");
                            util.linhas();

                            if(arvoreAlunos.verificaVazio()){
                                System.out.println("Não há alunos cadastrados para remover!");
                                break;
                            }else{

                                System.out.println("Digite o RGM do aluno:  ");
                                rgm = input.nextInt();

                                util.limpar_tela();
                                Aluno aluno_busca = arvoreAlunos.buscarPorRgm(rgm);
                                if (aluno_busca == null){
                                    System.out.println("Aluno com o RGM: "+rgm+" não encontrado!");
                                    break;
                                }else{
                                    String nome_aluno = aluno_busca.getNome();
                                    arvoreAlunos = arvoreAlunos.removerAluno(rgm);
                                    util.limpar_tela();
                                    System.out.println("Aluno com RGM: "+rgm+" removido com sucesso!");
                                    util.escrever_arquivo_txt(nome_aluno,Integer.toString(rgm),"rgmsremovidos.txt");
                                }
                            }
                               
                            break;
                        case 3:
                            System.out.println("[3] -  Pesquisar Aluno por RGM;");
                            util.linhas();
                            
                            if(arvoreAlunos.verificaVazio()){
                                System.out.println("Não há alunos cadastrados para pesquisar!");
                                break;
                            }else{
                                System.out.println("Digite o RGM do aluno: ");
                                int rgmBusca =input.nextInt();

                                Aluno resultado = arvoreAlunos.buscarPorRgm(rgmBusca);
                                util.limpar_tela();

                                if(resultado != null){
                                    System.out.println("Aluno Encontrado com sucesso!");
                                    System.out.println("Nome: " + resultado.getNome());
                                    System.out.println("RGM: " + resultado.getRgm());
                                } else {
                                    System.out.println("Aluno com o RGM: " + rgmBusca + " Não encontrado!");
                                }
                            }

                            break;
                       case 4: // esvaziar árvore
                             arvoreAlunos.esvaziar();  // Chama o método que apaga a árvore
                            System.out.println("Árvore esvaziada com sucesso!");
                             break;


                            
                        case 5:
                            System.out.println("[5] -  Exibir Árvore;");
                            if ((arvoreAlunos.verificaVazio())) {
                                System.out.println("Não há alunos cadastrados para exibir!");
 
                                
                            }else{
                                arvoreAlunos.exibirArvore();

                            }


                            break;
                        default:
                            System.out.println("Limite de índices excedido! Tente novamente...");


                    }
                }
                if(escolha == 0){
                    input.close();
                    util.limpar_arquivo_txt("rgmscriados.txt");
                    util.limpar_arquivo_txt("rgmsremovidos.txt");
                    
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
