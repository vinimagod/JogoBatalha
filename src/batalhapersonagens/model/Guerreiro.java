package batalhapersonagens.model;

public class Guerreiro extends Personagem {

    private final double adrenalina = 0.08;
    private final double heroismo = 0.06;

    public Guerreiro(String nome){
        super(nome);
    }


    public double getAdrenalina() {
        return adrenalina;
    }

    public double getHeroismo() {
        return heroismo;
    }

    

    public int calcVida(int dado){
        int vida =  5*getForca() + dado;
        return vida;
    }

    public int calcDano(int dado){
        int dano = 3*getForca() + dado;
        return dano;
    }


    @Override
    public String toString(){
        return super.toString() + "\nAdrenalina: " + adrenalina + "" + "\nHeroísmo: "+  heroismo ;
    }
    
}
