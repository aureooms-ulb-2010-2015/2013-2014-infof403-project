#include <stdio.h>

void accept_i64(__int64_t* it);

__int64_t i;
int main(){
	accept_i64(&i);
	return 0;
}

void accept_i64(__int64_t* it){
	*it = 0;
	int c;
	char neg = 0;
	c = getchar();
	if(c == '-'){
		neg = 1;
		c = getchar();
	}
	while(1){
		if(c < '0') break;
		if(c > '9') break;
		*it *= 10;
		*it += c - '0';
		c = getchar();
	}

	if(neg) *it = -*it;
}