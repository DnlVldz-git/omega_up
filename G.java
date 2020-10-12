
import java.util.Scanner;

public class G {
    public static void main(String[] args){
        Scanner leer = new Scanner(System.in);
        pila pilita = new pila();
        int eventos = leer.nextInt();
        if(eventos<=0||eventos >=501) return;
        int resp1, resp2, n;
        while(eventos!=0){  //se hace un while con el número de eventos
            resp1 = leer.nextInt(); //se lee la respuesta 1
            if(resp1<=0||resp1>=3)return; //se checa que estè dentro de los límites
            resp2 = leer.nextInt(); //se lee la respuesta 2
            if(resp2<=-501||resp2>=501)return;  //se checa que estè dentro de los límites
            n = leer.nextInt();   //

            if(resp1==1){ //si la resp1 es 1, checará si el las resp 2 es 1 o 2, para insertar en las listas
                if(resp2==1){
                    pilita.insertar1(n);
                    eventos--;
                }else if(resp2==2){
                    pilita.insertar2(n);
                    eventos--;
                }
            }else if(resp1==2){ //si la resp1 es 2, checará qué es resp2 para cambiar
               if(resp2==1){
                    pilita.cambiar1(n);
                    eventos--;
                }else if(resp2==2){
                    pilita.cambiar2(n);
                    eventos--;
                }
            }else{
                return;
            }
        }
       pilita.recorrer1();  //imprime ambas listas
       System.out.print("\n");
       pilita.recorrer2();
    }
}

class pila{
    nodo inicio1 = null, inicio2 = null;

    public void insertar1(int dato){
        nodo nuevo = new nodo();
        nuevo.dato = dato;
        nuevo.sig=null;
        if(inicio1==null){
            inicio1= nuevo;
        }else{
            nuevo.sig = inicio1;
            inicio1 = nuevo;
        }
    }
    public void insertar2(int dato){
        nodo nuevo = new nodo();
        nuevo.dato = dato;
        nuevo.sig=null;
        if(inicio2==null){
            inicio2= nuevo;
        }else{
            nuevo.sig = inicio2;
            inicio2 = nuevo;
        }
    }
    public void cambiar1(int rep){
        for(int i = 0;i<rep;i++){
            if(inicio1!=null){
               insertar2(inicio1.dato);
               inicio1 = inicio1.sig;
            }
        }

    }
    public void cambiar2(int rep){
        for(int i = 0;i<rep;i++){
            if(inicio2!=null){
                insertar1(inicio2.dato);
                inicio2 = inicio2.sig;
            }
        }
    }
    public void recorrer1(){
        while(inicio1!=null){
            System.out.print(inicio1.dato);
            if(inicio1.sig !=null){
                System.out.print(" ");
            }
            inicio1=inicio1.sig;
        }
    }
    public void recorrer2(){
        while(inicio2!=null){
            System.out.print(inicio2.dato);
            if(inicio2.sig !=null){
                System.out.print(" ");
            }
            inicio2=inicio2.sig;
        }
    }
}

class nodo{ //se crea el nodo para la cola
    int dato;
    nodo sig;
}
