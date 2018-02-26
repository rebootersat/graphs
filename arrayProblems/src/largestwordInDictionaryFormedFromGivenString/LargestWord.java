package largestwordInDictionaryFormedFromGivenString;

/**
 * Find largest word in dictionary by deleting some characters of given string
 * 
 * @author SANDEEP
 *
 */
public class LargestWord
{
	private String[] dictionary;
	
	public void setDictionary(String[] dictionary) {
		this.dictionary = dictionary;
	}
	
	public String getLargestWord(String sequence) {
		if (dictionary == null || dictionary.length == 0 || sequence == null)
			return null;
		
		String subSeq = "";
		for (int i = 0; i < dictionary.length; i++)
		{
			if (isSubSequence(sequence, dictionary[i]))
			{
				if (dictionary[i].length() > subSeq.length())
					subSeq = dictionary[i];
			}
		}
		return subSeq;
	}
	
	private boolean isSubSequence(String sequence, String dicWord) {
		char[] word = dicWord.toCharArray();
		char[] seq = sequence.toCharArray();
		int j = 0;
		int noOfMatchingCharacters = 0;
		for (int i = 0; i < word.length; i++)
		{
			if (j >= seq.length)
				break;
			for (; j < seq.length; j++)
			{
				if (word[i] == seq[j])
				{
					noOfMatchingCharacters++;
					break;
				}
			}
		}
		return noOfMatchingCharacters == word.length;
	}
}
