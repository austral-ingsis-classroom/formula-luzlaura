package edu.austral.ingsis.math;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import edu.austral.ingsis.math.operations.*;
import edu.austral.ingsis.math.operations.Module;
import org.junit.jupiter.api.Test;

public class PrintTest {

  /** Case 1 + 6 */
  @Test
  public void shouldPrintFunction1() {

    final String expected = "1.0 + 6.0";
    Function sum = new Addition(new Constant(1.0), new Constant(6.0));
    String result = sum.print();

    assertThat(result, equalTo(expected));
  }

  /** Case 12 / 2 */
  @Test
  public void shouldPrintFunction2() {
    final String expected = "(12.0 / 2.0)";
    Function division = new Division(new Constant(12.0), new Constant(2.0));

    final String result = division.print();

    assertThat(result, equalTo(expected));
  }

  /** Case (9 / 2) * 3 */
  @Test
  public void shouldPrintFunction3() {
    final String expected = "((9.0 / 2.0) * 3.0)";
    Function division = new Division(new Constant(9.0), new Constant(2.0));
    Function multiplication = new Multiplication(division, new Constant(3.0));

    final String result = multiplication.print();

    assertThat(result, equalTo(expected));
  }

  /** Case (27 / 6) ^ 2 */
  @Test
  public void shouldPrintFunction4() {
    final String expected = "(27.0 / 6.0) ^ 2.0";
    Function division = new Division(new Constant(27.0), new Constant(6.0));
    Function power = new Power(division, new Constant(2.0));
    String result = power.print();
    assertThat(result, equalTo(expected));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldPrintFunction6() {
    final String expected = "|value| - 8.0";
    Function module = new Module(new Variable("value"));
    Function substraction = new Substraction(module, new Constant(8.0));
    final String result = substraction.print();

    assertThat(result, equalTo(expected));
  }

  /** Case (5 - i) * 8 */
  @Test
  public void shouldPrintFunction8() {
    final String expected = "((5.0 - i) * 8.0)";
    final Function substraction = new Substraction(new Constant(5.0), new Variable("i"));
    final Function multiplication = new Multiplication(substraction, new Constant(8.0));

    final String result = expected;

    assertThat(result, equalTo(expected));
  }
}
