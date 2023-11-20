package pass1;

public class Table {
	String symbol;
	int address;
	int index;
	
	public Table(String symbol,int address)
	{
		this.symbol=symbol;
		this.address=address;
		index=0;	
	}
	public Table(String symbol,int address,int index)
	{
		this.symbol=symbol;
		this.address=address;
		this.index=index;	
	}
	
	public void setAddress(int address)
    {
        this.address=address;	
    }
	public int getAddress()
	{
		return this.address;
	}
	public void setIndex(int index)
	{
		this.index=index;	
    }
	public int getIndex()
	{
		return this.index;	
	}
	public void setSymbol(String symbol)
    {
		this.symbol=symbol;	
    }
	public String getSymbol()
	{
		return this.symbol;	
	}

}
