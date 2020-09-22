public class TennisScorer implements ITennisScorer {

    private int playerAScore = 0;
    private int playerBScore = 0;

    @Override
    public void playerAScores() {
        playerAScore = calcScore(playerAScore);
    }

    @Override
    public void playerBScores() {
        playerBScore = calcScore(playerBScore);
    }

    @Override
    public String getScore() {
        if (checkIfDeuce()) {
            return "Deuce";
        }

        if (checkIfAPlayerOverForty()) {
            return checkIfAdvantageOrGame();
        }

        return playerAScore + "-" + playerBScore;
    }

    private int calcScore(int player) {
        if (player == 30) {
            return player + 10;
        } else {
            return player + 15;
        }
    }

    private String checkIfAdvantageOrGame() {
        if (checkIfGame(playerAScore, playerBScore)) {
            return "-Game";
        } else if (checkIfGame(playerBScore, playerAScore)) {
            return "Game-";
        } else if (checkIfAdvantage(playerAScore, playerBScore)) {
            return "-Advantage";
        } else if (checkIfAdvantage(playerBScore, playerAScore)) {
            return "Advantage-";
        }
        return null;
    }

    private boolean checkIfAdvantage(int player, int enemy) {
        return player > enemy;
    }

    private boolean checkIfGame(int player, int enemy) {
        return (player - 30) >= enemy;
    }


    private boolean checkIfAPlayerOverForty() {
        return playerAScore > 40 || playerBScore > 40;
    }

    private boolean checkIfDeuce() {
        return playerAScore == playerBScore && playerAScore == 40;
    }
}
