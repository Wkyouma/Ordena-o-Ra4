
import java.util.Random;

public class GnomeSort {
    public long trocas = 0;     
    public long interacoes = 0; 

    public void gnomeSort(int[] Gnome, int tamanho) {
        trocas = 0;               
        interacoes = 0;        
        int i = 0;             

 
        while (i < tamanho - 1) { 
            interacoes++;       
            if (Gnome[i] > Gnome[i + 1]) {
                int temp = Gnome[i];
                Gnome[i] = Gnome[i + 1];
                Gnome[i + 1] = temp;
                trocas++;       
                if (i > 0) {
                    i--;
                }
            } else {
                i++;
            }
        }
    }

    public static void main(String[] args) {
        int[] tamanhos = new int[]{1000, 10000, 100000, 500000, 1000000}; 
        for (int n : tamanhos) {
            System.out.println("Resultados para: " + n);
            Random random = new Random(101);  
            int[] numbers = new int[n];     

            for (int i = 0; i < n; i++) {
                numbers[i] = random.nextInt(n * 10);
            }

            GnomeSort gnomeSort = new GnomeSort();

            long inicioTemp = System.currentTimeMillis();
            gnomeSort.gnomeSort(numbers, n);  
            long finalTemp = System.currentTimeMillis();

            // Exibe os resultados
            System.out.println("Tempo: " + (finalTemp - inicioTemp) + " ms");
            System.out.println("Trocas: " + gnomeSort.trocas);
            System.out.println("Iterações: " + gnomeSort.interacoes);
        }
    }
}
