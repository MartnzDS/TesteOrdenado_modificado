package ordena;

import java.util.Random;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Utilidades {

    private static Random random = new Random();

    //cria um vetor do tamanho informado e preenche os vetores com valores aleatórios
    public static Item[] gerarVetor(int tamanho) {

        Item[] vetor = new Item[tamanho];

        for (int i = 0; i < tamanho; i++) {
            vetor[i] = new Item(random.nextInt(100000));
        }

        return vetor;
    }

    //cria uma cópia do vetor original e garante que todos os algoritmos ordenem exatamente os mesmos dados
    public static Item[] copiarVetor(Item[] original) {

        Item[] copia = new Item[original.length];

        for (int i = 0; i < original.length; i++) {
            copia[i] = new Item(original[i].getValor());
        }

        return copia;
    }

    //mostra os elementos na tela
    public static void imprimirVetor(Item[] vetor) {

        for (Item item : vetor) {
            System.out.print(item.getValor() + " ");
        }

        System.out.println();
    }

    //cria um arquivo txt, salva todas as médias
    public static void salvarResultados(String nomeArquivo, int[] tamanhos,
                                        double[] mediaBubble,
                                        double[] mediaInsertion,
                                        double[] mediaShell) {

        String timestamp = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        String nomeComTimestamp = nomeArquivo.replace(".txt", "_" + timestamp + ".txt");

        try (PrintWriter pw = new PrintWriter(new FileWriter(nomeComTimestamp))) {

            pw.println("RESULTADOS DE ORDENACAO");
            pw.println("Media de 100 execucoes por algoritmo (em milissegundos)");
            pw.println("--------------------------------------------------------------------------------");
            pw.printf("%-10s %-20s %-20s %-20s%n",
                    "Tamanho", "Bubble(ms)", "Insertion(ms)", "Shell(ms)");
            pw.println("--------------------------------------------------------------------------------");

            for (int i = 0; i < tamanhos.length; i++) {
                pw.printf("%-10d %-20.6f %-20.6f %-20.6f%n",
                        tamanhos[i],
                        mediaBubble[i],
                        mediaInsertion[i],
                        mediaShell[i]);
            }

            pw.println("--------------------------------------------------------------------------------");
            System.out.println("Resultados salvos em: " + nomeComTimestamp);

        } catch (IOException e) {
            System.err.println("Erro ao salvar arquivo: " + e.getMessage());
        }
    }
}
