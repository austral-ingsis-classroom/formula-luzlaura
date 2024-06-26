package edu.austral.ingsis.math;

import java.util.*;

public class Variable implements Function {

  private final String variable;

  public Variable(String variable) {
    this.variable = variable;
  }

  @Override
  public Double evaluate(Map<String, Double> variables) {
    return variables.get(variable);
  }

  @Override
  public List<String> listVariables() {
    return Collections.singletonList(variable);
  }

  @Override
  public String print() {
    return variable;
  }
}
