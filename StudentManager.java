package SinhVien;
import java.util.*;
public interface StudentManager {
	public boolean addStudent(List<Person> p, Person s);
	public boolean editStudent(List<Person> p);
	public boolean delStudent(List<Person> p);
	public List<Person> sortedStudent(List<Person> p, boolean isStu);
	public List<Person> sortedName(List<Person> p, boolean isName);
	void printStudent(List<Person> p);
}
