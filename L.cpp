#include <stdio.h>
#include <math.h>

int fact(int x,int y){
	if(y<=2){
		return x+y;
	}else{
		return x+fact(x,y-1)+(5*fact(x,y-2));
	}
}

int main(int argc, char const *argv[])
{
	int n=0;
	scanf("%d",&n);
	if (n<=5)
	{
		for (int i = 0; i < n; ++i)
		{
			int x;
			scanf("%d",&x);
			int y;
			scanf("%d",&y);

				printf("%d\n",fact(x,y) );
		}
	}
}
