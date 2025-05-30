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

    public void removerFolha(int rgm, Arvore arvore){

        if(rgm == aluno.getRgm()){

        }else{

            if (rgm < aluno.getRgm()) {
                
                // Significa que irá ser alocado para Esquerda;
                if (noEsquerda == null) {
                    this.noEsquerda = null;
                } else {
                    this.noEsquerda.removerFolha(rgm, arvore);
                }

            } else if (rgm > aluno.getRgm())
                // Significa que irá ser alocado para Direita;
                if (noDireita == null) {
                    this.noDireita = null;
                } else {
                    this.noDireita.removerFolha(rgm, arvore);
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
