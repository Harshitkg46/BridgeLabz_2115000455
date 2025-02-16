public class ConcatenationComparison {
	public static void main(String[] args) {
		int iterations = 1_000_000;
		String word = "hello";
		long startTime = System.nanoTime();
		StringBuffer stringBuffer = new StringBuffer();
		for (int i = 0; i < iterations; i++) {
			stringBuffer.append(word);
		}
		long endTime = System.nanoTime();
		long stringBufferTime = endTime - startTime;
		startTime = System.nanoTime();
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < iterations; i++) {
			stringBuilder.append(word);
		}
		endTime = System.nanoTime();
		long stringBuilderTime = endTime - startTime;
		System.out.println("Time taken by StringBuffer: " + stringBufferTime + " ns");
		System.out.println("Time taken by StringBuilder: " + stringBuilderTime + " ns");
		if (stringBufferTime > stringBuilderTime) {
			System.out.println("StringBuilder is faster.");
		} else {
			System.out.println("StringBuffer is faster.");
		}
	}
}
