import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        String filename = "", userinput, input;
        int i, wr = 0, filenamber;
        List<String> anspeople = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите категорию слов:");
        System.out.println("1 - животные");
        System.out.println("2 - страны");
        System.out.println("3 - общая тема");
        System.out.println("4 - растения");

        while (true) {
            try {
                filenamber = Integer.parseInt(scanner.nextLine());
                if (filenamber < 1 || filenamber > 4)
                    System.out.println("Вы ввели неверное число");
                else
                    break;
            } catch (NumberFormatException e) {
                System.err.println("Неверный ввод");
            }
        }
        scanner.close();

        if (filenamber == 1) filename = "animals.txt";
        else if(filenamber == 2) filename = "countries.txt";
        else if(filenamber == 3) filename = "words.txt";
        else if(filenamber == 4) filename = "plants.txt";

        Word word = new Word();
        word.SelectRandomWord(filename);

        String w = word.GetRandomWord();
        int len = word.GetLength();
        System.out.print(w);
    }
}