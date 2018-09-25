package main.java;

public class TennisGame1 implements ITennisGame {
    
    private int _player1Score = 0;
    private int _player2Score = 0;
    private String _player1Name;
    private String _player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this._player1Name = player1Name;
        this._player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(this._player1Name))
            _player1Score += 1;
        else
            _player2Score += 1;
    }

    public String getScore() {
        if (_player1Score == _player2Score)
        {
            return getTiedScore();
        }
        else if (_player1Score >=4 || _player2Score >=4)
        {
            return getAdvantageOrWinScore();
        }
        else
        {
            return translateScore(_player1Score) + "-" + translateScore(_player2Score);
        }
    }

    private String getAdvantageOrWinScore() {
        String score;
        int minusResult = _player1Score - _player2Score;
        if (minusResult==1) {
            score ="Advantage " + this._player1Name;
        } else if (minusResult ==-1) {
            score ="Advantage " + this._player2Name;
        } else if (minusResult>=2) {
            score = "Win for " + this._player1Name;
        } else {
            score ="Win for " + this._player2Name;
        }
        return score;
    }

    private String getTiedScore() {
        if (_player1Score <= 2) {
            return translateScore(_player1Score) + "-All";
        } else {
            return "Deuce";
        }

    }

    private String translateScore(int scoreNumber) {
        switch (scoreNumber) {
            case 0:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            default:
                return "Forty";
        }
    }
}
