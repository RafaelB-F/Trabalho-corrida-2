import java.util.ArrayList;
import java.util.List;

class Corrida {
    private List<Moto> motos;
    private int numVoltas;

    public Corrida(int numVoltas) {
        this.numVoltas = numVoltas;
        this.motos = new ArrayList<>();
    }

    public void adicionarMoto(Moto moto) {
        motos.add(moto);
    }

    public void iniciarCorrida() {
        System.out.println("=== Corrida de Motos ===");
        System.out.println("Quantidade de voltas: " + numVoltas);
        System.out.println("Motos participantes:");
        for (Moto moto : motos) {
            System.out.println("- " + moto.getNome());
        }
        System.out.println("=== Preparar... ===");
        System.out.println("=== Apontar... ===");
        System.out.println("=== Já! ===");

        for (int volta = 1; volta <= numVoltas; volta++) {
            System.out.println("Volta " + volta);
            for (Moto moto : motos) {
                if (!verificarDistanciaRestante(moto) || verificarVoltasCompletas(moto)) {
                    continue;
                }
                moto.avancar();
                System.out.println(moto.getNome() + " - Distância percorrida: " + moto.getDistanciaPercorrida() + " km");
            }
        }

        System.out.println("=== Fim da corrida ===");
        System.out.println("Resultados:");
        ordenarMotosPorDistancia();
        for (int i = 0; i < motos.size(); i++) {
            Moto moto = motos.get(i);
            String posicao;
            if (i == 0) {
                posicao = "1º lugar";
            } else if (i == 1) {
                posicao = "2º lugar";
            } else if (i == 2) {
                posicao = "3º lugar";
            } else {
                posicao = (i + 1) + "º lugar";
            }
            System.out.println(posicao + ": " + moto.getNome() + " - Distância percorrida: " + moto.getDistanciaPercorrida() + " km");
        }
    }

    private boolean verificarDistanciaRestante(Moto moto) {
        int distanciaRestante = (numVoltas * 20) - (moto.getDistanciaPercorrida() % (numVoltas * 20));
        if (distanciaRestante <= 0) {
            System.out.println(moto.getNome() + " já completou todas as voltas.");
            return false;
        }
        return true;
    }

    private boolean verificarVoltasCompletas(Moto moto) {
        int voltasCompletas = moto.getDistanciaPercorrida() / (numVoltas * 20);
        return voltasCompletas >= numVoltas;
    }

    private void ordenarMotosPorDistancia() {
        motos.sort((moto1, moto2) -> moto2.getDistanciaPercorrida() - moto1.getDistanciaPercorrida());
    }
}