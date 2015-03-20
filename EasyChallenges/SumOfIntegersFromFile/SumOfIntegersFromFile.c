#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int main(int argc, const char * argv[]) {
  FILE *file = fopen(argv[1], "r");
  char line[1024];
  int final = 0;
  while (fgets(line, 1024, file)) {
    char *p;
    p = strtok(line, " ");
    while (p) {
      if(p)
      {
        final+=atoi(p);
      }
      p = strtok(NULL, " ");
    }
  }
  printf("%d", final);
  return 0;
}
