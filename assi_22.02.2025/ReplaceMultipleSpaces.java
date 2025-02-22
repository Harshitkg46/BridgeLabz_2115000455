
public class ReplaceMultipleSpaces {
    public static void main(String[] args) {
        String text = "This  is   an example  with  multiple    spaces.";
        System.out.println("Before: " + text);
        String replaced = text.replaceAll("\s+", " ");
        System.out.println("After: " + replaced);
    }
}
