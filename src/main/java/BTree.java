 public class BTree {
    //二叉树结点
     static class TreeNode {
         private TreeNode left;//左子节点
         private TreeNode right;//右子节点
         private int val;//结点数值

         public TreeNode(int val) {
             this.val = val;
         }

        public TreeNode() {
        }
     }
     private  static TreeNode root;
     //先序遍历
     public static void preTraverseBTree(TreeNode root1) {
         if (root1 != null) {
             System.out.println(root1.val);
             preTraverseBTree(root1.left);
             preTraverseBTree(root1.right);

         }
     }
     //中序遍历
     public static void inTraverseBTree(TreeNode root){
         if(root!=null){
             inTraverseBTree(root.left);
             System.out.println(root.val);
             inTraverseBTree(root.right);
         }
     }
     public static void main(String args[]) {
         int init[] = {2, 3, 5, 4, 1};
         root=new TreeNode(init[0]);
         for (int i=1;i<init.length;i++) {
             createTree(root,init[i]);
         }
         //先序遍历该树
         System.out.println("先序遍历为：");
         preTraverseBTree(root);
         //先序遍历该树
         System.out.println("中序遍历为：");
         inTraverseBTree(root);
         System.out.println("树的深度为："+getHeight(root));
         System.out.println("最大值为："+getMax(root));

     }
     //创建二叉查找树
     public static void createTree(TreeNode root2, int value) {
         if (root2 == null) {
             root2 = new TreeNode(value);
         }
         else {
             //当前结点
             TreeNode temp = root2;
             while (temp != null) {
                 if (value > temp.val) {
                     if (temp.right == null) {
                         temp.right = new TreeNode(value);
                         return;
                     }
                     else {
                         temp = temp.right;
                     }

                 }
                 else {
                     if (temp.left == null) {
                         temp.left = new TreeNode(value);
                         return;
                     }
                     else {
                         temp = temp.left;
                     }
                 }

             }
         }
     }
     //求解树的深度
     public static int getHeight(TreeNode root){
         if(root==null){
             return 0;
         }
         int left=getHeight(root.left);
         int right=getHeight(root.right);
         int max=left>right?left:right;
         return max+1;
     }
     //求解最大值
     public static int getMax(TreeNode root){
         if(root==null){
             return -1;

         }
         int left=getMax(root.left);
         int right=getMax(root.right);
         int temp=root.val;
         int max=Math.max(left,Math.max(right,temp));
         System.out.println("");
         return max;

     }
 }
