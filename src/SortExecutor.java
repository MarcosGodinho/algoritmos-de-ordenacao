import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class SortExecutor {
    private final List<Double> tempos = new ArrayList<>();

    public void execute(String tipoSort, String tipoOrdenacao, int quantidadeNumeros, int repeticoes) throws IOException {
        for (int j = 1; j <= repeticoes; j++) {

            List<Integer> numeros = switch (tipoOrdenacao) {
                case "Crescente" -> GeradorNumerosAleatorios.gerarNumerosCrescente(quantidadeNumeros);
                case "Decrescente" -> GeradorNumerosAleatorios.gerarNumerosDescrescente(quantidadeNumeros);
                case "Aleatorio" -> GeradorNumerosAleatorios.gerarNumerosAleatorios(quantidadeNumeros);
                default -> throw new IllegalStateException("Unexpected value: " + tipoOrdenacao);
            };

            GeradorNumerosAleatorios.escreverNumerosNoArquivo(numeros, "src\\" + "ArquivosOrdenacoes\\numeros" + tipoOrdenacao + ".txt");
            String inputFile = "src\\" + "ArquivosOrdenacoes\\numeros" + tipoOrdenacao + ".txt";
            String outputFile = "src\\" + "ArquivosOrdenacoes\\" + tipoSort + "SortArquivos\\" + tipoSort + tipoOrdenacao + j + ".txt";

            try {
                long startTime = System.nanoTime();

                List<Integer> numbers = GeradorNumerosAleatorios.lerNumerosDoArquivo(inputFile);

                switch (tipoSort.toUpperCase()) {
                    case "MERGE":
                        sorts.mergeSort(numbers, 0, numbers.size() - 1);
                        break;
                    case "QUICK":
                        sorts.QuickSort.quickSort(numbers, 0, numbers.size() - 1);
                        break;
                    case "BUBBLE":
                        sorts.BubbleSort.bubbleSort(numbers);
                        break;
                    case "INSERTION":
                        sorts.InsertionSort.insertionSort(numbers);
                        break;
                    case "SELECTION":
                        sorts.SelectionSort.selectionSort(numbers);
                        break;
                }

                //GeradorNumerosAleatorios.escreverNumerosNoArquivo(numbers, outputFile);

                long endTime = System.nanoTime();
                long executionTime = endTime - startTime;
                double executionTimeInSeconds = (double) executionTime / 1_000_000_000.0; // Converter para segundos
                tempos.add(executionTimeInSeconds);

                //System.out.println("Execução " + j + " : " + executionTimeInSeconds);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Calcula ordenacao média dos tempos de execução
        double somaDosTempos = 0;
        for (Double tempo : tempos) {
            somaDosTempos += tempo;
        }
        double mediaDosTempos = somaDosTempos / repeticoes;

        String mediaFormatada = String.format("%.5f", mediaDosTempos);

        System.out.println(tipoSort + " : " + tipoOrdenacao + " : " + mediaFormatada);
    }
}
