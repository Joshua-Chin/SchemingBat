package functions.misc;

import java.util.List;

import main.Environment;
import datatypes.Atom;
import datatypes.Expression;
import datatypes.Function;

public class IsNull extends Function {

	@SuppressWarnings("unchecked")
	@Override
	public Expression invoke(List<Expression> args, Environment e) {
		argcheck(1, args);
		Object o=args.get(0).eval(e).value();
		if(o instanceof List){
			List<Expression> temp=(List<Expression>) o;
			return new Atom(temp.size()==0);
		}
		return new Atom(false);
	}

}
