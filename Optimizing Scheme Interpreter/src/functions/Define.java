package functions;

import java.util.Arrays;
import java.util.List;

import main.Environment;
import datatypes.Atom;
import datatypes.Expression;
import datatypes.ExpressionList;
import datatypes.Function;
import datatypes.Variable;

public class Define extends Function {

	@Override
	public Expression invoke(List<Expression> args, Environment e) {
		if(args.size()!=2&&args.size()!=3){
			argcheck(3, args);
		}
		try {
			String name = ((Variable) args.get(0)).name;
			Expression exp = args.get(1).eval(e);
			Environment.addglobal(name, exp);
			return new Atom(null);
		} catch (ClassCastException ex) {
			List<Expression> signature = ((ExpressionList) args.get(0)).args();
			String name = ((Variable) signature.get(0)).name;
			Expression varnames = new ExpressionList(signature.subList(1,
					signature.size()));
			Expression exp = new Lambda().invoke(
					Arrays.asList(varnames, args.get(1)), e);
			Environment.addglobal(name, exp);
			return new Atom(null);
		}
	}

}
