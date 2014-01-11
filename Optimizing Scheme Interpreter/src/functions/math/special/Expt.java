package functions.math.special;

import java.math.BigDecimal;
import java.util.List;

import main.Environment;
import datatypes.Atom;
import datatypes.Expression;
import datatypes.Function;

public class Expt extends Function {

	@Override
	public Expression invoke(List<Expression> args, Environment e) {
		argcheck(2, args);
		BigDecimal base = (BigDecimal) args.get(0).eval(e).value();
		BigDecimal power = (BigDecimal) args.get(1).eval(e).value();
		return new Atom(new BigDecimal(Math.pow(base.doubleValue(),
				power.doubleValue())));
	}

}
