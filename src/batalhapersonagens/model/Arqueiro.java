package batalhapersonagens.model;

public class Arqueiro extends Personagem {

    private final double tiroCerto = 0.15;
    private final double camuflagem = 0.03;

    public Arqueiro(String nome){
        super(nome);
    }


    public double getTiroCerto() {
        return tiroCerto;
    }

    public double getCamuflagem() {
        return camuflagem;
    }

    
    
    public int calcVida(int dado){
        int vida =  4*getAgilidade() + dado;
        return vida;
    }

    public int calcDano(int dado){
        int dano = 2*getAgilidade() + dado;
        return dano;
    }


    @Override
    public String toString(){
        return super.toString() + "\nTiro Certeiro: " + tiroCerto + "" + "\nCamuflagem: "+  camuflagem ;
    }
    
}
