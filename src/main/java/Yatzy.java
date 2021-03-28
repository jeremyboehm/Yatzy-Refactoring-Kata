import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

public class Yatzy {

    private List<Integer> rolls;

    public Yatzy(List<Integer> rolls) {
        this.rolls = rolls;
    }

    public int chance() {
        return calculateScore(rolls);
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
        return getSumOf(rolls, 1);
    }

    public int twos() {
        return getSumOf(rolls, 2);
    }

    public int threes() {
        return getSumOf(rolls, 3);
    }

    public int fours() {
        return getSumOf(rolls, 4);
    }

    public int fives() {
        return getSumOf(rolls, 5);
    }

    public int sixes() {
        return getSumOf(rolls, 6);
    }

    public int score_pair() {

        List<Integer> highestPair = getHighestPair(rolls);

        return calculateScore(highestPair);
    }

    public int two_pair() {
        List<Integer> twoHighestPairs = getTwoHighestPairs(rolls);

        return calculateScore(twoHighestPairs);
    }

    public int four_of_a_kind() {
        return numberOfAKind(4);
    }

    public int three_of_a_kind() {
        return numberOfAKind(3);
    }

    public int smallStraight() {
        return calculateStraight(1);
    }

    public int largeStraight() {
        return calculateStraight(2);
    }

    public int fullHouse() {
        int twoOfAKind = numberOfAKind(2);
        int threeOfAKind = numberOfAKind(3);

        return twoOfAKind == 0 || threeOfAKind == 0 ? 0 : twoOfAKind + threeOfAKind;

    }

    private int getSumOf(List<Integer> rolls, int number) {
        return (int) rolls.stream().filter(roll -> roll.equals(number)).mapToLong(roll -> roll).sum();
    }

    private List<Integer> getHighestPair(List<Integer> rolls) {

        rolls.sort(Collections.reverseOrder());

        for (int i = 0; i < rolls.size(); i++) {
            if (rolls.get(i).equals(rolls.get(i + 1))) {
                return asList(rolls.get(i), rolls.get(i + 1));
            }
        }
        return Collections.emptyList();
    }

    private List<Integer> getTwoHighestPairs(List<Integer> rolls) {
        List<Integer> pairs = new ArrayList<>();

        pairs.addAll(getHighestPair(rolls));
        Integer integer = pairs.get(0);
        List<Integer> rollsUpdated = rolls.stream().filter(val -> !val.equals(integer)).collect(Collectors.toList());
        pairs.addAll(getHighestPair(rollsUpdated));

        return !pairs.isEmpty() ? pairs : Collections.emptyList();
    }

    private int calculateScore(List<Integer> rolls) {
        return rolls.stream().mapToInt(number -> number).sum();
    }

    private int calculateStraight(int straightStarter) {
        Collections.sort(rolls);

        if (!rolls.get(0).equals(straightStarter))
            return 0;

        for (int i = 0; i < rolls.size() - 1; i++) {
            if (!rolls.get(i + 1).equals(rolls.get(i) + 1)) {
                return 0;
            }
        }
        return calculateScore(rolls);
    }

    private int numberOfAKind(int kind) {
        int frequency;
        for (Integer roll : rolls) {
            frequency = Collections.frequency(rolls, roll);

            if (frequency >= kind) {
                return roll*kind;
            }
        }
        return 0;
    }
}



