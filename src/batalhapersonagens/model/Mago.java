package batalhapersonagens.model;

public class Mago extends Personagem{
    
    public final double cura = 0.05;
    public final double buff = 0.1;

    public Mago(String nome){
        super(nome);
    }

    public double getCura() {
        return cura;
    }

    public double getBuff() {
        return buff;
    }


    
    public int calcVida(int dado){
        int vida =  7*getIntel() + dado;
        return vida;
    }

    public int calcDano(int dado){
        int dano = 2*getIntel() + dado;
        return dano;
    }


    @Override
    public String toString(){
        return super.toString() + "\nCura: " + cura + "" + "\nBuff: "+  buff ;
    }
    
}
