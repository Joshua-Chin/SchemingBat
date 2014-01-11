package functions.lists;

import java.util.LinkedList;
import java.util.List;

import main.Environment;
import datatypes.Atom;
import datatypes.Expression;
import datatypes.Function;

public class Cons extends Function {

	@SuppressWarnings("unchecked")
	@Override
	public Expression invoke(List<Expression> args, Environment e) {
		argcheck(2, args);
		List<Expression> temp=(List<Expression>) args.get(1).eval(e).value();
		List<Expression> out=new LinkedList<>();
		out.add(args.get(0).eval(e));
		out.addAll(temp);
		return new Atom(out);
	}

}
