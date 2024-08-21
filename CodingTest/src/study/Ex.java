package study;

public class Ex {
    public static void main(String[] args) {
        Child c = new Child();
        System.out.println("x=" + c.getX());
    }


}
class parent {
    int x = 100;
    public parent() {
        this(200);
    }
    public parent(int x) {
        this.x = x;
    }
    int getX() {
        return x;
    }
}
class Child extends parent {
    int x = 3000;

    public Child() {
        this(1000);
    }
    public Child(int x) {
        this.x = x;
    }
}
