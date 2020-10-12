#include <stdio.h>
#include <stdlib.h>

int fact(int n){
  if(n==0){
    return 1;
  }else{
    return n*fact(n-1)+1;
  }
}

int main(int argc, char const *argv[]) {
  int num;
  scanf("%d", &num);
  if(num<=-1||num>=1001) return 0;
  int res = fact(num);
  printf("%d",res );
  return 0;
}
