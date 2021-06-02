public class Driver{
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.addAtIndex("A", 0);

        list.addAtIndex("B", 1);
        System.out.println("The Head is: "+list.getHead().getData());
        System.out.println("The Tail is: "+list.getTail().getData());
        list.addAtIndex("E", 0);
        list.addAtIndex("C", 2);
        list.addAtIndex("D", 1);
        System.out.println("The Head is: "+list.getHead().getData());
        System.out.println("The Tail is: "+list.getTail().getData());
        System.out.println("List is empty: "+list.isEmpty());
        System.out.println("List size: "+list.size());
        for (int i=0; i<list.size(); i++) {
            System.out.println(list.getAtIndex(i));
        }
        System.out.println("Removing :"+list.remove("B"));
        for (int i=0; i<list.size(); i++) {
            System.out.println(list.getAtIndex(i));
        }
        System.out.println("The Head is: "+list.getHead().getData());
        System.out.println("The Tail is: "+list.getTail().getData());
        System.out.println("List is empty: "+list.isEmpty());
        System.out.println("List size: "+list.size());
    }
}
