// Configurando a estrutura do nó:

public class Folha {

    // Valores dentro do nó
    private int RGM;
    private String nomeAluno;

    public Folha(int RGM, String nomeAluno){
        this.RGM = RGM;
        this.nomeAluno = nomeAluno;

    }

    public int getRgm(){
        return RGM;
    }

}
