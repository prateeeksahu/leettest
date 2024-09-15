package practice.binaryTree;

import java.io.*;
import java.util.*;

public class isBST {
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static class Pair {
        Node node;
        int state;

        Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public static Node construct(Integer[] arr) {
        Node root = new Node(arr[0], null, null);
        Pair rtp = new Pair(root, 1);

        Stack<Pair> st = new Stack<>();
        st.push(rtp);

        int idx = 0;
        while (st.size() > 0) {
            Pair top = st.peek();
            if (top.state == 1) {
                idx++;
                if (arr[idx] != null) {
                    top.node.left = new Node(arr[idx], null, null);
                    Pair lp = new Pair(top.node.left, 1);
                    st.push(lp);
                } else {
                    top.node.left = null;
                }

                top.state++;
            } else if (top.state == 2) {
                idx++;
                if (arr[idx] != null) {
                    top.node.right = new Node(arr[idx], null, null);
                    Pair rp = new Pair(top.node.right, 1);
                    st.push(rp);
                } else {
                    top.node.right = null;
                }

                top.state++;
            } else {
                st.pop();
            }
        }

        return root;
    }

    public static void display(Node node) {
        if (node == null) {
            return;
        }

        String str = "";
        str += node.left == null ? "." : node.left.data + "";
        str += " <- " + node.data + " -> ";
        str += node.right == null ? "." : node.right.data + "";
        System.out.println(str);

        display(node.left);
        display(node.right);
    }

    public static int height(Node node) {
        if (node == null) {
            return -1;
        }

        int lh = height(node.left);
        int rh = height(node.right);

        int th = Math.max(lh, rh) + 1;
        return th;


    }

    public static  class bstpair{
        boolean isbst;
        int max;
        int min;
    }

    public static bstpair isbst(Node node){

        if(node == null){
            bstpair p = new bstpair();
            p.min = Integer.MAX_VALUE;
            p.max = Integer.MIN_VALUE;
            p.isbst = true;
            return p;
        }

        bstpair l = isbst(node.left);
        bstpair r = isbst(node.right);

        bstpair m = new bstpair();

        m.max = Math.max(node.data, Math.max(l.max, r.max));
        m.min = Math.min(node.data, Math.min(l.min, r.min));

        m.isbst = l.isbst && r.isbst && (node.data >= l.max && node.data <= r.min);

        return m;
    }

    public static boolean isbst2(Node node){
        if (node == null) return true;

        boolean l = isbst2(node.left);
        boolean r = isbst2(node.right);

        boolean t = false;

        if((node.left == null || node.left.data <=  node.data) && (node.right == null || node.right.data >= node.data)){
            t = true;
        }

        return l && r && t;
    }


//    public static boolean isbst(Node node){
//        if (node == null) return true;
//
//        boolean l = isbst(node.left);
//        boolean r = isbst(node.right);
//
//
//        return l && r && (node.left == null || node.left.data <= node.data) && (node.right == null || node.right.data > node.data);
//    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            if (values[i].equals("n") == false) {
                arr[i] = Integer.parseInt(values[i]);
            } else {
                arr[i] = null;
            }
        }

        Node root = construct(arr);

        bstpair p = isbst(root);
        System.out.println(p.isbst);
    }

}