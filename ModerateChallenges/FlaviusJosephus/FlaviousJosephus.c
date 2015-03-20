#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <math.h>

int main(int argc, const char * argv[]) {
  FILE *file = fopen(argv[1], "r");
  char line[1024];
  while (fgets(line, 1024, file)) { 
    char n=-1, m=-1, Done = 0;
    char *p;
    p = strtok(line, ",");
    while (p) {
      if(p)
      {
        int result=atoi(p);
        if(n==-1) {
          n = (char)result;
        }
        else if(m==-1) {
          m = (char)result;
        }
      }
      p = strtok(NULL, ",");
    }
    int i = 0, count = 0;
    int array[n];
    for(i = 0; i < n; i++) {
      array[i] = i;
    }
    i=0;
    while(Done != n) {
      i=i%m;
      count=count%n;
      if(array[count] == -1) {
        count++;
        continue;
      }
      if(i==m-1){
        printf("%d ", array[count]);
        array[count] = -1;
        Done++;
      }
      i++;
      count++;
    }
    printf("\n");
  }
  return 0;
}
