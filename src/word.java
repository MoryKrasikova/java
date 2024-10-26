import java.io.*;
import java.util.*;

public class word {
    private String randomword; // Строка для хранения случайного слова
    private int length; // Длина слова

    // Конструктор
    public word() {
        randomword = null;
        length = 0;
    }

    // Метод для выбора случайного слова
    public void selectrandomword(String filename) {

        try {
                    file = new BufferedReader(new FileReader(filename)); // Открываем файл
                } catch (FileNotFoundException e) {
                    System.err.println("Ошибка открытия файла");
                    return; // Выходим из метода, если файл не открыт
                }

        List<String> words = new ArrayList<>(); // Список для хранения слов
        String word;

        // Читаем все слова из файла
        while ((word = file.readLine()) != null) {
            words.add(word); // Добавляем каждое считанное слово в список
        }
        file.close();

        if (!words.isEmpty()) {
            Random rand = new Random(); // Инициализация генератора случайных чисел
            int randomindex = rand.nextint(words.size()); // Генерация случайного индекса

            length = words.get(randomindex).length(); // Узнаем длину случайного слова
            randomWord = words.get(randomindex); // Сохраняем случайное слово
        }
    }

    // Метод для получения слова
    public String getrandomword() {
        return randomword;
    }

    // Метод для получения длины слова
    public int getlength() {
        return length;
    }
}