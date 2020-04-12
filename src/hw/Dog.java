package hw;

public class Dog extends Animal {
    public Dog(String myName) {
        super(myName);
    }

    public void sleep(){
        System.out.println(name+"站着睡");
    }

}
