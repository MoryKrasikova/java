import java.util.Scanner;
public class Letter implements Cloneable{
    private Scanner scanner;
    // Конструктор
    public Letter(Scanner scanner) {
        this.scanner = scanner; // Инициализация scanner
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
    // Мелкое копирование
    public Letter shallowCopy() {
        try {
            return (Letter) this.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Клонирование не поддерживается", e);
        }
    }

    // Глубокое копирование
    public Letter deepCopy() {
        return new Letter(new Scanner(System.in));
    }
}
