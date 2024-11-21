import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        String filename = "";
        char userinput;
        int i, wr, filenamber, ls;
        int answer = 1;
        Scanner scanner = new Scanner(System.in);

        ArrayList<GameResult> results = new ArrayList<>();
        while(answer==1) {
            List<Character> anspeople = new ArrayList<>();

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
            else if (filenamber == 2) filename = "countries.txt";
            else if (filenamber == 3) filename = "words.txt";
            else if (filenamber == 4) filename = "plants.txt";

            Word word = new Word();
            try{
                word.SelectRandomWord(filename);
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }

            String w = word.GetRandomWord();
            GameResult gr = new GameResult(0,0,6,0,0,0, 0);
            int len = word.GetLength();

            gr.SetCurrentWord(w);
            String alf = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
            for (i = 0; i < len; i++) {
                anspeople.add('_');
            }

            while (gr.GetRightAnswers() < len && gr.GetWrongAnswers() < 6) {
                int count = 0;
                System.out.print("Слово из " + len + " букв, введите букву - ");

                Letter let = new Letter(scanner);
                userinput = let.Chek();

                gr.AddAnswer(userinput);
                gr.Check(userinput, len, alf, anspeople);

                for (i = 0; i < len; i++) {
                    if (!anspeople.get(i).equals('_')) {
                        count += 1;
                    }
                }

                if (count == len)//при выигрыше, когда в слове не останется не отгаданных букв
                {
                    wr = gr.GetWinResult();
                    System.out.println("Вы отгадали слово - " + w + " за " + wr + " попыток.");
                    gr.DisplayLetters();
                    results.add(gr);
                    break;
                } else if (gr.GetWrongAnswers() == 6) {
                    System.out.println("Вы проиграли! Слво - " + w);
                    ls = gr.GetLoss();
                    gr.DisplayLetters();
                    results.add(gr);
                    break;
                }
            }
            gr.displayStats();
            scanner.nextLine();
            System.out.println("Меню: ");
            System.out.println("1 - Продолжить игру");
            System.out.println("2 - Посмотреть количество выигрышей");
            System.out.println("3 - Посмотреть количество проигрышей");
            System.out.println("0 - Выйти из игры");
            int input1;
            while (true) {
                try {
                    input1 = Integer.parseInt(scanner.nextLine());
                    if (input1 < 0 && input1 > 3)
                        System.out.println("Вы ввели неверное число");
                    else
                        break;
                } catch (NumberFormatException e) {
                    System.err.println("Неверный ввод");
                }
            }
            if(input1==1 || input1==0){
                answer = input1;
            }
            else if(input1==2 || input1==3) {
                if(input1==2) {
                    gr.KolWin();
                    int kolwin = gr.GetWin();
                    System.out.println("Количество выигрышей = " + kolwin);
                }
                else if(input1==3) {
                    gr.KolLoss();
                    int kolloss = gr.GetLoss();
                    System.out.println("Количество проигрышей = " + kolloss);
                }
                System.out.print("Если вы хотите выйти из игры введите '0', иначе  '1' - ");
                int input2;
                while (true) {
                    try {
                        input2 = Integer.parseInt(scanner.nextLine());
                        if (input2 != 1 && input2 != 0)
                            System.out.println("Вы ввели неверное число");
                        else
                            break;
                    } catch (NumberFormatException e) {
                        System.err.println("Неверный ввод");
                    }
                }
                answer = input2;
            }

        }
        scanner.close();
        int kol = 1;
        for (GameResult result : results) {
            GameOutcome outcome = result;
            System.out.print("За " + kol + " игру: ");
            System.out.println(outcome); // Вызывается метод toString()
            kol+=1;
        }
    }

}