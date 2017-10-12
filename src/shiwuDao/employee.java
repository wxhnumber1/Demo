package shiwuDao;

public class employee {
   private int id;
   private String name;
   private int age;
   private String address;
   private int password;
   private double xinzi;
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
public int getPassword() {
	return password;
}
public void setPassword(int password) {
	this.password = password;
}
public double getXinzi() {
	return xinzi;
}
public void setXinzi(double xinzi) {
	this.xinzi = xinzi;
}
@Override
public String toString() {
	return "employee [id=" + id + ", name=" + name + ", age=" + age + ", address=" + address + ", password=" + password
			+ ", xinzi=" + xinzi + "]";
}
	
	
}
