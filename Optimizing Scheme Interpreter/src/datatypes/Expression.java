package datatypes;

import main.Environment;

/**
 * 
 * The base class of all Scheme values.
 * 
 * @author Joshua
 * 
 */
public abstract class Expression {

	public abstract String linenumber();

	/**
	 * Returns the {@link Atom} equivalent to this expression. This is the
	 * primary method to retrieve the value of an expression.
	 * 
	 * @param e
	 *            - the environment the expression should be evaluated in
	 * @return - the atom equal to this expression
	 */
	public final Atom eval(Environment e) {
		Expression out = this;
		try {
			while (!((out = out.simplify(e)) instanceof Atom)) {
				Environment.logcomputation();
			}
		} catch (Exception exc) {
			if (exc.getMessage().startsWith("Error at line")) {
				throw exc;
			} else {
				throw new RuntimeException("Error at line " + out.linenumber()
						+ ": " + exc.getMessage());
			}
		}
		return (Atom) out;
	}

	/**
	 * 
	 * This method should be never be called by an extension.
	 * 
	 * @param e
	 *            - the environment the expression should be evaluated in
	 * @return - an expression simpler than the original expression. Repeatedly
	 *         applying simplify should ideally return an {@link Atom}.
	 * 
	 */
	public abstract Expression simplify(Environment e);
}
