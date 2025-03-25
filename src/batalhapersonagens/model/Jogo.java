package batalhapersonagens.model;


import java.util.ArrayList;

public interface Jogo {

    public abstract void setAtributos(ArrayList<Personagem>personagens);
    public abstract double atkBonus(Personagem p, double dano);
    public abstract double defBonus(Personagem p, double dano);
    public abstract void atk(Personagem p1, Personagem p2);
    
}
