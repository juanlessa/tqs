package stack;

import static org.junit.Assert.*;

import org.junit.Test;

public class StackTest {

  @Test
  public void testIsEmptyOnConstruction() {
    Stack stack = new Stack(10);
    boolean isEmpty = stack.isEmpty();
    assertTrue(
      "isEmpty should return true with a newly created stack",
      isEmpty
    );
  }

  @Test
  public void testSizeOnConstruction() {
    Stack stack = new Stack(10);
    int size = stack.size();
    assertEquals(0, size);
  }

  @Test
  public void testSizeAfterNPushes() {
    Stack stack = new Stack(10);
    stack.push(1);
    stack.push(7);
    stack.push(5);
    int size = stack.size();

    assertEquals(3, size);
  }

  @Test
  public void testIsEmptyAfterNPushes() {
    Stack stack = new Stack(10);
    stack.push(1);
    boolean isEmpty = stack.isEmpty();

    assertFalse("stack with one element should return false", isEmpty);
  }

  @Test
  public void testPopAfterPush() {
    Stack stack = new Stack(10);
    int expected = 5;
    stack.push(expected);
    int poped = stack.pop();

    assertEquals(expected, poped);
  }

  @Test
  public void testSizeStaySameAfterPeek() {
    Stack stack = new Stack(10);
    stack.push(1);
    int sizeBeforePeek = stack.size();
    stack.peek();
    int sizeAfterPeek = stack.size();

    assertEquals(sizeBeforePeek, sizeAfterPeek);
  }

  @Test
  public void testPeekAfterPush() {
    Stack stack = new Stack(10);
    int expected = 5;
    stack.push(expected);
    int peeked = stack.peek();

    assertEquals(expected, peeked);
  }

  @Test
  public void testAfterNPops() {
    Stack stack = new Stack(10);
    stack.push(5);
    stack.push(5);
    stack.push(5);
    stack.push(5);
    int size = stack.size();
    for (int i = 0; i < size; i++) {
      stack.pop();
    }

    assertTrue(
      "stack should be empty after stack.size() pops",
      stack.isEmpty()
    );
    assertEquals(0, stack.size());
  }

  @Test
  public void testPoppingEmptyStack() {
    Stack stack = new Stack(10);
    stack.pop();
    //assertThrows(
    //  NoSuchElementException.class,
    //  () -> {}
    //);
  }
}
