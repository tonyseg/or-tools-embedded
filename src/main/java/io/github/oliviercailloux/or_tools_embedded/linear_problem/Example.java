package io.github.oliviercailloux.or_tools_embedded.linear_problem;

import com.google.ortools.linearsolver.MPConstraint;
import com.google.ortools.linearsolver.MPObjective;
import com.google.ortools.linearsolver.MPSolver;
import com.google.ortools.linearsolver.MPVariable;

public class Example {

	static { System.loadLibrary("jniortools"); }

	private static void runLinearExample(String solverType) {
		MPSolver solver = new MPSolver("LinearExample", MPSolver.OptimizationProblemType.valueOf(solverType));
		double infinity = MPSolver.infinity();

		// x1 is continuous non-negative variables.
		MPVariable x = solver.makeNumVar(0.0, infinity, "x");

		// Maximize x
		MPObjective objective = solver.objective();
		objective.setCoefficient(x, 1);

		
		objective.setMaximization();

		// x1  <= 10.
		MPConstraint c0 = solver.makeConstraint(-infinity, 10.0);
		c0.setCoefficient(x, 1);
		
		solver.solve();
		
		System.out.println("Number of variables = " + solver.numVariables());
		System.out.println("Number of constraints = " + solver.numConstraints());

		// The objective value of the solution.
		System.out.println("Optimal objective value = " + solver.objective().value());
		solver.solve();
		// The value of each variable in the solution.
		System.out.println("x = " + x.solutionValue());
		
	}

	public static void main(String[] args) throws Exception {
		runLinearExample("GLOP_LINEAR_PROGRAMMING");
	}

}
