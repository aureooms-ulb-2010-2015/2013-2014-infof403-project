#include <stdio.h>

void display(int it);

int main(){
	int i;
	display(i);
	return 0;
}

void display(int it){
	int c = '0' + it % 10;
	it /= 10;
	if(it > 0) display(it);
	putchar(c);
}