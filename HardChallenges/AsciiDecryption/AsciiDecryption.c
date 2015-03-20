#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int main(int argc, const char * argv[]) {
  FILE *file = fopen(argv[1], "r");
  char line[1024];
  while (fgets(line, 1024, file)) {
    int length = -1;
    char lastLetter = -1;
    char AsciiSpace = ' ';
    int Message[1024];
    int index = 0;
    char *p;
    p = strtok(line, " ");
    while (p) {
      if(p)
      {
        if(strcmp(p,"|")==0){
        }
        else if(length == -1 ) {
          length = atoi(p);
        }
        else if(lastLetter == -1) {
          lastLetter = *p;
        }
        else {
          Message[index] = atoi(p);
          index++;
        }
      }
      p = strtok(NULL, " ");
    }
    int i = 0, x=0, n=0;
    char space = 0;
    char Check1 = 0, Check2 = 0;
    for(i = 1; i <= index-length; i++) {
      Check1 = Message[i-1];
      Check2 = Message[i+length];
      if(Check1 == Check2) {
        Check1 -= AsciiSpace;
        if(Message[i+length-1] == lastLetter + Check1) {
          n=Check1;
          break;
        }
      }
    }

    for(i = 0; i <= index; i++) {
      printf("%c", (char)(Message[i]-n));
    }
    printf("\n");
  }
  return 0;
}
