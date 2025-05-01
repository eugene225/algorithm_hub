import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        Stack<Character> charStack = new Stack<>();
        Stack<Integer> numberStack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == '(' || ch == '[') {
                charStack.push(ch);
                numberStack.push(0);
            } else {
                if (charStack.isEmpty()) {
                    System.out.println(0);
                    return;
                }

                char top = charStack.pop();
                int inner = numberStack.pop();

                if ((ch == ')' && top != '(') || (ch == ']' && top != '[')) {
                    System.out.println(0);
                    return;
                }

                int value = (ch == ')') ? 2 : 3;
                int toPush = (inner == 0) ? value : inner * value;

                if (!numberStack.isEmpty()) {
                    numberStack.push(numberStack.pop() + toPush);
                } else {
                    numberStack.push(toPush);
                }
            }
        }

        if (!charStack.isEmpty()) {
            System.out.println(0);
            return;
        }

        System.out.println(numberStack.pop());
    }
}
