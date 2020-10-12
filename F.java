
import java.util.Scanner;

public class F {

    public static void main(String[] args){
        Scanner leer = new Scanner(System.in);
        int  num = leer.nextInt();	//se lee el numero para realizar recursión
        if(num<=1||num>=160) return;	//se comprueba que esté dentro de los límites
            int  fact = fact(num);	//se llama a la función factorial
            System.out.println(fact);	//se imprime la función factorial
    }
    static int fact(int n){
        if(n<50){	//si el número es menor a 50, retornará 2
            return 2;
        }
        return fact(n-1)+(fact(n-5)*2);	//se hará la operación de funcion de n-1 + funcion de n-5 por 5
    }
}
