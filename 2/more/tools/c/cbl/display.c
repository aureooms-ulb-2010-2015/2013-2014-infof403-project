#include <stdio.h>

void display_i64(size_t it);
void display_string(char* string);

int main(){
	size_t i;
	display_i64(i);
	char* string = "Hello world!";
	display_string(string);
	return 0;
}

void display_i64(size_t it){
	int c = '0' + it % 10;
	it /= 10;
	if(it > 0) display_i64(it);
	putchar(c);
}

void display_string(char* string){
	while(*string != '\0'){
		putchar(*string);
		++string;
	}
}