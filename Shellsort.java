
import java.util.Random;

public class Shellsort {

    int listaf[];
    int trocas;
    int interacoes;

    public void shell(int[] lista, int tamanho) {
        int meio = tamanho / 2;

        while (meio > 0) {
            for (int i = meio; i < tamanho; i++) {
                int temp = lista[i];
                int j = i;
                interacoes++;

                while (j >= meio && lista[j - meio] > temp) {
                    lista[j] = lista[j - meio];
                    j -= meio;
                    trocas++;
                }
                lista[j] = temp;

                if (j != i) {
                    trocas++;
                }
            }
            meio /= 2;
        }

        listaf = lista;
    }

    public void imprimir() {
        for (int n : listaf) {
            System.out.print(n + " , ");
        }
    }

    public static void main(String[] args) {
        int[] tamanhos = new int[]{1000, 10000, 100000, 500000, 1000000};

        for (int n : tamanhos) {
            for(int a = 0; a < 1; a++){
                System.out.println("");
                System.out.println("Resultados para:" + n);
                Random random = new Random(10);
                int[] numbers = new int[n];
                for (int i = 0; i < n; i++) {
                    numbers[i] = random.nextInt(n * 10);
                }
                Shellsort sh = new Shellsort();
                long inicioTemp = System.currentTimeMillis();
                sh.shell(numbers, n);
                long finalTemp = System.currentTimeMillis();
                System.out.println("Tempo: " + (finalTemp - inicioTemp) + " ms");
                System.out.println("Trocas: " + sh.trocas);
                System.out.println("Iterações: " + sh.interacoes);
            }
        }
    }
}
