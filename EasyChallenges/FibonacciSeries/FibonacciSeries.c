#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int F(int n) {
  if(n==0||n==1) {
    return n;
  }
  else {
    return F(n-1) + F(n-2);
  }
}

int main(int argc, const char * argv[]) {
  FILE *file = fopen(argv[1], "r");
  char line[1024];
  while (fgets(line, 1024, file)) {
    int n = 0;
    char *p;
    p = strtok(line, " ");
    while (p) {
      if(p)
      {
        n=atoi(p);
      }
      p = strtok(NULL, " ");
    }
    printf("%d\n", F(n));
  }
  return 0;
}
