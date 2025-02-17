public class StringPerformance {
	
   public static void main(String[] args) {
       int n = 10000;
      
       long start = System.nanoTime();
       String s = "";
       for (int i = 0; i < n; i++) s += i;
       long end = System.nanoTime();
       System.out.println("String Time: " + (end - start) / 1e6 + " ms");
       start = System.nanoTime();
       StringBuilder sb = new StringBuilder();
       for (int i = 0; i < n; i++) sb.append(i);
       end = System.nanoTime();
       System.out.println("StringBuilder Time: " + (end - start) / 1e6 + " ms");
       start = System.nanoTime();
       StringBuffer sf = new StringBuffer();
       for (int i = 0; i < n; i++) sf.append(i);
       end = System.nanoTime();
       System.out.println("StringBuffer Time: " + (end - start) / 1e6 + " ms");
   }
}
