package telephone;

public class DemoGSM {
	public static void main(String[] args) {
		GSM vilioGSM = new GSM();
		vilioGSM.model = "Lenovo K5";
		vilioGSM.insertSimCard("0895533242");

		GSM krasiGSM = new GSM();
		krasiGSM.model = "Iphone 7";
		krasiGSM.insertSimCard("0895553333");
		
		System.out.println("info for call in Vilio GSM");
		vilioGSM.printInfoForTheLastOutgoingCall();
		vilioGSM.printInfoForTheLastIncomingCall();
		
		//several calls
		vilioGSM.call(krasiGSM, 3);
		krasiGSM.call(vilioGSM, 1);
		vilioGSM.call(krasiGSM, 5);
		krasiGSM.call(vilioGSM, 10);
		
		System.out.println("\n\ninfo for call in Vilio GSM");
		vilioGSM.printInfoForTheLastIncomingCall();
		vilioGSM.printInfoForTheLastOutgoingCall();
		vilioGSM.getSumForCall();
		System.out.printf("Total cost of calls %.2f lv",vilioGSM.getSumForCall());

		System.out.println("\n\ninfo for call in Krasi GSM");
		krasiGSM.printInfoForTheLastIncomingCall();
		krasiGSM.printInfoForTheLastOutgoingCall();
		System.out.printf("Total cost of calls %.2f lv",krasiGSM.getSumForCall());
	}
}
