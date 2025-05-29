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

}
