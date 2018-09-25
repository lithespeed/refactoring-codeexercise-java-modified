package main.java;

public class TennisGame2 implements ITennisGame
{
    private int _player1Point = 0;
    private int _player2Point = 0;
    
    private String _player1Name;
    private String _player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this._player1Name = player1Name;
        this._player2Name = player2Name;
    }

    private String translateScore(int numberScore) {
        if (numberScore == 0) {
            return "Love";
        } else if (numberScore == 1) {
            return "Fifteen";
        } else if (numberScore == 2) {
            return "Thirty";
        } else if (numberScore == 3) {
            return "Forty";
        }
        return "Exception";
    }

    public String getScore(){
        if (_player1Point == _player2Point) {
            return getTieScore();
        }

        if (_player1Point > _player2Point && _player1Point < 4)
        {
            return translateScore(this._player1Point) + "-" + translateScore(this._player2Point);
        }
        if (_player2Point > _player1Point && _player2Point < 4)
        {
            return translateScore(this._player1Point) + "-" + translateScore(this._player2Point);
        }

        return getAdvantageOrWinningScore();
    }

    private String getTieScore() {
        if (_player1Point == _player2Point && _player1Point < 3)
        {
            return translateScore(_player1Point) + "-All";
        }
        return "Deuce";
    }

    private String getAdvantageOrWinningScore() {
        String score = "";
        if ((_player1Point > _player2Point || _player2Point > _player1Point) &&
                (_player1Point >= 3 ||_player2Point >= 3))
        {
            score = "Advantage " + whoIsWinning();
        }

        if ((_player1Point >=4 || _player2Point >=4) &&
            Math.abs(_player1Point - _player2Point)>=2)
        {
            score = "Win for " +  whoIsWinning();
        }
        return score;
    }

    private String whoIsWinning() {
        if (this._player1Point > this._player2Point) {
            return this._player1Name;
        }
        return this._player2Name;
    }
    
    public void wonPoint(String player) {
        if (player.equals(this._player1Name)) {
            _player1Point++;
        } else {
            _player2Point++;
        }
    }
}