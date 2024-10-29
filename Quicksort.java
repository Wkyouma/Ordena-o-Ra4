import java.util.Random;

public class Quicksort {

    int pivo;
    int esquerda = 0;
    int direita = 0;
    int listaf[];
    int trocas = 0;
    int interacoes = 0;

    public void quicksort(int[] lista, int inicio, int tamanho) {
        pivo = lista[inicio];
        esquerda = inicio;
        direita = tamanho;

        while (esquerda <= direita) {
            interacoes++;

            while (lista[esquerda] < pivo) {
                esquerda++;
                interacoes++;
            }
            while (lista[direita] > pivo) {
                direita--;
                interacoes++;
            }

            if (esquerda <= direita) {
                int temp = lista[esquerda];
                lista[esquerda] = lista[direita];
                lista[direita] = temp;
                trocas++;
                esquerda++;
                direita--;
            }
        }

        if (inicio < direita) {
            quicksort(lista, inicio, direita);
        }
        if (esquerda < tamanho) {
            quicksort(lista, esquerda, tamanho);
        } else {
            listaf = lista;
        }
    }

    public void imprime() {
        for (int num : listaf) {
            System.out.println(num + " , ");
        }
    }

    public static void main(String[] args) {
        int[] tamanhos = new int[]{1000, 10000, 100000, 500000, 1000000};

        for (int n : tamanhos) {
            System.out.println("Resultados para:"+ n);
            Random random = new Random(10);
            int[] numbers = new int[n];
            for (int i = 0; i < n; i++) {
                numbers[i] = random.nextInt(n * 10);
            }
            Quicksort qs = new Quicksort();
            long inicioTemp = System.currentTimeMillis();
            qs.quicksort(numbers, 0, n - 1);
            long finalTemp = System.currentTimeMillis();
            System.out.println("Tempo: " + (finalTemp - inicioTemp) + " ms");
            System.out.println("Trocas: " + qs.trocas);
            System.out.println("Iterações: " + qs.interacoes);
        }
    }
}
