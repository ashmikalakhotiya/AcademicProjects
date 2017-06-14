import java.util.ArrayList;
import java.util.Random;

public class Clause {

	ArrayList<Integer> a;
	static int m = 2;

	public Clause() {
	}

	public Clause(ArrayList<Integer> a) {
		this.a = new ArrayList<>();
	}

	public ArrayList<Integer> generateClause(int k, int v, ArrayList<Integer> fileContent, int swcase) {
		if (swcase == 1) {
			for (int i = 0; i < k; i++) {
				a.add(fileContent.get(m));
				m++;
			}
			return a;
		} else {
			for (int i = 0; i < k; i++) {
				a.add(getRandomLiterals(0, (2 * v) - 1));
			}
			return a;
		}
	}

	public int getRandomLiterals(int min, int max) {
		Random rand = new Random();
		return (rand.nextInt(max - min + 1) + min);
	}
}