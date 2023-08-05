public void revert() {
    Node node = head;
    Node temp = head;
    head = tail;
    tail = temp;

    while(node.nextNode != null){
        temp = node.nextNode;
        node.nextNode = node.previousNode;
        node.previousNode = temp;
        node = node.previousNode;

    }
}