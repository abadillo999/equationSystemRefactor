package eacs.tfd.solver;

import java.util.Iterator;

public class ReductionMethod extends SolutionMethod {

	
	@Override
	public void resolve() {
		assert this.nameSet.size() == 2;
		Iterator<String> nameIterator = this.nameSet.iterator();
		String firstName = nameIterator.next();	
		String secondName = nameIterator.next();
		float value1 = this.getLast(2).getValue(firstName);
		float value2 = this.getLast().getValue(firstName);
		this.copyBefore(2);
		this.getLast().multiply(value2);
		this.copyBefore(2);
		this.getLast().multiply(-value1);
		this.copyBefore();
		this.getLast().add(this.getLast(3));
		this.copyBefore();
		this.getLast().simplify(Side.LEFT, firstName);
		this.copyBefore();
		this.getLast().simplify(Side.LEFT, secondName);
		this.copyBefore();
		this.getLast().simplify(Side.RIGHT);
		this.copyBefore();
		this.getLast().multiply(1/this.getLast(2).getValue(secondName));
		this.setSolution(secondName, this.getLast());
		this.copyBefore(9);
		this.getLast().apply(secondName, this.getLast(2).getValue(Side.RIGHT));
		this.copyBefore();
		this.getLast().add(new Constant(-this.getLast(2).getValue(Side.LEFT)));
		this.copyBefore();
		this.getLast().simplify(Side.LEFT);
		this.copyBefore();
		this.getLast().simplify(Side.RIGHT);
		this.copyBefore();
		this.getLast().multiply(1/this.getLast(2).getValue(firstName));
		this.setSolution(firstName, this.getLast());
	}
	


}
