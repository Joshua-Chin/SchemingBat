package functions.math.special;

import java.math.BigDecimal;
import java.util.List;

import main.Environment;
import datatypes.Atom;
import datatypes.Expression;
import datatypes.Function;

public class Min extends Function {

	@Override
	public Expression invoke(List<Expression> args, Environment e) {
		if (args.size() == 0) {
			argcheck(1, args);
		}
		BigDecimal ex = (BigDecimal) args.get(0).eval(e).value();
		for (Expression arg : args) {
			BigDecimal temp = (BigDecimal) arg.eval(e).value();
			if (ex.compareTo(temp)>0){
				ex=temp;
			}
		}
		return new Atom(ex);
	}

}
