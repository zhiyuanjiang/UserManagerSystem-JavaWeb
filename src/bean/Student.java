package bean;

public class Student {
	
	private String name;
	private String id;
	
	public Student() {}
	
	public Student(String _name, String _id) {
		name = _name;
		id = _id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String _name) {
		name = _name;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String _id) {
		id = _id;
	}
}

