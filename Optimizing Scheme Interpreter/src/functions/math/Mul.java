package functions.math;

import java.math.BigDecimal;
import java.util.List;

import main.Environment;
import datatypes.Atom;
import datatypes.Expression;
import datatypes.Function;

public class Mul extends Function {
	public Expression invoke(List<Expression> args, Environment e) {
		if (args.size() == 0) {
			argcheck(1, args);
		}
		BigDecimal out = BigDecimal.ONE;
		for (Expression ex : args) {
			out = out.multiply((BigDecimal) ex.eval(e).value());
		}
		return new Atom(out);
	};
}
