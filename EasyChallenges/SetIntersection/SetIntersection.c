#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int main(int argc, const char * argv[]) {
  FILE *file = fopen(argv[1], "r");
  char line[1024];
  while (fgets(line, 1024, file)) {
    char *p1, *s1, *s2, second = 0;
    p1 = strtok(line, ";");
    while (p1) {
      if(p1)
      {
        if(second==0) {
          s1 = p1;
          second=1;
        }
        else {
          s2 = p1;
        }
      }
      p1 = strtok(NULL, ";");
    }
    int array1[1024];
    int array2[1024];
    int i = 0, x=0, y=0, z=0;
    p1 = strtok(s1, ",");
    while (p1) {
      if(p1)
      {
        array1[i] = atoi(p1);
        i++;
      }
      p1 = strtok(NULL, ",");
    }
    p1 = strtok(s2, ",");
    while (p1) {
      if(p1)
      {
        array2[x] = atoi(p1);
        x++;
      }
      p1 = strtok(NULL, ",");
    }
    int firstPrint = 0;
    for(z=0; z<=i; z++) {
      for(y=0; y<=x; y++) {
        if(array1[z]==array2[y]) {
          if(firstPrint == 1) {
            printf(",");
          }
          printf("%d", array1[z]);
          firstPrint = 1;
        }
      }
    }
    printf("\n");
  }
  return 0;
}
