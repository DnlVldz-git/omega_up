#include <bits/stdc++.h>
#include <string>

using namespace std;

string multiply(string num1, string num2){

    int len1 = num1.size();
    int len2 = num2.size();

    vector<int> result(len1 + len2, 0);
    int i_n1 = 0;
    int i_n2 = 0;

    for (int i=len1-1; i>=0; i--) {
        int carry = 0;
        int n1 = num1[i] - '0';
        i_n2 = 0;
        for (int j=len2-1; j>=0; j--) {
          int n2 = num2[j] - '0';
          int sum = n1*n2 + result[i_n1 + i_n2] + carry;
          carry = sum/10;
          result[i_n1 + i_n2] = sum % 10;
          i_n2++;
        }
        if (carry > 0)
          result[i_n1 + i_n2] += carry;
        i_n1++;
    }

    int i = result.size() - 1;
    while (i>=0 && result[i] == 0)
      i--;
    if (i == -1) return "0";

    string s = "";
    while (i >= 0){
      s += to_string(result[i--]);
    }
    return s;
}

string contar(string num){
  if(num.length() == 1){
    return num;
  }else{
    int suma = 0;
    for(int i = 0; i < num.length(); i++){
      suma += (num[i] - '0');
    }
    string nuevo_num = to_string(suma);
    return contar(nuevo_num);
  }
}


int main(){

    string digito, veces;
    int casos;

    cin >> casos;
    for(int i = 0; i < casos; i++){
        cin >> digito >> veces;
      	digito = contar(digito);
        string res = multiply(digito, veces);
        string fin = contar(res);
        cout << fin << endl;
    }
    return 0;
}
