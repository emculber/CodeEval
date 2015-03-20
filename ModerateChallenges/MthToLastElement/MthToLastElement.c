#include <stdio.h>
int main(int argc, const char * argv[]) {
  FILE *file = fopen(argv[1], "r");
  char line[1024];
  while (fgets(line, 1024, file)) {
    int i=0;
    while(line[i]-'0' > 9 || line[i]-'0'<0) {
      printf("%c", line[i]);
      i++;
    }
      printf("%c", line[i]);
    int x = line[i]-'0';
    if(x > ((i-1)/2)) {
      printf("\n");
      continue;
    }
    i= (i)-(x*2);
    printf("%c\n", line[i]);
  }
  return 0;
}
