package main;

import java.util.List;

import parser.Parser;
import datatypes.Atom;
import datatypes.Expression;

public class Main {

	public static String eval(String s) {
		String out = "";
		try {
			List<Expression> expressions = Parser.parse(s);
			Environment env = new Environment();
			for (Expression expr : expressions) {
				try {
					Atom temp = expr.eval(env);
					if (temp == null) {
						out += "A: ";
					} else {
						out += "A: " + temp;
					}
				} catch (Exception e) {
					out += "B: " + e.getMessage();
				}
				out += '\n';
			}
		} catch (Exception e) {
			out += "B: " + e.getMessage();
		}
		return out;
	}
}
