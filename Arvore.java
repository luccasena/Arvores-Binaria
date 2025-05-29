public class Arvore{

    private Folha folha;
    private Arvore noDireita;
    private Arvore noEsquerda;

    public Arvore(){
        this.noDireita = null;
        this.folha = null;
        this.noEsquerda = null;
    }

    public Arvore(Folha folha){
        this.noDireita = null;
        this.folha = folha;
        this.noEsquerda = null;
    }

    public boolean verificaVazio(){
        return this.folha == null;
    }

    public void inserirFolha(Folha novoAluno){
        if(verificaVazio()){
            this.folha = novoAluno;

        }else{
            Arvore novaArvore = new Arvore(novoAluno);
            if (novoAluno.getRgm() < folha.getRgm()) {
                // Significa que irá ser alocado para Esquerda;
                if (noEsquerda == null) {
                    this.noEsquerda = novaArvore;
                } else {
                    this.noEsquerda.inserirFolha(novoAluno);
                }

            } else if (novoAluno.getRgm() > folha.getRgm())
                // Significa que irá ser alocado para direita;
                if (noDireita == null) {
                    this.noDireita = novaArvore;
                } else {
                    this.noDireita.inserirFolha(novoAluno);
                }
        }

    }

}
