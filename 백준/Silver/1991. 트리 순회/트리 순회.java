
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static Node head = new Node('A',null,null);

    static class Node {
        char data;
        Node left;
        Node right;

        public Node(char data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine()," ");
            char root = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);
            insertNode(head,root,left,right);
        }

        proOrder(head);
        System.out.println();
        inOrder(head);
        System.out.println();
        postOrder(head);

    }

    public static void insertNode(Node top, char root, char left, char right) {
        if (top.data == root) {
            top.left = (left == '.' ? null : new Node(left, null, null));
            top.right = (right == '.' ? null : new Node(right, null, null));
        } else {
            if (top.left != null) insertNode(top.left,root,left,right);
            if (top.right != null) insertNode(top.right,root,left,right);
        }
    }

    //재귀 함수
    //전위 순위
    private static void proOrder(Node node) {
        if (node == null) {
            return;
        } else {
            System.out.print(node.data);
            proOrder(node.left);
            proOrder(node.right);
        }
    }

    //중위 순위
    private static void inOrder(Node node) {
        if (node == null) {
            return;
        } else {
            inOrder(node.left);
            System.out.print(node.data);
            inOrder(node.right);

        }

    }

    //후위 순위
    private static void postOrder(Node node) {
        if (node == null) {
            return;
        } else {
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.data);
        }
    }
}
