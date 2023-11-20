package pass2;
import java.io.*;
import java.util.*;

public class pass2 {

	static int lc;
	public static void main(String[] args) throws IOException,FileNotFoundException,ArrayIndexOutOfBoundsException
	{
		BufferedReader br=new BufferedReader(new FileReader("SYMTAB.txt"));
		ArrayList<TableRow> symtab=new ArrayList<>();
		String line;
		
		while((line=br.readLine())!=null)
		{
			String parts[]=line.split("\\s+");
			symtab.add(new TableRow(parts[1],Integer.parseInt(parts[2]),Integer.parseInt(parts[0])));
			System.out.println(parts[1]+" "+Integer.parseInt(parts[2])+" "+Integer.parseInt(parts[0]));
		}
		
		br.close();
		br=new BufferedReader(new FileReader("C:\\Users\\ASHISH\\eclipse-workspace\\pass1\\Ic.txt"));
		BufferedWriter bw=new BufferedWriter(new FileWriter("pass2.txt"));
		String code;
		
		
		while((line=br.readLine())!=null)
		{
			String parts[]=line.split("\\s+");
			
			 if(parts[0].contains("DL,02"))
		        {  int constant=Integer.parseInt(parts[1].replaceAll("[^0-9]",""));
		        	lc=lc+constant;
		        	
		        }
			
	        if(parts[0].contains("AD") ||(parts[0].contains("DL,02")))
	        {
	        	bw.write("\n");
	        }
	        else if(parts.length==1)
	        {
	        	int opcode=Integer.parseInt(parts[0].replaceAll("[^0-9]" ,""));
	        	code=String.format("%02d",opcode)+"\t0\t"+String.format("%03d",0)+"\n";
	        	bw.write(code);
	        }
	        else if(parts.length==2)
	        {
	        	if(parts[0].contains("DL,01"))
	        	{
	        		int constant=Integer.parseInt(parts[1].replaceAll("[^0-9]",""));
	        		code=String.format("%02d",0)+"\t0\t"+String.format("%03d",constant)+"\n";
	        		bw.write(lc+")"+code);
	        		System.out.println(lc+")"+code);
	        	}
	        	else if(parts[0].contains("IS"))
	        	{
	        		int opcode=Integer.parseInt(parts[0].replaceAll("[^0-9]",""));
	        		int symindex=Integer.parseInt(parts[1].replaceAll("[^0-9]" ,""));
	        		int add=symtab.get(symindex-1).getAddress();
	        		code=String.format("%02d",opcode)+"\t0\t"+String.format("%03d",add)+"\n";
	        		bw.write(lc+")"+code);
	        		System.out.println(lc+")"+code);	
	        	}	
	        }
	        else if(parts.length==3)
	        {    
	        	int opcode=Integer.parseInt(parts[0].replaceAll("[^0-9]",""));
	       
	        	int regcode=Integer.parseInt(parts[1]);
	        	int symindex=Integer.parseInt(parts[2].replaceAll("[^0-9]",""));
	        	int add=symtab.get(symindex-1).getAddress();
	        	code=String.format("%02d",opcode)+"\t"+regcode+"\t"+String.format("%03d",add)+"\n";
	        	bw.write(lc+")"+code);
	        	System.out.println(lc+")"+code);
	        			
	        }
	        lc++;
		}
		br.close();
	    bw.close();	
	}

	}


