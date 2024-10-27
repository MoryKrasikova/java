import java.io.*;
import java.util.*;


public class Word {
    private String randomword; // Строка для хранения случайного слова
    private int length; // Длина слова

    // Конструктор
    public Word() {
        randomword = null;
        length = 0;
    }

    // Метод для выбора случайного слова
    public void SelectRandomWord(String filename) {

        List<String> words = new ArrayList<>(); // Список для хранения слов

        // Используем try-with-resources для автоматического закрытия файла
        try (BufferedReader file = new BufferedReader(new FileReader(filename))) {
            String word;

            // Читаем все слова из файла
            while ((word = file.readLine()) != null) { // Читаем построчно
                words.add(word); // Добавляем каждое считанное слово в список
            }

            if (!words.isEmpty()) {
                Random rand = new Random(); // Инициализация генератора случайных чисел
                int randomindex = rand.nextInt(words.size()); // Генерация случайного индекса
                length = words.get(randomindex).length(); // Узнаем длину случайного слова
                randomword = words.get(randomindex); // Сохраняем случайное слово
            }
        } catch (FileNotFoundException e) {
            System.err.println("Ошибка открытия файла");
        } catch (IOException e) {
            System.err.println("Ошибка чтения файла");
        }
    }

    // Метод для получения слова
    public String GetRandomWord() {
        return randomword;
    }

    // Метод для получения длины слова
    public int GetLength() {
        return length;
    }
}
