package edu.austral.ingsis.math.operations;

import edu.austral.ingsis.math.Function;
import java.util.*;

public class Power implements Function {
  private final Function left;
  private final Function right;

  public Power(Function left, Function right) {
    this.left = left;
    this.right = right;
  }

  // asumo que el left es la base y right exponente
  // mantengo esos nombres para dejar las cosas con las mismas varibles
  @Override
  public Double evaluate(Map<String, Double> variables) {
    return Math.pow(left.evaluate(variables), right.evaluate(variables));
  }

  @Override
  public List<String> listVariables() {
    List<String> leftVariables = left.listVariables();
    List<String> rightVariables = right.listVariables();
    leftVariables.addAll(rightVariables);
    return leftVariables;
  }

  @Override
  public String print() {
    return left.print() + " ^ " + right.print();
  }
}
