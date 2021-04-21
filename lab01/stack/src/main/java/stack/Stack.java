package stack;

import java.util.NoSuchElementException;

public class Stack {

  int[] arr;
  int top;
  int capacity;

  public Stack(int size) {
    this.arr = new int[size];
    this.capacity = size;
    this.top = -1;
  }

  public boolean isEmpty() {
    if (top < 0) {
      return true;
    }
    return false;
  }

  public void push(int element) {
    System.out.println(this.arr);
    System.out.println(this.top);
    this.arr[++this.top] = element;
  }

  public int pop() {
    if (this.size() == 0) {
      throw new NoSuchElementException("you can not pop from a empty stack.");
    }
    int removed = this.arr[this.top];
    this.top--;
    return removed;
  }

  public int size() {
    return this.top + 1;
  }

  public int peek() {
    return this.arr[this.top];
  }
}
