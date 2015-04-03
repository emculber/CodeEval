#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int main(int argc, const char * argv[]) {
  FILE *file = fopen(argv[1], "r");
  char line[1024];
  while (fgets(line, 1024, file)) {
    int i=-1;
    char *p;
    p = strtok(line, ",");
    while (p) {
      if(p)
      {
        int result=atoi(p);
        if(i==-1) {
          i=result;
        }
        if(i!=result) {
          printf("%d,", i);
          i=result;
        }
      }
      p = strtok(NULL, ",");
    }
    printf("%d\n", i);
  }
  return 0;
}
