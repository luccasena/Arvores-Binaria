import java.util.Scanner;

public class Arvore{

    // Atributos

    private Aluno aluno;
    private Arvore noDireita;
    private Arvore noEsquerda;
    
    // Métodos

    public Aluno getAluno() {
        return aluno;
    }

    public Arvore getDireita(){
        return noDireita;
    }

    public Arvore getEsquerda(){
        return noEsquerda;
    }

    public Arvore(){
        this.noDireita = null;
        this.aluno = null;
        this.noEsquerda = null;
    }

    public Arvore(Aluno aluno){
        this.noDireita = null;
        this.aluno = aluno;
        this.noEsquerda = null;
    }

    public boolean verificaVazio(){
        return this.aluno == null;
    }

    public Arvore encontrarSucessor() {
        Arvore atual = this;
        while (atual.noEsquerda != null) {
            atual = atual.noEsquerda;
        }
        return atual;
}

    public void inserirAluno(Aluno novoAluno){
        if(verificaVazio()){
            this.aluno = novoAluno;

        }else{
            Arvore novaArvore = new Arvore(novoAluno);
            if (novoAluno.getRgm() < aluno.getRgm()) {
                // Significa que irá ser alocado para Esquerda;
                if (noEsquerda == null) {
                    this.noEsquerda = novaArvore;
                } else {
                    this.noEsquerda.inserirAluno(novoAluno);
                }

            } else if (novoAluno.getRgm() > aluno.getRgm()){
                // Significa que irá ser alocado para direita;
                if (noDireita == null) {
                    this.noDireita = novaArvore;
                } else {
                    this.noDireita.inserirAluno(novoAluno);
                }
            }
        }
    }  

    public Arvore removerAluno(int rgm){
        // Verifica se a árvore está vazia
        if(verificaVazio()){
            System.out.println("Não há registros de alunos!");
            return null;

        }else{
            // Percorre à esquerda
            if (rgm < aluno.getRgm() && noEsquerda != null) {
                noEsquerda = noEsquerda.removerAluno(rgm);

            // Percorre à direita
            } else if (rgm > aluno.getRgm() && noDireita != null) {
                noDireita = noDireita.removerAluno(rgm);

            // Encontrou o nó a ser removido
            } else {
                // Caso 1: Sem filhos
                if (noEsquerda == null && noDireita == null) {
                    return null;

                // Caso 2: Um filho (direito)
                } else if (noEsquerda == null) {
                    return noDireita;

                // Caso 2: Um filho (esquerdo)
                } else if (noDireita == null) {
                    return noEsquerda;

                // Caso 3: Dois filhos
                } else {
                    // Encontrar sucessor (menor valor na subárvore direita)
                    Arvore sucessor = noDireita.encontrarSucessor();
                    this.aluno = sucessor.aluno; // Copia os dados
                    noDireita = noDireita.removerAluno(sucessor.aluno.getRgm()); // Remove o sucessor real
                }
            }

            return this;
        }
    }

    public void exibirArvore() {
        utilidades util = new utilidades();
        Scanner input = new Scanner(System.in);

        if (verificaVazio()) {
            System.out.println("Não há registros de alunos para exibir!");
            
        }

        while (true) {
            util.menu_exibir();
            int opcao = -1;

            if (input.hasNextInt()) {
                opcao = input.nextInt();
            } else {
                System.out.println("Entrada inválida. Por favor, insira um número.");
                input.next(); 
                input.nextLine(); 
                continue;
            }
            input.nextLine(); 
            util.limpar_tela();

            switch (opcao) {
                case 0:
                    System.out.println("Saindo do menu de exibição...");
                    input.close();

                    return;
                case 1:
                    System.out.println("Exibindo em Pré Ordem: ");
                    util.linhas();
                    util.preOrdem(this);
                    util.linhas();
                    break;
                case 2:
                    System.out.println("Exibindo em In Ordem: ");
                    util.linhas();
                    util.inOrdem(this);
                    util.linhas();
                    break;
                case 3:
                    System.out.println("Exibindo em Pós Ordem: ");
                    util.linhas();
                    util.posOrdem(this);
                    util.linhas();
                    break;
                case 4:
                    System.out.println("Exibindo Graficamente em Janela:");
                    util.linhas();
                        final Arvore arvore = this; 
                        javax.swing.SwingUtilities.invokeLater(new Runnable() {
                            public void run() {
                                new GUIArvore(arvore); 
                            }
                        });
                        System.out.println("Janela gráfica da árvore foi solicitada...");
                    break; 
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    util.linhas();
                    break;
        
        }

        if (opcao != 0 && opcao != 4) { 
            System.out.println("\nPressione Enter para voltar ao menu de exibição...");
            input.nextLine(); 
            util.limpar_tela();
        } else if (opcao == 4) {
             System.out.println("A janela gráfica opera independentemente. Pressione Enter para continuar no terminal...");
             input.nextLine();
             util.limpar_tela();
        }
    }
}

    public Aluno buscarPorRgm(int rgmBusca){

        if(this.verificaVazio()){
            return null;
        }

        if(rgmBusca == this.aluno.getRgm()){
            return this.aluno;
        } else if (rgmBusca < this.aluno.getRgm()) {
            if (this.noEsquerda == null) return null;
            return this.noEsquerda.buscarPorRgm(rgmBusca);
        } else{
            if(this.noDireita == null) return null;
            return this.noDireita.buscarPorRgm(rgmBusca);
        }
    }
    // Esvaziar a arvore
   public void esvaziar() {
    // Primeiro esvazia o nó esquerda (se existir)
    if (this.noEsquerda != null) {
        this.noEsquerda.esvaziar();
        this.noEsquerda = null;
    }

    // Depois esvazia o nó direita (se existir)
    if (this.noDireita != null) {
        this.noDireita.esvaziar();
        this.noDireita = null;
    }

    // Por fim, esvazia o nó atual
    this.aluno = null;
}


}
