package hw;

public class Cat extends Animal {
    public Cat(String myName) {
        super(myName);
    }
    public void catchmouse() {
		System.out.println(super.name+"抓老鼠");
	}
}
