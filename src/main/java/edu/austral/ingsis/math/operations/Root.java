package edu.austral.ingsis.math.operations;

import edu.austral.ingsis.math.Function;
import java.util.*;

public class Root implements Function {
  private final Function number;

  public Root(Function number) {
    this.number = number;
  }

  @Override
  public Double evaluate(Map<String, Double> variables) {
    return Math.sqrt(number.evaluate(variables));
  }

  @Override
  public List<String> listVariables() {
    return number.listVariables();
  }

  @Override
  public String print() {
    return "sqrt(" + number.print() + ")";
  }
}
