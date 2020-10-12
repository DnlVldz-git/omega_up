import java.util.Scanner;
import java.util.*;

public class B {

    public static void main(String[] args){

        Scanner leer = new Scanner(System.in); //se crea el scanner con nombre leer
        int numero_galletas, gallleta, dulzura, conteo = 0; //se crean las variables de numero de galleta, galleta, dulzura y conteo
        Queue<Integer> lista_galletas = new PriorityQueue<>();  //se crea una cola de enteros, llama lista_galletas

        numero_galletas = leer.nextInt(); //se lee el número de galletas
        dulzura = leer.nextInt(); //se lee la dulzura a la que se desea llegar

        for(int i = 0; i < numero_galletas; i++){ //se hace un for con el nùmero de galletas
            galleta = leer.nextInt(); //se lee la dulzura de cada galleta
            lista_galletas.add(galleta);  //se agrega la dulzura a la cola
        }

        int dulzura_minima = lista_galletas.peek(); //se hace un peek al primer elemento de la cola y se guarda en dulzura_minima

        while(dulzura_minima < dulzura && lista_galletas.size() > 1){ //mientras que la dulzura_minima sea menor a dulzura y el tamaño de la lista_galletas sea mayor a uno harà un ciclo
            int nueva_dulzura = lista_galletas.poll() + (2 * lista_galletas.poll());// se crea la nuva dulzura, obteniendo el primer elemento de la lista, luego sumarlo con el segundo multiplicado por dos
            conteo++; //se incrementa el conteo
            lista_galletas.add(nueva_dulzura);  // se agrega la nueva dulzura a la lista
            dulzura_minima = lista_galletas.peek(); // ahora, dulzura mìnima será el primer elemento de la lista
        }

        if(dulzura <= dulzura_minima){  //si la dulzura es menor o igual a la dulzura mìnima, entonces imprimimos el nùmero de pasos
            System.out.println(conteo);
        }else{  //en otro caso va a imprimir menos 1
            System.out.println(-1);
        }
    }
}
