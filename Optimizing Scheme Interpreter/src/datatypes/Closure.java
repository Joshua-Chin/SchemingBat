package datatypes;

import main.Environment;
/**
 * 
 * @author Joshua
 *
 *
 *This class encloses an expression within a self-contained environment,
 *capturing all global and local variables present at creation
 */
public class Closure extends Expression {

	private final Expression exp;
	private final Environment env;

	public Closure(Expression exp, Environment env) {
		this.exp = exp;
		this.env = env.clone();
	}

	@Override
	public Expression simplify(Environment e) {
		Expression out = exp.simplify(env);
		if (out instanceof Closure) {
			return out;
		} else if (out instanceof Atom) {
			return out;
		} else {
			return new Closure(out, env);
		}
	}

	@Override
	public String toString() {
		return exp.toString();
	}

	@Override
	public String linenumber() {
		return exp.linenumber();
	}

}
