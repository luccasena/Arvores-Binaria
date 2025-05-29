public class Arvore{

    private Aluno aluno;
    private Arvore noDireita;
    private Arvore noEsquerda;


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

}
