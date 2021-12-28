import java.util.Arrays;

public class StringAddCalculator {
    public static int splitAndSum(String stringNumber) {
        if (stringNumber == null || stringNumber.isEmpty()){
            return 0;
        }
        String delimiter = ",|:";
        if (stringNumber.startsWith("//") && stringNumber.charAt(3) == '\n'){
            delimiter += "|" + stringNumber.charAt(2);
            stringNumber = stringNumber.substring(4);
        }
        return Arrays.stream(stringNumber.split(delimiter))
                .mapToInt(Integer::parseInt).sum();
    }
    int parsePositiveInt(String target){
        int result;
        try {
            result = Integer.parseInt(target);
        }
        catch (Exception e){
            throw new RuntimeException();
        }

        if (result < 0){
            throw new RuntimeException();
        }
        return result;
    }
}
