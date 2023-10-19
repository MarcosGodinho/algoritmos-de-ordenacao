import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GeradorNumerosAleatorios {

    public static List<Integer> gerarNumerosAleatorios(int quantidade) {
        List<Integer> numeros = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < quantidade; i++) {
            numeros.add(random.nextInt(quantidade) + 1);
        }

        Collections.shuffle(numeros);
        return numeros;
    }

    public static List<Integer> gerarNumerosCrescente(int quantidade) {
        List<Integer> numeros = new ArrayList<>();

        for (int i = 0; i < quantidade; i++) {
            numeros.add(i);
        }

        return numeros;
    }

    public static List<Integer> gerarNumerosDescrescente(int quantidade) {
        List<Integer> numeros = new ArrayList<>();

        for (int i = quantidade; i > 0; i--) {
            numeros.add(i);
        }

        return numeros;
    }
    public static List<Integer> lerNumerosDoArquivo(String arquivo) throws IOException {
        List<Integer> numbers = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
            String line;
            while ((line = reader.readLine()) != null) {
                numbers.add(Integer.parseInt(line));
            }
        }
        return numbers;
    }

    public static void escreverNumerosNoArquivo(List<Integer> numbers, String arquivo) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo))) {

            for (Integer number : numbers) {
                writer.write(number.toString());
                writer.newLine();
            }
        }
    }
}
