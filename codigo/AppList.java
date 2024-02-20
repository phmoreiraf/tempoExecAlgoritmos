import java.util.ArrayList;



import java.util.ArrayList;
import java.util.Random;

/**
 * MIT License
 *
 * Copyright(c) 2022 João Caram <caram@pucminas.br>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */


import javax.management.InvalidAttributeValueException;

/**
  * Classe Pessoa apenas para uso no exercício de marcação de tempo de execução. Contém id numérico e nome
  */
public class Pessoa {

        /**
         * Atributo de identificação da pessoa (número positivo). Duas pessoas com o mesmo identificador são consideradas a mesma.
         */
        private int id;

        /**
         * Atributo de nome da pessoa (o nome deve ter pelo menos 2 caracteres)
         */
        private String nome;

        /**
         * Construtor: recebe nome e id. Pode lançar exceção em casos de id inválido (não positivo) ou nome incompleto (menos de 2 caracteres)
         * @param id ID para a pessoa. Deve ser um número positivo (>0)
         * @param nome Nome para a pessoa. Precisa possuir ao menos 2 caracteres.
         * @throws InvalidAttributeValueException Será lançada exceção de atibuto inválido se o identificador ou o nome não obedecerem às regras descritas acima.
         */
        public Pessoa(int id, String nome) throws InvalidAttributeValueException{
            if(id<=0 || nome.length()<2)
                throw new InvalidAttributeValueException("Atributos inválidos para a pessoa");
            this.id = id;
            this.nome = nome;
        }

        /**
         * Igualdade de pessoas: duas pessoas são iguais se têm o mesmo id. A tentativa de comparar objetos de outras classes gera resposta falsa
         * @param o Objeto (Pessoa) a ser comparado com este
         * @return TRUE caso o id das pessoas seja igual, FALSE caso contrário ou em tentativa de comparação com objetos de outras classes.
         */
        @Override
        public boolean equals(Object o){
            try{
                Pessoa outra = (Pessoa)o;
                return this.id == outra.id;
            }catch (ClassCastException cex){
                return false;
            }
        }

        /**
         * Representação em string: "NNNN - id XXX" , sendo NNNN o nome da pessoa e XXX seu id
         * @return Uma string com a especificação acima.
         */
        public String toString(){
            return this.nome + " - id "+this.id;
        }

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

}

public class AppList {
    public static void main(String[] args) throws Exception {

        GerenciadorPessoas gerenciador = new GerenciadorPessoas();

        final double NANO_TO_MS = 1_000_000d; // para converter de nano a milissegundos
        final double MS_TO_SEC = 1_000d;

        long ini = System.nanoTime();

        gerenciador.inserirPessoas(2500000);
        ArrayList<Pessoa> pessoasEncontradas = gerenciador.buscarPessoas(40000);
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

/// YAROSLAVSKIY, V. Dual-pivot quicksort. Research Disclosure, 2009.
// Disponível em
// https://pt.wikipedia.org/wiki/Quicksort#Quicksort_utilizando_dois_ou_mais_pivôs
// https://en.wikipedia.org/wiki/Quicksort#Variants
// http://www.kriche.com.ar/root/programming/spaceTimeComplexity/DualPivotQuicksort.pdf
