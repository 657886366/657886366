//import java.util.LinkedList;
//
//class ClassDef extends ClassDefList {
//	String id; // variable on the left side of the assignment
//	String superClassName;
//	ClassBody cb;
//	LinkedList<String> className = new LinkedList<String>();
//	ClassDef(String s, ClassBody classBody){
//		id=s;
//		cb=classBody;
//		printClassName();
//	}
//	ClassDef(String cla,String sc, ClassBody classBody){
//		id=cla;
//		superClassName=sc;
//		cb=classBody;
//		printClassName();
//	}
//	
//	void printClassName() {
//		IO.displayln(id+"=");
//		IO.displayln("superclass="+superClassName);
//		
//	}
//}


class ClassDef
{
	ClassName className;
	ClassName superClassName; // value can be null
	ClassBody classBody;

	ClassDef(ClassName cn, ClassName scn, ClassBody cb)
	{
		className = cn;
		superClassName = scn;
		classBody = cb;
	}

	void semanticCheck()
	{
		SemanticChecker.currentClassName = className.id;
		SemanticChecker.currentClassDefEntry = new ClassDefEntry();
		if ( superClassName == null )
			SemanticChecker.currentClassDefEntry.superClassName = "";
		else
			SemanticChecker.currentClassDefEntry.superClassName = superClassName.id;
		SemanticChecker.symbolTable.put(className.id, SemanticChecker.currentClassDefEntry);
		classBody.semanticCheck();
	}
}