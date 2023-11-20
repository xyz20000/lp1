package pass1;
import java.util.HashMap;
public class InstructionTable {
	HashMap<String,Integer> IS,DL,AD,RG;
	 
	   public InstructionTable()
	   {
		   IS=new HashMap();
		   DL=new HashMap();
		   AD=new HashMap();
		   RG=new HashMap();
		   IS.put("ADD",01);
		   IS.put("SUB",02);
		   IS.put("MUL",03);
		   IS.put("MOVER",04);
		   IS.put("MOVEM",05);
		   IS.put("COMPARE",06);
		   AD.put("START",01);
		   AD.put("END",02);
		   AD.put("ORIGIN",03);
		   AD.put("LTORG",05);
		   DL.put("DC",01);
		   DL.put("DS",02);
		   RG.put("AREG",01);
		   RG.put("BREG",02);
		   
	   }
	 
	   public String getType(String s)
	   {
		   s=s.toUpperCase();
		   if(AD.containsKey(s))
			   return "AD";
			
		   else if(IS.containsKey(s))
		           return "IS";
		   
		   else if(DL.containsKey(s))
			   return "DL";
		   
		   else if(RG.containsKey(s))
			   return "RG";
		   
		   else
			   return " ";
		   

	}
	   
	   public int getCode(String s)
	   {
		   s=s.toUpperCase();
		   if(AD.containsKey(s))
				  return AD.get(s);
				  
		   else if(IS.containsKey(s))
		        return IS.get(s);
		   
		   else if(DL.containsKey(s))
			return DL.get(s);
		   
		   else if(RG.containsKey(s))
		        return RG.get(s);
		   
		   else
	                return (-1);
		   
		    		 
	}
	

}
