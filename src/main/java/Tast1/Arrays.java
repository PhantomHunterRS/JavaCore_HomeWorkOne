package Tast1;

import java.util.ArrayList;

public class Arrays <Elements> {
     private Elements[] arrays;

    public Arrays(Elements[] arrays) {
        this.arrays = arrays;
    }
    public Elements[] getArrays() {
        return arrays;
    }
    public void setArrays(Elements[] arrays) {
        this.arrays = arrays;
    }
    public void changesElementsArray(Elements[] changes, int first, int last){
        Elements element;
        element = changes[first];
        changes[first] = changes[last];
        changes[last] = element;
        }
    public ArrayList<?> convertsArrayList(Elements[] arrays){
        ArrayList<Elements> arrayListE = new ArrayList<Elements>();
        for (Elements x: arrays) {
            arrayListE.add(x);
        }
        return arrayListE;
    }
    public  void printGenerics(Elements[] arrays){
        for (Elements x: arrays) {
            System.out.println(x);
        }
    }
}

class Main {
    public static void main(String[] args) {
      /* TASK 1  */
        // ссылочный Числовой массив
        Integer [] arrays = {1,2,3,4,5};
    Arrays<Integer> integerArrays = new Arrays<Integer>(arrays);
    integerArrays.changesElementsArray(arrays,1,4);
        integerArrays.printGenerics(arrays);
        // ссылочный Строковый массив
    String [] arrays2 = {"ASD","ZXC","QWE","RFV","BGT"};
        Arrays<String> stringArrays = new Arrays<String>(arrays2);
        stringArrays.changesElementsArray(arrays2,3,1);
        stringArrays.printGenerics(arrays2);

      /* TASK 2   */
        // преобразование массива в ArrayList
        integerArrays.convertsArrayList(arrays);
        stringArrays.convertsArrayList(arrays2);
   }

}
