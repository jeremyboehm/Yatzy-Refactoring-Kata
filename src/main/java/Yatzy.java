import java.util.List;

public class Yatzy {

    private List<Integer> rolls;
    private Calculator calculator;

    public Yatzy(List<Integer> rolls, Calculator calculator) {
        this.rolls = rolls;
        this.calculator = calculator;
    }

    public int chance() {
        return calculator.calculateScore(rolls);
    }

    public int yatzy() {
        for (int i = 0; i < rolls.size(); i++) {
            for (int k = i + 1; k < rolls.size(); k++) {
                if (!rolls.get(i).equals(rolls.get(k))) {
                    return 0;
                }
            }
        }
        return 50;
    }

    public int ones() {
        return calculator.getSumOf(rolls, 1);
    }

    public int twos() {
        return calculator.getSumOf(rolls, 2);
    }

    public int threes() {
        return calculator.getSumOf(rolls, 3);
    }

    public int fours() {
        return calculator.getSumOf(rolls, 4);
    }

    public int fives() {
        return calculator.getSumOf(rolls, 5);
    }

    public int sixes() {
        return calculator.getSumOf(rolls, 6);
    }

    public int score_pair() {

        List<Integer> highestPair = calculator.getHighestPair(rolls);

        return calculator.calculateScore(highestPair);
    }

    public int two_pair() {
        List<Integer> twoHighestPairs = calculator.getTwoHighestPairs(rolls);

        return calculator.calculateScore(twoHighestPairs);
    }

    public int four_of_a_kind() {
        return calculator.numberOfAKind(this.rolls, 4);
    }

    public int three_of_a_kind() {
        return calculator.numberOfAKind(this.rolls, 3);
    }

    public int smallStraight() {
        return calculator.calculateStraight(this.rolls, 1);
    }

    public int largeStraight() {
        return calculator.calculateStraight(this.rolls, 2);
    }

    public int fullHouse() {
        int twoOfAKind = calculator.numberOfAKind(this.rolls, 2);
        int threeOfAKind = calculator.numberOfAKind(this.rolls, 3);

        return twoOfAKind == 0 || threeOfAKind == 0 ? 0 : twoOfAKind + threeOfAKind;

    }
}



