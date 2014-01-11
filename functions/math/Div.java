package functions.math;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.List;

import main.Environment;
import datatypes.Atom;
import datatypes.Expression;
import datatypes.Function;

public class Div extends Function {

	private static final MathContext mc = new MathContext(25);

	@Override
	public Expression invoke(List<Expression> args, Environment e) {
		if (args.size() == 0) {
			argcheck(1, args);
		}
		if (args.size() == 1) {
			return new Atom(BigDecimal.ONE.divide((BigDecimal) args.get(0)
					.eval(e).value(), mc));
		} else {
			BigDecimal temp = (BigDecimal) args.get(0).eval(e).value();
			for (int i = 1; i < args.size(); i++) {
				BigDecimal divisor = (BigDecimal) args.get(i).eval(e).value();
				temp = temp.divide(divisor, mc);
			}
			return new Atom(temp);
		}
	}
}
