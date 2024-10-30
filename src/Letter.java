import java.util.Scanner;
public class Letter {
    private Scanner scanner;

    public Letter(Scanner scanner) {
        this.scanner = scanner; // Инициализация scanner
    }
    // Конструктор
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
