import java.util.Random;

class Moto {
    private String nome;
    private int distanciaPercorrida;
    private int velocidadeBase;

    public Moto(String nome, int velocidadeBase) {
        this.nome = nome;
        this.velocidadeBase = velocidadeBase;
    }

    public String getNome() {
        return nome;
    }

    public int getDistanciaPercorrida() {
        return distanciaPercorrida;
    }

    public void avancar() {
        Random random = new Random();
        int distancia = random.nextInt(velocidadeBase) + 1;
        distanciaPercorrida += distancia;
    }
}