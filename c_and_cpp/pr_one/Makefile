# Hola, esto es un intento de aprendizaje de Make, ya sé, en la universidad van a estar diciendo "Tienes que usar
# cmake" y ¿qué más basta? ¿quieren acaso también que empiece a usar los plumbing commands de git? pues bueno
# solamente iré poco a poco escalando hijos de sus *** madres
# TODO: Checar estos enlaces para las cuestiones:
# https://en.cppreference.com/w/cpp/language/definition
# https://devblogs.microsoft.com/cppblog/diagnosing-hidden-odr-violations-in-visual-c-and-fixing-lnk2022/
# https://stackoverflow.com/questions/70801992/are-variable-templates-declared-in-a-header-an-odr-violation

OBJS = main.o other_functions.o

all: cajero.out

cajero.out: $(OBJS)
	g++ $? -o $@
	@echo "El programa se compiló correctamente"

%.o: %.cpp
	g++ -c $< -o $@

clean:
	rm -f *.o cajero.out
