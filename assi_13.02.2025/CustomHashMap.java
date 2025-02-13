class CustomHashMap {
    private static class Node {
        int key, value;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    private static final int SIZE = 1000;
    private Node[] map;
    public CustomHashMap() {
        map = new Node[SIZE];
    }
    private int hash(int key) {
        return key % SIZE;//indices
    }
    public void put(int key, int value) {
        int index = hash(key);
        if (map[index] == null) {
            map[index] = new Node(key, value);
            return;
        }
        Node current = map[index];
        while (true) {
            if (current.key == key) {
                current.value = value;
                return;
            }
            if (current.next == null) break;
            current = current.next;
        }
        current.next = new Node(key, value);
    }
    public int get(int key) {
        int index = hash(key);
        Node current = map[index];
        while (current != null) {
            if (current.key == key) return current.value;
            current = current.next;
        }
        return -1;
    }
    public void remove(int key) {
        int index = hash(key);
        Node current = map[index], prev = null;
        while (current != null) {
            if (current.key == key) {
                if (prev == null) map[index] = current.next;
                else prev.next = current.next;
                return;
            }
            prev = current;
            current = current.next;
        }
    }
    public static void main(String[] args) {
        CustomHashMap mpp = new CustomHashMap();
        mpp.put(1, 10);
        mpp.put(2, 20);
        System.out.println(mpp.get(1));
        mpp.remove(2);
        System.out.println(mpp.get(2));
    }
}
