class LinkedList {
    private Node head;

    public LinkedList() {

    }

    public static int counter;
    public static int getCounter() {
        return counter;
    }
    public void increement(){
        counter++;
    }
    public void decreement(){
        counter--;
    }

    public int size(){
        return getCounter();
    }


    // appends the specified element to the end of this list.
    public void append(Object data) {

        // Initialize Node only incase of 1st element
        if (head == null) {
            head = new Node(data);
        }

        Node end = new Node(data);
        Node n = head;

        // Let's check for NPE before iterate over Current
        if (n != null) {

            // starting at the head node, crawl to the end of the list and then add element after last node
            while (n.getNext() != null) {
                n=n.getNext();
            }

            // the last node's "next" reference set to our new node
            n.setNext(end);
        }
        increement();

    }

    public boolean remove(int index) {

        if(index < 1 || index > size()){
            return false;
        }

        Node current = head;

        if(head!=null){
            for(int i = 0;i<index;i++){
                if(current.getNext()==null){
                    return false;
                }
                current=current.getNext();
            }
            current.setNext(current.getNext().getNext());
            decreement();
            return true;
        }
        return false;
    }


    public String toString() {
        String output = "";

        if (head != null) {
            Node crunchifyCurrent = head.getNext();
            while (crunchifyCurrent != null) {
                output += "[" + crunchifyCurrent.getData().toString() + "]";
                crunchifyCurrent = crunchifyCurrent.getNext();
            }

        }
        return output;
    }

    class Node {
        // reference to the next node in the chain, or null if there isn't one.
        private Node next;

        // data carried by this node. could be of any type you need.
        private Object data;

        // Node constructor
        public Node(Object data) {
            this.data = data;
            next=null;
        }

        public Object getData() {
            return data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

    }
}

public class LinkedListTest {
    public static LinkedList LinkedList;

    public static void main(String[] args) {

        // Default constructor - let's put "0" into head element.
        LinkedList = new LinkedList();

        // add more elements to LinkedList

        LinkedList.append("1");
        LinkedList.append("2");
        LinkedList.append("3");

        System.out.println("Print: crunchifyList: \t\t" + LinkedList);
        System.out.println(".remove(2): \t\t\t\t" + LinkedList.remove(2) + " (element removed)");
        System.out.println("Print: crunchifyList: \t\t" + LinkedList);
    }
}
