
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(System.in);
		ArrayList<Integer> fileContent = new ArrayList<>();
		System.out.println("Select operation to perform " + "\n\n" + "1.FileRead \n" + "2.Random Generation \n");
		int choice = 0;
		System.out.print("Enter your choice ");
		try {
			choice = in.nextInt();
		} catch (InputMismatchException exception) {
			System.out.println("\nInvalid Input...... Rerun the Program with valid input");
			return;
		}
		System.out.print("\n");

		switch (choice) {

		case 1:

			int swcase = 1;
			int count = 0;
			File file = new File("file");

			Scanner sc = new Scanner(file);
			while (sc.hasNextLine()) {

				int i = sc.nextInt();
				count++;
				if (count < 2) {
					if (i >= 0) {
						fileContent.add(i);
					} else {
						System.out.println(
								"\nFile data should be greater than equal to 0 ...... Correct and Rerun the Program");
						return;
					}
				} else {
					if (i >= 0 && i < (2 * fileContent.get(0))) {
						fileContent.add(i);
					} else {
						System.out.println(
								"\nLiterals should be between 0 and 2v-1 ...... Correct and Rerun the Program");
						return;
					}

				}

			}

			System.out.print("\n");
			int v = fileContent.get(0);
			System.out.print("Number of variables:" + v);

			System.out.print("\n");
			int t = fileContent.get(1);
			System.out.print("Number of clauses :" + t);

			System.out.print("\n");
			int k = 3;
			System.out.print("k in k sat :" + k);

			Predicate p = new Predicate();
			p.generateAllClauses(t, k, v, fileContent, swcase);
			System.out.println("\n");
			p.displayInnerList();
			System.out.print("\n");
			p.generateVariables(v);
			int nodes = p.evaluatePredicate(v, 0);
			System.out.print("\nNumber of nodes backtracked : " + nodes + "\n");

			System.out.print("\nFinal Variables in array are : ");
			p.displayVariables();

			break;

		case 2:
			int swcase1 = 2;
			int v1 = 0, t1 = 0, k1 = 0;
			try {
				System.out.print("Enter the variables:");
				v1 = in.nextInt();
				if (v1 < 0) {
					System.out.println(
							"\nInput data should be greater than equal to 0 .... Rerun the Program with valid input");
					return;
				}

				System.out.print("\n");
				System.out.print("Enter the clauses :");
				t1 = in.nextInt();
				if (t1 < 0) {
					System.out.println(
							"\nInput data should be greater than equal to 0 .... Rerun the Program with valid input");
					return;
				}
				System.out.print("\n");
				System.out.print("Enter the k in k sat :");
				k1 = in.nextInt();
				if (k1 < 0) {
					System.out.println(
							"\nInput data should be greater than equal to 0 .... Rerun the Program with valid input");
					return;
				}

			} catch (InputMismatchException exception) {
				System.out.println("\nInvalid Input...... Rerun the Program with valid input");
				return;
			}

			Predicate p1 = new Predicate();
			p1.generateAllClauses(t1, k1, v1, fileContent, swcase1);
			System.out.println("\n");
			p1.displayInnerList();
			System.out.print("\n");
			p1.generateVariables(v1);
			int nodes1 = p1.evaluatePredicate(v1, 0);
			System.out.print("\nNumber of nodes backtracked : " + nodes1 + "\n");

			System.out.print("\nFinal Variables in array are : ");
			p1.displayVariables();
			break;

		default:
			System.out.println("Enter proper choice!");
			break;

		}
	}

}