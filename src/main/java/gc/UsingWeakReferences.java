package gc;

import java.lang.ref.WeakReference;

public class UsingWeakReferences {

    public static void main(String[] args) {
        Employee employee = new Employee();
        System.out.println(employee);
        WeakReference<Employee> wr = new WeakReference<>(employee);
        Employee ewr1 = wr.get();
        System.out.println(ewr1);

        employee = null;
        System.out.println(ewr1);
        Employee ewr2 = wr.get();
        System.out.println(ewr2);

        ewr1 = null;
        ewr2 = null;
        System.gc();
        Employee ewr3 = wr.get();
        System.out.println(ewr3);

    }

}

class Employee{

}
