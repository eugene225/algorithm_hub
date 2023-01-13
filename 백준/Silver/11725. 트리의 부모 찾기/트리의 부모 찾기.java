import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static int N;
    static ArrayList<ArrayList<Integer>> tree;
    static boolean[] visited;
    static int[] parentNode;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        tree = new ArrayList<ArrayList<Integer>>();

        for(int i=0;i<N;i++){
            tree.add(new ArrayList<>());
        }

        StringTokenizer st;
        for(int i=0;i<N-1;i++){
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken()) - 1;
            int child = Integer.parseInt(st.nextToken()) - 1;

            tree.get(parent).add(child);
            tree.get(child).add(parent);
        }

        visited = new boolean[N];
        parentNode = new int[N];

        Queue<Integer> q = new LinkedList<>();
        q.add(0);  // 시작노드 0번 -> 문제에서는 1번
        visited[0] = true;

        while(!q.isEmpty()){
            int n = q.remove();
            for(int childs : tree.get(n)){ //n번 노드의 자식들 탐색
                if(!visited[childs]){
                    visited[childs] = true;
                    q.add(childs);
                    parentNode[childs] = n;
                }
            }
        }

        for(int i=1;i<N;i++){
            System.out.println(parentNode[i]+1);
        }
    }
}