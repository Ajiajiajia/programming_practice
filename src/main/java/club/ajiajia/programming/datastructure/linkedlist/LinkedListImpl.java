package club.ajiajia.programming.datastructure.linkedlist;

/**
 * 基本链表实现
 * @author ajiajia
 */
public class LinkedListImpl implements LinkedList {

    /**
     * 链表的头节点，不储存值
     */
    private Node head;

    public LinkedListImpl(Node head) {
        // 构造函数，初始化时要求必须出入一个head节点，否则无法正常工作
        this.head = head;
    }

    public void add(int val) {
        // 示例，在尾部插入一个值
        // 1. 先判空检查！看看头节点是否为空
        if (head == null) {
            // 报错并返回
            System.out.println("发生错误，当前链表头结点为空！");
            return;
        }
        // 2. 为这个值创建一个包裹它的节点（元素）
        Node node = new Node();
        node.setValue(val);
        // 3. 找到尾部, 可以把walker想象成一个游标
        Node walker = head;
        // 想想为什么不能用 walker != null 判断？
        while (walker.getNext() != null) {
            // 只要walker的后一个节点不为空，就说明walker还没有移动到尾节点，继续向后移动
            walker = walker.getNext();
        }
        // 4. 循环结束后walker就是尾部节点，把刚才创建好的新节点添加到它的next引用上即可
        walker.setNext(node);
    }

    public void remove(int index) {

    }

    public Node get(int index) {
        return null;
    }

    public void insert(int index, int val) {

    }

    public void replace(int index, int val) {

    }

    public void print() {
        // 打印链表内的元素
        if (head == null) {
            // 报错并返回
            System.out.println("发生错误，当前链表头结点为空！");
            return;
        }
        // 注意体会这里循环的条件和add方法不一样的地方
        Node walker = head.getNext();
        int i = 0;
        while (walker != null) {
            System.out.println("第" + (++i) + "个值为: " + walker.getValue());
            walker = walker.getNext();
        }
    }

    public static void main(String[] args) {
        // main函数，在这里运行你的代码
        // 完成上面的方法后，在这里尝试创建一个链表，验证你的代码：
        // 依次插入(add)三个值1，2，3
        // 然后在第二个位置插入(insert)一个值4，打印结果应为1,4,2,3
        // 删除(remove)第三个位置的值，打印结果应为：1,4,3
        // 替换(replace) 第一个位置的值为2，打印结果应为：2,4,3
    }
}
