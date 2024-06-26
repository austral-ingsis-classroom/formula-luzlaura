package edu.austral.ingsis.math;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.empty;

import edu.austral.ingsis.math.operations.*;
import edu.austral.ingsis.math.operations.Module;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ListVariablesTest {

  /** Case 1 + 6 */
  @Test
  public void shouldListVariablesFunction1() {
    final List<String> result = Collections.emptyList();

    assertThat(result, empty());
  }

  /** Case 12 / div */
  @Test
  public void shouldListVariablesFunction2() {
    Function division = new Division(new Constant(12.0), new Variable("div"));
    List<String> result = division.listVariables();

    assertThat(result, containsInAnyOrder("div"));
  }

  /** Case (9 / x) * y */
  @Test
  public void shouldListVariablesFunction3() {
    Function division = new Division(new Constant(9.0), new Variable("x"));
    Function multiplication = new Multiplication(division, new Variable("y"));
    List<String> result = multiplication.listVariables();
    assertThat(result, containsInAnyOrder("x", "y"));
  }

  /** Case (27 / a) ^ b */
  @Test
  public void shouldListVariablesFunction4() {
    Function division = new Division(new Constant(27.0), new Variable("a"));
    Function power = new Power(division, new Variable("b"));
    List<String> result = power.listVariables();

    assertThat(result, containsInAnyOrder("a", "b"));
  }

  /** Case z ^ (1/2) */
  @Test
  public void shouldListVariablesFunction5() {
    Function division = new Division(new Constant(1.0), new Constant(2.0));
    Function power = new Power(new Variable("z"), division);
    List<String> result = power.listVariables();

    assertThat(result, containsInAnyOrder("z"));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldListVariablesFunction6() {
    Function module = new Module(new Variable("value"));
    Function substraction = new Substraction(module, new Constant(8.0));
    List<String> result = substraction.listVariables();

    assertThat(result, containsInAnyOrder("value"));
  }

  /** Case (5 - i) * 8 */
  @Test
  public void shouldListVariablesFunction8() {
    Function substraction = new Substraction(new Constant(5.0), new Variable("i"));
    Function multiplication = new Multiplication(substraction, new Constant(8.0));
    List<String> result = multiplication.listVariables();

    assertThat(result, containsInAnyOrder("i"));
  }
}
