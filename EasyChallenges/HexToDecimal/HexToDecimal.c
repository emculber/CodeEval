#include <stdio.h>
int main(int argc, const char * argv[]) {
  FILE *file = fopen(argv[1], "r");
  char line[1024];
  while (fgets(line, 1024, file)) {
    int i=0, count=0, final=0, baseCount=1;
    while((line[i] >= '0' && line[i] <= '9') || (line[i] >= 'a' && line[i] <= 'f')) {
      i++;
    }
    i--;
    while(i!=-1) {
      int num=0;
      if(line[i] >= '0' && line[i] <= '9') {
        num = line[i] -'0';
      }
      else {
        num = line[i] - 'a';
        num += 10;
      }

      final += (num*baseCount);
      count++;
      i--;
      baseCount*=16;
    }
    printf("%d\n", final);
  }
  return 0;
}
