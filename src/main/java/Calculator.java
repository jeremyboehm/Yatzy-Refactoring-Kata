import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

public class Calculator {

    int getSumOf(List<Integer> rolls, int number) {
        return (int) rolls.stream().filter(roll -> roll.equals(number)).mapToLong(roll -> roll).sum();
    }

    List<Integer> getHighestPair(List<Integer> rolls) {

        rolls.sort(Collections.reverseOrder());

        for (int i = 0; i < rolls.size(); i++) {
            if (rolls.get(i).equals(rolls.get(i + 1))) {
                return asList(rolls.get(i), rolls.get(i + 1));
            }
        }
        return Collections.emptyList();
    }

    int calculateScore(List<Integer> rolls) {
        return rolls.stream().mapToInt(number -> number).sum();
    }

    int calculateStraight(List<Integer> rolls, int straightStarter) {
        Collections.sort(rolls);

        if (!rolls.get(0).equals(straightStarter))
            return 0;

        for (int i = 0; i < rolls.size() - 1; i++) {
            if (!rolls.get(i + 1).equals(rolls.get(i) + 1)) {
                return 0;
            }
        }
        return new Calculator().calculateScore(rolls);
    }

    List<Integer> getTwoHighestPairs(List<Integer> rolls) {

        List<Integer> pairs = new ArrayList<>(new Calculator().getHighestPair(rolls));
        Integer firstPair = pairs.get(0);
        List<Integer> rollsUpdated = rolls.stream().filter(val -> !val.equals(firstPair)).collect(Collectors.toList());
        pairs.addAll(new Calculator().getHighestPair(rollsUpdated));

        return !pairs.isEmpty() ? pairs : Collections.emptyList();
    }

    int numberOfAKind(List<Integer> rolls, int kind) {
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
