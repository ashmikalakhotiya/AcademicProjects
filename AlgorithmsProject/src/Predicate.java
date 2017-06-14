import java.util.ArrayList;

public class Predicate {

	ArrayList<Clause> outerlist = new ArrayList<>();
	ArrayList<Integer> innerlist;
	int[] variables;
	int literal;
	int nodes = 0;

	public ArrayList<Clause> generateAllClauses(int t, int k, int v, ArrayList<Integer> fileContent, int swcase) {
		for (int i = 0; i < t; i++) {
			Clause c = new Clause(innerlist);
			innerlist = c.generateClause(k, v, fileContent, swcase);
			outerlist.add(c);
		}
		return outerlist;
	}

	public void displayInnerList() {

		for (Clause a : outerlist) {
			System.out.println(a.a);
		}
	}

	public void generateVariables(int v) {
		variables = new int[v];
		for (int i = 0; i < v; i++) {
			variables[i] = -1;
		}
	}

	public int evaluatePredicate(int v, int m) {

		for (int p = m; p <= v; p++) {
			boolean predicateValue = true;
			for (Clause a : outerlist) {
				boolean clauseValue = false;
				for (int i = 0; i < a.a.size(); i++) {
					literal = a.a.get(i);
					System.out.print(literal + " ");
					boolean literalInitialValue;

					if (p > 0 && variables[p - 1] != 1) {
						variables[p - 1] = 0;
					}

					if (literal >= v && variables[literal - v] != -1) {
						literalInitialValue = !genarateLiteralsValue(literal, v, p);
					} else {
						literalInitialValue = genarateLiteralsValue(literal, v, p);
					}
					clauseValue = clauseValue || literalInitialValue;

					System.out.print(literalInitialValue + "\n");
				}

				System.out.print("VALUE OF THIS CLAUSE = " + clauseValue + "\n\n");

				if (clauseValue == false) {

					if (variables[p - 1] == 1) {
						nodes++;
						int x = p + v - 1;
						int count = 0;
						for (int j = 0; j < a.a.size(); j++) {
							int y = a.a.get(j);
							if (y >= v) {
								y = y - v;
								if (y == p - 1) {
									count++;
								}
							}
							if (count > 2) {
								System.out.println("Program is unsatisfiable");
								System.exit(0);
							}

							if (x != y && variables[y] != 1) {
								variables[y] = 1;
								break;
							}
						}
						variables[p - 1] = 0;
						evaluatePredicate(v, p);
					} else {
						variables[p - 1] = 1;
						evaluatePredicate(v, p);
					}

				}
				predicateValue = predicateValue && clauseValue;
			}
			System.out.print("VALUE OF Predicate = " + p + " " + predicateValue + "\n\n");
			System.out.println("------------------------------");
		}
		return nodes;

	}

	private boolean genarateLiteralsValue(int literal, int v, int p) {
		if (p == 0) {
			return true;
		} else {

			if (literal >= v) {
				literal = literal - v;
			}
			if (variables[literal] == 0) {
				return false;
			} else {
				return true;
			}

		}
	}

	public void displayVariables() {
		for (int v : variables) {
			System.out.print(v + " ");
		}
	}

}