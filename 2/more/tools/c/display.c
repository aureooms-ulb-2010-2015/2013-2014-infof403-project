#include <stdio.h>

void display(int it);

int main (){
	int i;
	display(i);
	return 0;
}

void display(int it){
	do{
		int c = '0' + it % 10;
		putchar(c);
		it /= 10;
	} while(it > 0);
}