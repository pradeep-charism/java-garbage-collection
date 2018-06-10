package gc;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.List;

public class UsingPhantomReferences {

    public static void main(String[] args) {
        ReferenceQueue<Person> referenceQueue = new ReferenceQueue<>();
        List<FinalizePerson> phanthomReferences = new ArrayList<>();

        List<Person> people = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            Person p = new Person();
            people.add(p);
            phanthomReferences.add(new FinalizePerson(p, referenceQueue));
        }

        people = null;

        for (FinalizePerson finalizePerson: phanthomReferences){
            System.out.println("Before GC: "+finalizePerson.isEnqueued());
        }

        System.gc();

        for (FinalizePerson finalizePerson: phanthomReferences){
            System.out.println("After GC: "+finalizePerson.isEnqueued());
        }

        Reference<? extends Person> queue;
        while ((queue = referenceQueue.poll()) != null){
            ((FinalizePerson) queue).cleanUp();
        }

    }

}

class FinalizePerson extends PhantomReference<Person> {

    /**
     * Creates a new phantom reference that refers to the given object and
     * is registered with the given queue.
     *
     * <p> It is possible to create a phantom reference with a <tt>null</tt>
     * queue, but such a reference is completely useless: Its <tt>get</tt>
     * method will always return null and, since it does not have a queue, it
     * will never be enqueued.
     *
     * @param referent the object the new phantom reference will refer to
     * @param q        the queue with which the reference is to be registered,
     */
    public FinalizePerson(Person referent, ReferenceQueue<? super Person> q) {
        super(referent, q);
    }

    public void cleanUp(){
        System.out.println("Finalize Person invoked. Cleaning in progress...");
    }
}
