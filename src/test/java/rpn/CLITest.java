package rpn;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static rpn.CLI.*;

public class CLITest {

    @Test
    public void should_evaluate_single_digit_constant() {
        assertThat(evaluate("5")).isEqualTo(5);
    }

    @Test
    public void should_evaluate_multiple_digits_constant() {
        assertThat(evaluate("17")).isEqualTo(17);
    }

    @Test
    public void should_evaluate_simple_addition() {
        assertThat(evaluate("17 5 +")).isEqualTo(22);
    }

    @Test
    public void should_evaluate_simple_substract() {
        assertThat(evaluate("5 5 -")).isEqualTo(0);
    }

    @Test
    public void should_evaluate_simple_division() {
        assertThat(evaluate("10 2 /")).isEqualTo(5);
    }

    @Test
    public void should_evaluate_simple_multiplication() {
        assertThat(evaluate("10 2 *")).isEqualTo(20);
    }

    @Test
    public void should_evaluate_more_complex_addition() {
        assertThat(evaluate("2 3 5 + +")).isEqualTo(10);
    }

    @Test
    public void should_evaluate_more_more_complex_operation() {
        assertThat(evaluate("3 5 8 * 7 + *")).isEqualTo(141);
    }

    @Test
    public void should_evaluate_more_or_less_complex_operation() {
        assertThat(evaluate("7 3 + 8 - 2 /")).isEqualTo(1);
    }

    @Test
    public void should_evaluate_addition_substraction() {
        assertThat(evaluate("5 2 3 + -")).isEqualTo(0);
    }

    @Test
    public void should_evaluate_addition_substraction_multiplication_division() {
        assertThat(evaluate("5 2 3 + - 1 + 10 * 2 /")).isEqualTo(5);
    }
}