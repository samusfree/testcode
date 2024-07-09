import java.io.*;
import java.util.*;

//Write a function to return second largest element in Binary search tree

//        ( 5 )
//       /     \
//     (3)     (8*)        => 8
//    /  \     /  \
//  (1)  (4) (7)  (9)

//        ( 5 )
//       /     \
//     (3)     (8)
//    /  \     /  \
//  (1)  (4) (7)  (12)    => 11
//                /
//              (10)
//              /  \
//            (9)  (11*)

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}

class ThreeBinarySearch {
    public static void main(String[] args) {
        TreeNode five = new TreeNode(5);
        TreeNode three = new TreeNode(3);
        TreeNode eight = new TreeNode(8);
        TreeNode one = new TreeNode(1);
        TreeNode four = new TreeNode(4);
        TreeNode seven = new TreeNode(7);
        TreeNode nine = new TreeNode(9);
        TreeNode ten = new TreeNode(10);
        TreeNode eleven = new TreeNode(11);
        TreeNode twelve = new TreeNode(12);

        /*five.left = three;
        five.right = eight;
        three.left = one;
        three.right =* four;
        eight.left = seven;
        eight.right = nine;*/

        five.left = three;
        five.right = eight;
        three.left = one;
        three.right = four;
        eight.left = seven;
        eight.right = twelve;
        twelve.left = ten;
        ten.left = nine;
        ten.right = eleven;

        System.out.println(findSecondLargest(five));
    }

    public static int findSecondLargest(TreeNode root) {
        //use recursitivty to move on the three and return the value
        //if(root.left == null && root.right == null) {
        //  return root.val;
        if(root.right != null && root.right.left == null && root.right.right == null) {
            return Math.min(root.val, root.right.val);
        } else if(root.right == null && root.left != null) {
            return findSecondLargest(root.left);
        }
        else {
            return findSecondLargest(root.right);
        }
    }
}
