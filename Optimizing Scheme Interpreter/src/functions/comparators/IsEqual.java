package functions.comparators;

import java.util.List;

import main.Environment;
import datatypes.Atom;
import datatypes.Expression;
import datatypes.Function;

public class IsEqual extends Function {

	@Override
	public Expression invoke(List<Expression> args, Environment e) {
		argcheck(2, args);
		return new Atom(args.get(0).eval(e).value()
				.equals(args.get(1).eval(e).value()));
	}

}
