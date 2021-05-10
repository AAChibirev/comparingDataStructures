package main;

public class Person implements Comparable{

    private int age;
    private String name;
    private String passport;

    public Person(int age, String name, String passport) {
        this.age = age;
        this.name = name;
        this.passport = passport;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (this.getClass() != obj.getClass()) return false;

        Person person = (Person)obj;

        return this.age == person.age
                && this.name.equals(person.name)
                && this.passport.equals(person.passport);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + name.hashCode();
        result = 31 * result + age;
        result = 31 * result + passport.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", passport='" + passport + '\'' +
                '}';
    }

    @Override
    public int compareTo(Object obj) {
        //this < obj = -1
        Person another = (Person) obj;
        return this.age - another.age;
    }
}

