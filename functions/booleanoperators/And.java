package functions.booleanoperators;

import java.util.List;

import main.Environment;
import datatypes.Atom;
import datatypes.Expression;
import datatypes.Function;

public class And extends Function {

	@Override
	public Expression invoke(List<Expression> args, Environment e) {
		for (Expression arg : args) {
			if (!(Boolean) arg.eval(e).value()) {
				return new Atom(Boolean.FALSE);
			}
		}
		return new Atom(Boolean.TRUE);
	}

}
