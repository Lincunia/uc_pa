#include <iostream>

class Teacher {
	public:
		void teach() {
			std::cout << "I'm teaching to idiots\n";
		}
};

class Student {
	private:
		Teacher *teacher;
		void defaultFunction(){
			std::cout << "Arroz con pollo\n";
		}
	public:
		void assignTeacher(Teacher *teacher) {
			this->teacher = teacher;
		}
		void receiveClass() {
			(teacher) 
				? teacher->teach()
				: defaultFunction();
		}
};

/*
 * The mese presence of Teacher in the Student class explains the situation
 * that a student knows a teacher
 */
int main(){
	Student *student = new Student();
	student->receiveClass();
	student->assignTeacher(new Teacher());
	student->receiveClass();
	return 0;
}
