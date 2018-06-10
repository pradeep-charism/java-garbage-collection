package gc;

import java.lang.management.ManagementFactory;
import java.util.Arrays;
import java.util.List;

public class GarbageCollectorMXBeanExample {

    public static void main(String[] args) {
        List<java.lang.management.GarbageCollectorMXBean> garbageCollectorMXBeans = ManagementFactory.getGarbageCollectorMXBeans();
        garbageCollectorMXBeans.stream().forEach(e -> {
            System.out.println(e.getCollectionCount());
            System.out.println(e.getCollectionTime());
            System.out.println(e.getName());

            String[] memoryPoolNames = e.getMemoryPoolNames();
            Arrays.asList(memoryPoolNames).stream().forEach(k -> System.out.println(k.getBytes()));
        });
    }
}
