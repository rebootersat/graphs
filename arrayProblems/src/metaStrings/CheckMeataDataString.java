package metaStrings;

/**
 * One string is meta data of other string if one string can be formed as second
 * string after performing swap operation
 * 
 * @author SANDEEP
 *
 */
public class CheckMeataDataString
{
	private String first;
	private String second;
	
	public void setFirst(String first) {
		this.first = first;
	}
	
	public void setSecond(String second) {
		this.second = second;
	}
	
	public boolean isMetaData() {
		if (first == null || second == null)
			return false;
		if (first.length() == 1 || second.length() == 1)
			return false;
		if (first.length() != second.length())
			return false;
		boolean isMetaData = false;
		char[] metaFirst = first.toCharArray();
		char[] metaSecond = second.toCharArray();
		int swapIndex = -1;
		for (int i = 0; i < first.length(); i++)
		{
			if (swapIndex == -1 && metaFirst[i] != metaSecond[i])
			{
				isMetaData = false;
				swapIndex = i;
			}
			else
			{
				if (metaFirst[i] != metaSecond[i])
				{
					if (metaFirst[swapIndex] == metaSecond[i] && metaFirst[i] == metaSecond[swapIndex])
					{
						isMetaData = true;
					}
					else
					{
						isMetaData = false;
						break;
					}
				}
			}
		}
		
		return isMetaData;
	}
}
