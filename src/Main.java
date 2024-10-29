import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        String filename = "";
        char userinput;
        int i, wr, filenamber;
        List<Character> anspeople = new ArrayList<>();
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

        if (filenamber == 1) filename = "animals.txt";
        else if(filenamber == 2) filename = "countries.txt";
        else if(filenamber == 3) filename = "words.txt";
        else if(filenamber == 4) filename = "plants.txt";

        Word word = new Word();
        word.SelectRandomWord(filename);

        String w = word.GetRandomWord();
        int len = word.GetLength();
        GameResult gr = new GameResult();
        gr.SetCurrentWord(w);

        String alf = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        for(i = 0; i<len; i++)
        {
            anspeople.add('_');
        }

        while(gr.GetRightAnswers()<len && gr.GetWrongAnswers()<6)
        {
            int count = 0;
            System.out.print("Слово из " + len + " букв, введите букву - ");

            Letter let = new Letter(scanner);
            userinput = let.Chek();

            gr.SetAnswer(userinput);
            gr.Check(userinput, len, alf, anspeople);

            for (i = 0; i < len; i++)
            {
                if (!anspeople.get(i).equals('_'))
                {
                    count += 1;
                }
            }

            if (count == len)//при выигрыше, когда в слове не останется не отгаданных букв
            {
                wr = gr.GetWinResult();
                System.out.println("Вы отгадали слово - " + w + " за " + wr + " попыток.");
                gr.DisplayLetters();
                gr.KolWin();
                break;
            }

            else if(gr.GetWrongAnswers() == 6)
            {
                System.out.println("Вы проиграли! Слво - " + w);
                gr.DisplayLetters();
                gr.KolLoss();
                break;
            }
        }
        scanner.close();
    }
}