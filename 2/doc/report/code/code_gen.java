

	public void handle_ASSIGNATION() throws Exception{
		this.read();
		switch(this.token.unit){
			case ADD:{
				
				IntegerVariable right = this.handle_EXPRESSION();
				this.read();
				this.match(LexicalUnit.TO);
				this.read();
				this.match(LexicalUnit.IDENTIFIER);
				VariableDecl decl = getVariable(token.getValue());
				this.read();
				this.match(LexicalUnit.END_OF_INSTRUCTION);

				String var_1 = variableAllocator.getNext();
				IntegerVariable left = new IntegerVariable(decl, var_1);
				new AssignTemp(left, decl);
				this.ensureSize(left, right);

				String var_0 = variableAllocator.getNext();
				IntegerVariable result = new IntegerVariable(left.isSigned(), left.getSize(), var_0);
				new Add(result, left, right);
				this.ensureDest(result, new IntegerVariable(decl));
				new Assign(result, decl);
				break;
			}