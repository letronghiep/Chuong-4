package SinhVien;

import java.util.*;

public class Test {
	public static void main(String[] args) {
		List<Person> listPerson = new ArrayList<>();
//		int id, String name, int age, String address, double gpa
		Person p = new Person();
		Scanner sc = new Scanner(System.in);
		Person p1 = new Person(1, "Lê Trọng Hiệp", 19, "Ninh Bình", 3.3);
		Person p2 = new Person(2, "Vũ Thị Bích Huyền", 19, "Thái Nguyên", 3.2);
		Person p3 = new Person(3, "Vũ Minh Huệ", 19, "Ninh Bình", 3.4);
		listPerson.add(p1);
		listPerson.add(p2);
		listPerson.add(p3);
		p.printStudent(listPerson);
		int choose;
		do {
			System.out.println("------------Menu select-------------");
			System.out.println("1 - Add student");
			System.out.println("2 - Edit student by id.");
			System.out.println("3 - Delete student by id.");
			System.out.println("4 - Sort student by gpa.");
			System.out.println("5 - Sort student by name.");
			System.out.println("6 - Show student.");
			System.out.println("0 - Exit.");
			System.out.println("Enter your choose: ");
			choose = sc.nextInt();
			
//			sc.nextLine();
			switch (choose) {
			case 1:
				System.out.println("---------Add student-------");
				System.out.println("Enter id student: ");
				sc.nextLine();
				int id = sc.nextInt();
				sc.nextLine();
				System.out.println("Enter name student: ");
				String name = sc.nextLine();
				System.out.println("Enter age student: ");
				int age = sc.nextInt();
				sc.nextLine();
				System.out.println("Enter address student: ");
				String address = sc.nextLine();
				System.out.println("Enter gpa student: ");
				double gpa = sc.nextDouble();
				Person newPer = new Person(id, name, age, address, gpa);
				p.addStudent(listPerson, newPer);
				p.printStudent(listPerson);
				break;
			case 2:
				System.out.println("-----------Edit student-------");
				p.editStudent(listPerson);
				p.printStudent(listPerson);
				break;
			case 3:
				p.delStudent(listPerson);
				p.printStudent(listPerson);
				break;
			case 4:
				System.out.println("----------Sorted Student By GPA----------");
				List<Person> listGPA = p.sortedStudent(listPerson, true);
				System.out.println("List student after sort by gpa: ");

				listGPA.forEach((x) -> {
					System.out.println(x);
				});

				break;
			case 5:
				System.out.println("------------Sorted Student by Name");
				List<Person> listName = p.sortedName(listPerson, true);
				System.out.println("List student after sort by name: ");
				listName.forEach((x) -> {
					System.out.println(x);
				});
				break;
			case 6:
				System.out.println("----------Show student-----------");
				p.printStudent(listPerson);
				break;
			case 0: 
				System.out.println("Exited!");
				break;
			default:
				break;
			}
			if(choose < 0 || choose > 6) {
				System.out.println("Data input wrong! Please enter data again: ");
			}
		} while (choose >= 0 || choose <= 6);
	}
}
