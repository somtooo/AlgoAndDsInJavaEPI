package stacksandqueues;
import java.util.NoSuchElementException;

public class CircularQueue {
  private int start;
  private int end;
  private int[] body;

  public CircularQueue(int capacity ) {
    this.body = new int[capacity];
    this.start = 0;
    this.end = 0;
  }

  public void enqueue(int data) {
    if (end >= this.body.length) {
      this.body = resizeArray(this.body, this.body.length *2);
    }
    this.body[end] = data;
    end++;
  }

  public int dequeue() {
    if (start == end) {
      throw new NoSuchElementException("Queue is empty");
    }
    var ans = this.body[start];
    start++;
    return ans;
  }

  public int numOfElementsStored() {
    return (end - start);
  }

  private  int[] resizeArray (int[] oldArray, int newSize) {
    int oldSize = java.lang.reflect.Array.getLength(oldArray);
    int[] newArray = new int[newSize];
    int preserveLength = Math.min(oldSize, newSize);
    if (preserveLength > 0)
      System.arraycopy(oldArray, 0, newArray, 0, preserveLength);
    return newArray;
  }

  public static void main(String[] args) {
    var q = new CircularQueue(5);
    q.enqueue(1);
    q.enqueue(2);
    q.enqueue(3);
    q.enqueue(4);
    q.enqueue(5);
    q.enqueue(6);

    for (int i = 0; i < 6; i++) {
      System.out.println(q.dequeue());

    }
  }
}
