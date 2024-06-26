package edu.austral.ingsis.math;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import edu.austral.ingsis.math.operations.Addition;
import edu.austral.ingsis.math.operations.Division;
import edu.austral.ingsis.math.operations.Module;
import edu.austral.ingsis.math.operations.Multiplication;
import edu.austral.ingsis.math.operations.Power;
import edu.austral.ingsis.math.operations.Substraction;
import org.junit.jupiter.api.Test;

public class ResolutionTest {

  /** Case 1 + 6 */
  @Test
  public void shouldResolveSimpleFunction1() {
    final Double result = 7d;
    Function sum = new Addition(new Constant(1.0), new Constant(6.0));
    double resolve = sum.evaluate(null);
    assertThat(resolve, equalTo(7d));
  }

  /** Case 12 / 2 */
  @Test
  public void shouldResolveSimpleFunction2() {
    Function division = new Division(new Constant(12.0), new Constant(2.0));
    double resolve = division.evaluate(null);
    assertThat(resolve, equalTo(6d));
  }

  /** Case (9 / 2) * 3 */
  @Test
  public void shouldResolveSimpleFunction3() {
    Function division = new Division(new Constant(9.0), new Constant(2.0));
    Function multiplication = new Multiplication(division, new Constant(3.0));
    double resolve = multiplication.evaluate(null);
    assertThat(resolve, equalTo(13.5d));
  }

  /** Case (27 / 6) ^ 2 */
  @Test
  public void shouldResolveSimpleFunction4() {
    Function division = new Division(new Constant(27.0), new Constant(6.0));
    Function power = new Power(division, new Constant(2.0));
    double resolve = power.evaluate(null);

    assertThat(resolve, equalTo(20.25d));
  }

  /** Case 36 ^ (1/2) */
  @Test
  public void shouldResolveSimpleFunction5() {
    Function division = new Division(new Constant(1.0), new Constant(2.0));
    Function power = new Power(new Constant(36.0), division);
    double resolve = power.evaluate(null);

    assertThat(resolve, equalTo(6d));
  }

  /** Case |136| */
  @Test
  public void shouldResolveSimpleFunction6() {
    Function module = new Module(new Constant(136.0));
    double result = module.evaluate(null);
    assertThat(result, equalTo(136d));
  }

  /** Case |-136| */
  @Test
  public void shouldResolveSimpleFunction7() {
    Function module = new Module(new Constant(-136.0));
    double result = module.evaluate(null);
    assertThat(result, equalTo(136d));
  }

  /** Case (5 - 5) * 8 */
  @Test
  public void shouldResolveSimpleFunction8() {
    Function substraction = new Substraction(new Constant(5.0), new Constant(5.0));
    Function multiplication = new Multiplication(substraction, new Constant(8.0));
    double result = multiplication.evaluate(null);

    assertThat(result, equalTo(0d));
  }
}
