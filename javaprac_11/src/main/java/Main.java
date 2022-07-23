class ArrayCalculation {

    int[] arr = {0, 1, 2, 3, 4};

    public int divide(int denominatorIndex, int numeratorIndex) throws ArithmeticException,ArrayIndexOutOfBoundsException{
        // 아 이제 ArithmeticException,ArrayIndexOutOfBoundsException 이 생기는 경우에 handling을 해줘야한다라는 것을 알게된다.
        return arr[denominatorIndex] / arr[numeratorIndex];
    }
}

public class Main {
    public static void main(String[] args) {
        ArrayCalculation arrayCalculation = new ArrayCalculation();

        System.out.println("2 / 1 = " + arrayCalculation.divide(2, 1));
        try{
            System.out.println("1 / 0 = " + arrayCalculation.divide(1, 0)); // java.lang.ArithmeticException: "/ by zero"
        }catch ( ArithmeticException arithmeticException){
            System.out.println("잘못된 계산" + arithmeticException.getMessage());
        }
        try{
            System.out.println("Try to divide using out of index element = "
                    + arrayCalculation.divide(5, 0)); // java.lang.ArrayIndexOutOfBoundsException: 5
        }catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException){
            System.out.println("잘못된 index 분모 타당한 index 분모는 0초과입니다."+ arrayIndexOutOfBoundsException.getMessage());
        }

    }

}