package main;

import java.util.*;

public class MainClass {
    private static Person person = new Person(24, "Petr", "2222");

    public static void main(String[] args) {

        //ArrayList vs LinkedList
        List<Person> arrayList = new LinkedList<>();
        List<Person> linkedList = new LinkedList<>();

        //measureListAdding(arrayList, 100000, "begin");
        //System.out.println(arrayList.size());

        //measureListRemoving(arrayList, 100000, "end");
        //System.out.println(arrayList.size());

        //HashSet, LinkedHashSet, TreeSet

        Set<Integer> hashSet = new HashSet<>();
        Set<Person> linkedHashSet = new LinkedHashSet<>();
        Set<Integer> treeSet = new TreeSet<>();

        //measureSetAdding(hashSet, 100000);
        //System.out.println(hashSet.size());

        //measureSetRemoving(hashSet,10000);
        //System.out.println(hashSet.size());

        //HashMap, LinkedHashMap, TreeMap

        Map<Integer, Person> hashMap = new HashMap<>();
        Map<Integer, Person> linkedHashMap = new LinkedHashMap<>();
        Map<Integer, Person> treeMap = new TreeMap<>();

        //measureMapAdding(hashMap, 100000);
        //System.out.println(hashMap.size());

        //measureMapRemoving(hashMap, 100000);
        //System.out.println(hashMap.size());


    }

    public static void measureListAdding(List<Person> list, int operationQuantity, String where) {
        long start = 0;
        long finish = 0;
        long elapsed;

        if ("begin".equals(where)) {
            //to begin
            start = System.nanoTime();
            for (int i = 0; i < operationQuantity; i++) {
                list.add(i, person);
            }
            finish = System.nanoTime();
        }

        if ("middle".equals(where)) {
            //to middle
            int fromIndex = list.size() / 2;
            start = System.nanoTime();
            for (int i = fromIndex; i < fromIndex + operationQuantity; i++) {
                list.add(i, person);
            }
            finish = System.nanoTime();
        }

        if ("end".equals(where)) {
            //to end
            start = System.nanoTime();
            for (int i = 0; i < operationQuantity; i++) {
                list.add(person);
            }
            finish = System.nanoTime();
        }
        elapsed = finish - start;
        System.out.println("Time for adding/inserting "
                + operationQuantity + " elements to "
                + where + " of " + list.getClass() + ": "
                + elapsed / 1_000_000d);

    }

    public static void measureListRemoving(List<Person> list, int operationQuantity, String from) {
        long start = 0;
        long finish = 0;
        long elapsed;

        if ("begin".equals(from)) {
            //from begin
            start = System.nanoTime();
            for (int i = 0; i < operationQuantity; i++) {
                list.remove(0);
            }
            finish = System.nanoTime();
        }

        if ("middle".equals(from)) {
            //from middle
            int fromIndex = list.size() / 2;
            start = System.nanoTime();
            for (int i = fromIndex; i < fromIndex + operationQuantity; i++) {
                list.remove(fromIndex);
            }
            finish = System.nanoTime();
        }

        if ("end".equals(from)) {
            int fromIndex = list.size() - 1;
            start = System.nanoTime();
            for (int i = fromIndex; i > fromIndex - operationQuantity; i--) {
                list.remove(i);
            }
            finish = System.nanoTime();
        }
        elapsed = finish - start;
        System.out.println("Time for removing "
                + operationQuantity + " elements from "
                + from + " of " + list.getClass() + ": "
                + elapsed / 1_000_000d);

    }

    public static void measureSetAdding(Set<Integer> set, int operationQuantity) {

        long start = System.nanoTime();
        for (int i = 0; i < operationQuantity; i++) {
            set.add((operationQuantity-1-i));

            //for random element
            //set.add((operationQuantity-i) * new Random().nextInt(operationQuantity));
        }
        long finish = System.nanoTime();
        System.out.println("Time for adding "
                + operationQuantity + " elements to "
                + set.getClass() + ": "
                + ((finish - start)/ 1_000_000d));

    }

    public static void measureSetRemoving(Set<Integer> set, int operationQuantity) {
        long start = System.nanoTime();
        for (int i = 0; i < operationQuantity; i++) {
            set.remove(i);
        }
        long finish = System.nanoTime();
        System.out.println("Time for removing "
                + operationQuantity + " elements from "
                + set.getClass() + ": "
                + ((finish - start)/ 1_000_000d));

    }

    public static void measureMapAdding(Map<Integer, Person> map, int operationQuantity) {

        long start = System.nanoTime();
        for (int i = 0; i < operationQuantity; i++) {
            map.put(operationQuantity -1 - i, new Person(i, "Petr" + i, "2222"));
        }
        long finish = System.nanoTime();
        System.out.println("Time for adding "
                + operationQuantity + " elements to "
                + map.getClass() + ": "
                + ((finish - start)/ 1_000_000d));
    }

    public static void measureMapRemoving(Map<Integer, Person> map, int operationQuantity) {
        long start = System.nanoTime();
        for (int i = 0; i < operationQuantity; i++) {
            map.remove(i);
        }
        long finish = System.nanoTime();
        System.out.println("Time for removing "
                + operationQuantity + " elements to "
                + map.getClass() + ": "
                + ((finish - start)/ 1_000_000d));
    }


}
