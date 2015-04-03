#include <stdio.h>
int main(int argc, const char * argv[]) {
  FILE *file = fopen(argv[1], "r");
  char line[1024];
  while (fgets(line, 1024, file)) {
    int i = 0;
    while(line[i] != ',') {
      i++;
    }
    char LookingFor = line[i + 1];
    int x = 0;
    int foundAt = -1;
    for(x = 0; x <= i; x++) {
      if(line[x] == LookingFor) {
        foundAt = x;
        continue;
      }
    }
    printf("%d\n", foundAt);
  }
  return 0;
}
