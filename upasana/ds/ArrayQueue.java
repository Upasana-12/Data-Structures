package upasana.ds;
public class ArrayQueue<E> implements Queue<E> 
{
  // instance variables
  /** Default array capacity. */
  public static final int CAPACITY = 1000;      // default array capacity

  /** Generic array used for storage of queue elements. */
  private E[] data;                             // generic array used for storage

  /** Index of the top element of the queue in the array. */
  private int f = -1;                            // index of the front element
  private int r = -1; 

  /** Current number of elements in the queue. */
  private int sz = 0;                           // current number of elements

  // constructors
  /** Constructs an empty queue using the default array capacity. */
  public ArrayQueue() 
  { 
    int f=-1;
    int r=-1;
    data = (E[]) new Object[CAPACITY];

  }         // constructs queue with default capacity

  /**
   * Constructs and empty queue with the given array capacity.
   * @param capacity length of the underlying array
   */
  @SuppressWarnings({"unchecked"})
  public ArrayQueue(int capacity) 
  { 
    data = (E[]) new Object[capacity];
  }

  // methods
  /**
   * Returns the number of elements in the queue.
   * @return number of elements in the queue
   */
  @Override
  public int size() 
  { 
    return sz;
  }

  /** Tests whether the queue is empty. */
  @Override
  public boolean isEmpty() 
  { 
    return sz==0;
  }

  /**
   * Inserts an element at the rear of the queue.
   * This method runs in O(1) time.
   * @param e   new element to be inserted
   * @throws IllegalStateException if the array storing the elements is full
   */
  @Override
  public void enqueue(E e) throws IllegalStateException 
  {
    if(sz!=CAPACITY)
    {
      if(f==-1 && r==-1)
      {
        r++;
        f++;
      }
      else
      r++;
      data[r]=e;
      sz++;
    }
  }

  /**
   * Returns, but does not remove, the first element of the queue.
   * @return the first element of the queue (or null if empty)
   */
  @Override
  public E first() 
  {
    if(sz==0)
    return null;
    return data[f];
  }

  /**
   * Removes and returns the first element of the queue.
   * @return element removed (or null if empty)
   */
  @Override
  public E dequeue() 
  {
    if(sz==0)
    return null;
    sz--;
    return data[f++];
  }

  /**
   * Returns a string representation of the queue as a list of elements.
   * This method runs in O(n) time, where n is the size of the queue.
   * @return textual representation of the queue.
   */
  public String toString() 
  {
    int i=f;
    StringBuilder s = new StringBuilder("(");
    while(i<=r)
    {
      s.append(data[i]);
      s.append(" ");
      i++;
    }
    s.append(")");
    return s.toString();
  }

  public static void main(String[] args) {
    Queue<Integer> S = new ArrayQueue<>();  // contents: ()
    S.enqueue(5);                              // contents: (5)
    S.enqueue(3);                              // contents: (5, 3)
    System.out.println(S.size());           // contents: (5, 3)     outputs 2
    System.out.println(S.dequeue());            // contents: (5)        outputs 3
    System.out.println(S.isEmpty());        // contents: (5)        outputs false
    System.out.println(S.dequeue());            // contents: ()         outputs 5
    System.out.println(S.isEmpty());        // contents: ()         outputs true
    System.out.println(S.dequeue());            // contents: ()         outputs null
    S.enqueue(7);                              // contents: (7)
    S.enqueue(9);                              // contents: (7, 9)
    //System.out.println(S.top());            // contents: (7, 9)     outputs 9
    S.enqueue(4);                              // contents: (7, 9, 4)
    System.out.println(S.size());           // contents: (7, 9, 4)  outputs 3
    System.out.println(S.dequeue());            // contents: (7, 9)     outputs 4
    S.enqueue(6);                              // contents: (7, 9, 6)
    S.enqueue(8);                              // contents: (7, 9, 6, 8)
    System.out.println(S.dequeue());            // contents: (7, 9, 6)  outputs 8
    System.out.println(S.toString());
  }
}