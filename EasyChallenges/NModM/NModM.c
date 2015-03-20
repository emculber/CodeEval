#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <math.h>

int main(int argc, const char * argv[]) {
  FILE *file = fopen(argv[1], "r");
  char line[1024];
  while (fgets(line, 1024, file)) {
    double n=0,m=0;
      
    char *p;
    p = strtok(line, ",");
    while (p) {
      if(p)
      {
        int result=atoi(p);
        if(n==0) {
            n = (double)result;
        }
        else if(m==0) {
            m = (double)result;
        }
      }
      p = strtok(NULL, ",");
    }

    double a = n/m;
    a-=floor(a);
    a*=m;
    printf("%d\n", (int)a);
  }
  return 0;
}
