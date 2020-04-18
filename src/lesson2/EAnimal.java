package lesson2;

public class EAnimal {
	public String name;
    public EAnimal(String myName) {
        name = myName;
    }
    public void eat(){
        System.out.println(name+"会吃");
    }
    public void sleep(){
        System.out.println(name+"会睡");
    }
}
