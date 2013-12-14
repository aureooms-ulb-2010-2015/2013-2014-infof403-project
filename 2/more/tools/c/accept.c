#include <stdio.h>

void accept(int* it);

int main (){
	int i;
	accept(&i);
	return 0;
}

void accept(int* it){
	*it = 0;
	int c;
	while(1){
		c = getchar();
		if(c < '0') break;
		if(c > '9') break;
		*it *= 10;
		*it += c - '0';
	}
}