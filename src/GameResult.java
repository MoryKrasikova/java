
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

    public void KolWin() { win += 1; }

    public int GetWin() { return win; }

    public int GetLoss() { return loss; }

    public void KolLoss() { loss += 1; }

    public int GetWinResult() {
        winresult = rightanswers + wronganswers;
        return winresult;
    }
}
