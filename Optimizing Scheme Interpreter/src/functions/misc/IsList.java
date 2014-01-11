package functions.misc;

import java.util.List;

import main.Environment;
import datatypes.Atom;
import datatypes.Expression;
import datatypes.Function;

public class IsList extends Function {

	@Override
	public Expression invoke(List<Expression> args, Environment e) {
		argcheck(1, args);
		return new Atom(args.get(0).eval(e).value() instanceof List);
	}

}
