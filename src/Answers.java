import java.util.ArrayList;

public class Answers {
    protected int wronganswers; // Количество неверных ответов
    protected int rightanswers; // Количество верных ответов
    private int tries; // Количество попыток
    private String currentword; // Текущее слово
    private ArrayList<Letter> letters; // Массив объектов Letter

    public void setCurrentWord(String word) {
        currentword = word;
    }
    public void setAnswer(char ans) {
        addLetter(ans); // Записываем букву в массив
    }
    private void addLetter(char letter) {
        letters.add(new Letter(letter)); // Создаем новый объект и добавляем в массив
    }
    public void check(char answer, int wordLength, String usedLetters, char[] ansPeople) {
        int kol = 0; // Количество совпадений
        int kol1 = 0; // Количество использованных букв

        for (int i = 0; i < wordLength; i++) {
            if (Character.toLowerCase(answer) == Character.toLowerCase(currentword.charAt(i))) {
                kol += 1;
                ansPeople[i] = currentword.charAt(i); // Открываем букву в ansPeople
            }
        }

        for (int i = 0; i < usedLetters.length(); i++) {
            if (Character.toLowerCase(answer) == Character.toLowerCase(usedLetters.charAt(i))) {
                kol1 += 1;
                usedLetters = usedLetters.substring(0, i) + '.' + usedLetters.substring(i + 1); // Убираем использованную букву
            }
        }

        // Проверка на правильный или неверный ответ
        if (kol > 0 && kol1 > 0) { // Верный ответ
            rightanswers += 1;
            System.out.println("Вы угадали букву: " + String.valueOf(ansPeople));
        } else { // Неверный ответ
            wronganswers += 1;
            System.out.println("Вы не угадали букву или уже использовали её: " + String.valueOf(ansPeople));
            tries = 6 - wronganswers; // Обновление количества оставшихся попыток
            System.out.println("У вас осталось " + tries + " попыток.");
        }
    }

    public int getRightAnswers() {
        return rightanswers;
    }

    // Метод для получения количества неверных ответов
    public int getWrongAnswers() {
        return wronganswers;
    }

    public void displayLetters() {
        System.out.print("Введенные буквы: ");
        for (Letter letter : letters) {
            System.out.print(letter.getValue() + " "); // Получаем значения букв
        }
        System.out.println();
    }
}
