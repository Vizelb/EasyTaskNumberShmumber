import java.util.ArrayList;
import java.util.Scanner;

public class Numbers {


    ArrayList<Integer> numbers = new ArrayList<>();

    public void init() {
        System.out.println(" Введите числа.\n Команда \"stop\" остановит ввод.");
        readText();
        //writeText();
        //checkNatureOfNumber();
        writeText();
        System.out.println("\nСамое большое число это: ");
        System.out.println(calculateMax()); // "\n" +
    }

    private void readText() {
        ArrayList<String> garbage = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int counter = 0;
        do {
            if (scanner.hasNextInt()) {
                numbers.add(scanner.nextInt());
            } else //if(!scanner.hasNextInt()){
            {
                garbage.add(scanner.nextLine());

                if (garbage.get(counter).equals("stop"))
                    return;
                counter++;
            }
        } while (!garbage.equals("stop"));
    }

    private void checkNatureOfNumber() {
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) <= 0 || ((numbers.get(i) % 1) != 0)) {
                numbers.remove(i);
            }
        }
    }

    private void writeText() {
        for (Integer integres : numbers) {
            System.out.print(integres + ", ");
        }
    }

    private String calculateMax() {
        int maxSumma = 0;
        int maxNumber = 0;
        int[] summa = new int[numbers.size()];
        int currentInt;

        for (int i = 0; i < numbers.size(); i++) {
            currentInt = numbers.get(i);
            while (currentInt > 0) {
                summa[i] += (currentInt % 10);
                currentInt /= 10;
            }

            if (summa[i] > maxSumma) {
                maxSumma = summa[i];
                maxNumber = numbers.get(i);
            }
        }


        String answer = String.valueOf(maxNumber + " - с суммой цифр равной " + maxSumma);
        return answer;
    }
}
