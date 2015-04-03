#include <stdio.h>

int main(int argc, const char * argv[]) {
  FILE *file = fopen(argv[1], "r");
  char line[1024];
  while (fgets(line, 1024, file)) {
    int i = 0, j = 0, ExpectedCount = 0, ActualCount = 0;
    for(i = 0; i < 1024; i++) {
      if(line[i] >= '0' && line[i] <= '9') {
        ExpectedCount = line[i] - '0';
        ActualCount = 0;
        for(j = 0; j < 1024; j++) {
          if(line[j] >= '0' && line[j] <= '9') {
            if(line[j]-'0' == i) {
              ActualCount++;
            }
          }
          else {
            break;
          }
        }
        if(ActualCount != ExpectedCount) {
          printf("0\n");
          break;
        }
      }
      else {
        printf("1\n");
        break;
      }
    }
  }
  return 0;
}
