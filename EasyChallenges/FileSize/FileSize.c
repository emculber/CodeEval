#include <stdio.h>

int main(int argc, const char * argv[]) {
  FILE *file = fopen(argv[1], "r");
  fseek(file, 0l, SEEK_END);
  printf("%ld", ftell(file));
  return 0;
}
