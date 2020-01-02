package Tast1;

import java.awt.*;
import java.util.ArrayList;

public class BoxWithFruits {

    public static void main(String[] args) {
        Apple apple = new Apple(15);
        Orange orange = new Orange(20);
        Box.boxArrayList.add(new Box<Fruit>(apple));
        Box.boxArrayList.add(new Box<Fruit>(orange));

        orange.setWeight(60);
        apple.setWeight(90);


        for (Box x:Box.boxArrayList) {
            System.out.println(x.nameBox + " "+ x.getObj().getClass() + " " + x.getObj().getWeight());

        }
        Box.reShift("box3","box2",35);
        Box.reShift("box1","box2",15);
        Box.reShift("box1","box4",35);

        for (Box x:Box.boxArrayList) {
            System.out.println(x.getObj().getClass().getSimpleName() + " " + x.nameBox + " "+ x.getObj().getWeight());

        }
    }
}
class Apple implements Fruit {
    private float MAXWEIGHT = 100f;
    private float WEIGHTQUANTITY = 1.0f;
    private float appleWeight = 0f;

    public Apple(int quantity) {
        appleWeight = 1.0f * quantity;

    }
    public float getWeight() {
        return appleWeight;
    }
    public void setWeight(int appleQuantity) {
        float putInBox = appleQuantity * WEIGHTQUANTITY;
        if (((this.appleWeight + putInBox) / MAXWEIGHT) > 1) {
                this.appleWeight = this.appleWeight + putInBox - (int)(MAXWEIGHT / WEIGHTQUANTITY) * WEIGHTQUANTITY;
                System.out.println(this.appleWeight + " This is a Apple Box is FULL, punts in new Apple Box");
                Box.boxArrayList.add(new Box<Fruit>(new Apple((int) (MAXWEIGHT / WEIGHTQUANTITY))));
                setWeight((int)(this.appleWeight / WEIGHTQUANTITY));
            } else {
            this.appleWeight += putInBox;
        }
        }
    public float getMAXWEIGHT() {
        return MAXWEIGHT;
    }
    public float getWEIGHTQUANTITY() {
        return WEIGHTQUANTITY;
    }
    public void takeFromBox(int appleQuantity) {
        float takeFromBox = WEIGHTQUANTITY*appleQuantity;
        if (this.appleWeight > takeFromBox){
            this.appleWeight -=takeFromBox;
            System.out.println("You took it out of the Orange Box -" + takeFromBox);
        }else {
            System.out.println(" You couldn't take it out of the Orange Box " + takeFromBox + " the remainder is less");
        }
    }

}
class Orange implements Fruit {
    private float  MAXWEIGHT = 100f;
    private float WEIGHTQUANTITY = 1.5f;
    private float orangeWeight = 0f;
    public Orange(int quantity) {
        orangeWeight = WEIGHTQUANTITY*quantity;
    }
    public float getWeight() {
        return orangeWeight;
    }
    public void setWeight(int orangeQuantity) {
        float putInBox = orangeQuantity * WEIGHTQUANTITY;
        if (((this.orangeWeight + putInBox) / MAXWEIGHT) > 1) {
            this.orangeWeight = this.orangeWeight + putInBox - (int)(MAXWEIGHT / WEIGHTQUANTITY) * WEIGHTQUANTITY;
                System.out.println(this.orangeWeight + " This is a Orange Box is FULL, punts in new Orange Box");
                Box.boxArrayList.add(new Box<Fruit>(new Orange((int) (MAXWEIGHT / WEIGHTQUANTITY))));
                setWeight((int)(this.orangeWeight / WEIGHTQUANTITY));
            } else {
            this.orangeWeight += putInBox;
            }
    }
    public float getMAXWEIGHT() {
        return MAXWEIGHT;
    }
    public float getWEIGHTQUANTITY() {
        return WEIGHTQUANTITY;
    }
    public void takeFromBox(int orangeQuantity) {
        float takeFromBox = WEIGHTQUANTITY*orangeQuantity;
        if (this.orangeWeight > takeFromBox){
            this.orangeWeight -=takeFromBox;
            System.out.println("You took it out of the Orange Box -" + takeFromBox);
        }else {
            System.out.println(" You couldn't take it out of the Orange Box " + takeFromBox + " the remainder is less");
        }
    }

}
interface Fruit{
    public String name = "Fruit";
    public float getWeight();
    public void setWeight(int quantity);
    public float getMAXWEIGHT();
    public float getWEIGHTQUANTITY();
    public void takeFromBox(int quantity);
}
class Box <TY extends Fruit> {
    String nameBox;
    static int count = 1;
    static ArrayList<Box> boxArrayList = new ArrayList<Box>();
    private TY obj;
    public Box(TY obj) {
        nameBox = "box" + count;
        this.obj = obj;
        count ++;
     }
     //
    public static void reShift(String box1, String box2, int weight) {
            Box boxOne = null, boxTwo = null;
            for (Box x : Box.boxArrayList) {
                if (x.nameBox.equals(box1)) {
                    boxOne = x;
                    for (Box y : Box.boxArrayList) {
                        if (y.nameBox.equals(box2)) {
                            boxTwo = y;
                        }
                    }
                }
            }
        if ((boxOne.getObj().getClass().equals(boxTwo.getObj().getClass())) && (boxOne.getObj().getWeight() >0f) && (boxTwo.getObj().getWeight() >0f) )  {
            boxOne.getObj().setWeight(weight);
            boxTwo.getObj().takeFromBox(weight);
            System.out.println("It turned out to shift the fruit");
        }else {
            System.out.println("Fruit should not be disturbed");
        }

        }
    public TY getObj() {
        return obj;
    }
    public void setObj(TY obj) {
        this.obj = obj;
    }
}