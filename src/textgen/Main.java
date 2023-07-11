package textgen;

public class Main {
    public static void main(String[] args) {
        MyLinkedList<String> list = new MyLinkedList<>();
        list.add("A");
        list.add("B");

        String elementAtIndex0 = list.get(0);
        System.out.println(elementAtIndex0); // Output: A

        String elementAtIndex1 = list.get(1);
        System.out.println(elementAtIndex1); // Output: B

        System.out.println(list.size());

        String removedElementAtIndex0 = list.remove(0);
        System.out.println(removedElementAtIndex0); // A

        System.out.println(list.size());
        System.out.println(list.toString());

        // Throws IndexOutOfBoundsException
//        String elementAtIndexInvalid = list.get(2);
//        System.out.println(elementAtIndexInvalid);

        MyLinkedList<Integer> linkedList = new MyLinkedList<>();

        // Add elements to the linked list
        linkedList.add(10);
        linkedList.add(20);
        linkedList.add(30);
        linkedList.add(40);

        // Test removing an element at a specific index
        linkedList.remove(2);  // Remove element at index 2

        // Verify the elements and size after removal
        System.out.println(linkedList);  // Should print: [10, 20, 40]
        System.out.println(linkedList.size());  // Should print: 3
        linkedList.add(69);
        System.out.println(linkedList);
        System.out.println(linkedList.size());
    }
}
