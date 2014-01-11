package functions.lists;

import java.util.LinkedList;
import java.util.List;

import main.Environment;
import datatypes.Atom;
import datatypes.Expression;
import datatypes.Function;

public class ListFunc extends Function {

	@Override
	public Expression invoke(List<Expression> args, Environment e) {
		List<Expression> out = new LinkedList<>();
		for (Expression arg : args) {
			out.add(arg.eval(e));
		}
		return new Atom(out);
	}

}
