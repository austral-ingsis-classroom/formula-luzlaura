package edu.austral.ingsis.math;

import java.util.List;
import java.util.Map;

public interface Function {
  Double evaluate(Map<String, Double> variables);

  List<String> listVariables();

  String print();
}
