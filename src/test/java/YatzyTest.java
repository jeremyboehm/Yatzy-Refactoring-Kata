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
    public void yatzy_scores_50_when_all_dices_numbers_are_the_same() {
        assertEquals(50, new Yatzy(asList(4, 4, 4, 4, 4)).yatzy());
        assertEquals(50, new Yatzy(asList(6, 6, 6, 6, 6)).yatzy());
    }

    @Test
    public void yatzy_scores_0_when_there_is_a_difference_into_dices_numbers() {
        assertEquals(0, new Yatzy(asList(6, 6, 6, 6, 3)).yatzy());
    }

    @Test
    public void ones_scores_the_sum_of_all_1_into_dices_numbers() {
        assertEquals(1, new Yatzy(asList(1, 2, 3, 4, 5)).ones());
        assertEquals(2, new Yatzy(asList(1, 2, 1, 4, 5)).ones());
        assertEquals(0, new Yatzy(asList(6, 2, 2, 4, 5)).ones());
        assertEquals(4, new Yatzy(asList(1, 2, 1, 1, 1)).ones());
    }

    @Test
    public void twos_scores_the_sum_of_all_2_into_dices_numbers() {
        assertEquals(4, new Yatzy(asList(1, 2, 3, 2, 6)).twos());
        assertEquals(10, new Yatzy(asList(2, 2, 2, 2, 2)).twos());
    }

    @Test
    public void threes_scores_the_sum_of_all_3_into_dices_numbers() {
        assertEquals(6, new Yatzy(asList(1, 2, 3, 2, 3)).threes());
        assertEquals(12, new Yatzy(asList(2, 3, 3, 3, 3)).threes());
    }

    @Test
    public void fours_scores_the_sum_of_all_4_into_dices_numbers() {
        assertEquals(12, new Yatzy(asList(4, 4, 4, 5, 5)).fours());
        assertEquals(8, new Yatzy(asList(4, 4, 5, 5, 5)).fours());
        assertEquals(4, new Yatzy(asList(4, 5, 5, 5, 5)).fours());
    }

    @Test
    public void fives_scores_the_sum_of_all_5_into_dices_numbers() {
        assertEquals(10, new Yatzy(asList(4, 4, 4, 5, 5)).fives());
        assertEquals(15, new Yatzy(asList(4, 4, 5, 5, 5)).fives());
        assertEquals(20, new Yatzy(asList(4, 5, 5, 5, 5)).fives());
    }

    @Test
    public void sixes_scores_the_sum_of_all_6_into_dices_numbers() {
        assertEquals(0, new Yatzy(asList(4, 4, 4, 5, 5)).sixes());
        assertEquals(6, new Yatzy(asList(4, 4, 6, 5, 5)).sixes());
        assertEquals(18, new Yatzy(asList(6, 5, 6, 6, 5)).sixes());
    }

    @Test
    public void one_pair_scores_the_sum_of_the_high_pair_into_dices_numbers() {
        assertEquals(6, new Yatzy(asList(3, 4, 3, 5, 6)).score_pair());
        assertEquals(10, new Yatzy(asList(5, 3, 3, 3, 5)).score_pair());
        assertEquals(12, new Yatzy(asList(5, 3, 6, 6, 5)).score_pair());
    }

    @Test
    public void two_pairs_scores_the_sum_of_the_two_high_pairs_into_dices_numbers() {
        assertEquals(16, new Yatzy(asList(3, 3, 5, 4, 5)).two_pair());
        assertEquals(16, new Yatzy(asList(3, 3, 5, 5, 5)).two_pair());
    }

    @Test
    public void three_of_a_kind_scores_the_sum_of_the_triple_occurrence_of_a_kind_into_dices_numbers() {
        assertEquals(9, new Yatzy(asList(3, 3, 3, 4, 5)).three_of_a_kind());
        assertEquals(15, new Yatzy(asList(5, 3, 5, 4, 5)).three_of_a_kind());
        assertEquals(9, new Yatzy(asList(3, 3, 3, 3, 5)).three_of_a_kind());
    }

    @Test
    public void four_of_a_kind_scores_the_sum_of_the_four_occurrence_of_a_kind_into_dices_numbers() {
        assertEquals(12, new Yatzy(asList(3, 3, 3, 3, 5)).four_of_a_kind());
        assertEquals(20, new Yatzy(asList(5, 5, 5, 4, 5)).four_of_a_kind());
        assertEquals(12, new Yatzy(asList(3, 3, 3, 3, 3)).four_of_a_kind());
    }

    @Test
    public void small_straight_scores_the_sum_of_a_suite_of_1_2_3_4_and_5_into_dices_numbers() {
        assertEquals(15, new Yatzy(asList(1, 2, 3, 4, 5)).smallStraight());
        assertEquals(15, new Yatzy(asList(2, 3, 4, 5, 1)).smallStraight());
        assertEquals(0, new Yatzy(asList(1, 2, 2, 4, 5)).smallStraight());
    }

    @Test
    public void large_straight_scores_the_sum_of_a_suite_of_2_3_4_5_and_6_into_dices_numbers() {
        assertEquals(20, new Yatzy(asList(6, 2, 3, 4, 5)).largeStraight());
        assertEquals(20, new Yatzy(asList(2, 3, 4, 5, 6)).largeStraight());
        assertEquals(0, new Yatzy(asList(1, 2, 2, 4, 5)).largeStraight());
    }

    @Test
    public void full_house_scores_the_sum_of_two_of_a_kind_and_a_three_of_a_kind_into_dices_numbers() {
        assertEquals(18, new Yatzy(asList(6, 2, 2, 2, 6)).fullHouse());
        assertEquals(0, new Yatzy(asList(2, 3, 4, 5, 6)).fullHouse());
    }
}
