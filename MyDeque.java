public class MyDeque<E>{
  private E[] data;
  private int size, start, end;

  @SuppressWarnings("unchecked")
  public MyDeque() {
    data = (E[])new Object[10];
    size = 0;
    start = 0;
    end = 0;
  }

  @SuppressWarnings("unchecked")
  public MyDeque(int initialCapacity) {
    data = (E[])new Object[initialCapacity];
    size = 0;
    start = 0;
    end = 0;
  }

  public int size() {
    return size;
  }
/*
  public String toString() {

  }
*/
  public void addFirst(E element) {
    if(start == 0) {
      start = data.length - 1;
      data[start] = element;
    }
    else if (start == end && size > 0) {
      @SuppressWarnings("unchecked")
      E[] replacement = (E[])new Object[size * 2];
      resize(data, replacement);
      data = replacement;
      addFirst(element);
    }
    else {
      data[start] = element;
      start --;
    }
  }

  private void resize(E[] small, E[] large) {
    int x = start;
    for (int counter = 0; counter < size; counter ++) {
      if (x == small.length) {
        x = 0;
      }
      large[counter] = small[x];
      x ++;
    }
    start = 0;
    end = size;
  }
/*
  public void addLast(E element) {

  }

  public E removeFirst() {

  }

  public E removeLast() {

  }
*/
  public E getFirst(E element) {
    return data[start];
  }

  public E getLast(E element) {
    if (end == 0) return data[data.length - 1];
    return data[end - 1];
  }
}
