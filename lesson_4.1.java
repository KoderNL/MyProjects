public class Methods{
	public static void main(String [] args){
		testMax();
		testToCharArray();
		testHasDublicatesWhenFindDuplicates();
		testHasDublicatesWhenNotFindDuplicates();
	}

	static void testHasDublicatesWhenFindDuplicates(){
		byte[] array = {10,15,100,15};
		boolean actual = hasDuplicates(array);
		assertEquals("#3", true, actual);

	}

	static void testHasDublicatesWhenNotFindDuplicates(){
		byte[] array = {10,15,100};
		boolean actual = hasDuplicates(array);
		assertEquals("#4", false, actual);
	}
	//bytes in array [0, 127]
	static boolean hasDuplicates (byte[] array){
		boolean [] hasDuplicates = new boolean[128];
		
		return true;
	}
}