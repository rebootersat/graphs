package firstNonrepeatableChar;

public class Test {
	public static void main(String[] args) {
		Test test = new Test();
		char firstNonRepeatableChar = test.getFirstNonRepeatableChar("GeeksQuiz");
		System.out.println(firstNonRepeatableChar);
	}

	public char getFirstNonRepeatableChar(String str) {
		char[] chars = str.toCharArray();
		int[] charactersInfo = new int[256];

		for (int i = 0; i < chars.length; i++) {
			charactersInfo[chars[i]] = charactersInfo[chars[i]] + 1;
		}
		for (int i = 0; i < chars.length; i++) {
			if (charactersInfo[chars[i]] == 1)
				return chars[i];
		}

		return ' ';

	}
}
