package functions.math.integer;

import java.math.BigDecimal;
import java.util.List;

import main.Environment;
import datatypes.Atom;
import datatypes.Expression;
import datatypes.Function;

public class Modulo extends Function {

	@Override
	public Expression invoke(List<Expression> args, Environment e) {
		argcheck(2, args);
		BigDecimal top = (BigDecimal) args.get(0).eval(e).value();
		BigDecimal bot = (BigDecimal) args.get(1).eval(e).value();
		return new Atom(new BigDecimal(top.toBigIntegerExact().mod(
				bot.toBigIntegerExact())));
	}

}
