package src.main.java.execucaoalgoritmos;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.management.InvalidAttributeValueException;

public class AppHash {
    public static void main(String[] args) throws InvalidAttributeValueException {

        final double NANO_TO_MS = 1_000_000d; // para converter de nano a milissegundos
        final double MS_TO_SEC = 1_000d;

        Map<Integer, Pessoa> mapaPessoas = new HashMap<>();

        long ini = System.nanoTime();
        // Inserindo P pessoas com id crescente no HashMap
        final int P = 10000000;
        for (int i = 1; i <= P; i++) {
            mapaPessoas.put(i, new Pessoa(i, "Pessoa " + i));
        }

        // Realizando N buscas por pessoas com ids aleatórios no HashMap
        final int N = 20000;
        Random rand = new Random();
        for (int i = 0; i < N; i++) {
            int idAleatorio = rand.nextInt(P) + 1; // Gerando um id aleatório entre 1 e P
            Pessoa pessoaEncontrada = mapaPessoas.get(idAleatorio);
            if (pessoaEncontrada != null) {
                System.out.println("Pessoa encontrada: " + pessoaEncontrada);
            } else {
                System.out.println("Pessoa com ID " + idAleatorio + " não encontrada.");
            }
        }

        long fim = System.nanoTime();

        double tempoMs = (fim - ini) / NANO_TO_MS; // conversões e, em seguida, impressão do resultado
        double tempoSeg = tempoMs / MS_TO_SEC;

        System.out.println("Finalizado em " + String.format("%.2f", tempoMs) + " ms ("
                + String.format("%.4f", tempoSeg) + " segundos).");
    }
}
