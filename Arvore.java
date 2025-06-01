import java.util.Scanner;

public class Arvore{

    private Aluno aluno;
    private Arvore noDireita;
    private Arvore noEsquerda;

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
            } else if (rgm > aluno.getRgm()) {
                if (noDireita != null)
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

    public void exibirArvore(){
        utilidades util = new utilidades();
        Scanner input = new Scanner(System.in);


        if(verificaVazio()){
        System.out.println("Não há registros de alunos!");
        } else {
            while(true){
                util.menu_exibir();
                int opcao = input.nextInt();
                util.limpar_tela();

                switch (opcao) {
                    case 0:
                        System.out.println("Saindo do menu de exibição...");

                        break;
                    case 1:
                        System.out.println("Exibindo em Pré Ordem: ");
                        util.linhas();
                        util.preOrdem(this); // this representa o objeto da árvore onde o método foi chamado, garantindo que a travessia (e impressão) será feita a partir da raiz da árvore
                        break;
                    case 2:
                        System.out.println("Exibindo em In Ordem: ");
                        util.linhas();
                        util.inOrdem(this);
                        break;
                    case 3:
                        System.out.println("Exibindo em Pós Ordem: ");
                        util.linhas();
                        util.posOrdem(this);
                        break;
                    case 4:
                        System.out.println("Exibindo em Graficamente: ");

                        break;
                        
                    default:
                        System.out.println("Opção inválida! Tente novamente.");
                        
                        break;
                }
                if(opcao == 0){
                    input.nextLine();
                    break;
                }   
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

}