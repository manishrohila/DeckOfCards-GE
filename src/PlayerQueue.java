public class PlayerQueue {
    private Node front;
    private Node rear;

    private class Node {
        Player data;
        Node next;

        Node(Player data) {
            this.data = data;
            this.next = null;
        }
    }

    public void enqueue(Player data) {
        Node newNode = new Node(data);
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    public Player dequeue() {
        if (front == null) return null;
        Player data = front.data;
        front = front.next;
        if (front == null) rear = null;
        return data;
    }

    public boolean isEmpty() {
        return front == null;
    }
}
