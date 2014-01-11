package functions.comparators;

import java.math.BigDecimal;
import java.util.List;

import main.Environment;
import datatypes.Atom;
import datatypes.Expression;
import datatypes.Function;

public class Eq extends Function {

	@Override
	public Expression invoke(List<Expression> args, Environment e) {
		if(args.size()==0){
			argcheck(1, args);
		}
		BigDecimal current=(BigDecimal) args.get(1).eval(e).value();
		BigDecimal previous=(BigDecimal) args.get(0).eval(e).value();
		for(int i=0;i<args.size()-1;i++){
			current=(BigDecimal) args.get(i+1).eval(e).value();
			if(!(current.compareTo(previous)==0)){
				return new Atom(false);
			}
			previous=current;
		}
		return new Atom(true);
	}

}
