package pass1;
import java.io.*;
import java.util.*;
public class File {

	public static void main(String[] args) throws IOException,FileNotFoundException,ArrayIndexOutOfBoundsException
	{
		int lc=0;
		String code;
		BufferedReader br=new BufferedReader(new FileReader("input.txt"));
		BufferedWriter wr=new BufferedWriter(new FileWriter("Ic.txt"));
		String line;
		InstructionTable table=new InstructionTable();
		LinkedHashMap<String,Table>Symtab=new LinkedHashMap();
		int symindex=0;
		
		while((line=br.readLine())!=null)
		{
			String parts[]=line.split("\\s+");
		
		
			if(parts[1].equals("START"))
			{
				lc=Integer.parseInt(parts[2]);
				code="(AD,01)\t"+"(C,"+lc+")";
				wr.write(code+"\n");
			}
			if(parts[1].equals("END"))
			{
				
				code="(AD,02)\t";
				wr.write(code+"\n");
			}
			if(parts[1].equals("DS"))
			{
				int j=Integer.parseInt(parts[2]);
				code="(DL,02)\t"+"(C,"+j+")";
				wr.write(code+"\n");
				lc=lc+j;
				
			}
			if(parts[1].equals("DC"))
			{
				int j=Integer.parseInt(parts[2]);
				code="(DL,01)\t"+"(C,"+j+")";
				wr.write(code+"\n");
				lc=lc+1;
			}
			if(!parts[0].isEmpty())
			{
			   if(Symtab.containsKey(parts[0]))
				  {
					Symtab.put(parts[0],new Table(parts[0],lc,Symtab.get(parts[0]).getIndex()));
				  }
			   else
			      {
				   Symtab.put(parts[0],new Table(parts[0],lc,++symindex));
				   
			      }
				
			}
			if(table.getType(parts[1]).equals("IS"))
			{
			  code="(IS,0"+table.getCode(parts[1]) +")";	
			  int j=2;
			  String code2="";
			  while(j<parts.length)
			  {
				  if(table.getType(parts[j]).equals("RG"))
				  {
					  code2=code2+table.getCode(parts[j])+" ";
					  
				  }
				  else
				  {
					  if(Symtab.containsKey(parts[j]))
					  {
						  int ind=Symtab.get(parts[j]).getIndex();
						  code2=code2+"(S,0"+ind+")";
					  }
					  else
					  {
						  Symtab.put(parts[j],new Table(parts[j],-1,++symindex));
						  int ind=Symtab.get(parts[j]).getIndex();
						  code2=code2+"(S,0"+ind+")";
					  }
					  
				  }
				  j++;
				  
			  }//while
			  code=code+" "+code2;
			  wr.write(code+"\n");
			  
			}	
		}
		br.close();
		wr.close();
		BufferedWriter bws=new BufferedWriter(new FileWriter("SYMTAB.txt"));
		Iterator<String> itr=Symtab.keySet().iterator();
		System.out.println("Symbol Table\n");
		while(itr.hasNext())
		{
			String key=itr.next().toString();
			Table value=Symtab.get(key);
			System.out.println(value.getIndex()+"\t"+value.getSymbol()+"\t"+value.getAddress()+"\n");
	
			bws.write(value.getIndex()+"\t"+value.getSymbol()+"\t"+value.getAddress()+"\n");	
		}
	bws.close();
	}
		
	

}

