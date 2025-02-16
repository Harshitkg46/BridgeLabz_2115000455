public class SearchForSpecificWord {
	public static void main(String[] args) {
		String[] sentences = {
				"If any man touches you, he dies.",
				"If you let any man touch you, he dies.",
				"If you stop me from touching you, I die."
		};
		String word = "any";
		System.out.println("Sentence containing word: " + helper(sentences, word));
	}
	public static String helper(String[] sentences, String word) {
		for (String sentence : sentences) {
			if (sentence.contains(word)) {
				return sentence;
			}
		}
		return "Not Found";
	}
}
