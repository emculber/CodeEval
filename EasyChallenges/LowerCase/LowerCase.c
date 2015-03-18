#include <stdio.h>
#include <string.h>

int main(int argc, const char * argv[]) {
  FILE *file = fopen(argv[1], "r");
  char line[1024];
  while (fgets(line, 1024, file)) {
    char *String = line;
    int i = 0, size=strlen(String);
    for(i=0; i<size; i++) {
      if(line[i] >= 'A' && line[i] <= 'Z') {
        printf("%c", line[i] + 32);
        continue;
      }
      printf("%c", line[i]);
    }
  }
  return 0;
} 
