//
//public abstract class Parser extends LexAnalyzer{
//	
//	static boolean errorFound = false;
//	
//	public static ClassDefList classDefList() {
//		//<class def list> →<class def> | <class def><class def list>
//		ClassDef classDef = classDef();
//		if ( state == State.Id )
//		{
//			ClassDefList classDefList = classDefList();
//			return new MultipleClassDef(classDef, classDefList);
//		}
//		else
//			return classDef;
//	}
//	
////	class ClassDefEntry // symbol table entry for a single <class def>
////	{
////		String superClassName; // value is "" if superclass is absent
////		LinkedList<String> fields = new LinkedList<String>();
////		HashMap<String, LinkedList<String>> funMap = new HashMap<String, LinkedList<String>>();
////			// function names mapped to their parameters
////
////		public String toString()
////		{
////			return "\nsuperclass=" + superClassName + "\nfields=" + fields.toString() + "\nfunctions=" + funMap.toString();
////		}
////	}
//	
////	static HashMap<String, ClassDefEntry> symbolTable = new HashMap<String, ClassDefEntry>();
////	// class names mapped to their ClassDefEntry objects
//	
//	public static ClassDef classDef() {
//		//<class def>→ "class" <class name> [ : <class name>] <class body>   // <class name> after ":" is the direct superclass name.
//		if ( state == State.Id )
//		{
//			String className = t;
//			getToken();
//			
//			
//			if (state == State.Colon )
//			{
//			    
//				getToken();
//				
//				if ( state == State.Id)
//				{
//					String superclass=t;
//					getToken();
//					if(state==State.LBrace) {
//						ClassBody classBody=classBody();
//					  return new ClassDef(className, superclass,classBody);
//					}
//					else
//						errorMsg(5);
//				}
//				else
//					errorMsg(4);
//			}
//			else if(state==State.LBrace) {
//				ClassBody classBody=classBody();
//				return new ClassDef(className,classBody);
//			}
//			else
//				errorMsg(3);
//		}
//		else
//			errorMsg(5);
//		return null;
//	}
//	
//	public static ClassBody classBody() {
//		return null;
//		
//	}
//	
//	public static void errorMsg(int i)
//	{
//		errorFound = true;
//		
//		display(t + " : Syntax Error, unexpected symbol where");
//
//		switch( i )
//		{
//		case 1:	displayln(" arith op or ) expected"); return;
//		case 2: displayln(" id, int, float, or ( expected"); return;
//		case 3:	displayln(" = expected"); return;
//		case 4:	displayln(" ; expected"); return;
//		case 5:	displayln(" id expected"); return;		
//		}
//	}
//
//	public static void main(String argv[])
//	{
//		// argv[0]: input file containing an assignment list
//		// argv[1]: output file displaying the parse tree
//		
//		setIO( argv[0], argv[1] );
//		
//
//		getToken();
//
//		ClassDefList classDefList = classDefList(); // build a parse tree
//		if ( ! t.isEmpty() )
//			errorMsg(5);
////		else if ( ! errorFound )
////			assignmentList.printParseTree(""); // print the parse tree in linearly indented form in argv[1] file
//
//		closeIO();
//	}
//  
//}
public class notUsed {

}





//
//import java.util.HashMap;
//
//import LexAnalyzer.State;
//
///**
//	 
//	This class is a lexical analyzer for the tokens defined by the grammar:
//	
//⟨letter⟩ → a | b | ... | z | A | B | ... | Z
//⟨digit⟩ → 0 | 1 | ... | 9
//⟨id⟩ → ⟨letter⟩ {⟨letter⟩ | ⟨digit⟩}
//⟨int⟩ → [+|−] {⟨digit⟩}+
//⟨float⟩ → [+|−] ( {⟨digit⟩}+ "." {⟨digit⟩}  |  "." {⟨digit⟩}+  )
//⟨floatE⟩ → (⟨float⟩ | ⟨int⟩) (e|E) [+|−] {⟨digit⟩}+
//⟨add⟩ → +
//⟨sub⟩ → −
//⟨mul⟩ → *
//⟨div⟩ → /
//⟨or⟩ → "|"
//⟨and⟩ → &
//⟨not⟩ → !
//⟨lt⟩ → "<"
//⟨le⟩ → "<="
//⟨gt⟩ → ">"
//⟨ge⟩ → ">="
//⟨eq⟩ → "="
//⟨dot operator⟩ → "."
//⟨LParen⟩ → "("
//⟨RParen⟩ → ")"
//⟨LBrace⟩ → "{"
//⟨RBrace⟩ → "}"
//⟨colon⟩ → ":"
//
//	This class implements a DFA that will accept the above tokens.
//
//	The DFA states are represented by the Enum type "State".
//	
//
//	The function "driver" operates the DFA. 
//	The function "nextState" returns the next state given the current state and the input character.
//
//	To recognize a different token set, modify the following:
//
//	  enum type "State" and function "isFinal"
//	  function "nextState" 
//
//	The functions "driver", "getToken" remain the same.
//
//	**/
//
//
//	public abstract class LexAnalyzer extends IO
//	{
//		
//		static State nextState[][] = new State[26][128];
//	 
//	          // This array implements the state transition function State x (ASCII char set) --> State.
//	          // The state argument is converted to its ordinal number used as
//	          // the first array index from 0 through 25. 
//
//		private static HashMap<String, State> keywordMap = new HashMap<String, State>();
//
//		public enum State 
//	       	{ 
//		  // non-final states     ordinal number
//
//			Start,             // 0
//			Period,            // 1
//			E,                 // 2
//			EPlusMinus,        // 3
//
//		  // final states
//
//			Id,                // 4
//			Int,               // 5
//			Float,             // 6
//			FloatE,            // 7
//			Add,              // 8
//			Sub,             // 9
//			Mul,             // 10
//			Div,               // 11
//			LParen,            // 12
//			RParen,            // 13
//			LBrace,            //14
//			RBrace,            //15
//            Lt,                //16
//            Le,                //17
//            Gt,                //18
//            Ge,                 //19
//            Eq,                 //20
//            DotOp,             //21
//            Or,                //22
//            And,               //23
//            Not,               //24
//            Colon,             //25
//            id_c,              //26
//            id_cl,             //27
//            id_cla,            //28
//            id_clas,           //29
//            id_i,              //30
//            id_n,              //31
//            id_nu,             //32
//            id_nul,            //33
//            id_t,              //34
//            id_th,              //35
//            id_thi,             //36
//            Keyword_class,       //37
//            Keyword_if,          //38
//            Keyword_null,        //39
//            Keyword_this,        //40
//            DecimalPoint,    // 23         "+.", "-."
//			UNDEF;
//
//			private boolean isFinal()
//			{
//				return ( this.compareTo(State.Id) >= 0 );  
//			}	
//		}
//		
//		private static void setKeywordMap()
//		{
//			keywordMap.put("class", State.Keyword_class);
//			keywordMap.put("if",    State.Keyword_if);
//			keywordMap.put("null",  State.Keyword_null);
//			keywordMap.put("this",  State.Keyword_this);
//		}
//		public static void setLex()
//
//		// Sets the nextState array and keywordMap.
//
//		{
//			setNextState();
//			setKeywordMap();
//		}
//
//
//		// By enumerating the non-final states first and then the final states,
//		// test for a final state can be done by testing if the state's ordinal number
//		// is greater than or equal to that of Id.
//
//		// The following variables of "IO" class are used:
//
//		//   static int a; the current input character
//		//   static char c; used to convert the variable "a" to the char type whenever necessary
//
//		public static String t; // holds an extracted token
//		public static State state; // the current state of the FA
//
//		private static int driver()
//
//		// This is the driver of the FA. 
//		// If a valid token is found, assigns it to "t" and returns 1.
//		// If an invalid token is found, assigns it to "t" and returns 0.
//		// If end-of-stream is reached without finding any non-whitespace character,
//		// assigns the empty string "" to "t" and returns -1.
//
//		{
//			State nextSt; // the next state of the FA
//
//			t = "";
//			state = State.Start;
//
//			if ( Character.isWhitespace((char) a) )
//				a = getChar(); // get the next non-whitespace character
//			if ( a == -1 ) // end-of-stream is reached
//				return -1;
//
//			while ( a != -1 ) // do the body if "a" is not end-of-stream
//			{
//				c = (char) a;
//				nextSt = nextState( state, c );
//				if ( nextSt == State.UNDEF ) // The FA will halt.
//				{
//					if ( state.isFinal() )
//						return 1; // valid token extracted
//					else // "c" is an unexpected character
//					{
//						t = t+c;
//						a = getNextChar();
//						return 0; // invalid token found
//					}
//				}
//				else // The FA will go on.
//				{
//					state = nextSt;
//					t = t+c;
//					a = getNextChar();
//				}
//			}
//
//			// end-of-stream is reached while a token is being extracted
//
//			if ( state.isFinal() )
//				return 1; // valid token extracted
//			else
//				return 0; // invalid token found
//		} // end driver
//
//		public static void getToken()
//
//		// Extract the next token using the driver of the FA.
//		// If an invalid token is found, issue an error message.
//
//		{
//			int i = driver();
//			if ( i == 0 )
//				displayln(t + " : Lexical Error, invalid token");
//		}
//
//		private static State nextState(State s, char c)
//
//		// Returns the next state of the FA given the current state and input char;
//		// if the next state is undefined, UNDEF is returned.
//
//		{
//			switch( state )
//			{
//			case Start:
//				
//				//check keyword first, otherwise the input will all be id.
//				
//			    if(c=='c')
//					return State.id_c;
//				else if(c=='i')
//					return State.id_i;
//				else if(c=='n')
//					return State.id_n;
//				else if(c=='t')
//					return State.id_t;
//				else if ( Character.isLetter(c) )
//					return State.Id;
//				else if ( Character.isDigit(c) )
//					return State.Int;
//				else if ( c == '+' )
//					return State.Add;
//				else if ( c == '-' )
//					return State.Sub;
//				else if ( c == '*' )
//					return State.Mul;
//				else if ( c == '/' )
//					return State.Div;
//				else if ( c == '(' )
//					return State.LParen;
//				else if ( c == ')' )
//					return State.RParen;
//				else if ( c == '{' )
//					return State.LBrace;
//				else if ( c == '}' )
//					return State.RBrace;
//				else if ( c == '<' )
//					return State.Lt;
//				else if (c=='>')
//					return State.Gt;
//				else if (c=='=')
//					return State.Eq;
//				else if (c=='.')
//					return State.DotOp;
//				else if (c=='|')
//					return State.Or;
//				else if (c=='&')
//					return State.And;
//				else if (c=='!')
//					return State.Not;
//				else if (c==':')
//					return State.Colon;
//				
//				else
//					return State.UNDEF;
//			case id_c:
//				if(c=='l')
//					return State.id_cl;
//				else if (Character.isLetterOrDigit(c))
//                    return State.Id;
//                else
//                    return State.UNDEF;
//			case id_cl:
//				if(c=='a')
//					return State.id_cla;
//				else if (Character.isLetterOrDigit(c))
//                    return State.Id;
//                else
//                    return State.UNDEF;
//			case id_cla:
//				if(c=='s')
//					return State.id_clas;
//				else if (Character.isLetterOrDigit(c))
//                    return State.Id;
//                else
//                    return State.UNDEF;
//			case id_clas:
//				if(c=='s')
//					return State.Keyword_class;
//				else if (Character.isLetterOrDigit(c))
//                    return State.Id;
//                else
//                    return State.UNDEF;
//			case id_i:
//				if(c=='f')
//					return State.Keyword_if;
//				else if (Character.isLetterOrDigit(c))
//                    return State.Id;
//                else
//                    return State.UNDEF;
//			case id_n:
//				if(c=='u')
//					return State.id_nu;
//				else if (Character.isLetterOrDigit(c))
//                    return State.Id;
//                else
//                    return State.UNDEF;
//			case id_nu:
//				if(c=='l')
//					return State.id_nul;
//				else if (Character.isLetterOrDigit(c))
//                    return State.Id;
//                else
//                    return State.UNDEF;
//			case id_nul:
//				if(c=='l')
//					return State.Keyword_null;
//				else if (Character.isLetterOrDigit(c))
//                    return State.Id;
//                else
//                    return State.UNDEF;
//			case id_t:
//				if(c=='h')
//					return State.id_th;
//				else if (Character.isLetterOrDigit(c))
//                    return State.Id;
//                else
//                    return State.UNDEF;
//			case id_th:
//				if(c=='i')
//					return State.id_thi;
//				else if (Character.isLetterOrDigit(c))
//                    return State.Id;
//                else
//                    return State.UNDEF;
//			case id_thi:
//				if(c=='s')
//					return State.Keyword_this;
//				else if (Character.isLetterOrDigit(c))
//                    return State.Id;
//                else
//                    return State.UNDEF;
//			case Lt:
//				 if(c=='=')
//					return State.Le;
//				else 
//					return State.UNDEF;
//			case Gt:
//				 if(c=='=')
//					return State.Ge;
//				else 
//					return State.UNDEF;
//			
//			case Id:
//				if ( Character.isLetterOrDigit(c) )
//					return State.Id;
//				else
//					return State.UNDEF;
//			case Int:
//				if ( Character.isDigit(c) )
//					return State.Int;
//				else if ( c == '.' )
//					return State.Period;
//				else
//					return State.UNDEF;
//			case Period:
//				if ( Character.isDigit(c) )
//					return State.Float;
//				else
//					return State.UNDEF;
//			case Float:
//				if ( Character.isDigit(c) )
//					return State.Float;
//				else if ( c == 'e' || c == 'E' )
//					return State.E;
//				else
//					return State.UNDEF;
//			case E:
//				if ( Character.isDigit(c) )
//					return State.FloatE;
//				else if ( c == '+' || c == '-' )
//					return State.EPlusMinus;
//				else
//					return State.UNDEF;
//			case EPlusMinus:
//				if ( Character.isDigit(c) )
//					return State.FloatE;
//				else
//					return State.UNDEF;
//			case FloatE:
//				if ( Character.isDigit(c) )
//					return State.FloatE;
//				else
//					return State.UNDEF;
//			case Keyword_class:
//				if(Character.isLetterOrDigit(c))
//                    return State.Id;
//                else
//                	return State.UNDEF;
//			case Keyword_if:
//				if(Character.isLetterOrDigit(c))
//                    return State.Id;
//                else
//                	return State.UNDEF;
//			case Keyword_null:
//				if(Character.isLetterOrDigit(c))
//                    return State.Id;
//                else
//                	return State.UNDEF;
//			case Keyword_this:
//				if(Character.isLetterOrDigit(c))
//                    return State.Id;
//                else
//                	return State.UNDEF;
//			default:
//				return State.UNDEF;
//			}
//		} // end nextState
//
//		public static void main(String argv[])
//
//		{		
//			// argv[0]: input file containing source code using tokens defined above
//			// argv[1]: output file displaying a list of the tokens 
//
//			setIO( argv[0], argv[1] );
//			
//			int i;
//
//			while ( a != -1 ) // while "a" is not end-of-stream
//			{
//				i = driver(); // extract the next token
//				if ( i == 1 ) {
//					if(state.compareTo(state.id_c)>=0 && state.compareTo(state.id_thi)<=0){
//                        displayln(t+"	: "+ state.Id);
//                    }
//					else{
//                        displayln(t + "   : " + state.toString());
//				    }
//				}
//				else if ( i == 0 )
//					displayln( t+" : Lexical Error, invalid token");
//			} 
//
//			closeIO();
//		}
//	} 



