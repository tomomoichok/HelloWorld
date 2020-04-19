package lesson2;

public class EDog extends EAnimal {
    public EDog(String myName) {
        super(myName);
    }

    public void sleep(){
        System.out.println(name+"站着睡");
    }

}
