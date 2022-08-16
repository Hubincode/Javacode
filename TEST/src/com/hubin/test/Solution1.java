package com.hubin.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution1 {
    public ArrayList<Integer> test(TreeNode root){
        if(root==null)
            return null;
        ArrayList<Integer> arrayList=new ArrayList<Integer>();
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size= queue.size();
            TreeNode treeNode= queue.poll();
            while(size>0){

                if(treeNode.left!=null){
                    queue.add(treeNode.left);
                }
                if(treeNode.right!=null){
                    queue.add(treeNode.right);
                }
                size--;
            }
            arrayList.add(treeNode.val);
        }
        return arrayList;

    }
    @Test
    public void test(){
        //TreeNode root=new TreeNode(1,new TreeNode(2,null,null),new TreeNode(3,null,null));
        TreeNode root=new TreeNode(1,new TreeNode(4,new TreeNode(1,null,null),null),new TreeNode(3,null,null));
        //TreeNode root=null;
        Solution1 solution1=new Solution1();
        System.out.print(solution1.test(root));

 }

}
