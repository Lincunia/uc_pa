#include <iostream>
#include <string>
using namespace std;

void hexa(string oct_string, int number)
{
	number = stoi(oct_string, 0, 16);
	cout << "hexadecimal: " << oct_string
		 << "\nnumber: " << number;
}
void octa(string oct_string, int number)
{
	number = stoi(oct_string, 0, 8);
	cout << "oct_string: " << oct_string
		 << "\nnumber: " << number;
}
void all_num(string oct_string, int n)
{
	n = stoi(oct_string, 0, 10);
	cout << "Binary: ";
	bool v;
	int number=n, aux;
	while (number!=0)
	{
		v=number%2;
		cout<<v;
		number/=2;
	}
	cout << "\nOctal: ";
	number=n;
	while (number!=0)
	{
		aux=number%8;
		cout<<aux;
		number/=8;
	}
	cout << "\nHexadecimal: ";
	number=n;
	while (number!=0)
	{
		aux=number%16;
		switch (aux)
		{
		case 15:
			cout << 'f';
			break;
			
		case 14:
			cout << 'e';
			break;
			
		case 13:
			cout << 'd';
			break;

		case 12:
			cout << 'c';
			break;
		
		case 11:
			cout << 'b';
			break;
			
		case 10:
			cout << 'a';
			break;

		default:
			cout << aux;
			break;
		}
		number/=16;
	}
	
}

int main()
{
	string oct_string;
	cout << "Insert your number: ";
	getline(cin, oct_string);
	int number = 0, key;
	cout << "Put in the key: "; // 8 for octal, 16 for hexadecimal and 4 for binary
	cin >> key;
	if (key == 8)
		octa(oct_string, number);
	if (key == 16)
		hexa(oct_string, number);
	if (key == 4)
		all_num(oct_string, number);		
	return 0;
}
