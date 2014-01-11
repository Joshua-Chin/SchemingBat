package functions.math.special;

import java.math.BigDecimal;
import java.util.List;

import main.Environment;
import datatypes.Atom;
import datatypes.Expression;
import datatypes.Function;

public class Sqrt extends Function {

	@Override
	public Expression invoke(List<Expression> args, Environment e) {
		argcheck(1, args);
		double d=((BigDecimal)args.get(0).eval(e).value()).doubleValue();
		return new Atom(new BigDecimal(Math.sqrt(d)));
	}

}
