import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TennisScorerTest {

    @Test
    public void initialScoreReturnLoveLove() {
        TennisScorer tennisScorer = new TennisScorer();

        String actual = tennisScorer.getScore();
        String expected = "0-0";

        assertEquals(actual, expected);
    }

    @Test
    public void playerAScoresReturnsFifteenLove() {
        TennisScorer tennisScorer = new TennisScorer();

        tennisScorer.playerAScores();
        String actual = tennisScorer.getScore();
        String expected = "15-0";

        assertEquals(actual, expected);
    }

    @Test
    public void playerAScoresTwiceReturnsThirtyLove() {
        TennisScorer tennisScorer = new TennisScorer();

        tennisScorer.playerAScores();
        tennisScorer.playerAScores();
        String actual = tennisScorer.getScore();
        String expected = "30-0";

        assertEquals(actual, expected);
    }

    @Test
    public void playersTiedAtThirtyReturnsThirtyThirty() {
        TennisScorer tennisScorer = new TennisScorer();

        tennisScorer.playerAScores();
        tennisScorer.playerAScores();
        tennisScorer.playerBScores();
        tennisScorer.playerBScores();
        String actual = tennisScorer.getScore();
        String expected = "30-30";

        assertEquals(actual, expected);
    }

    @Test
    public void playerBScoresThreeTimesReturnsLoveFourty() {
        TennisScorer tennisScorer = new TennisScorer();

        tennisScorer.playerBScores();
        tennisScorer.playerBScores();
        tennisScorer.playerBScores();
        String actual = tennisScorer.getScore();
        String expected = "0-40";

        assertEquals(actual, expected);
    }

    @Test
    public void playersTiedAtFourtyReturnsDeuce() {
        TennisScorer tennisScorer = new TennisScorer();

        tennisScorer.playerAScores();
        tennisScorer.playerAScores();
        tennisScorer.playerAScores();
        tennisScorer.playerBScores();
        tennisScorer.playerBScores();
        tennisScorer.playerBScores();
        String actual = tennisScorer.getScore();
        String expected = "Deuce";

        assertEquals(actual, expected);
    }

    @Test
    public void playerAScoresInDeuceReturnsAdvantagePlayerA() {
        TennisScorer tennisScorer = new TennisScorer();

        tennisScorer.playerAScores();
        tennisScorer.playerAScores();
        tennisScorer.playerAScores();
        tennisScorer.playerBScores();
        tennisScorer.playerBScores();
        tennisScorer.playerBScores();
        tennisScorer.playerAScores();
        String actual = tennisScorer.getScore();
        String expected = "-Advantage";

        assertEquals(actual, expected);
    }

    @Test
    public void playerBScoresInDeuceReturnsAdvantagePlayerB() {
        TennisScorer tennisScorer = new TennisScorer();

        tennisScorer.playerBScores();
        tennisScorer.playerBScores();
        tennisScorer.playerBScores();
        tennisScorer.playerAScores();
        tennisScorer.playerAScores();
        tennisScorer.playerAScores();
        tennisScorer.playerBScores();
        String actual = tennisScorer.getScore();
        String expected = "Advantage-";

        assertEquals(actual, expected);
    }

    @Test
    public void playerBWinsReturnsGamePlayerB() {
        TennisScorer tennisScorer = new TennisScorer();

        tennisScorer.playerBScores();
        tennisScorer.playerBScores();
        tennisScorer.playerBScores();
        tennisScorer.playerBScores();
        String actual = tennisScorer.getScore();
        String expected = "Game-";

        assertEquals(actual, expected);
    }

    @Test
    public void playerAWinsReturnsGamePlayerA() {
        TennisScorer tennisScorer = new TennisScorer();

        tennisScorer.playerAScores();
        tennisScorer.playerAScores();
        tennisScorer.playerAScores();
        tennisScorer.playerBScores();
        tennisScorer.playerBScores();
        tennisScorer.playerBScores();
        tennisScorer.playerAScores();
        tennisScorer.playerAScores();
        String actual = tennisScorer.getScore();
        String expected = "-Game";

        assertEquals(actual, expected);
    }
}
