import java.util.*;

public class MyDeque<E>{
  private E[] data;
  private int size, start, end;

  public static void main(String[] args) {
    MyDeque<String> test = new MyDeque<String>(10);
    //System.out.println(test.toStringDebug());
    for (Integer x = 0; x < 13; x ++) {
      test.addFirst(x + "");
      //System.out.println(x + "");
    }
    System.out.println(test);
  }

  @SuppressWarnings("unchecked")
  public MyDeque() {
    data = (E[])new Object[10];
    size = 0;
  }

  @SuppressWarnings("unchecked")
  public MyDeque(int initialCapacity) {
    data = (E[])new Object[initialCapacity];
    //System.out.println(printArr(data));
    size = 0;
  }

  public int size() {
    return alteredMod(end - start);
  }

  private String printArr(E[] arr) {
    String output = "";
    for (E x: arr) {
      output += x + " ";
    }
    return output;
  }

  public String toString() {
    //System.out.println("Start: " + start);
    //System.out.println("End: " + end);
    //System.out.println(printArr(data));
    String output = "{";
    for (int x = 0; x < size; x ++) {
      output += data[(start + x) % data.length] + " ";
    }
    output += "}";
    return output;
  }

  public String toStringDebug() {
    String output = "";
    for(int x = 0; x < data.length; x ++) {
      output += data[x] + " ";
      //System.out.println(data[counter]);
    }
    return output;
  }

  public void addFirst(E element) {
    //System.out.println("ADDING: " + element + " SIZE: " + size + " START: " + start + " END: " + end);
    //System.out.println(printArr(data) + "\n");
    if (element == null) throw new NullPointerException();
    if (size >= data.length - 1) resize();
    start = alteredMod(start - 1);
    data[start] = element;
    size ++;
  }

  private void resize() {
    @SuppressWarnings("unchecked")
    E[] temp = (E[])new Object[data.length * 2 + 1];
    for (int x = 0; x < data.length; x ++) {
      temp[x] = data[(start + x) % data.length];
    }
    end = size;
    start = 0;
    data = temp;
  }

  private int alteredMod(int input) {
    return (input + data.length) % data.length;
  }

  public void addLast(E element) {
    if (element == null) throw new NullPointerException();
    if (size >= data.length - 1) resize();
    data[end] = element;
    end = (end + 1) % data.length;
    size ++;
  }

  public E removeFirst() {
    if (size == 0) throw new NoSuchElementException();
    start = (start + 1) % data.length;
    size --;
    return data[alteredMod(start - 1)];
  }

  public E removeLast() {
    //System.out.println("Start: " + start + "End: " + end);
    if (size == 0) throw new NoSuchElementException();
    end = alteredMod(end - 1);
    size --;
    //System.out.println("Output: " + data[(end + 1) % data.length]);
    int index = (end + 1) % data.length - 1;
    if (index < 0) index = data.length - 1;
    return data[index];
  }

  public E getFirst() {
    if (size == 0) throw new NoSuchElementException();
    return data[start];
  }

  public E getLast() {
    if (size == 0) throw new NoSuchElementException();
    if (end == 0) return data[data.length - 1];
    return data[end - 1];
  }
}
