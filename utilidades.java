import java.io.BufferedReader;
import java.io.FileReader; //biblioteca para ler arquivo

public class utilidades {

    public void limpar_tela(){
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }

    public void linhas(){
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-");
    }

    public void menu_principal(){
        linhas();
        System.out.println("            Árvore Binária para Cadastro de Alunos            ");
        linhas();
        System.out.println("[1] -  Inserir Aluno;");
        System.out.println("[2] -  Remover Aluno;");
        System.out.println("[3] -  Pesquisar Aluno por RGM;");
        System.out.println("[4] -  Esvaziar;");
        System.out.println("[5] -  Exibir Árvore;");
        System.out.println("[0] -  Sair;");
        linhas();
    }

    public void menu_exibir(){
        linhas();
        System.out.println("            Exibir Árvore Binária             ");
        linhas();
        System.out.println("[1] -  Pré-Ordem;");
        System.out.println("[2] -  In-Ordem;");
        System.out.println("[3] -  Pós-Ordem;");
        System.out.println("[4] -  Graficamente;");
        System.out.println("[0] -  Sair;");
        linhas();
    }
    
    public void preOrdem(Arvore arvore){
    if (arvore == null || arvore.verificaVazio()) return;
        System.out.println("RGM: " + arvore.getAluno().getRgm() + " | Nome: " + arvore.getAluno().getNome());
        preOrdem(arvore.getEsquerda());
        preOrdem(arvore.getDireita());
    }
    public void inOrdem(Arvore arvore){
    if (arvore == null || arvore.verificaVazio()) return;
        inOrdem(arvore.getEsquerda());
        System.out.println("RGM: " + arvore.getAluno().getRgm() + " | Nome: " + arvore.getAluno().getNome());
        inOrdem(arvore.getDireita());
    }
    public void posOrdem(Arvore arvore){
    if (arvore == null || arvore.verificaVazio()) return;
        posOrdem(arvore.getEsquerda());
        posOrdem(arvore.getDireita());
        System.out.println("RGM: " + arvore.getAluno().getRgm() + " | Nome: " + arvore.getAluno().getNome());
    }

     public void adicionar_alunos_via_doc_txt(Arvore arvore){

        String caminhoarquivo = "rgms.txt";
        BufferedReader leitor = null; //aceita qualquer tipo de ENTRADA de dado  

        try{    
            FileReader leitorarquivo = new FileReader(caminhoarquivo);
            leitor = new BufferedReader(leitorarquivo); 
            // read-line le uma linha do arquivo e pula para a proxima linha

            String nome_aluno; //ler a primeira linha (espera que seja o nome)
            String rgm_aluno_string; //ler a segunda linha (espera que seja o rgm)
         

            while((nome_aluno = leitor.readLine()) != null &&
                  (rgm_aluno_string = leitor.readLine()) != null){

                    int rgm_aluno = Integer.parseInt(rgm_aluno_string.trim());
                    Aluno aluno = new Aluno(rgm_aluno, nome_aluno);
                    arvore.inserirAluno(aluno);

            }
            System.out.println("Arquivo txt lido e Alunos criados!");
            leitor.close();
        }catch(Exception erro){
            System.out.println("Algo deu errado!");
            System.out.println(erro.getMessage());
        }
    }

}
