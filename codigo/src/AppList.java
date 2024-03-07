
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import javax.management.InvalidAttributeValueException;

public class AppList {

 public static class GerenciadorPessoas {
        private ArrayList<Pessoa> pessoas;

        public GerenciadorPessoas() {
            pessoas = new ArrayList<>();
        }

        public void inserirPessoas(int quantidade) throws InvalidAttributeValueException {
            for (int i = 1; i <= quantidade; i++) {
                pessoas.add(new Pessoa(i, "Pessoa " + i));
            }
        }

        public ArrayList<Pessoa> buscarPessoas(int quantidade) {
            ArrayList<Pessoa> resultado = new ArrayList<>();
            Random rand = new Random();
            for (int i = 0; i < quantidade; i++) {
                int index = rand.nextInt(pessoas.size());
                resultado.add(pessoas.get(index));
            }
            return resultado;
        }

        public void imprimirPessoas() {
            for (Pessoa pessoa : pessoas) {
                System.out.println(pessoa);
            }
        }
    }
    public static void main(String[] args) throws Exception {

        GerenciadorPessoas gerenciador = new GerenciadorPessoas();

        final double NANO_TO_MS = 1_000_000d; // para converter de nano a milissegundos
        final double MS_TO_SEC = 1_000d;

        long ini = System.nanoTime();

        gerenciador.inserirPessoas(2500000); // Mudar de acordo com o teste que queira realizar
        ArrayList<Pessoa> pessoasEncontradas = gerenciador.buscarPessoas(40000); // Mudar de acordo com o teste que queira realizar
        System.out.println("Pessoas encontradas:");
        for (Pessoa pessoa : pessoasEncontradas) {
            System.out.println(pessoa);
        }

        long fim = System.nanoTime();

        double tempoMs = (fim - ini) / NANO_TO_MS; // conversões e, em seguida, impressão do resultado
        double tempoSeg = tempoMs / MS_TO_SEC;

        System.out.println("Finalizado em " + String.format("%.2f", tempoMs) + " ms ("
                + String.format("%.4f", tempoSeg) + " segundos).");
    }
}
