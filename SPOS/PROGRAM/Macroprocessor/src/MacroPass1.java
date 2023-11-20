import java.io.*;
import java.util.*;
import static java.lang.System.out;
public class MacroPass1 {
     static List<MNT> mnt=new LinkedList<MNT>();
     static List<String> ala=new LinkedList<String>();
     static List<String> mdt=new LinkedList<String>();
     static int mntc=0;
     static int mdtc=0;
     static BufferedReader br;
     static BufferedWriter bw;
     
     
	public static void main(String[] args) throws Exception ,IOException
	{   String line;
		br=new BufferedReader(new FileReader("IP.txt"));
		bw=new BufferedWriter(new FileWriter("OP.txt"));
		
		
		while((line=br.readLine())!=null)
		 {  String parts[]=line.split("\\s+");
		
		
		    if(parts[0].equals("MACRO"))
		      {
			process_def(line);
		       }
		    else
			   {
			 	bw.write(line+"\n");
			   }
		}
		
		System.out.println("ALA");
		printala();
		System.out.println("MNT");
		printmnt();
		System.out.println("MDT");
		printmdt();
		bw.close();
	}
	static void printala() throws IOException
	{
		
		int i=0;
		for(String l:ala)
		{
			System.out.println(i+" "+l);
			bw.write(i+" "+l+"\n");
			i++;
		}
		out.println(" ");
		
	}
	static void printmnt() throws IOException
	{
		
		int i=0;
		for(MNT l:mnt)
		{
			System.out.println(i+" "+l.macro_name+" "+l.mdtc);
			bw.write(i+" "+l.macro_name+" "+l.mdtc+"\n");
			i++;
		}
		out.println();
	}
	static void printmdt() throws IOException
	{
		
		int i=0;
		for(String l:mdt)
		{
			System.out.println(i+" "+l);
			bw.write(i+" "+l+"\n");
			i++;
		}
		out.println();
	}
static void process_def(String line) throws IOException
  {
	String l=br.readLine();
	String tk[]=l.split(" ");
	mnt.add(new MNT(tk[0],mdtc));
	mntc++;
	String args[]=tk[1].split(",");
	for(int i=0;i<args.length;i++)
	{
		ala.add(args[i]);
		
	}
	mdt.add(l);
	mdtc++;
	while(!l.equalsIgnoreCase("MEND"))
	{   int ind;
		int i=0;
		String opline="";
		l=br.readLine();
		if((ind=l.indexOf("&"))>0)
		{  // System.out.print(l);
			String wrd[]=l.split("\\s+");
			opline=opline+" " +wrd[0];
			String margs[]=wrd[1].split(",");
			opline=opline+" "+margs[0];
			//System.out.println(margs.length);
			while(i<margs.length)
			{   
				if(margs[i].startsWith("&"))
				{
					ind=ala.indexOf(margs[i]);
					opline=opline+" #"+ind;
				}
				i++;
			}
		}
		else
		{
			opline=l;
		}
		mdt.add(opline);
		mdtc++;
	}		
   }
}
