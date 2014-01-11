package functions.lists;

import java.util.List;

import main.Environment;
import datatypes.Atom;
import datatypes.Expression;
import datatypes.Function;

public class Cdr extends Function {

	@SuppressWarnings("unchecked")
	@Override
	public Expression invoke(List<Expression> args, Environment e) {
		argcheck(1, args);
		List<Expression> temp = (List<Expression>) args.get(0).eval(e).value();
		return new Atom(temp.subList(1, temp.size()));
	}

}
