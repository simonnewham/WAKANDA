import java.io.*;
import java.util.*;

public class Parser {
	
	enum isTerm{
		TRMNL, NONTRMNL
	}
	//read in lexer 
	//were thinking of instead taking in an ArrayList of Tokens instead of file
	public Parser(File file){
		BufferedReader br = new BufferedReader(new FileReader(file));
		try {
			StringBuilder sb= new StringBuilder(); 
			String line= br.readLine();
			
			while (line !=null){
				
			}
		} finally{
			br.close();
		}
	}

	//call program 
    
	public boolean parse(){
		
	}
	
	
	
	
	
}
