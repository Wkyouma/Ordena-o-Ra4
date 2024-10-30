package Ra4;

import java.util.Random;

public class GnomeSort {
    public long trocas = 0;       // Contador de trocas realizadas durante a ordenação
    public long interacoes = 0;   // Contador de interações do algoritmo

    public void gnomeSort(int[] Gnome, int tamanho) {
        trocas = 0;               // Reseta o número de trocas
        interacoes = 0;           // Reseta o número de interações
        int i = 0;                // Índice inicial para o algoritmo

        // Enquanto o índice estiver dentro do array, continua a ordenar
        while (i < tamanho - 1) { 
            interacoes++;          // Conta cada interação

            // Verifica se o elemento atual é maior que o próximo
            if (Gnome[i] > Gnome[i + 1]) {
                // Se sim, troca os elementos de lugar
                int temp = Gnome[i];
                Gnome[i] = Gnome[i + 1];
                Gnome[i + 1] = temp;
                trocas++;          // Conta cada troca realizada

                // Se não estamos no início do array, movemos o índice uma posição para trás
                if (i > 0) {
                    i--;
                }
            } else {
                // Se os elementos estão na ordem correta, avança o índice
                i++;
            }
        }
    }
    public static void main(String[] args) {
        int[] tamanhos = new int[]{1000, 10000, 100000, 500000, 1000000}; // Tamanhos do array a serem ordenados

        for (int n : tamanhos) {
            System.out.println("Resultados para: " + n);
            Random random = new Random(101);  // Gerador de números aleatórios com uma seed fixa
            int[] numbers = new int[n];       // Array para armazenar os números aleatórios

            // Preenche o array com números aleatórios
            for (int i = 0; i < n; i++) {
                numbers[i] = random.nextInt(n * 10);
            }

            GnomeSort gnomeSort = new GnomeSort(); // Cria uma instância do GnomeSort

            // Inicia a contagem do tempo de execução
            long inicioTemp = System.currentTimeMillis();
            gnomeSort.gnomeSort(numbers, n);  // Ordena o array usando GnomeSort
            long finalTemp = System.currentTimeMillis(); // Finaliza a contagem do tempo de execução

            // Exibe os resultados
            System.out.println("Tempo: " + (finalTemp - inicioTemp) + " ms");
            System.out.println("Trocas: " + gnomeSort.trocas);
            System.out.println("Iterações: " + gnomeSort.interacoes);
        }
    }
}
