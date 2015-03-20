#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int main(int argc, const char * argv[]) {
  FILE *file = fopen(argv[1], "r");
  char line[1024];
  while (fgets(line, 1024, file)) {
    int p1=-1,p2=-1,n=-1;
    char *p;
    p = strtok(line, ",");
    while (p) {
      if(p)
      {
        int result=atoi(p);
        if(n==-1) {
          n = (char)result;
        }
        else if(p1==-1) {
          p1 = (char)result;
        }
        else if(p2==-1) {
          p2 = (char)result;
        }
      }
      p = strtok(NULL, ",");
    }
    int x = n & (1<<(p1-1));
    x = x>>(p1-1);
    int y = n & (1<<(p2-1));
    y = y>>(p2-1);
    if(x==y) {
      printf("true\n");
    }
    else {
      printf("false\n");
    }
  }
  return 0;
}
