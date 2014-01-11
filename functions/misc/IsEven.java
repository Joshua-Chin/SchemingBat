package functions.misc;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

import main.Environment;
import datatypes.Atom;
import datatypes.Expression;
import datatypes.Function;

public class IsEven extends Function {

	@Override
	public Expression invoke(List<Expression> args, Environment e) {
		argcheck(1, args);
		BigInteger temp = ((BigDecimal) args.get(0).eval(e).value())
				.toBigIntegerExact();
		return new Atom(temp.mod(BigInteger.valueOf(2)).equals(BigInteger.ZERO));
	}
}
