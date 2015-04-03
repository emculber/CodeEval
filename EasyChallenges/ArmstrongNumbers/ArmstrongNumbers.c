#include <stdio.h>
int main(int argc, const char * argv[]) {
  FILE *file = fopen(argv[1], "r");
  char line[1024];
  while (fgets(line, 1024, file)) {
    int i=0, j=0, Power = 0, Number = 0, FinalNumber = 0;
    for(i=0; i<1024; i++) {
      if(line[i] >= '0' && line[i] <= '9') {
        Number *= 10;
        Number += line[i]-'0';
        Power++;
      }
    }
    for(i=0; i<=Power; i++) {
      if(line[i] >= '0' && line[i] <= '9') {
        int temp = line[i]-'0';
        for(j=1; j<Power; j++) {
          temp *= line[i]-'0';
        }
        FinalNumber += temp;
      }
    }
    if(FinalNumber == Number) {
      printf("True\n");
    }
    else {
      printf("False\n");
    }
  }
  return 0;
}
