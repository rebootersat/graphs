package metaStrings;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CheckMeataDataStringTest
{
	private CheckMeataDataString metaDataString;

	@Before
	public void setUp() {
		metaDataString = new CheckMeataDataString();
	}
	
	@Test
	public void isMetaData_whenAnyOneISNull_shouldRteurnFalse() {
		boolean isMetaData = metaDataString.isMetaData();
		assertEquals(false, isMetaData);
	}
	
	@Test
	public void isMetaData_whenStringLengthLessThanTwo_shouldRteurnFalse() {
		metaDataString.setFirst("g");
		metaDataString.setSecond( "k");
		boolean isMetaData = metaDataString.isMetaData();
		assertEquals(false, isMetaData);
	}
	
	@Test
	public void isMetaData_whenMetaDataStringTrue_shouldRteurnTrue() {
		metaDataString.setFirst("geeks");
		metaDataString.setSecond( "keegs");
		boolean isMetaData = metaDataString.isMetaData();
		assertEquals(true, isMetaData);
	}
	
	@Test
	public void isMetaData_LengthOfBothMetaDataStringDifferent_shouldRteurnFalse() {
		metaDataString.setFirst("gee");
		metaDataString.setSecond( "keegs");
		boolean isMetaData = metaDataString.isMetaData();
		assertEquals(false, isMetaData);
	}
}
