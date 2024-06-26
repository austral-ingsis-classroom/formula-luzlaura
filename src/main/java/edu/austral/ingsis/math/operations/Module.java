package edu.austral.ingsis.math.operations;

import edu.austral.ingsis.math.Function;
import java.util.*;

public class Module implements Function {
  private final Function number;

  public Module(Function number) {
    this.number = number;
  }

  @Override
  public Double evaluate(Map<String, Double> variables) {
    return Math.abs(number.evaluate(variables));
  }

  @Override
  public List<String> listVariables() {
    return number.listVariables();
  }

  @Override
  public String print() {
    return "|" + number.print() + "|";
  }
}
