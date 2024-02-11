package workingWithFilesAndAPIs.ComparableComparator;

import java.util.Arrays;
import java.util.Comparator;

public class Dispatcher {
    public static void main(String[] args) {
    Dog[] arr = {new Dog("Mark", 11, "Black"),
                 new Dog("Abba", 7, "White"),
                 new Dog("Bee", 1, "Gold"),
                 new Dog("Abba", 5, "White")};
        System.out.println(Arrays.toString(arr));
    Arrays.sort(arr, new CompareByAge());
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr, new Comparator<Dog>() {
            @Override
            public int compare(Dog o1, Dog o2) {
                return ((Dog)o1).color.compareTo(((Dog)o2).color);
            }
        });
        System.out.println(Arrays.toString(arr));
    }

}

class Dog implements Comparable {
    String name;
    int age;
    String color;

    Dog(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    @Override
    public int compareTo(Object o) {
        int result = this.name.compareTo(((Dog)o).name);
        if (result != 0) {
            return result;
        } else {
            result = this.age - ((Dog) o).age;
            if (result != 0) {
                return result;
            } else {
                return this.color.compareTo(((Dog) o).color);
            }
        }
    }
    @Override
    public String toString(){
        return this.name + " " + this.age + " " + this.color;
    }
}
class CompareByName implements Comparator{
    @Override
    public int compare(Object o1, Object o2) {
        return ((Dog)o1).name.compareTo(((Dog)o2).name);
    }
}
class CompareByAge implements Comparator{
    @Override
    public int compare(Object o1, Object o2) {
        return ((Dog)o2).age - ((Dog)o1).age;
    }
}

