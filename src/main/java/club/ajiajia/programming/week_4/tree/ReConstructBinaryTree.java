package club.ajiajia.programming.week_4.tree;
/*
    Solution 4
 */


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
     TreeNode(int x) { val = x; }
}


public class ReConstructBinaryTree {
        public TreeNode reConstructBinaryTree(int [] pre,int [] in) {


//        int size=0;
//        size=pre.length;
////        List<Integer> preLeft=new ArrayList<Integer>();
////        List<Integer> preRight=new ArrayList<Integer>();
////        List<Integer> inLeft=new ArrayList<Integer>();
////        List<Integer> inRight=new ArrayList<Integer>();
//        int [] preLeft =new int[size];
//        int [] preRight=new int[size];
//        int [] inLeft=new int[size];
//        int [] inRight=new int[size];
//        int root=pre[0];
//        TreeNode node=new TreeNode(root);
//        int index;
//        for(index=0;index<size;index++){
//            if (in[index]==root){
//                break;
//            }
//        }
//        for (int j=0;j<size;j++){
//            if (j<index){
//                inLeft.add(in[j]);
//                preLeft.add(pre[j+1]);
//            }
//            else{
//                inRight.add(in[j]);
//                preRight.add(pre[j]);
//            }
//        }
//
//        node.left = reConstructBinaryTree(preLeft, inLeft);
//        node.right= reConstructBinaryTree(preRight, inRight);

            if(pre == null || in == null){
                return null;
            }
            TreeNode root = reConstructBinaryTree(pre,0,pre.length-1,in,0,in.length-1);
            return root;
        }
        private TreeNode reConstructBinaryTree(
        int[] pre,int startPre,int endPre,int[] in,int startIn,int endIn){
            if(startPre>endPre||startIn>endIn){
                return null;
            }
            //前序遍历的第一个数字是根节点的值
            TreeNode root = new TreeNode(pre[startPre]);
            //遍历中序数组，找到根节点的位置,创建左右子树
            for(int i = startIn;i <=endIn; i++){
                if(in[i]==pre[startPre]){
                    root.left = reConstructBinaryTree(pre,startPre+1,startPre+i-startIn,in,startIn,i-1);
                    root.right = reConstructBinaryTree(pre,startPre+i+1-startIn,endPre,in,i+1,endIn);
                }
            }
            return root;
        }
}

