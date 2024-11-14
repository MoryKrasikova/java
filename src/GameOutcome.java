

public class GameOutcome {
    private int rightanswers;
    private int wronganswers;
    static int kolgame;
    public GameOutcome(int rightAnswers, int wrongAnswers) {
        this.rightanswers = rightAnswers;
        this.wronganswers = wrongAnswers;
        kolgame += 1;
    }

    public int GetRightAnswers() {
        return rightanswers;
    }

    public int GetWrongAnswers() {
        return wronganswers;
    }

    @Override
    public String toString() {
        return "Правильные ответы: " + rightanswers + ", Неверные ответы: " + wronganswers;
    }
    public static int GetKolGame() {
        return kolgame;
    }
}
