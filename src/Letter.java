import java.util.Scanner;
public class Letter {
    private char letter;
    private Scanner scanner;
    public Letter() {}

    public Letter(Scanner scanner) {
        this.scanner = scanner; // Инициализация scanner
    }
    // Конструктор
    public Letter(char letter) {
        this.letter = letter;
    }

    // Метод для получения буквы
    public char GetValue() {
        return letter;
    }
    public char Chek()
    {

        char letter;
        while (true)
        {
            String input = scanner.next(); // Читаем следующее слово (строку)

             // Проверка: введённое значение должно состоять из 1 символа и быть буквой
            if (input.length() == 1 && Character.isLetter(input.charAt(0))) {
                letter = input.charAt(0);
                break; // Если всё верно, выходим из цикла
            } else {
                System.out.println("Ошибка: Пожалуйста, введите только одну букву.");
            }
        }
        return letter;
    }
}
