package eacs.tfd.solver;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class SolutionMethod {
	protected Map<String, Equation> solutions;

	protected EquationSystem equationSystem;
	
	protected List<Equation> equationList;
	
	protected Set<String> nameSet;
	
	
	public SolutionMethod() {
		this.nameSet = new HashSet<String>();
		this.solutions = new HashMap<String, Equation>();
		}
	
	public void set(List<Equation> equationList, Set<String> nameSet){
		this.equationList = equationList;
		this.nameSet =nameSet;
	}

	public abstract void resolve();

	void copyBefore(int before){
		int index = this.equationList.size() - before;
		this.add(this.get(index).clon());
	}
	
	void copyBefore(){
		this.copyBefore(1);
	}
	
	private Equation get(int index){
		return this.equationList.get(index);
	}
	
	public void add(Equation equation) {
		this.equationList.add(equation);
		for(String name : equation.getNameSet()){
			this.nameSet.add(name);
		}
	}
	
	public Set<String> getNameSet() {
		return nameSet;
	}
	
	Equation getLast(){
		return this.getLast(1);
	}
	
	Equation getLast(int before){
		int index = this.equationList.size() - before;
		return this.equationList.get(index);
	}
	
	void setSolution(String firstName, Equation equation) {
		this.solutions.put(firstName, equation);
	}
	
	public float getSolution(String name){
		return this.solutions.get(name).getValue(Side.RIGHT);
	}
	
	public boolean equal(EquationSystem equationSystem){
		if (this.equationList.size()!= equationSystem.equationList.size()){
			return false;
		}
		for(int i=0; i<this.equationList.size(); i++){
			if (!this.equationList.get(i).equal(equationSystem.equationList.get(i)))
				return false;
		}
		return true;
	}
	
	public String toString() {
		String result = "\n";
		for(int i=0; i<this.equationList.size(); i++){
			result += this.equationList.get(i) + "\n";
		}
		return result;
	}
}
