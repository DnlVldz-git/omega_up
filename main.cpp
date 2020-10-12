#include <stack>
#include <iostream>

using namespace std;

bool checar_caracter(char apertura, char cierre){	//compara si son los correspondientes a apertura y cierre devuelve true si lo son
	if( apertura == '(' && cierre == ')' ) return true; //compara si son parentesis y si son de cierre y apertura
	else if ( apertura == '[' && cierre == ']' ) return true;	//compara si son corchetes y si son de cierre y apertura
	else if ( apertura == '{' && cierre == '}' ) return true;//compara si son llaves y si son de cierre y apertura
	return false;	//si no entra en ningùn caso retorna false
}
bool equilibrio(string secuencia){	//
    stack<char>pila;		//se crea una pila de chars
    for(int j=0;j<secuencia.size();j++){	//hace un for del tamaño del arreglo
        if(secuencia[j]=='(' || secuencia[j]=='{' || secuencia[j]=='['){	//si el caràcter es de apertura, se guarda en la pila
            pila.push(secuencia[j]);
        }
        else if(secuencia[j]==')' || secuencia[j]=='}' || secuencia[j]==']'){//si son de cierre, se checa si la pila esta vacía o si sì corresponden al mismo caracter de cierre y de apertura, llamando a la función checar caracter
            if (pila.empty() || !checar_caracter(pila.top(),secuencia[j])){
                return false;	//en cualquiera de los casos va a retornar falso
            }
        		else(pila.pop());	//en otro caso, se hara pop a la pila
        }
    }
        return pila.empty()? true:false;	//al final del for retornara si la pila està vacia o no
}

int main(){	//
    string secuencia;	//string para poner los parentesis, corchetes y llaves
    int casos;	//guarda el numero de casos
    cin>>casos;	//pide el nùmero de casos
    for(int i=0;i<casos;i++){	//hace un for por el número de casos
        cin>>secuencia;	//pide la cadena de parentesis, corchetes y llaves
        if(equilibrio(secuencia)){	//checa si están equilibrados y si tienen las aperturas y cierres correctos
            cout<<"SI"<<endl;	//en caso que sì, imprime SI
        }
        else{
            cout<<"NO"<<endl;	//en caso que no, imprime no.
        }
    }
return 0;
}
