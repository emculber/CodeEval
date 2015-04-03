import java.io.*;
import java.util.ArrayList;

public class Main {
	// Logging/Debugging-----------------------------------
	static boolean printEachInputLine = false;
	static boolean printComparisonCode = false;
	static boolean printRoughPrecents = false;
	static boolean printWhileGettingVariables = true;

	// Logging/Debugging-----------------------------------

	public static void main(String[] args) throws IOException {
		File file = new File("/Users/Erik/Documents/Development/java/Fun-Little-Projects/CodeEval/HardChallenges/CodePlagiarism/Code-Plagiarism-Input.txt");
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;

		// Used for Source Code -------------------------------
		boolean sourceCode1 = true;
		ArrayList<String> code1 = new ArrayList<String>();
		ArrayList<String> code2 = new ArrayList<String>();
		// Used for Source Code -------------------------------
		while ((line = buffer.readLine()) != null) {
			line = line.trim();
			if (printEachInputLine) {
				System.out.print("Loading in line=" + line);
			}

			// Checking for other Inputs---------------------
			if (line.equals("")) {
				if (printEachInputLine) {
					System.out.print("(Line Skipped Does Not Contain Anything)\n");
				}
				continue;
			}
			if (line.contains("<<< Python") || line.contains("<<< Go")) {
				if (printEachInputLine) {
					System.out.print("(Code is " + line + ")");
					System.out.print("(SourceCode1)(Clearing Code1 and Code2)\n");
				}
				code1 = new ArrayList<String>();
				code2 = new ArrayList<String>();
				sourceCode1 = true;
				continue;
			} else if (line.contains("=====")) {
				if (printEachInputLine) {
					System.out.print("(SourceCode2)\n");
				}
				sourceCode1 = false;
				continue;
			} else if (line.contains("*****")) {
				FigureOutPercent(code1, code2);
				continue;
			}
			// Checking for other Inputs---------------------

			// Logging Source Code -------------------------
			if (sourceCode1) {
				code1.add(line);
			} else if (!sourceCode1) {
				code2.add(line);
			}
			// Logging Source Code -------------------------

			if (printEachInputLine) {
				System.out.print("\n");
			}
		}
	}

	private static void FigureOutPercent(ArrayList<String> one, ArrayList<String> two) {
		if (printComparisonCode) {
			System.out.print("Printing Comparison Code\n");
		}
		double test = printTwoArraysAndRoughCheck(one, two);
		if (test == 100) {
			if (printRoughPrecents) {
				System.out.println("Exactly the Same!! " + test + "% Same");
			}
		} else {
			if (printRoughPrecents) {
				System.out.println("Roughly " + test + "% Same");
			}
		}

		// Do Code

		ArrayList<String> variables = GetVariables(one, two);

		// Do Code
	}

	private static ArrayList<String> GetVariables(ArrayList<String> one, ArrayList<String> two) {
		ArrayList<String> variables = new ArrayList<String>();
		for (String string : one) {
			if (printWhileGettingVariables) {
				System.out.print("Checking---" + string);
			}
			if (string.contains(" = ") || string.contains(" := ") || string.contains("type ")) {
				if (printWhileGettingVariables) {
					System.out.print("--- Was Found to be a Variable ---");
				}
				variables.add(string);
			}
			if (printWhileGettingVariables) {
				System.out.print("\n");
			}
		}
		variables.add("*****");
		for (String string : two) {
			if (printWhileGettingVariables) {
				System.out.print("Checking---" + string);
			}
			if (string.contains(" = ")) {
				if (printWhileGettingVariables) {
					System.out.print("--- Was Found to be a Variable ---");
				}
				variables.add(string);
			}
			if (printWhileGettingVariables) {
				System.out.print("\n");
			}
		}
		return variables;
	}

	private static double printTwoArraysAndRoughCheck(ArrayList<String> one, ArrayList<String> two) {
		double count = 0;
		int i = 0;
		if (one.size() >= two.size()) {
			for (i = 0; i < one.size(); i++) {
				if (printComparisonCode) {
					System.out.print(one.get(i) + "----------");
				}
				if (i < two.size()) {
					if (printComparisonCode) {
						System.out.print(two.get(i));
					}
					if (one.get(i).equalsIgnoreCase(two.get(i))) {
						count++;
					}
				}
				if (printComparisonCode) {
					System.out.print("\n");
				}
			}
		} else if (one.size() < two.size()) {
			for (i = 0; i < two.size(); i++) {
				if (printComparisonCode) {
					System.out.print(two.get(i) + "----------");
				}
				if (i < one.size()) {
					if (printComparisonCode) {
						System.out.print(one.get(i));
					}
					if (one.get(i).equalsIgnoreCase(two.get(i))) {
						count++;
					}
				}
				if (printComparisonCode) {
					System.out.print("\n");
				}
			}
		}
		return (count / ((double) i)) * 100;
	}
}