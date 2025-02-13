import java.util.Stack;
class QueueUsingStacks {
   private Stack<Integer> s1;
   private Stack<Integer> s2;
   public QueueUsingStacks() {
       s1 = new Stack<>();
       s2 = new Stack<>();
   }

   public void enqueue(int x) {
       s1.push(x);
   }

   public int dequeue() {
       if (s2.isEmpty()) {
           while (!s1.isEmpty()) {
               s2.push(s1.pop());
           }
       }
       return s2.isEmpty() ? -1 : s2.pop();
   }
   public boolean isEmpty() {
       return s1.isEmpty() && s2.isEmpty();
   }

   public int peek() {
       if (s2.isEmpty()) {
           while (!s1.isEmpty()) {
               s2.push(s1.pop());
           }
       }
       return s2.isEmpty() ? -1 : s2.peek();
   }
public static void main(String[] args) {
       QueueUsingStacks obj = new QueueUsingStacks();
       obj.enqueue(1);
       obj.enqueue(2);
       obj.enqueue(3);
       System.out.println(obj.dequeue());
       System.out.println(obj.peek());
       System.out.println(obj.isEmpty());
   }
}
