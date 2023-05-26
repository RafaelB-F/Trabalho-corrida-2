import java.util.Scanner;

public class JogoCorridaMotos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo ao jogo de corrida de motos!");

        System.out.print("Digite a quantidade de voltas desejada: ");
        int numVoltas = scanner.nextInt();

        Corrida corrida = new Corrida(numVoltas);

        System.out.print("Digite o número de participantes: ");
        int numParticipantes = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha

        for (int i = 1; i <= numParticipantes; i++) {
            System.out.print("Digite o nome do participante " + i + ": ");
            String nome = scanner.nextLine();

            System.out.print("Digite a velocidade base (entre 1 e 100) para a moto " + nome + ": ");
            int velocidadeBase = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            Moto moto = new Moto(nome, velocidadeBase);
            corrida.adicionarMoto(moto);
        }

        System.out.println("Iniciando a corrida...");
        corrida.iniciarCorrida();
    }
}