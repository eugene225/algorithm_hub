import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static Node R;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        R = new Node(Integer.parseInt(br.readLine()), null, null);

        while(true){
            String s = br.readLine();
            if(s == null || s.equals("")) break;
            R.insert(Integer.parseInt(s));
        }

        postOrder(R);

    }

    public static void postOrder(Node node){
        if(node==null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.value);
    }

    public static class Node{
        int value;
        Node right;
        Node left;

        public Node(int value, Node left, Node right){
            this.value = value;
            this.left = left;
            this.right = right;
        }

        void insert(int n){
            if(n < this.value){
                if(this.left == null){
                    this.left = new Node(n, null, null);
                }else{
                    this.left.insert(n);
                }
            }
            else{
                if(this.right == null){
                    this.right = new Node(n, null, null);
                }
                else this.right.insert(n);
            }
        }
    }


}