package club.ajiajia.programming.datastructure.linkedlist;

/**
 * 基础链表 - 操作抽象 （整型）
 * @author ajiajia
 */
public interface LinkedList {

    /**
     * 在尾部增加一个值
     * @param val 要增加的值
     */
    void add(int val);

    /**
     * 删除指定位置的元素
     * @param index 要删除的元素在链表中所处的位置
     */
    void remove(int index);

    /**
     * 获取指定位置的元素
     * @param index 要插入元素的位置
     * @return
     */
    Node get(int index);

    /**
     * 在指定位置插入一个值
     * @param index 要插入的位置
     * @param val 要插入的值
     */
    void insert(int index, int val);

    /**
     * 替换指定位置元素的值
     * @param index 要替换的元素所在的位置
     * @param val 要更新的值
     */
    void replace(int index, int val);

    /**
     * 打印链表内容
     */
    void print();
}
