package functions.math;

import java.math.BigDecimal;
import java.util.List;

import main.Environment;
import datatypes.Atom;
import datatypes.Expression;
import datatypes.Function;

public class Plus extends Function {

	@Override
	public Expression invoke(List<Expression> args, Environment e) {
		if(args.size()==0){
			argcheck(1, args);
		}
		BigDecimal val = BigDecimal.ZERO;
		for (Expression expr : args) {
			val = val.add((BigDecimal) expr.eval(e).value());
		}
		return new Atom(val);
	}

}
