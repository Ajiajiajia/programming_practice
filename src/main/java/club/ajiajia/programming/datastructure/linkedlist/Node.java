package club.ajiajia.programming.datastructure.linkedlist;

/**
 * 基础链表 - 节点 (元素)
 * @author ajiajia
 */
public class Node {

    /*
     * Notice: 区分清楚Node和其内部的value，
     * 回答在链表中"元素(节点)"和"值"有什么区别呢？
     */

    /**
     * 当前节点值
     */
    private int value;

    /**
     * 指向下一个节点的引用
     */
    private Node next;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
            "value=" + value +
            ", next=" + next +
            '}';
    }
}
