package practice.genericTree;

import java.io.*;
import java.util.*;

public class multisolver {
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

    static int s, max, min, ht;

    public static void multisolver(Node node, int d){


        s++;
        min = Math.min(min, node.data);
        max = Math.max(max, node.data);
        ht = Math.max(ht, d);
        for(Node child : node.children){
            multisolver(child, d+1);
        }

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

        s = 0;
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        ht = 0;
        multisolver(root,0);

        System.out.println("s " + s );
        System.out.println("min " + min );
        System.out.println("max " + max );
        System.out.println("ht " + ht );
    }

}
