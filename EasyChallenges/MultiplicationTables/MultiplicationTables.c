#include <stdio.h>

int main(int argc, const char * argv[]) {
  int i=1, multi = 1, check = 12, condition = 13;
  while(multi<condition) {
    printf("%d", i);
    if(i == check) {
      printf("\n");
      multi++;
      check = 12*multi;
      i = multi;
    }
    else {
      i+=multi;
    }
    if(i < 10 && i != multi) {
      printf("   ");
    }
    else if(i < 100 && i != multi) {
      printf("  ");
    }
    else if(i != multi) {
      printf(" ");
    }
  }
  return 0;
} 
