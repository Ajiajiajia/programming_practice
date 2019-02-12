package club.ajiajia.programming.week_4.tree.LinkList;

import java.util.ArrayList;
import java.util.Stack;

class LinkNode{
    LinkNode next;
    int node_value;
}

//Solution 3
public class PrintListFromTailToHead {

    public ArrayList<Integer> printListFromTailToHead(LinkNode listNode) {

        Stack<Integer> stack = new Stack<Integer>();
        ArrayList<Integer> newList = new ArrayList<Integer>();
        LinkNode t = listNode;

        while( t != null ){

            stack.push(t.node_value);
            t = t.next;
        }
        while( !stack.empty() ){
            newList.add(stack.pop());
        }
        return newList;
    }

    public static void main(String[] args) {
        PrintListFromTailToHead plr=new PrintListFromTailToHead();
        LinkNode node1=new LinkNode();
        LinkNode node2=new LinkNode();
        LinkNode node3=new LinkNode();
        node1.node_value=1;
        node2.node_value=2;
        node3.node_value=3;
        node1.next=node2;
        node2.next=node3;
        plr.printListFromTailToHead(node1);
        }
}
