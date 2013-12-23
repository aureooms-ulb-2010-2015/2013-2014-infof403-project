package cs.parser;

import java.util.Map;
import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;

import cs.parser.data.declaration.*;

import cs.parser.error.*;

/**
 *
 * The S-COBOL Semantical Analyzer.
 *
 * @author  Chaste Gauvain
 * @author  Ooms Aurélien
 *
 */

public class SemanticalAnalyzer{
	

	private String program_id;
	private Map<String, VariableDecl> variables = new HashMap<String, VariableDecl>();
	private Set<String> labelsUse = new HashSet<String>();
	private Set<String> labelsDef = new HashSet<String>();

	public VariableDecl getVariable(String name) throws Exception{
		if(this.variables.containsKey(name)) return this.variables.get(name);
		else throw new SemanticalException("error: no such variable '" + name + "'");
	}

	public void declareVariable(String name, VariableDecl decl) throws Exception{
		if(!this.variables.containsKey(name)) this.variables.put(name, decl);
		else throw new SemanticalException("error: variable '" + name + "' already defined");
	}

	public void checkVariables() throws Exception{
		for(Map.Entry<String, VariableDecl> entry : variables.entrySet()){
			VariableDecl decl = entry.getValue();
			if(decl.isAssigned()){
				long value = Long.decode(decl.getValue());
				int signed = decl.isSigned() ? 1 : 0;
				if(value > 0) value = -value;
				if(value >= Math.pow(2, Integer.decode(decl.getLLVMSize()) - signed)){
					throw new SemanticalException("error: literal " + decl.getValue() + " cannot fit in '" + decl.getName() + "' (" + decl.getLLVMType() + ")");
				}
			}
		}
	}

	public void defLabel(String name) throws Exception{
		if(this.variables.containsKey(name)) throw new SemanticalException("error: '" + name + "' is a variable");
		if(this.labelsDef.contains(name)) throw new SemanticalException("error: '" + name + "' label already defined");
		else this.labelsDef.add(name);
	}

	public void useLabel(String name) throws Exception{
		if(this.variables.containsKey(name)) throw new SemanticalException("error: '" + name + "' is a variable");
		else if(!this.labelsUse.contains(name)) labelsUse.add(name);
	}

	public void checkLabels() throws Exception{
		for(String label : labelsDef){
			if(!this.labelsUse.contains(label) && !label.equals("start")) throw new SemanticalException("error: '" + label + "' label is not used");
		}
		for(String label : labelsUse){
			if(!this.labelsDef.contains(label)) throw new SemanticalException("error: '" + label + "' label is not defined");
		}

		if(!labelsDef.contains("start")) throw new SemanticalException("error: 'start' label is not defined");
	}

	public void setProgramId(String program_id){
		this.program_id = program_id;
	}


	public void matchProgramId(String program_id) throws Exception{
		if(!this.program_id.equals(program_id))
			throw new SemanticalException("error: program id does not match");
	}

}