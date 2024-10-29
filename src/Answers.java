import java.util.ArrayList;
import java.util.List;
public class Answers {
    protected int wronganswers; // Количество неверных ответов
    protected int rightanswers; // Количество верных ответов
    private int tries; // Количество попыток
    private String currentword; // Текущее слово
    private ArrayList<Letter> letters; // Массив объектов Letter

    public Answers() {
        wronganswers = 0;
        this.rightanswers = 0;
        tries = 6;
        currentword = "";
        letters = new ArrayList<>(); // Инициализация ArrayList
    }
    public Answers(int wornganswers, int rightanswers) {
        this.wronganswers = wronganswers;
        this.rightanswers = rightanswers;
        this.tries = 6; // или установите значение по умолчанию
        this.currentword = "";
        this.letters = new ArrayList<>();
    }

    public void SetCurrentWord(String word) {
        currentword = word;
    }
    public void SetAnswer(char ans) {
        AddLetter(ans); // Записываем букву в массив
    }
    private void AddLetter(char letter) {
        letters.add(new Letter(letter)); // Создаем новый объект и добавляем в массив
    }
    public void Check(char answer, int wordlength, String usedletters, List<Character> anspeople) {
        int kol = 0; // Количество совпадений
        int kol1 = 0; // Количество использованных букв

        for (int i = 0; i < wordlength; i++) {
            if (Character.toLowerCase(answer) == Character.toLowerCase(currentword.charAt(i))) {
                kol += 1;
                anspeople.set(i, currentword.charAt(i)); // Открываем букву в ansPeople
            }
        }

        for (int i = 0; i < usedletters.length(); i++) {
            if (Character.toLowerCase(answer) == Character.toLowerCase(usedletters.charAt(i))) {
                kol1 += 1;
                usedletters = usedletters.substring(0, i) + '.' + usedletters.substring(i + 1); // Убираем использованную букву
            }
        }

        // Проверка на правильный или неверный ответ
        if (kol > 0 && kol1 > 0) { // Верный ответ
            rightanswers += 1;
            System.out.println("Вы угадали букву: " + String.valueOf(anspeople));
        } else { // Неверный ответ
            wronganswers += 1;
            System.out.println("Вы не угадали букву или уже использовали её: " + String.valueOf(anspeople));
            tries = 6 - wronganswers; // Обновление количества оставшихся попыток
            System.out.println("У вас осталось " + tries + " попыток.");
        }
    }

    public int GetRightAnswers() {
        return rightanswers;
    }

    // Метод для получения количества неверных ответов
    public int GetWrongAnswers() {
        return wronganswers;
    }

    public void DisplayLetters() {
        System.out.print("Введенные буквы: ");
        for (Letter letter : letters) {
            System.out.print(letter.GetValue() + " "); // Получаем значения букв
        }
        System.out.println();
    }
}
