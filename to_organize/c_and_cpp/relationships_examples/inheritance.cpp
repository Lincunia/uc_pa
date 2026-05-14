#include <iostream>
using std::string, std::cout, std::endl;

class Animal {
protected:
    string name;

public:
    Animal(string n) : name(n)
    {
    }
    virtual void emitSound() { cout << "The sound from the beggining of all time" << endl; }
};

class Dog : public Animal {
public:
    Dog(string n)
        : Animal(n)
    {
    }
    void emitSound() override
    {
        cout << name << " says: WOF!" << endl;
    }
};

class Tiger : public Animal {
public:
    Tiger(string n)
        : Animal(n)
    {
    }
    void emitSound() override
    {
        cout << name << " says: ROAR!" << endl;
    }
};

int main(){
	Animal *dog = new Dog("Chien");
	dog->emitSound();
	delete dog;
	Animal *tiger = new Tiger("Mia");
	tiger->emitSound();
	delete tiger;
	return 0;
}
