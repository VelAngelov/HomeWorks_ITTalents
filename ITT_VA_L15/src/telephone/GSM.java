package telephone;

public class GSM {
	// Fields
	String model;
	boolean hasSimCard;
	String simMobileNum;
	int outgoingCallsDuration;
	Call lastIncomingCall;
	Call lastOutgoingCall;

	// Methods
	/*
	 * insertSimCard:
	 * 
	 * @simMobileNumber - {08}[0-9](10) - telephone number
	 */
	void insertSimCard(String simMobileNumber) {
		if (isValidSimNum(simMobileNumber)) {
			simMobileNum = simMobileNumber;
			hasSimCard = true;
		} else {
			System.out.println("Incorrect number for Sim Card!");
		}
	}

	/*
	 * removeSimCard
	 */
	void removeSimCard() {
		hasSimCard = false;
		simMobileNum = null;
	}

	/*
	 * call
	 * 
	 * @receiver -GSM
	 * 
	 * @duration -duration for the call in minutes
	 */
	void call(GSM receiver, int duration) {

		if (receiver.hasSimCard && hasSimCard && !receiver.simMobileNum.equals(simMobileNum)) {
			if (duration > 0 && duration < 60) {
				lastOutgoingCall = new Call();
				lastOutgoingCall.caller = this;
				lastOutgoingCall.reciever = receiver;
				lastOutgoingCall.duration = duration;
				outgoingCallsDuration += duration;

				receiver.lastIncomingCall = lastOutgoingCall;
			}
		}
	}

	/*
	 * Print total cost or outgoing calls using last outgoingCall
	 * priceForAMinute
	 */
	double getSumForCall() {
		if (lastOutgoingCall == null) {
			return 0;
		}
		return lastOutgoingCall.priceForAMinute * outgoingCallsDuration;
	}

	/*
	 * validate simMobileNum
	 */
	static boolean isValidSimNum(String simMobileNumber) {
		if (simMobileNumber.startsWith("08") && simMobileNumber.length() == 10) {
			for (int i = 2; i < simMobileNumber.length(); i++) {
				if (simMobileNumber.charAt(i) < '0' || simMobileNumber.charAt(i) > '9') {
					return false;
				}
			}
			return true;
		} else {
			return false;
		}
	}

	/*
	 * print info for lastOutgoingCall and last IncomingCall
	 */
	void printInfoForTheLastOutgoingCall() {
		if (lastOutgoingCall != null) {
			System.out.println("last outgoing call");
			System.out.printf("Reciever:%s\t Call duration:%d%n", lastOutgoingCall.reciever.simMobileNum,
					lastOutgoingCall.duration);
			System.out.printf("Price:%.2f lv%n", lastOutgoingCall.duration * lastOutgoingCall.priceForAMinute);
		} else {
			System.out.println("There is no outgoing calls");
		}
	}

	void printInfoForTheLastIncomingCall() {
		if (lastIncomingCall != null) {
			System.out.println("last incoming call:");
			System.out.printf("Call from:%s\t Call duration:%d%n", lastIncomingCall.caller.simMobileNum,
					lastIncomingCall.duration);
		} else {
			System.out.println("There is no incoming calls");
		}
	}
}
