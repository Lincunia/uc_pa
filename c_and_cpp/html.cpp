#include <iostream>
#include <string.h>
#include <fstream>
using namespace std;

/*
 * CREATING A FILE WITH BOOTSTRAP
 */
int main(int argc, char **argv)
{
  char txt[100];
  ofstream file;
  if (argc == 2)
  {
    strcpy(txt, argv[1]);
    goto gasoline;
  }
  cout << "Coloque nombre: ";
  cin.getline(txt, 100, '\n');
gasoline:
  file.open(txt);
  if (file.fail())
    exit(1);
  file << "<!DOCTYPE html>\n"
    << "<html lang=\"es\">\n"
    << "<head>\n"
    << "    <meta charset=\"utf-8\">\n"
    << "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n"
    << "    <title>Document</title>\n"
    << "    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD\" crossorigin=\"anonymous\">\n"
    << "</head>\n"
    << "<body>\n"
    << "    <div class=\"container\">\n"
    << "        <h1>Hello world !</h1>\n"
    << "    </div>\n"
    << "    <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN\" crossorigin=\"anonymous\"></script>\n"
    << "</body>\n</html>";
  file.close();
  return 0;
}
