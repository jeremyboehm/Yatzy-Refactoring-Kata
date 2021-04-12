import org.junit.Test;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public class YatzyTest {

    private Calculator calculator = new Calculator();

    @Test
    public void chance_scores_sum_of_all_dice() {
        assertEquals(15, new Yatzy(asList(2, 3, 4, 5, 1), calculator).chance());
        assertEquals(16, new Yatzy(asList(3, 3, 4, 5, 1), calculator).chance());
    }

    @Test
    public void yatzy_scores_50_when_all_dices_numbers_are_the_same() {
        assertEquals(50, new Yatzy(asList(4, 4, 4, 4, 4), calculator).yatzy());
        assertEquals(50, new Yatzy(asList(6, 6, 6, 6, 6), calculator).yatzy());
    }

    @Test
    public void yatzy_scores_0_when_there_is_a_difference_into_dices_numbers() {
        assertEquals(0, new Yatzy(asList(6, 6, 6, 6, 3), calculator).yatzy());
    }

    @Test
    public void ones_scores_the_sum_of_all_1_into_dices_numbers() {
        assertEquals(1, new Yatzy(asList(1, 2, 3, 4, 5), calculator).ones());
        assertEquals(2, new Yatzy(asList(1, 2, 1, 4, 5), calculator).ones());
        assertEquals(0, new Yatzy(asList(6, 2, 2, 4, 5), calculator).ones());
        assertEquals(4, new Yatzy(asList(1, 2, 1, 1, 1), calculator).ones());
    }

    @Test
    public void twos_scores_the_sum_of_all_2_into_dices_numbers() {
        assertEquals(4, new Yatzy(asList(1, 2, 3, 2, 6), calculator).twos());
        assertEquals(10, new Yatzy(asList(2, 2, 2, 2, 2), calculator).twos());
    }

    @Test
    public void threes_scores_the_sum_of_all_3_into_dices_numbers() {
        assertEquals(6, new Yatzy(asList(1, 2, 3, 2, 3), calculator).threes());
        assertEquals(12, new Yatzy(asList(2, 3, 3, 3, 3), calculator).threes());
    }

    @Test
    public void fours_scores_the_sum_of_all_4_into_dices_numbers() {
        assertEquals(12, new Yatzy(asList(4, 4, 4, 5, 5), calculator).fours());
        assertEquals(8, new Yatzy(asList(4, 4, 5, 5, 5), calculator).fours());
        assertEquals(4, new Yatzy(asList(4, 5, 5, 5, 5), calculator).fours());
    }

    @Test
    public void fives_scores_the_sum_of_all_5_into_dices_numbers() {
        assertEquals(10, new Yatzy(asList(4, 4, 4, 5, 5), calculator).fives());
        assertEquals(15, new Yatzy(asList(4, 4, 5, 5, 5), calculator).fives());
        assertEquals(20, new Yatzy(asList(4, 5, 5, 5, 5), calculator).fives());
    }

    @Test
    public void sixes_scores_the_sum_of_all_6_into_dices_numbers() {
        assertEquals(0, new Yatzy(asList(4, 4, 4, 5, 5), calculator).sixes());
        assertEquals(6, new Yatzy(asList(4, 4, 6, 5, 5), calculator).sixes());
        assertEquals(18, new Yatzy(asList(6, 5, 6, 6, 5), calculator).sixes());
    }

    @Test
    public void one_pair_scores_the_sum_of_the_high_pair_into_dices_numbers() {
        assertEquals(6, new Yatzy(asList(3, 4, 3, 5, 6), calculator).score_pair());
        assertEquals(10, new Yatzy(asList(5, 3, 3, 3, 5), calculator).score_pair());
        assertEquals(12, new Yatzy(asList(5, 3, 6, 6, 5), calculator).score_pair());
    }

    @Test
    public void two_pairs_scores_the_sum_of_the_two_high_pairs_into_dices_numbers() {
        assertEquals(16, new Yatzy(asList(3, 3, 5, 4, 5), calculator).two_pair());
        assertEquals(16, new Yatzy(asList(3, 3, 5, 5, 5), calculator).two_pair());
    }

    @Test
    public void three_of_a_kind_scores_the_sum_of_the_triple_occurrence_of_a_kind_into_dices_numbers() {
        assertEquals(9, new Yatzy(asList(3, 3, 3, 4, 5), calculator).three_of_a_kind());
        assertEquals(15, new Yatzy(asList(5, 3, 5, 4, 5), calculator).three_of_a_kind());
        assertEquals(9, new Yatzy(asList(3, 3, 3, 3, 5), calculator).three_of_a_kind());
    }

    @Test
    public void four_of_a_kind_scores_the_sum_of_the_four_occurrence_of_a_kind_into_dices_numbers() {
        assertEquals(12, new Yatzy(asList(3, 3, 3, 3, 5), calculator).four_of_a_kind());
        assertEquals(20, new Yatzy(asList(5, 5, 5, 4, 5), calculator).four_of_a_kind());
        assertEquals(12, new Yatzy(asList(3, 3, 3, 3, 3), calculator).four_of_a_kind());
    }

    @Test
    public void small_straight_scores_the_sum_of_a_suite_of_1_2_3_4_and_5_into_dices_numbers() {
        assertEquals(15, new Yatzy(asList(1, 2, 3, 4, 5), calculator).smallStraight());
        assertEquals(15, new Yatzy(asList(2, 3, 4, 5, 1), calculator).smallStraight());
        assertEquals(0, new Yatzy(asList(1, 2, 2, 4, 5), calculator).smallStraight());
    }

    @Test
    public void large_straight_scores_the_sum_of_a_suite_of_2_3_4_5_and_6_into_dices_numbers() {
        assertEquals(20, new Yatzy(asList(6, 2, 3, 4, 5), calculator).largeStraight());
        assertEquals(20, new Yatzy(asList(2, 3, 4, 5, 6), calculator).largeStraight());
        assertEquals(0, new Yatzy(asList(1, 2, 2, 4, 5), calculator).largeStraight());
    }

    @Test
    public void full_house_scores_the_sum_of_two_of_a_kind_and_a_three_of_a_kind_into_dices_numbers() {
        assertEquals(18, new Yatzy(asList(6, 2, 2, 2, 6), calculator).fullHouse());
        assertEquals(0, new Yatzy(asList(2, 3, 4, 5, 6), calculator).fullHouse());
    }
}
