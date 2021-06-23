import java.util.Scanner;

public class WaterBilling
{
	public static final double VAT=30.99;
	
	public static void main(String[] args)
	{
		
		Scanner keyboard = new Scanner(System.in);
		double[] arr = {0.0000,5.9178,10.3562,19.7260,34.5205,49.3151};
		double[] tariff = {4.0,15.57,22.78,38.32,99.99,265.12};
		System.out.print("Enter Previous meter reading: ");
		double prevMeterReading = keyboard.nextInt();
		System.out.print("Enter Current meter reading: ");
		double curMeterReading = keyboard.nextInt();
		double waterUsed = curMeterReading-prevMeterReading;
		double totalAmount = 0;
		double subtotal = 0;
		System.out.print("\n");
		
		
		
		System.out.print("\n");
		double cumulative = 0;
		double volumeUsed = 0;
		System.out.print("From"+"\t\t"+"To"+"\t\t"+"Volume used"+"\t\t"+"Cumulative"+"\t\t"+"Tariff"+"\t\t"+"Cost");
		System.out.print("\n");

		int k = 0;
		int total = 0;
		for(int i = 0; i<6; i++)
		{
			k = i;
			if(cumulative>waterUsed)
			{
				break;
			}
			if(i < 5){
				total += arr[i+1]-arr[i];
				if(total > waterUsed)
				{
					break;
				}
				volumeUsed = arr[i+1]-arr[i];
				totalAmount = tariff[i]*volumeUsed;
				subtotal += totalAmount;
				cumulative += volumeUsed;
				System.out.println(arr[i]+"\t\t"+arr[i+1]+"\t\t"+volumeUsed+"\t\t\t"+cumulative+"\t\t\t"+tariff[i]+"\t\t"+totalAmount);
			}
		}
		volumeUsed = Math.round((waterUsed-cumulative)*50)/50;
		volumeUsed += 0.6438;
		totalAmount = tariff[k]*volumeUsed;
		subtotal += totalAmount;
		System.out.println(arr[k]+"\t\t"+arr[k+1]+"\t\t"+volumeUsed+"\t\t\t"+waterUsed+"\t\t\t"+tariff[k]+"\t\t"+totalAmount);
		for(int j = k+1; j<arr.length; j++)
		{
			if(j<5)
			{
				totalAmount = tariff[j]*0;
				System.out.println(arr[j]+"\t\t"+arr[j+1]+"\t\t"+0.0000+"\t\t\t"+waterUsed+"\t\t\t"+tariff[j]+"\t\t"+totalAmount);
			}
		}
		totalAmount = 0;
		System.out.println(arr[arr.length-1]+"\t\t"+"      "+"\t\t"+0.0000+"\t\t\t"+waterUsed+"\t\t\t"+tariff[tariff.length-1]+"\t\t"+totalAmount);
		System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t"+"Subtotal \t"+subtotal);
		System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t"+"VAT \t\t"+VAT);
		System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t"+"Subtotal \t"+(subtotal+VAT));
	}
}
