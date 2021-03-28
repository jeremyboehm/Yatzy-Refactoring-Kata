import org.junit.Test;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public class YatzyTest {

    @Test
    public void chance_scores_sum_of_all_dice() {
        assertEquals(15, new Yatzy(asList(2, 3, 4, 5, 1)).chance());
        assertEquals(16, new Yatzy(asList(3, 3, 4, 5, 1)).chance());
    }

    @Test
    public void yatzy_scores_50_when_all_dices_numbers_are_the_same_2() {
        assertEquals(50, new Yatzy(asList(4, 4, 4, 4, 4)).yatzy());
        assertEquals(50, new Yatzy(asList(6, 6, 6, 6, 6)).yatzy());
    }

    @Test
    public void yatzy_scores_0_when_there_is_a_difference_into_dices_numbers() {
        assertEquals(0, new Yatzy(asList(6, 6, 6, 6, 3)).yatzy());
    }

    @Test
    public void test_1s() {
        assertEquals(1, new Yatzy(asList(1, 2, 3, 4, 5)).ones());
        assertEquals(2, new Yatzy(asList(1, 2, 1, 4, 5)).ones());
        assertEquals(0, new Yatzy(asList(6, 2, 2, 4, 5)).ones());
        assertEquals(4, new Yatzy(asList(1, 2, 1, 1, 1)).ones());
    }

    @Test
    public void test_2s() {
        assertEquals(4, new Yatzy(asList(1, 2, 3, 2, 6)).twos());
        assertEquals(10, new Yatzy(asList(2, 2, 2, 2, 2)).twos());
    }

    @Test
    public void test_threes() {
        assertEquals(6, new Yatzy(asList(1, 2, 3, 2, 3)).threes());
        assertEquals(12, new Yatzy(asList(2, 3, 3, 3, 3)).threes());
    }

    @Test
    public void fours_test() {
        assertEquals(12, new Yatzy(asList(4, 4, 4, 5, 5)).fours());
        assertEquals(8, new Yatzy(asList(4, 4, 5, 5, 5)).fours());
        assertEquals(4, new Yatzy(asList(4, 5, 5, 5, 5)).fours());
    }

    @Test
    public void fives() {
        assertEquals(10, new Yatzy(asList(4, 4, 4, 5, 5)).fives());
        assertEquals(15, new Yatzy(asList(4, 4, 5, 5, 5)).fives());
        assertEquals(20, new Yatzy(asList(4, 5, 5, 5, 5)).fives());
    }

    @Test
    public void sixes_test() {
        assertEquals(0, new Yatzy(asList(4, 4, 4, 5, 5)).sixes());
        assertEquals(6, new Yatzy(asList(4, 4, 6, 5, 5)).sixes());
        assertEquals(18, new Yatzy(asList(6, 5, 6, 6, 5)).sixes());
    }

    @Test
    public void one_pair() {
        assertEquals(6, new Yatzy(asList(3, 4, 3, 5, 6)).score_pair());
        assertEquals(10, new Yatzy(asList(5, 3, 3, 3, 5)).score_pair());
        assertEquals(12, new Yatzy(asList(5, 3, 6, 6, 5)).score_pair());
    }

    @Test
    public void two_Pair() {
        assertEquals(16, new Yatzy(asList(3, 3, 5, 4, 5)).two_pair());
        assertEquals(16, new Yatzy(asList(3, 3, 5, 5, 5)).two_pair());
    }

    @Test
    public void three_of_a_kind() {
        assertEquals(9, Yatzy.three_of_a_kind(3, 3, 3, 4, 5));
        assertEquals(15, Yatzy.three_of_a_kind(5, 3, 5, 4, 5));
        assertEquals(9, Yatzy.three_of_a_kind(3, 3, 3, 3, 5));
    }

    @Test
    public void four_of_a_knd() {
        assertEquals(12, Yatzy.four_of_a_kind(3, 3, 3, 3, 5));
        assertEquals(20, Yatzy.four_of_a_kind(5, 5, 5, 4, 5));
        assertEquals(9, Yatzy.three_of_a_kind(3, 3, 3, 3, 3));
    }

    @Test
    public void smallStraight() {
        assertEquals(15, new Yatzy(asList(1, 2, 3, 4, 5)).smallStraight());
        assertEquals(15, new Yatzy(asList(2, 3, 4, 5, 1)).smallStraight());
        assertEquals(0, new Yatzy(asList(1, 2, 2, 4, 5)).smallStraight());
    }

    @Test
    public void largeStraight() {
        assertEquals(20, new Yatzy(asList(6, 2, 3, 4, 5)).largeStraight());
        assertEquals(20, new Yatzy(asList(2, 3, 4, 5, 6)).largeStraight());
        assertEquals(0, new Yatzy(asList(1, 2, 2, 4, 5)).largeStraight());
    }

    @Test
    public void fullHouse() {
        assertEquals(18, Yatzy.fullHouse(6, 2, 2, 2, 6));
        assertEquals(0, Yatzy.fullHouse(2, 3, 4, 5, 6));
    }
}
