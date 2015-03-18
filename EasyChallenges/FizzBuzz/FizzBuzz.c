#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int main(int argc, const char * argv[]) {
  FILE *file = fopen(argv[1], "r");
  char line[1024];
  while (fgets(line, 1024, file)) {
    unsigned char x=0, y=0, n=0,i=0;
      
    char *p;
    p = strtok(line, " ");
    while (p) {
      if(p)
      {
        int result=atoi(p);
        if(x==0) {
          x = (char)result;
        }
        else if(y==0) {
            y = (char)result;
        }
        else if(n==0) {
            n = (char)result;
        }
      }
      p = strtok(NULL, " ");
    }

    for(i=1; i<=n; i++) {
      if(i%x==0 && i%y==0) {
        printf("FB ");
        continue;
      }
      if(i%x==0) {
        printf("F ");
        continue;
      }
      if(i%y==0) {
        printf("B ");
        continue;
      }
      printf("%d ", i);
    }
    printf("\n");
  }
  return 0;
}
