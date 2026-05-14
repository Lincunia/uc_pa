FILES = basic_functions.o main.o product_functions.o shopping_functions.o

programa.out: $(FILES)
	g++ -o $@ $?

%.o: %.cpp
	g++ -c $<

clean:
	rm *.o *.out
