#include <iostream>
using std::cout, std::endl, std::string;

class Heart {
	public:
		Heart();
		~Heart();
};

/*
 * I wanted to put the method definition outside just to remember how to do
 * that with these programs to know how relationships work
 */
Heart::Heart(){
	cout << "The heart starts working" << endl;
}
Heart::~Heart(){
	cout << "The heart stoped working" << endl;
}

class Animal {
	private:
		Heart *heart;
	public:
		Animal (){
			heart = new Heart();
		}
		~Animal (){
			delete heart;
		}
};
/*
 * An object cannot exist without another one
 */
int main()
{
	Animal *person = new Animal();
	delete person;
	return 0;
}
