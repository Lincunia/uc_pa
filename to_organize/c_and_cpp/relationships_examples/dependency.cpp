#include <iostream>
using std::string, std::cout, std::endl;

class Printer {
	public:
		void print(string text){
			cout << "Printing: " << text << endl;
		}
};

class Document {
	public:
		void setToPrinter(Printer &prtr){
			prtr.print("SLOW MOTION! BABY");
		}
};

/*
 * This is where an object uses another one as a parameter or as a local
 * variable
 */
int main(){
	Printer *prtr = new Printer();
	Document doc;
	doc.setToPrinter(*prtr);
	delete prtr;
	return 0;
}
