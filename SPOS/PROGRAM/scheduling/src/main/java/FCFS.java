import java.util.Arrays;
import java.util.Scanner;

public class FCFS {

	private Scanner sc;

	public void  execute()
	{
		sc = new Scanner(System.in);

		//--------FCFS
		System.out.println("Enter Number of Processes:");
		int numProcess=sc.nextInt();
		Process []process=new Process[numProcess];

		//Accept Input
		for(int i=0;i<numProcess;i++)
		{
			System.out.println("P("+(i+1)+"):Enter Arrival time & Burst time");
			int at=sc.nextInt();
			int bt=sc.nextInt();
			//System.out.println("P("+(i+1)+"):Enter Arrival time");

			process[i]=new Process("P"+(i+1), bt, at);
		}

		//Sorting processes according to Arrival Time //No need if you take AT=0 or in ascending order
		Arrays.sort(process,new SortByArrival());

		int sum=0;
		double TotalWT=0,TotalTAT=0,avgWT=0,avgTAT=0;
		System.out.println("\n\nPRNo\tBT\tAT\tCT\tTAT\tWT");
		System.out.println("============================================================================================");
		for(int i=0;i<numProcess;i++)
		{
			sum=process[i].CT=sum+process[i].BT; //process 1 CT= sum=0+24=24+3=27
			process[i].TAT=process[i].CT-process[i].AT;//process 1TAT=27-0=27
			process[i].WT=process[i].TAT-process[i].BT;//Process 1 WT=27-3=24

			TotalWT=TotalWT+process[i].WT;
			TotalTAT=TotalTAT+process[i].TAT;

			process[i].display();
		}
		avgTAT=(double)TotalTAT/numProcess;
		avgWT=(double)TotalWT/numProcess;
		System.out.println("Average Waiting Time"+avgWT);
		System.out.println("Average TAT="+avgTAT);
	}

}
