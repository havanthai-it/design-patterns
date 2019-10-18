package creational.prototype;

public class Prototype {
    public static void main(String[] args) {
        Person person1 = new Person("Thai", 22);
        Person person2 = person1.clone();

        System.out.println(person1.toString());
        System.out.println(person2.toString());
    }
}

class Person implements Cloneable {
    private String name;
    private int age;

    public Person (String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    public Person clone() {
        Person clone = null;
        try {
            clone = (Person) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }

    @Override
    public String toString() {
        return String.format("%s - %d", name, age);
    }
}
