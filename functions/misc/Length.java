package functions.misc;

import java.math.BigDecimal;
import java.util.List;

import main.Environment;
import datatypes.Atom;
import datatypes.Expression;
import datatypes.Function;

public class Length extends Function {

	@SuppressWarnings("unchecked")
	@Override
	public Expression invoke(List<Expression> args, Environment e) {
		argcheck(1, args);
		return new Atom(new BigDecimal(((List<Expression>) args.get(0).eval(e)
				.value()).size()));
	}

}
