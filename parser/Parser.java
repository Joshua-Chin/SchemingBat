package parser;

import java.math.BigDecimal;
import java.util.AbstractList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import datatypes.Atom;
import datatypes.Expression;
import datatypes.ExpressionList;
import datatypes.Variable;

/**
 * 
 * @author Joshua
 * 
 */
public class Parser {
	/**
	 * 
	 * Returns the abstract syntax tree of the input. This parser supports
	 * string literals, symbol literals, and number literals. If there is a
	 * syntax error (e.g. mismatched parentheses), this throws a
	 * {@link ParserException}. If there is an unsupported syntax error, this
	 * throws a {@link UnsupportedOperationException}.
	 * 
	 * @param src
	 *            - the string to parse
	 * @return - the abstract syntax tree
	 * 
	 * @throws ParserException
	 *             if there is an error in the source code
	 * @throws UnsupportedOperationException
	 *             if there is an unsupported feature utilized in the source
	 *             code
	 */
	public static List<Expression> parse(String src) {
		return parse(tokenize(src));
	}

	private static List<Expression> parse(Queue<String> tokens) {
		List<Expression> ast = new LinkedList<>();
		Stack<List<Expression>> trace = new Stack<>();
		trace.push(ast);
		int line = 0;
		while (!tokens.isEmpty()) {
			String token = tokens.poll();

			if (token.equals("(")) {
				List<Expression> node = new LinkedList<>();
				trace.peek().add(new ExpressionList(node));
				trace.add(node);

			} else if (token.equals(")")) {
				if (trace.size() == 1) {
					throw new ParserException("Error at line:" + line
							+ ", Unmatched right parens");
				}
				trace.pop();

			} else if (token.equals("'")) {
				String nexttoken = tokens.poll();
				if (nexttoken.equals("(")) {
					List<Expression> node = new LinkedList<>();
					trace.peek().add(new Atom(node));
					trace.add(node);
				} else {
					trace.peek().add(new Atom(nexttoken));
				}
			} else if (token.equals("\n")) {
				line++;
			} else {
				Expression o;
				if (token.startsWith("\"")) {
					o = new Atom(token.substring(1, token.length() - 1));
				} else if (token.equals("#t")) {
					o = new Atom(Boolean.TRUE);
				} else if (token.equals("#f")) {
					o = new Atom(Boolean.FALSE);
				}else{
					try {
						o = new Atom(new BigDecimal(token));
					} catch (Exception e) {
						o = new Variable(token);
					}
				}
				if (o instanceof Atom) {
					((Atom) o).linenumber = "" + line;
				} else if (o instanceof Variable) {
					((Variable) o).linenumber = "" + line;
				}
				trace.peek().add(o);

			}
		}
		if (trace.size() != 1) {
			throw new ParserException("Unmatched left parens");
		}

		return ast;
	}

	private static Queue<String> tokenize(String source) {

		CharQueue q = new CharQueue(source);
		LinkedList<String> tokens = new LinkedList<>();
		String token = "";

		while (!q.isEmpty()) {
			char c = q.poll();
			if (isspecial(c)) {
				tokens.add(token);
				tokens.add(Character.toString(c));
				token = "";

			} else if (iswhitespace(c)) {
				tokens.add(token);
				token = "";

			} else if (c == ';') {
				while (!q.isEmpty() && q.peek() != '\n') {
					q.pop();
				}

			} else if (c == '"') {
				tokens.add(token);
				token = "\"";
				do {
					Character temp = q.poll();
					if (temp == null) {
						throw new ParserException("Unmatched \"");
					} else {
						token += temp;
					}
				} while (!token.endsWith("\""));
				tokens.add(token);
				token = "";

			} else {
				token += c;
			}
		}
		tokens.add(token);
		for (Iterator<String> i = tokens.iterator(); i.hasNext();) {
			if (i.next().equals("")) {
				i.remove();
			}
		}
		return tokens;
	}

	private static boolean isspecial(char c) {
		return c == '(' || c == ')' || c == '\'' || c == '\n';
	}

	private static boolean iswhitespace(char c) {
		return c == ' ' || c == '\t' || c=='\r';
	}

	@SuppressWarnings("serial")
	private static class CharQueue extends LinkedList<Character> {
		public CharQueue(final String s) {
			super(new AbstractList<Character>() {

				@Override
				public Character get(int arg0) {
					return s.charAt(arg0);
				}

				@Override
				public int size() {
					return s.length();
				}

			});
		}
	}
}
