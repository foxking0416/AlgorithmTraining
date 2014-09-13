package interfaceTest;

public class Human implements Whistle{

    private String name;
    
    public Human(String name) {
        this.name = name;
    }
 
    public void whistle() {
        System.out.printf("Human: %s!%n", name);
    }
    

}
