import java.util.Random;
public class TestMethods {
    public static void main(String[]args) {
        Random random = new Random();
        int result = intGenerator(5);

        System.out.println(result);


    }
    static int intGenerator(int lastNumber) {
        return random.nextInt(3);
    }
    static String nameGenerator() {
        String[] Names = {"vwCaddy","vwTransporter","fordTransit","vwCrafter"};
        String result = "";
        Random random = new Random();;
        int value = random.nextInt(3);

        for (int i = 0; i < Names.length; i++) {
            if(value == i) {
            result = "" + Names[i];
            }
        }
        return result;
    }

}