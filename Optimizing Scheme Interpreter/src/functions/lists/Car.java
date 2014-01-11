package functions.lists;

import java.util.List;

import main.Environment;
import datatypes.Atom;
import datatypes.Expression;
import datatypes.ExpressionList;
import datatypes.Function;
import datatypes.Variable;

public class Car extends Function {

	@SuppressWarnings("unchecked")
	@Override
	public Expression invoke(List<Expression> args, Environment e) {
		argcheck(1, args);
		Expression x = ((List<Expression>) args.get(0).eval(e).value()).get(0);
		if (x instanceof Atom) {
			return x;
		} else if (x instanceof ExpressionList) {
			return new Atom(((ExpressionList) x).args());
		} else {
			return new Atom(((Variable) x).name);
		}
	}

}
