#include <stdio.h>

void display_i16(unsigned short it);

unsigned short i;
int main(){
	display_i16(i);
	return 0;
}

void display_i16(unsigned short it){
	int c = '0' + it % 10;
	it /= 10;
	if(it > 0) display_i16(it);
	putchar(c);
}