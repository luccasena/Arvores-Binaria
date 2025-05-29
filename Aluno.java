// Configurando a estrutura do nó:

public class Aluno {

    // Valores dentro do nó
    private int RGM;
    private String nomeAluno;

    public Aluno(int RGM, String nomeAluno){
        this.RGM = RGM;
        this.nomeAluno = nomeAluno;

    }

    public int getRgm(){
        return RGM;
    }

    public String getNomeAluno(){
        return nomeAluno;
    }


}
