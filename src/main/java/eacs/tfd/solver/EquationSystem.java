package eacs.tfd.solver;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EquationSystem {

	//TODO private
	List<Equation> equationList;
	
	private Set<String> nameSet;
		
	private SolutionMethod solutionMethod;
	
	public EquationSystem(){
		this.equationList = new ArrayList<Equation>();
		this.nameSet = new HashSet<String>();
	}
	
	public void add(Equation equation) {
		this.equationList.add(equation);
		for(String name : equation.getNameSet()){
			this.nameSet.add(name);
		}
	}
	
	public void set(SolutionMethod solutionMethod){
		this.solutionMethod.set(this.equationList, this.nameSet);
	}
	
	public void resolve(){
		this.solutionMethod.resolve();
	}
	
	public float getSolution(String name){
		return this.solutionMethod.getSolution(name);
	}
	
	public boolean equal(EquationSystem equationSystem){
        return this.solutionMethod.equal(equationSystem); 
	}
	
	public String toString() {
		return this.solutionMethod.toString();
	}
	
}

