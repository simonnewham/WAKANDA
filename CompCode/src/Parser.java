import java.io.*;
import java.util.*;

public class Parser {
	
	enum isTerm{
		TRMNL, NONTRMNL
	}
	Program program;
	
	//read in lexer 
	//were thinking of instead taking in an ArrayList of Tokens instead of file
	
	public Parser(File file) throws IOException{
		//@ reading in a file: Breyden and Chris, you guys can read this in
		BufferedReader br = new BufferedReader(new FileReader(file));
		try {
			StringBuilder sb= new StringBuilder(); 
			String line= br.readLine();
			
			while (line !=null){
				sb.append(line);
        			sb.append(System.lineSeparator());
        			line = br.readLine();
			}
		} finally{
			br.close();
		}
		
		//Sets output of consoles System.out... to file
		PrintStream out = new PrintStream(new FileOutputStream("output.txt"));
		System.setOut(out);
	}
	
	public boolean parse(ArrayList<TokenTypes> lexer){
		program = new Program();
		
		program.parseProgram(lexer);
		
		return true;
		
	}
	
	
	
	
	
}
