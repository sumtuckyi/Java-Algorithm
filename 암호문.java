import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class 암호문 {
    static int NODE_MAX = 2100;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    static class Node {
        // Node type의 속성 정의
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class LinkedList {
        Node head;
        Node tail;
        Node[] nodeArr;
        int nodeCnt;

        public LinkedList() {
            head = null;
            nodeArr = new Node[NODE_MAX];
            nodeCnt = 0;
        }

        Node getNewNode (int data) {
            nodeArr[nodeCnt] = new Node(data);
            return nodeArr[nodeCnt++];
        }

        void insert(int idx, int num) {
            if(idx == 0) { // 새로 생성한 노드가 새로운 헤드가 됨
                Node newNode = getNewNode(num);
                newNode.next = head;
                head = newNode;
            } else {  // idx가 0이 아닌 경우
            Node cur = head; // cur = 0
            for (int i = 1; i < idx; i++) { // idx가 3이면
                cur = cur.next; // cur = 2
            }
            Node newNode = getNewNode(num);
            newNode.next = cur.next; // 새로 생긴 노드의 다음노드는 3번 노드 
            cur.next = newNode;
            }
        }

        void delete(int idx) {
            Node cur = head;
            if (idx == 0) { // head를 삭제하는 경우
                cur = cur.next;
                head = cur;
                return;
            }
            // 헤드를 삭제하는 경우가 아니라면
            for (int i = 1; i < idx; i++) { 
                cur = cur.next; // x-1번 노드
            }
            Node anchor = cur; // 삭제할 노드의 바로 앞 노드
            cur = cur.next; // 삭제할 노드
            anchor.next = cur.next; // 삭제할 노드의 앞 노드의 다음 노드를 삭제할 노드의 바로 다음 노드로 지정
        }

        void change(int idx, int new_data) {
            Node cur = head;
            for (int i = 0; i < idx; i++) {
                cur = cur.next;
            }
            cur.data = new_data;
        }

        void print(int L) throws Exception { // i번째 인덱스의 값을 출력
            Node cur = head;
            // bw.write(cur.data);
            for (int i = 0; i < L; i++) {
                if (cur.next == null) {
                    bw.write(String.valueOf(-1));
                    return;
                }
                cur = cur.next;
                // bw.write(cur.data);
            }
            bw.write(String.valueOf(cur.data)); 
            bw.write(cur.data);
            }
        }
    


    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());
        StringTokenizer stk;
        for (int tc = 1; tc < T + 1; tc ++) {
            LinkedList list = new LinkedList(); // 빈 linkedlist 생성
            bw.write("#");
            bw.write(tc + " ");
            int[] var = new int[3];
            stk = new StringTokenizer(br.readLine());
            for (int i = 0; i < 3; i++) {
                var[i] = Integer.parseInt(stk.nextToken());
            }
            int N = var[0]; // 수열의 길이
            int M = var[1]; // 명령어의 개수
            int L = var[2]; // 출력할 인덱스 번호
            // 수열의 초기상태 구현 
            stk = new StringTokenizer(br.readLine()); // 수열 입력받기
            for (int i = 0; i < N; i++) {
                int tmp = Integer.parseInt(stk.nextToken()); // 입력받은 수열에서 차례로 하나씩 정수로 변환
                list.insert(i, tmp); // linkedlist에 추가 
            }
            // M개의 명령어 수행
            for (int i = 0; i < M; i++) {
                stk = new StringTokenizer(br.readLine()); // 명령어 한 줄씩 입력받기
                char cmd = stk.nextToken().charAt(0); // 명령어의 종류
                int x, y;
                switch (cmd) {
                    case 'I':
                        x = Integer.parseInt(stk.nextToken());
                        y = Integer.parseInt(stk.nextToken());
                        list.insert(x, y);
                        break;
                    case 'D': // 인자 하나
                        y = Integer.parseInt(stk.nextToken());
                        list.delete(y);
                        break;
                    case 'C':
                        x = Integer.parseInt(stk.nextToken());
                        y = Integer.parseInt(stk.nextToken());
                        list.change(x, y);
                        break;
                }
            }
            list.print(L);
            bw.write("\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
