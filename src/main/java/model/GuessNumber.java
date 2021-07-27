package model;

import model.score.Ball;
import model.score.Strike;
import view.Input;
import view.Out;

import java.util.List;

public class GuessNumber {
    private List<String> inputNumbers;
    private final List<String> randomNumbers;
    private Strike strike;
    private Ball ball;

    public GuessNumber(List<String> inputNumbers, List<String> randomNumbers) {
        this.inputNumbers = inputNumbers;
        this.randomNumbers = randomNumbers;
    }

    public void guessResult() {
        int strikeCount = 0;

        while (true) {
            Strike strike = new Strike(this.inputNumbers, this.randomNumbers);
            Ball ball = new Ball(this.inputNumbers, this.randomNumbers);
            strikeCount = strike.countStrike();

            if (strikeCount == 3) {
                System.out.println("3 스트라이크!");
                break;
            }

            Out.resultOut(ball.countBall(), strike.countStrike());
            CheckInput checkInput = new CheckInput(Input.InputBaseballNumber());
            this.inputNumbers = checkInput.checkInputNumber();
        }
    }
}
