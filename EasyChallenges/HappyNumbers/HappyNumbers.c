#include <stdio.h>

int main(int argc, const char * argv[]) {
  FILE *file = fopen(argv[1], "r");
  char line[1024];
  while (fgets(line, 1024, file)) {
    int i = 0, index = -1;
    int number = 0, NumFound = 0;
    int pastNumber[30];
    while(NumFound == 0) {
      number = 0;
      for(i = 0; i < 1024; i++) {
        if(line[i] >= '0' && line[i] <= '9') {
          number += ((line[i]-'0') * (line[i]-'0'));
        }
        else {
          break;
        }
      }

      if(number == 1) {
        printf("%d\n", 1);
        NumFound = 1;
      }

      for(i = 0; i <= index; i++) {
        if(pastNumber[i] == number) {
          printf("%d\n", 0);
          NumFound = 1;
          break;
        }
      }
      pastNumber[++index] = number;
      sprintf(line, "%d", number);
    }
  }
  return 0;
}
