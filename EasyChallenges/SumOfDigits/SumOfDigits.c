#include <stdio.h>
#include <stdlib.h>

int main(int argc, const char * argv[]) {
  FILE *file = fopen(argv[1], "r");
  char line[1024];
  while (fgets(line, 1024, file)) {
    int i = 0, final = 0;
    while(line[i]-'0' < 10 && line[i]-'0' > -1) {
      final += line[i] - '0';
      i++;
    }
    printf("%d\n", final);
  }
  return 0;
}
