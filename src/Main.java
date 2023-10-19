import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        int quantidadeNumeros = 100000;
        int quantidadeNumerosMenor = 10000;
        int repeticoes = 1;

        //Tipos de listas de números: "Crescente", "Decrescente" e "Aleatorio"
        //Tipos de Sorts: "Merge", "Quick", "Bubble", "Insertion" e "Selection"

        //1 Cenário - A lista de números deve estar aleatoriamente ordenada.

        //Merge Sort      -   0,07939
        //Quick Sort      -   0,02951
        //Bubble Sort     -   45,50060
        //Insertion Sort  -   6,26747
        //Selection Sort  -   10,33784

        //2 Cenário - A lista de números deve estar ordenada de maneira crescente.

        //Merge Sort      -   0,03476
        //Quick Sort      -   10.000 números : 0,32770    *
        //Bubble Sort     -   0,01016
        //Insertion Sort  -   6,76209
        //Selection Sort  -   6,98311


        //3 Cenário - A lista de números deve estar ordenada de maneira decrescente.

        //Merge Sort      -   10.000 números : 0,00276    *
        //Quick Sort      -   10.000 números : 0,20294    *
        //Bubble Sort     -   10.000 números : 0,23909    *
        //Insertion Sort  -   10.000 números : 0,10421    *
        //Selection Sort  -   10.000 números : 0,05704    *

        //                                                                  * - Não rodou com 100.000 números



// ********************************************************************************//
// ****************************** Merge Sort **************************************//
// ********************************************************************************//

        SortExecutor merge1 = new SortExecutor();
        merge1.execute("Merge", "Aleatorio", quantidadeNumeros, repeticoes);

        SortExecutor merge2 = new SortExecutor();
        merge2.execute("Merge", "Crescente", quantidadeNumeros, repeticoes);

        SortExecutor merge3 = new SortExecutor();
        merge3.execute("Merge", "Decrescente", quantidadeNumerosMenor, repeticoes);

// ********************************************************************************//
// ****************************** Quick Sort **************************************//
// ********************************************************************************//

        SortExecutor quick1 = new SortExecutor();
        quick1.execute("Quick", "Aleatorio", quantidadeNumeros, repeticoes);

        SortExecutor quick2 = new SortExecutor();
        quick2.execute("Quick", "Crescente", quantidadeNumerosMenor, repeticoes);

        SortExecutor quick3 = new SortExecutor();
        quick3.execute("Quick", "Decrescente", quantidadeNumerosMenor, repeticoes);

// ********************************************************************************//
// ****************************** Bubble Sort *************************************//
// ********************************************************************************//

        SortExecutor bubble1 = new SortExecutor();
        bubble1.execute("Bubble", "Aleatorio", quantidadeNumeros, repeticoes);

        SortExecutor bubble2 = new SortExecutor();
        bubble2.execute("Bubble", "Crescente", quantidadeNumeros, repeticoes);

        SortExecutor bubble3 = new SortExecutor();
        bubble3.execute("Bubble", "Decrescente", quantidadeNumerosMenor, repeticoes);

// ********************************************************************************//
// ****************************** Insertion Sort **********************************//
// ********************************************************************************//

        SortExecutor insertion1 = new SortExecutor();
        insertion1.execute("Insertion", "Aleatorio", quantidadeNumeros, repeticoes);

        SortExecutor insertion2 = new SortExecutor();
        insertion2.execute("Insertion", "Crescente", quantidadeNumeros, repeticoes);

        SortExecutor insertion3 = new SortExecutor();
        insertion3.execute("Insertion", "Decrescente", quantidadeNumerosMenor, repeticoes);

// ********************************************************************************//
// ****************************** Selection Sort **********************************//
// ********************************************************************************//

        SortExecutor selection1 = new SortExecutor();
        selection1.execute("Selection", "Aleatorio", quantidadeNumeros, repeticoes);

        SortExecutor selection2 = new SortExecutor();
        selection2.execute("Selection", "Crescente", quantidadeNumeros, repeticoes);

        SortExecutor selection3 = new SortExecutor();
        selection3.execute("Selection", "Decrescente", quantidadeNumerosMenor, repeticoes);

    }
}