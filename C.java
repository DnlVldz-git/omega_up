import java.util.Scanner;
import java.util.Stack;

public class C {

	public static void main(String[] args) {
		Scanner leer = new Scanner(System.in);
		int num_1 = leer.nextInt();
		int num_2 = leer.nextInt();
		int num_3 = leer.nextInt();
		int array_1[] = new int[num_1];	//se inicizaliza el array 1 al tamaño del numero 1 dado
		for (int i = 0; i < num_1; i++) {	//se hace un for de num_1 para llenar el arreglo 1
			array_1[i] = leer.nextInt();
		}
		int array_2[] = new int[num_2];//se inicizaliza el array 2 al tamaño del numero 2 dado
		for (int i = 0; i < num_2; i++) {//se hace un for de num_2 para llenar el arreglo 2
			array_2[i] = leer.nextInt();
		}
		int array_3[] = new int[num_3];//se inicizaliza el array 3 al tamaño del numero 3 dado
		for (int i = 0; i < num_3; i++) {//se hace un for de num_3 para llenar el arreglo 3
			array_3[i] = leer.nextInt();
		}
		System.out.println(igualar_pilas(array_1, array_2, array_3)); //se imprime los arreglos iguales, llamando a la función igualar_pilas
		leer.close();
	}

	static int igualar_pilas(int[] array_1, int[] array_2, int[] array_3) {

		Stack<Integer> pila_1 = new Stack<Integer>();	//se crean 3 pilas
		Stack<Integer> pila_2 = new Stack<Integer>();
		Stack<Integer> pila_3 = new Stack<Integer>();

		int altura_total1 = 0, altura_total2 = 0, altura_total3 = 0; //se inicializan las alturas totales a 0

		//la manera de funcionar de este algoritmo, es que suma la altura total por niveles, haciendo más fácil identificar cual
		//es el que se debe remover para hacer que sean iguales
		for (int i = array_1.length - 1; i >= 0; i--) {
			altura_total1 += array_1[i];
			pila_1.push(altura_total1);
		}
		for (int i = array_2.length - 1; i >= 0; i--) {
			altura_total2 += array_2[i];
			pila_2.push(altura_total2);
		}
		for (int i = array_3.length - 1; i >= 0; i--) {
			altura_total3 += array_3[i];
			pila_3.push(altura_total3);
		}

		while (true) {	//se hará un ciclo indefinido, hasta que encuentre la forma de hacer las pilas iguales

			if (pila_1.isEmpty() || pila_2.isEmpty() || pila_3.isEmpty())	//si alguna de las pilas de termina, retornará 0
				return 0;

			altura_total1 = pila_1.peek();	//se hará un peak de las pilas y se asignará a las diferentes alturas
			altura_total2 = pila_2.peek();
			altura_total3 = pila_3.peek();

			if (altura_total1 == altura_total2 && altura_total2 == altura_total3)	//si las alturas son iguales, entonces ya retornará la altura total
				return altura_total1;


			if (altura_total1 >= altura_total2 && altura_total1 >= altura_total3)	//si la altura total 1 es mayor o igual que la altura_total2, y la altura_total1 es mayor o igual a la altura_total3
				pila_1.pop(); 	//harà un pop a la pila 1
			else if (altura_total2 >= altura_total1 && altura_total2 >= altura_total3)	//si la altura total 2 es mayor o igual que la altura_total1, y la altura_total2 es mayor o igual a la altura_total3
				pila_2.pop();	//hará un pop a la pila 2
			else if (altura_total3 >= altura_total2 && altura_total3 >= altura_total1)	//si la altura total 3 es mayor o igual que la altura_total2, y la altura_total3 es mayor o igual a la altura_total1
				pila_3.pop();	//hará un pop a la pila 3
		}

	}
}
