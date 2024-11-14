import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.File;

public class GameResult extends Answers{

    private int win;
    private int loss;
    private int winresult;

    public GameResult(){
        super(0,0);
        win = 0;
        loss = 0;
        winresult = 0;
    }

    public void KolWin() {
        String filename = "wins.txt";
        File file = new File(filename);
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {

            while (reader.readLine() != null) {
                win++;
            }
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }

    public int GetWin() {

        return win;
    }

    public int GetLoss() { return loss; }

    public void KolLoss() {
        String filename = "loss.txt"; // Имя файла с числом
        int kol = 0;
        try {
            // Проверяем существование файла
            if (!Files.exists(Paths.get(filename))) {
                // Если файла нет, создаем его и записываем начальное значение
                Files.writeString(Paths.get(filename), String.valueOf(kol));
            }

            // Читаем число из файла
            kol = Integer.parseInt(Files.readString(Paths.get(filename)).trim());

            // Увеличиваем число
            kol++;
            loss = kol;

            // Записываем обновленное число обратно в файл
            Files.writeString(Paths.get(filename), String.valueOf(kol));


        } catch (IOException e) {
            System.err.println("Ошибка ввода-вывода: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Ошибка: файл не содержит число.");
        }
    }

    public int GetWinResult() {
        winresult = rightanswers + wronganswers;
        String filename = "wins.txt";
        String texttoappend = String.valueOf(winresult);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) { // true - для добавления
            writer.write(texttoappend);
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Ошибка при записи в файл: " + e.getMessage());
        }
        return winresult;
    }
    public String toString() {
        return "Правильные ответы: " + rightanswers + ", Неверные ответы: " + wronganswers;
    }
}
