package functions.math;

import java.math.BigDecimal;
import java.util.List;

import main.Environment;
import datatypes.Atom;
import datatypes.Expression;
import datatypes.Function;

public class Minus extends Function {

	@Override
	public Expression invoke(List<Expression> args, Environment e) {
		if (args.size() == 0) {
			argcheck(1, args);
			return new Atom(null);
		} else if (args.size() == 1) {
			BigDecimal temp = (BigDecimal) args.get(0).eval(e).value();
			return new Atom(temp.negate());
		} else {
			BigDecimal temp = (BigDecimal) args.get(0).eval(e).value();
			for(int i=1;i<args.size();i++){
				BigDecimal temp1=(BigDecimal) args.get(1).eval(e).value();
				temp=temp.subtract(temp1);
			}
			return new Atom(temp);
		}
	}

}
