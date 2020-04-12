package hw;

public class Animal {
	public String name;
    public Animal(String myName) {
        name = myName;
    }
    public void eat(){
        System.out.println(name+"会吃");
    }
    public void sleep(){
        System.out.println(name+"会睡");
    }
}
