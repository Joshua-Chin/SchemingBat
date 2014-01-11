package functions;

import java.util.List;

import main.Environment;
import datatypes.Expression;
import datatypes.Function;

public class If extends Function {

	@Override
	public Expression invoke(List<Expression> args, Environment e) {
		argcheck(3, args);
		if((boolean) args.get(0).eval(e).value()){
			return args.get(1);
		}else{
			return args.get(2);
		}
	}

}
