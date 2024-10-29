
import java.util.Random;

public class InsertSort {
    public long trocas = 0;
    public long interacoes = 0;

    public void insertSort(int[] array, int tamanho) {
        trocas = 0;
        interacoes = 0;

        for (int i = 1; i < tamanho; i++) {
            interacoes++;  
            int temp = array[i];
            int a = i;

            while (a > 0 && array[a - 1] > temp) {
                interacoes++; 
                array[a] = array[a - 1];//troca
                a--;//decresimo para verificar o valor interior
                trocas++;
            }
            array[a] = temp;// Insere o valor original na posição correta                                                                   
        }
    }

    public void exibir(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] tamanhos = new int[]{1000, 10000, 100000, 500000, 1000000};
        for (int n : tamanhos) {
            System.out.println("Resultados para: " + n);
            Random ranndom = new Random(101);  
            int[] numbers = new int[n];
            for (int i = 0; i < n; i++) {
                numbers[i] = ranndom.nextInt( 10);
            }

            InsertSort insertSort = new InsertSort();
            long inicioTemp = System.currentTimeMillis();
            insertSort.insertSort(numbers, 10);
            long finalTemp = System.currentTimeMillis();

            System.out.println("Tempo: " + (finalTemp - inicioTemp) + " ms");
            System.out.println("Trocas: " + insertSort.trocas);
            System.out.println("Interações: " + insertSort.interacoes);
            System.out.println();
        }
    }
}
