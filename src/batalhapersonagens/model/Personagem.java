package batalhapersonagens.model;

public abstract class Personagem {

    private String nome;
    private int forca;
    private int agilidade;
    private int intel;
    private int vida;
    
    public Personagem(String nome){
        this.nome = nome;
    }



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getForca() {
        return forca;
    }

    public void setForca(int forca) {
        this.forca = forca;
    }

    public int getAgilidade() {
        return agilidade;
    }

    public void setAgilidade(int agilidade) {
        this.agilidade = agilidade;
    }

    public int getIntel() {
        return intel;
    }

    public void setIntel(int intel) {
        this.intel = intel;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public abstract int calcVida(int dado);
    
    public abstract int calcDano(int dado);
    
    @Override
    public String toString(){
        return "Nome: " + nome + "\nVida: " + vida + "\nForça: " + forca + "\nAgilidade: " +  agilidade + "\nInteligência: " + intel;
    }
}


