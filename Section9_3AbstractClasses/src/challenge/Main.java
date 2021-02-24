package challenge;

public class Main {
    public static void main(String[] args) {
        /*MyLinkedList list = new MyLinkedList(null);
        list.traverse(list.getRoot());

        String stringData = "Darwin Brisbane Perth Melbourne Canberra Adelaide Sydney Canberra";
        for (String cityName : stringData.split(" ")) {
            list.addItem(new Node(cityName));
        }

        list.traverse(list.getRoot());

        MyLinkedList numberList = new MyLinkedList(null);
        String numberData = "5 7 3 9 8 2 1 0 4 6";
        for (String number : numberData.split(" ")) {
            numberList.addItem(new Node(number));
        }

        numberList.traverse(numberList.getRoot());
        numberList.removeItem(new Node("3"));
        numberList.traverse(numberList.getRoot());

        numberList.removeItem(new Node("3"));
        numberList.traverse(numberList.getRoot());*/

        SearchTree tree = new SearchTree(null);
        tree.traverse(tree.getRoot());

        String stringData = "Darwin Brisbane Perth Melbourne Canberra Adelaide Sydney Canberra";
        for (String cityName : stringData.split(" ")) {
            tree.addItem(new Node(cityName));
        }

        tree.traverse(tree.getRoot());
    }
}
