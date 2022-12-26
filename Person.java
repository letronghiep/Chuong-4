package SinhVien;
import java.util.*;
public class Person implements StudentManager{

	Scanner sc = new Scanner(System.in);
	//	Variables
	private int id;
	private String name;
	private int age;
	private String address;
	private double gpa;
	
	public Person() {
		// TODO Auto-generated constructor stub
	}
	
	public Person(int id, String name, int age, String address, double gpa) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.address = address;
		this.gpa = gpa;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	@Override
	public String toString() {
		return "ID: " + id + "\nName: " + name + "\nAge: " + age + "\nAddress: " + address + "\nGPA: " + gpa + "\n";
	}
	@Override
	public boolean addStudent(List<Person> p, Person s) {
		
		boolean check = true;
		int n = p.size();
		for (int i = 0; i < n; i++) {
			if(s.getId() == p.get(i).getId()) {
				check = false;
			}
		}
		if(check) {
			p.add(s);
			System.out.println("Add Completed!");
			
		}else {
			System.out.println("ID has been in list!");
		}
		return check;
	}
	@Override
	public boolean editStudent(List<Person> p) {
		boolean check = false;
		System.out.println("Enter id you want to edit: ");
//		sc.nextLine();
		int idCheck = sc.nextInt();
		int n = p.size();
		for (int i = 0; i < n; i++) {
			if(p.get(i).getId() == idCheck) {
				check = true;
				System.out.println("Property can be edit: ");
				System.out.println(" 1 - name");
				System.out.println(" 2 - age");
				System.out.println(" 3 - address");
				System.out.println(" 4 - gpa");
				System.out.println(" 5 - Exits");
				System.out.println("--------------");
				System.out.println("Enter property quantity you want to edit: ");
				int cnt = sc.nextInt();
				while(cnt --> 0) {
					System.out.println("Enter your property: ");
					int choose = sc.nextInt();
					switch (choose) {
					case 1:
						System.out.println("Enter the new name: ");
						sc.nextLine();
						String newName = sc.nextLine();
						p.get(i).setName(newName);
						break;
					case 2:
						System.out.println("Enter the new age: ");
						sc.nextInt();
						int newAge = sc.nextInt();
						p.get(i).setAge(newAge);
						break;
					case 3:
						System.out.println("Enter the new address: ");
						sc.nextLine();
						String newAdd = sc.nextLine();
						p.get(i).setAddress(newAdd);
						break;
					case 4: 
						System.out.println("Enter the new gpa: ");
						sc.nextLine();
						double newGpa = sc.nextDouble();
						p.get(i).setGpa(newGpa);
						break;
					case 5: 
						System.out.println("Exited");
						break;
					default:
						continue;
					}
				}
				
			}
		}
		if(check) {
			System.out.println("Edit completed");
		}else {
			System.out.println("Id was not exist");
		}
		return check;
	}
	@Override
	public boolean delStudent(List<Person> p) {
		boolean check = false;
		System.out.println("Enter id check: ");
//		int idCheck = sc.nextInt();
		int idCheck = sc.nextInt();
		int n = p.size();
		for(int i=0; i<n; i++) {
			if(idCheck == p.get(i).getId()) {
				check = true;
				p.remove(i);
				break;
			}
		}
		if(check) {
			System.out.println("Delete Completed");
		}else {
			System.out.println("ID was not exist");
		}
		return check;
	}
	@Override
	public List<Person> sortedStudent(List<Person> p, boolean isStu) {
		List<Person> ans = new ArrayList<>();
		p.forEach((x)-> {
			ans.add(x);
		});
		if(isStu) {
			Collections.sort(ans, new sortedByGpa());
		}else {
			Collections.sort(ans, new sortedByGpa().reversed());
		}
		return ans;
	}
	class sortedByGpa implements Comparator<Person> {
		@Override
		public int compare(Person p1, Person p2) {
			if((p1.getGpa() - p2.getGpa()) >= 0) {
				return 1;
			}else return -1;
		}
	}
	@Override
	public List<Person> sortedName(List<Person> p, boolean isName){
		List<Person> ans = new ArrayList<>();
		p.forEach((x) -> {
			ans.add(x);
		});
		if(isName) {
			Collections.sort(ans, new sortedByName());
		}else {
			Collections.sort(ans, new sortedByName().reversed());
		}
		return ans;
	}
	class sortedByName implements Comparator<Person> {
		@Override 
		public int compare(Person p1, Person p2) {
			return p1.getName().compareTo(p2.getName());
			
		}
	}
	@Override
	public void printStudent(List<Person> p) {
		if(!p.isEmpty()) {
			System.out.println("List Student: ");
			p.forEach((x)->{
				System.out.println(x);
			});
		}else {
			System.out.println("List Student is not exist");
		}
	}

}
