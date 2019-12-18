package Tast1;

public class BoxWithFruits {
    public static void main(String[] args) {

    }
}
class Apple implements Fruit {
    float appleWeight;

    public Apple(int quantity) {
        appleWeight=1.0f*quantity;
    }
}
class Orange implements Fruit {
    float orangeWeight;

    public Orange(int quantity) {
        orangeWeight = 1.5f*quantity;
    }
}
interface Fruit{

}
class Box<BoxFruit extends Fruit>{

}