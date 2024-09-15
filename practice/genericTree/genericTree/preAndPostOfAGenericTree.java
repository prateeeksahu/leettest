package practice.genericTree;

import java.io.*;
import java.util.*;

public class preAndPostOfAGenericTree {
    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    public static void display(Node node) {
        String str = node.data + " -> ";
        for (Node child : node.children) {
            str += child.data + ", ";
        }
        str += ".";
        System.out.println(str);

        for (Node child : node.children) {
            display(child);
        }
    }

    public static Node construct(int[] arr) {
        Node root = null;

        Stack<Node> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == -1) {
                st.pop();
            } else {
                Node t = new Node();
                t.data = arr[i];

                if (st.size() > 0) {
                    st.peek().children.add(t);
                } else {
                    root = t;
                }

                st.push(t);
            }
        }

        return root;
    }


    public static class Pair{
        Node node;
        int state;

        Pair(Node node, int state){
            this.node = node;
            this.state = state;
        }
    }
//    static ArrayList<Integer> pre = new ArrayList<>();
//    static ArrayList<Integer> post = new ArrayList<>();
    public static void IterativePreandPostOrder(Node node) {
//        pre.add(node.data);
//
//        for(Node child : node.children){
//            IterativePreandPostOrder(child);
//        }
//
//        post.add(node.data);

        Stack <Pair> st = new Stack<>();
        st.push(new Pair(node, -1));

        String pre ="";
        String post = "";

        while(st.size()>0){
            Pair top = st.peek();

            if(top.state == -1){
                pre += top.node.data + " ";
                top.state++;
            } else if (top.state == top.node.children.size()){
                post += top.node.data + " ";
                st.pop();
            } else {
                st.push(new Pair(top.node.children.get(top.state),-1));
                top.state++;
            }
        }

        System.out.println(pre);
        System.out.println(post);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(values[i]);
        }

        Node root = construct(arr);
        IterativePreandPostOrder(root);
//        for(int x : pre){
//            System.out.print(x+" ");
//        }
//
//        System.out.println();
//
//        for(int x : post){
//            System.out.print(x+" ");
//        }
    }

}
