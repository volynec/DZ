import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Paths;
import java.util.Scanner;


public class Main {
    public static final String INPUT_FILE = "INPUT.TXT";
    public static final String OUTPUT_FILE = "OUTPUT.TXT";
    static int summArr = 0;
    static int multArr = 1;


    public static void main(String[] args) {
        try {
            parseFileAndCalculate();
            writeFile();
        } catch (IOException e) {
            System.out.println("Произошла ошибка ввода/выводв! ");
            System.out.println("Подробная отладочная информация: ");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Произошла неизвестная ошибка! ");
            System.out.println("Подробная отладочная информация: ");
            e.printStackTrace();
        }

    }

    private static void parseFileAndCalculate() throws IOException {
        int maxIndex = 0;
        int maxNum = 0;
        int minIndex = 0;
        int minNum = 0;

        Scanner scanner = new Scanner(Paths.get(INPUT_FILE));
        String line = scanner.nextLine();

        String line2 = scanner.nextLine();
        String[] strArr = line2.split(" ");
        int numArr[] = new int[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            numArr[i] = Integer.parseInt(strArr[i]);
        }

        for (int k = 0; k < numArr.length; k++) {
            if (numArr[k] >= 0) {
                summArr += numArr[k];
            }
        }
        for (int i = 0; i < numArr.length; i++) {

            if (numArr[i] >= maxNum) {
                maxNum = numArr[i];
                maxIndex = i;
            } else if (numArr[i] <= minNum) {
                minNum = numArr[i];
                minIndex = i;
            }
        }

        if (minIndex < maxIndex  )  {
            for (int j = minIndex + 1; j < maxIndex; j++) {
                multArr = multArr * numArr[j];
            }

        } else
            for (int j = maxIndex + 1; j < minIndex; j++) {
                multArr = multArr * numArr[j];
            }

        scanner.close();

        System.out.println(maxIndex);
        System.out.println(maxNum);
        System.out.println(minIndex);
        System.out.println(minNum);
        System.out.println(summArr);
        System.out.println(multArr);

    }


    private static void writeFile() throws IOException {
        try {
            FileWriter fw = new FileWriter(OUTPUT_FILE);
            Writer output = new BufferedWriter(fw);
            output.append(summArr + " ");
            output.append(multArr + "");

            output.flush();
            output.close();
            fw.close();
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }
}



