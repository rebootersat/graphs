package largestwordInDictionaryFormedFromGivenString;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class LargestWordTest
{
	private LargestWord word;
	
	@Before
	public void setUp() {
		word = new LargestWord();
	}
	
	@Test
	public void getLargestWord_whenDictionaryNull_shouldReturnNull() {
		String wd = word.getLargestWord("abpeplea");
		assertEquals(null, wd);
	}
	
	@Test
	public void getLargestWord_whenDictionaryEmpty_shouldReturnNull() {
		String wd = word.getLargestWord("abpeplea");
		assertEquals(null, wd);
	}
	
	@Test
	public void getLargestWord_whenProvidedStringNull_shouldReturnNull() {
		String wd = word.getLargestWord(null);
		assertEquals(null, wd);
	}
	
	@Test
	public void getLargestWord_whenInputValid_shouldReturnApple() {
		word.setDictionary(new String[]{"ale","apple","monkey","plea"});
		String wd = word.getLargestWord("abpeplea");
		assertEquals("apple", wd);
	}
}
