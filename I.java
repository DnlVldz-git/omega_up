import java.util.Scanner;

public class I {
    public static void main(String[] args){
        Scanner leer = new Scanner(System.in);
        int eventos = leer.nextInt();
        int[] gas = new int[eventos];
        int[] distancia = new int[eventos];

        for(int i = 0; i<eventos;i++){
            gas[i]=leer.nextInt();
            distancia[i]=leer.nextInt();
        }

        System.out.println(circuito(gas, distancia));

    }

    static int circuito(int[] gas, int[] distancia){

        int suma_dist_rest = 0;
	      int total = 0;
	      int inicio = 0;

	      for (int i = 0; i < gas.length; i++) {
		        int distancia_rest = gas[i] - distancia[i];
		        if (suma_dist_rest >= 0) {
			           suma_dist_rest += distancia_rest;
		        } else {
			           suma_dist_rest = distancia_rest;
			           inicio = i;
            }
	          total += distancia_rest;
        }

      	if (total >= 0){
      	   return inicio;
      	}else{
      		return -1;
      	}
    }
}
