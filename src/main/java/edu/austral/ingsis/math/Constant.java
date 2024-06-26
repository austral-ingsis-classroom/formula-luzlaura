package edu.austral.ingsis.math;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Constant implements Function {
  private final double value;

  public Constant(double value) {
    this.value = value;
  }

  @Override
  public Double evaluate(Map<String, Double> variables) {
    return value;
  }

  @Override
  public List<String> listVariables() {
    return Collections.emptyList();
  }

  @Override
  public String print() {
    return String.valueOf(value);
  }
}
