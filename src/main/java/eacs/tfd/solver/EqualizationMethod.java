package eacs.tfd.solver;

import java.util.Iterator;

public class EqualizationMethod extends SolutionMethod {

	@Override
	public void resolve() {
		assert this.getNameSet().size() == 2;
		Iterator<String> nameIterator = this.getNameSet().iterator();
		String firstName = nameIterator.next();	
		String secondName = nameIterator.next();
		this.copyBefore(2);
		this.getLast().multiply(1/this.getLast(3).getValue(firstName));
		this.copyBefore(2);
		this.getLast().multiply(1/this.getLast(3).getValue(firstName));
		this.copyBefore(2);
		this.getLast().add(new Variable(-this.getLast(3).getValue(secondName),secondName));
		this.copyBefore(2);
		this.getLast().add(new Variable(-this.getLast(3).getValue(secondName),secondName));
		this.copyBefore(2);
		this.getLast().simplify(Side.LEFT, secondName);
		this.copyBefore(2);
		this.getLast().simplify(Side.LEFT, secondName);
		this.copyBefore();
		this.getLast().invert();
		this.getLast().add(this.getLast(3));
		this.getLast().add(new Variable(-1,firstName));
		this.getLast().simplify(Side.LEFT, firstName);
		this.getLast().simplify(Side.RIGHT, firstName);
		this.copyBefore();
		this.getLast().add(new Constant(-this.getLast().getValue(Side.LEFT)));
		this.copyBefore();
		this.getLast().simplify(Side.LEFT);
		this.copyBefore();
		this.getLast().add(new Variable(-this.getLast().getValue(secondName),secondName));
		this.copyBefore();
		this.getLast().simplify(Side.LEFT, secondName);
		this.getLast().simplify(Side.RIGHT, secondName);
		this.copyBefore();
		this.getLast().simplify(Side.RIGHT);
		this.copyBefore();
		this.getLast().multiply(1/this.getLast().getValue(secondName));
		this.copyBefore(9);
		System.out.println(this.getLast(2).getValue(Side.RIGHT));
		this.getLast().apply(secondName, this.getLast(2).getValue(Side.RIGHT));
	}	

}
