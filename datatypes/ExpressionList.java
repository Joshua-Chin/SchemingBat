package datatypes;

import java.util.Collections;
import java.util.List;

import main.Environment;
/**
 * 
 * @author Joshua
 *
 *This class is an executable list of arguments
 */
public class ExpressionList extends Expression {

	private final List<Expression> args;

	public ExpressionList(List<Expression> args) {
		this.args = Collections.unmodifiableList(args);
	}

	public List<Expression> args() {
		return args;
	}

	@Override
	public Expression simplify(Environment e) {
		Function f;
		Object o = args.get(0).eval(e).value();
		try {
			f = (Function) o;
		} catch (ClassCastException ex) {
			throw new RuntimeException("Expected function, got " + o);
		}
		try {
			return f.invoke(args.subList(1, args.size()), e);
		} catch (ClassCastException ex) {
			throw new RuntimeException("Contract violated; " + ex.getMessage());
		}
	}

	@Override
	public String toString() {
		return args.toString();
	}

	@Override
	public String linenumber() {
		return args.get(0).linenumber();
	}

}
