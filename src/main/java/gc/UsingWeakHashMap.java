package gc;

import java.util.Date;
import java.util.WeakHashMap;

public class UsingWeakHashMap {

    public static void main(String[] args) {
        Person p = new Person();
        WeakHashMap<Person, PersonMetada> weakHashMap = new WeakHashMap();
        PersonMetada value = new PersonMetada();
        weakHashMap.put(p, value);

        System.out.println("Person present in weakhashmap: "+weakHashMap.containsKey(p));
        p= null;
        System.gc();
        System.out.println("Person present in weakhashmap: "+weakHashMap.containsKey(p));
    }
}

