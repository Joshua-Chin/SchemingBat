package functions;

import java.util.List;

import main.Environment;
import datatypes.Atom;
import datatypes.Expression;
import datatypes.ExpressionList;
import datatypes.Function;

public class Cond extends Function {

	@Override
	public Expression invoke(List<Expression> args, Environment e) {
		for(Expression arg:args){
			ExpressionList exp=(ExpressionList) arg;
			argcheck(2, exp.args());
			if((boolean) exp.args().get(0).eval(e).value()){
				return exp.args().get(1);
			}
		}
		return new Atom(null);
	}

}
