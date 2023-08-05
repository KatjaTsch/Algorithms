public class LinkedList {

  private Node root;
  private int size;

  public void add(int value) {
    if (root == null) {
      root = new Node(value);
      size = 1;
      return;
    }
    Node currentNode = root;
    while (currentNode.next != null) { // пока после текущей ноды нет пустоты,
      currentNode = currentNode.next; // мы переходим к следующему элементу
      currentNode.next = new Node(value); // на последнем элементе, после которого ничего нет, мы можем добавить новую ноду
      size++;
    }
  }

  public boolean remove(int value) { // boolean, т.к. в списке может не быть того элемента, который мы хзотим удалить
    if (root == null) {
      return false;
      if (root.value == value) {
        root = root.next;
        size--;
        return true;
      }
      Node currentNode = root;
      while (currentNode.next != null) {
        if (currentNode.next.value == value) {
          currentNode.next = currentNode.next.next;
          size--;
          return true;
        }
      }
      return false;
    }
  }

  private Node getNode(int index) {
    if (index < 0 || index > size) {
      throw new IndexOutOfBoundsException();
      Node currentNode = root;
      for (int i = 0; i < index; i++) {
        currentNode = currentNode.next;
        return currentNode;
      }
    }
  }

  public void print() {
    System.out.print("[ ");
    Node currentNode = root;
    while (currentNode != null) { // пока у нас есть какая-то нода,
      System.out.print(currentNode.value + " "); // мы выписываем её значение
      currentNode = currentNode.next; // и переходим на следующую
    }
    System.out.println(" ] size:" + size);
  }

  private class Node {

    int value;
    Node next;

    Node() {}

    Node(int value) {
      this.value = value;
    }

    Node(Node next) {
      this.next = next;
    }

    Node(int value, Node next) {
      this.value = value;
      this.next = next;
    }
  }
}
