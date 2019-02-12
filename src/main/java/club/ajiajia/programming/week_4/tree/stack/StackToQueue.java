package club.ajiajia.programming.week_4.tree.stack;

import java.util.Stack;

public class StackToQueue {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    //队列尾部插入结点
    public void push(int node) {
        stack1.push(node);
    }

    //队列头部删除结点
    public int pop() {
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        int first=stack2.pop();
        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        return first;
    }
    public static void main(String[] args) throws Exception {
        StackToQueue test = new StackToQueue();
        test.push(1);
        System.out.println(test.pop());
////        test.pop();
        test.push(2);
        test.push(3);
        System.out.println(test.pop());


    }

}
