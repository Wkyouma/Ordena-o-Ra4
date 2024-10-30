
import java.util.Random;

public class Shellsort {

    //declaração de auxiliares
    int listaf[];
    int trocas;
    int interacoes;

    //função principal
    public void shell(int[] lista, int tamanho) {
        //encontra o meio da lista 
        int meio = tamanho / 2;

        //loop principal
        while (meio > 0) {
            for (int i = meio; i < tamanho; i++) {
                int temp = lista[i]; // encontra o elemento a ser inserido
                int j = i; // encontra o indice do elemento a ser inserido
                interacoes++; //conta mais uma interação

                //compara elementos distantes
                while (j >= meio && lista[j - meio] > temp) {
                    lista[j] = lista[j - meio]; // Move o maior elemento para frente
                    j -= meio; // Avança para a próxima posição à esquerda
                    trocas++; //conta mais uma troca
                }
                lista[j] = temp; // Insere o elemento na posição correta

                if (j != i) {
                    trocas++;// se a posição mudou conta mais uma troca
                }
            }
            meio /= 2;// reduz o auxiliar meio pela metade
        }

        listaf = lista;// coloca lista em lista final ao encerrar o processo
    }

    //imprime a lista final
    public void imprimir() {
        for (int n : listaf) {
            System.out.print(n + " , ");
        }
    }
    //função de execução
    public static void main(String[] args) {
        //gera numeros aleatórios baseados em uma seed e os aloca em uma lista
        Random random = new Random(10);
        int[] numbers = new int[100000];
        for (int i = 0; i < 100000; i++) {
            numbers[i] = random.nextInt();
        }
        //inicia a classe Shellsort
        Shellsort sh = new Shellsort();
        //marcador de tempo inicial
        long inicioTemp = System.currentTimeMillis();
        //executa o shell sort
        sh.shell(numbers, 99999);
        //contador de tempo final
        long finalTemp = System.currentTimeMillis();
        //impressões: tempo decorrido, numero de trocas, numero de interações
        System.out.println("Tempo: " + (finalTemp - inicioTemp) + " ms");
        System.out.println("Trocas: " + sh.trocas);
        System.out.println("Iterações: " + sh.interacoes);
            
        
    }
}
