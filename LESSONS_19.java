class LESSONS_19 {
	
	public static void main(String [] args) {
		char[] arrayOne = {1,2,3,2,5};
		char[] arrayTwo = {2,9,3,4,5};

		isFindMatch(arrayOne,arrayTwo);
	}
//проверяет есть ли в 1 массиве, такая же последовательность символов которую 
//представляет собой второй массив. 
//Возвращает булеан
	static boolean isFindMatch(char[] arrayOne, char[] arrayTwo) {
		char[] temporaryArray = new char [arrayOne.length];
		int counter = 0;

		for(int i = 0; i < arrayOne.length; i++) {
			if(arrayOne[i] == arrayTwo[i]) {
				if(counter > 1){
					System.out.println(true);
					return true;
				}
				temporaryArray[counter] = arrayOne[i];
				counter++;
			}
		}
		return false;
	}
}