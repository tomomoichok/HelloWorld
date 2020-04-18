package lesson2;

public class ECat extends EAnimal {
    public ECat(String myName) {
        super(myName);
    }
    public void catchmouse() {
		System.out.println(super.name+"抓老鼠");
	}
}
