#include <stdio.h>

int main(int argc, const char * argv[]) {
  int i = 1;
  for(i=1; i < 100; i+=2) {
    printf("%d\n", i);
  }
  return 0;
}
