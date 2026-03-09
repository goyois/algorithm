
import java.io.*;
import java.util.*;

public class Main {

    static Node root;
    static StringBuilder sb = new StringBuilder();

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data=data;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        root = new Node(Integer.parseInt(br.readLine()));
        
        while (true) {
            String str = br.readLine();

            if (str == null || str.isEmpty()) break;
            Node node = new Node(Integer.parseInt(str));
            setTree(root,node);
        }
        travel(root);

        System.out.println(sb);
    }


    public static void travel(Node root) {
        if (root == null) return;
        else {
            travel(root.left);
            travel(root.right);
            sb.append(root.data).append("\n");
        }
    }


    public static void setTree(Node root, Node input) {
        if (root.data > input.data) {
            if (root.left != null) setTree(root.left,input);
            else root.left = input;
        }
        if (root.data < input.data) {
            if (root.right != null) setTree(root.right,input);
            else root.right = input;
        }
    }
}
