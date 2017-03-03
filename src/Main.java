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
        int max_index = 0;
        int max_num = 0;
        int min_index = 0;
        int min_num = 0;

        Scanner scanner = new Scanner(Paths.get(INPUT_FILE));
        String line = scanner.nextLine();

        String line2 = scanner.nextLine();
        String[] strArr = line2.split(" ");
        int numArr[] = new int[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            numArr[i] = Integer.parseInt(strArr[i]);
        }

        for (int i = 0; i < numArr.length; i++) {
            if (numArr[i] > 0) {
                summArr += numArr[i];
            }
        }
        for (int i = 0; i < numArr.length; i++) {

            if (numArr[i] > max_num) {
                max_num = numArr[i];
                max_index = i;
            } else if (numArr[i] < min_num) {
                min_num = numArr[i];
                min_index = i;
            }
        }
        if (min_index < max_index) {
            for (int j = min_index + 1; j < max_index ; j++) {
                multArr = multArr * numArr[j];
            }
        } else
            for (int j = max_index + 1; j < min_index ; j++) {
                multArr = multArr * numArr[j];
            }

        scanner.close();

    }


    private static void writeFile() throws IOException {
        try {
            FileWriter fw = new FileWriter(OUTPUT_FILE);
            Writer output = new BufferedWriter(fw);
                output.append(summArr + " ");
                output.append(multArr + " ");

            output.flush();
            output.close();
            fw.close();
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }
}



