package batalhapersonagens.model;

import java.util.ArrayList;
import java.util.Random;

public class JogoBatalha implements Jogo {

    Random random = new Random();


    public void setAtributos(ArrayList<Personagem> personagens){
        for (Personagem personagem : personagens) {
            if (personagem instanceof Guerreiro ){
                personagem.setForca(random.nextInt(101));
                personagem.setAgilidade(random.nextInt(51));
                personagem.setIntel(random.nextInt(51));
            }else if (personagem instanceof Arqueiro){
                personagem.setForca(random.nextInt(51));
                personagem.setAgilidade(random.nextInt(101));
                personagem.setIntel(random.nextInt(51));
            }else if (personagem instanceof Mago){
                personagem.setForca(random.nextInt(51));
                personagem.setAgilidade(random.nextInt(51));
                personagem.setIntel(random.nextInt(101));
            }
        }
    }

    public double atkBonus(Personagem p, double dano){
        if (p instanceof Guerreiro){
            Guerreiro g = (Guerreiro) p;
            if (random.nextInt(101) <= g.getAdrenalina()){
                return 0.4;
            }else {
                return 0;
            }
        }else if (p instanceof Arqueiro){
            Arqueiro a = (Arqueiro) p;
            if (random.nextInt(101) <= a.getTiroCerto()){
                return 0.25;
            }else {
                return 0;
            }
        }else if (p instanceof Mago){
            Mago m = (Mago) p;
            if(random.nextInt(101) <= m.getBuff()){
                return 0.55;
            }else{
                return 0;
            }
        }else {
            return 0;
        }
    }

    public double defBonus(Personagem p, double dano){
        if (p instanceof Guerreiro){
            Guerreiro g = (Guerreiro) p;
            if (random.nextInt(101)<= g.getHeroismo()){
                return dano/2;
            }else {
                return  0;
            }
        }else if (p instanceof Arqueiro){
            Arqueiro a = (Arqueiro) p;
            if(random.nextInt(101)<= a.getCamuflagem()){
                return dano;
            }else {
                return 0;
            }
        }else if (p instanceof Mago){
            Mago m = (Mago) p;
            if(random.nextInt()<= m.getCura()){
                m.setVida(p.getVida()+(int)dano);
                return 0;
            }else{
                return 0;
            }
        }
        else {
            return 0;
        }
}

    public void atk(Personagem p1, Personagem p2){
        int dado = random.nextInt(21);
        p1.calcVida(dado);
        p2.calcVida(dado);

        int danoFlat = p1.calcDano(dado);
        double bonus = atkBonus(p1, danoFlat);
        int dano = danoFlat + (int)bonus;
        double escudo = defBonus(p2, dano);
        int danoTotal = dano - (int)escudo;
        if (danoTotal > 0){
            p2.setVida(p2.getVida() - danoTotal);
        }
    }




}
