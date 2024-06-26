package edu.austral.ingsis.math.operations;

import edu.austral.ingsis.math.Function;
import java.util.*;

public class Addition implements Function {

  private final Function left;
  private final Function right;

  public Addition(Function left, Function right) {
    this.left = left;
    this.right = right;
  }

  @Override
  public Double evaluate(Map<String, Double> variables) {
    return left.evaluate(variables) + right.evaluate(variables);
  }

  @Override
  public List<String> listVariables() {
    List<String> variables = new ArrayList<>();
    variables.addAll(left.listVariables());
    variables.addAll(right.listVariables());
    return variables;
  }

  @Override
  public String print() {
    return left.print() + " + " + right.print();
  }
}
