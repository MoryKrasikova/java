

public class GameOutcome {
    private int rightanswers;
    private int wronganswers;

    public GameOutcome(int rightAnswers, int wrongAnswers) {
        this.rightanswers = rightAnswers;
        this.wronganswers = wrongAnswers;
    }

    public int getRightAnswers() {
        return rightanswers;
    }

    public int getWrongAnswers() {
        return wronganswers;
    }

    @Override
    public String toString() {
        return "Правильные ответы: " + rightanswers + ", Неверные ответы: " + wronganswers;
    }
}
