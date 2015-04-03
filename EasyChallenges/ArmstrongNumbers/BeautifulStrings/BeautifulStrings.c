#include <stdio.h>
int main(int argc, const char * argv[]) {
  //FILE *file = fopen(argv[1], "r");
  char line[1024]="ABbCcc";
  //while (fgets(line, 1024, file)) {
    int i = 0, Working = 0;
    for(i=0; i<1024; i++) {
      printf("Checking char %c\n", line[i]);
      if(line[i] == '\0') {
        break;
      }
      if(line[i] >= 'A' && line[i] <= 'Z') {
        Working += (line[i] - 'A') + 1;
      printf("Adding char %c To working Number %d\n", line[i], Working);
      }
      if(line[i] >= 'a' && line[i] <= 'z') {
        Working += (line[i] - 'a') + 1;
      printf("Adding char %c To working Number %d\n", line[i], Working);
      }
    }
    printf("%d\n", Working);
  //}
  return 0;
}
