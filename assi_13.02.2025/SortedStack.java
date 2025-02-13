import java.util.Stack;
public class SortedStack{
    public static void sortedInsert(Stack<Integer>st, int n) {
        if (st.isEmpty()||st.peek()<=n) {
            st.push(n);
            return;
        }
        int top = st.pop();
        sortedInsert(st,n);
        st.push(top);
    }

    public static void sortStack(Stack<Integer> st) {
        if (st.isEmpty()) return;
        int top = st.pop();
        sortStack(st);
        sortedInsert(st, top);
    }

    public static void print(Stack<Integer> st) {
        for (int n:st) {
            System.out.print(n + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(7);
        s.push(10);
        s.push(1);
        s.push(9);
        s.push(5);

        System.out.println("Original Stack:");
        print(s);
        sortStack(s);
        System.out.println("Sorted Stack:");
        print(s);
    }
}
