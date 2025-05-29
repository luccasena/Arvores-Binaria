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

    public void inserirFolha(Aluno novoAluno){
        if(verificaVazio()){
            this.aluno = novoAluno;

        }else{
            Arvore novaArvore = new Arvore(novoAluno);
            if (novoAluno.getRgm() < aluno.getRgm()) {
                // Significa que irá ser alocado para Esquerda;
                if (noEsquerda == null) {
                    this.noEsquerda = novaArvore;
                } else {
                    this.noEsquerda.inserirFolha(novoAluno);
                }

            } else if (novoAluno.getRgm() > aluno.getRgm())
                // Significa que irá ser alocado para direita;
                if (noDireita == null) {
                    this.noDireita = novaArvore;
                } else {
                    this.noDireita.inserirFolha(novoAluno);
                }
        }

    }
    public void exibirArvore(){
        utilidades util = new utilidades();
        Scanner input = new Scanner(System.in);

<<<<<<< HEAD
        
        if(verificaVazio()){
        System.out.println("Não há registros de alunos!");
        } else {
        System.out.println("Digite a ordem que deseja utilizar: ");
        util.menu_exibir();
        int opcao = input.nextInt();
            switch (opcao) {
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
                    
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    
                    break;
            }

        }

    }
=======
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



>>>>>>> 74cf15fd3c2a2f37b6520dc44e30caa96f063fa5
}
