package stack;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

public class StackTest {

  @Test
  public void testIsEmptyOnConstruction() {
    Stack stack = new Stack(10);
    boolean isEmpty = stack.isEmpty();
    assertTrue(isEmpty, "isEmpty should return true with a newly created stack");
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

    assertFalse(isEmpty, "stack with one element should return false");
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

    assertTrue(stack.isEmpty(), "stack should be empty after stack.size() pops");
    assertEquals(0, stack.size());
  }

  @Test
  public void testPoppingEmptyStack() {
    assertThrows(NoSuchElementException.class, () -> {
      Stack stack = new Stack(10);
      stack.pop();
    });
  }
}
