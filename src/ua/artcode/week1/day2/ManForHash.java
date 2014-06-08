package ua.artcode.week1.day2;

/**
 * Created by amakogon on 08.06.2014.
 */
public class ManForHash {

    private String name;
    private int age;

    public ManForHash(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int hashCode() {
        int hash = 17;
        hash = 31 * hash + age;
        hash = (31 * hash) + ((name != null) ? name.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(obj == null) {
            return false;
        }

        if(obj.getClass() != ManForHash.class){
            return false;
        }
        ManForHash man = (ManForHash) obj;

        return name != null && name.equals(man.name) && age == man.age;
    }

    @Override
    public String toString() {
        return "ManForHash{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
