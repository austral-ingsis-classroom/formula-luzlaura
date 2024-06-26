package edu.austral.ingsis.math;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import edu.austral.ingsis.math.operations.*;
import edu.austral.ingsis.math.operations.Module;
import java.util.*;
import org.junit.jupiter.api.Test;

public class ResolutionWithVariablesTest {

  /** Case 1 + x where x = 3 */
  @Test
  public void shouldResolveFunction1() {
    Function left = new Constant(1.0);
    Function right = new Variable("x");
    Map<String, Double> variables = new HashMap<>();
    variables.put("x", 3.0);
    Function sum = new Addition(left, right);
    Double result = sum.evaluate(variables);

    assertThat(result, equalTo(4d));
  }

  /** Case 12 / div where div = 4 */
  @Test
  public void shouldResolveFunction2() {
    Function left = new Constant(12.0);
    Function right = new Variable("div");
    Map<String, Double> variables = new HashMap<>();
    variables.put("div", 4.0);
    Function division = new Division(left, right);
    Double result = division.evaluate(variables);

    assertThat(result, equalTo(3d));
  }

  /** Case (9 / x) * y where x = 3 and y = 4 */
  @Test
  public void shouldResolveFunction3() {
    Function division = new Division(new Constant(9.0), new Variable("x"));
    Function multiplication = new Multiplication(division, new Variable("y"));
    Map<String, Double> variables = new HashMap<>();
    variables.put("x", 3.0);
    variables.put("y", 4.0);
    Double result = multiplication.evaluate(variables);
    assertThat(result, equalTo(12d));
  }

  /** Case (27 / a) ^ b where a = 9 and b = 3 */
  @Test
  public void shouldResolveFunction4() {
    Function division = new Division(new Constant(27.0), new Variable("a"));
    Function power = new Power(division, new Variable("b"));
    Map<String, Double> variables = new HashMap<>();
    variables.put("a", 9.0);
    variables.put("b", 3.0);
    Double result = power.evaluate(variables);

    assertThat(result, equalTo(27d));
  }

  /** Case z ^ (1/2) where z = 36 */
  @Test
  public void shouldResolveFunction5() {
    Function division = new Division(new Constant(1.0), new Constant(2.0));
    Function power = new Power(new Variable("z"), division);
    Map<String, Double> variables = new HashMap<>();
    variables.put("z", 36.0);
    Double result = power.evaluate(variables);

    assertThat(result, equalTo(6d));
  }

  /** Case |value| - 8 where value = 8 */
  @Test
  public void shouldResolveFunction6() {
    Function module = new Module(new Variable("value"));
    Function substraction = new Substraction(module, new Constant(8.0));
    Map<String, Double> variables = new HashMap<>();
    variables.put("value", 8.0);
    Double result = substraction.evaluate(variables);

    assertThat(result, equalTo(0d));
  }

  /** Case |value| - 8 where value = 8 */
  @Test
  public void shouldResolveFunction7() {
    Function module = new Module(new Variable("value"));
    Function substraction = new Substraction(module, new Constant(8.0));
    Map<String, Double> variables = new HashMap<>();
    variables.put("value", -8.0);
    Double result = substraction.evaluate(variables);

    assertThat(result, equalTo(0d));
  }

  /** Case (5 - i) * 8 where i = 2 */
  @Test
  public void shouldResolveFunction8() {
    Function substraction = new Substraction(new Constant(5.0), new Variable("i"));
    Function multiplication = new Multiplication(substraction, new Constant(8.0));
    Map<String, Double> variables = new HashMap<>();
    variables.put("i", 2.0);
    Double result = multiplication.evaluate(variables);

    assertThat(result, equalTo(24d));
  }
}
