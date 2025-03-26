package batalhapersonagens.model;

import java.nio.channels.Pipe.SourceChannel;
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
        int dado;
        int danoFlat;
        double bonus; 
        int danoTotal;
        double escudo;
        int danoCausado;
        int rodada = 0;
        while(true){
            rodada +=1;
            System.out.println("--ROUND " + rodada + "--");
            if(p1.getVida() > 0){
                //p1 Calcula os danos
                dado = random.nextInt(21);
                danoFlat = p1.calcDano(dado);
                bonus = atkBonus(p1, danoFlat);
                danoTotal = danoFlat + (int)bonus;
                escudo = defBonus(p2, danoTotal);
                danoCausado = danoTotal - (int)escudo;
                //p1 Ataca
                if (danoCausado > 0){
                    System.out.println(p1.getNome() + " Dano causado: " + danoCausado);
                    p2.setVida(p2.getVida() - danoCausado);
                }else{
                    System.out.println("Ataque bloqueado! :/\n");
                }
            }else{
                System.out.println(p2.getNome().toUpperCase() + " GANHOU!!\n");
                return;
            }
            if(p2.getVida() > 0){
                //p2 Calcula os danos
                dado = random.nextInt(21);
                danoFlat = p2.calcDano(dado);
                bonus = atkBonus(p2, danoFlat);
                danoTotal = danoFlat + (int)bonus;
                escudo = defBonus(p1, danoTotal);
                danoCausado = danoTotal - (int)escudo;
                //p2 Ataca
                if(danoCausado > 0){
                    System.out.println(p2.getNome() +  " Dano causado: " + danoCausado);
                    p1.setVida(p1.getVida() - danoCausado);
                }else{
                    System.out.println("Ataque bloqueado! :/\n");
                }
            }else{
                System.out.println(p1.getNome().toUpperCase() + " GANHOU!!\n");
                return;
            }
        }
    }




}
