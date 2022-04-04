package com.SS8_CleanCode_Refactoring.bai_tap;

public class TennisGame {
    public static String getScore(int numberScoreOne, int numberScoreTwo) {
        String score = "";
        int tempScore;
        final boolean ratio = numberScoreOne == numberScoreTwo;
        if (ratio) {
            score = getNumberScoreOne(numberScoreOne);
        } else if (numberScoreOne >= 4 || numberScoreTwo >= 4) {
            score = getPlayToWin(numberScoreOne, numberScoreTwo);
        } else {
            for (int i = 1; i < 3; i++) {
                if (i == 1) tempScore = numberScoreOne;
                else {
                    score += "-";
                    tempScore = numberScoreTwo;
                }
                score = getScore(score, tempScore);
            }
        }
        return score;
    }

    private static String getScore(String score, int tempScore) {
        switch (tempScore) {
            case 0:
                score += "Love";
                break;
            case 1:
                score += "Fifteen";
                break;
            case 2:
                score += "Thirty";
                break;
            case 3:
                score += "Forty";
                break;
        }
        return score;
    }

    private static String getPlayToWin(int numberScoreOne, int numberScoreTwo) {
        String score;
        int minusResult = numberScoreOne - numberScoreTwo;
        if (minusResult == 1) score = "Advantage player1";
        else if (minusResult == -1) score = "Advantage player2";
        else if (minusResult >= 2) score = "Win for player1";
        else score = "Win for player2";
        return score;
    }

    private static String getNumberScoreOne(int numberScoreOne) {
        String score;
        switch (numberScoreOne) {
            case 0:
                score = "Love-All";
                break;
            case 1:
                score = "Fifteen-All";
                break;
            case 2:
                score = "Thirty-All";
                break;
            case 3:
                score = "Forty-All";
                break;
            default:
                score = "Deuce";
                break;

        }
        return score;
    }

    public static void main(String[] args) {
        System.out.println(getScore(0,0));
        System.out.println(getScore(14,17));
        System.out.println(getScore(2,3));
        System.out.println(getScore(18,12));
    }
}
