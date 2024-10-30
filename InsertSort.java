
import java.util.Random;

//classe principal
public class InsertSort {
    //define variáveis auxiliares
    public long trocas = 0;
    public long interacoes = 0;

    //função principal
    public void insertSort(int[] array, int tamanho) {
       //zera os auxiliares para loop
        trocas = 0;
        interacoes = 0;

        //loop principal
        for (int i = 1; i < tamanho; i++) {
            interacoes++;  // conta mais uma interação
            int temp = array[i]; // armazena valor atual
            int a = i; //armazena indice atual

            //enquanto anterior>atual desloca elemento
            while (a > 0 && array[a - 1] > temp) {
                interacoes++; //conta mais uma interação
                array[a] = array[a - 1]; // desloca valor para trás
                a--; // desloca indice para trás
                trocas++; // conta mais uma troca
            }
            array[a] = temp;  // armazena o valor atribuido em temp                                                        
        }
    }

    //função para imprimir lista
    public void exibir(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    //função main
    public static void main(String[] args) {
        //vetor com quantidade de elementos para execução única
        int[] tamanhos = new int[]{1000, 10000, 100000, 500000, 1000000};
        //laço de repetição para execução unica
        for (int n : tamanhos) {
            //imprime quantidade de valores para execução atual
            System.out.println("Resultados para: " + n);
            //Gera conjunto de numeros aleatórios 
            Random ranndom = new Random(101);  
            int[] numbers = new int[n];
            for (int i = 0; i < n; i++) {
                numbers[i] = ranndom.nextInt( 10);
            }

            //inicia classe insertSort
            InsertSort insertSort = new InsertSort();
            //contagem de tempo inicial
            long inicioTemp = System.currentTimeMillis();
            //realiza organização da lista aleatória
            insertSort.insertSort(numbers, 10);
            //contagem de tempo final
            long finalTemp = System.currentTimeMillis();

            //impreções: tempo de execução, quantidade de trocas, numero de interações
            System.out.println("Tempo: " + (finalTemp - inicioTemp) + " ms");
            System.out.println("Trocas: " + insertSort.trocas);
            System.out.println("Interações: " + insertSort.interacoes);
            System.out.println();
        }
    }
}
