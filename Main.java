import java.util.ArrayList;
import java.util.Scanner;
class Inventory {
     String name;
     String serialNumber;
     int value;
	Inventory(String a, String b, int c){
		name = a;
		serialNumber = b;
		value = c;
	}
	public String toString(){
		return name+","+serialNumber+","+value;
	}
}

class Main {
	public static void main(String[] args) {
ArrayList<Inventory> elements = new ArrayList<>();
String tempName;
String tempSerial;
int tempVal;
Scanner in = new Scanner(System.in);
int input=0;
while(input!=5){
	questions();
	input=in.nextInt();
	in.nextLine();
	if(input==1){
		System.out.println("Enter the name:");
        tempName=in.nextLine();
		System.out.println("Enter the serial number:");
		tempSerial=in.nextLine();
		System.out.println("Enter the value in dollars (whole number):");
		tempVal=in.nextInt();
		in.nextLine();
		elements.add(new Inventory(tempName,tempSerial,tempVal));
	}
	else if(input==2){
		System.out.println("Enter the serial number of the item to delete:");
		tempSerial= in.nextLine();
		for(int i=0; i< elements.size();i++) {
			if(elements.get(i).serialNumber.equals(tempSerial)) {
				elements.remove(i);
				break;
			}
		}
	}
	else if(input == 3) {
		System.out.println("Enter the serial number of the item to change:");
		tempSerial = in.next();
		in.nextLine();
		System.out.println("Enter the new name:");
		tempName = in.nextLine();
		System.out.println("Enter the new value in dollars (whole numbers):");
		tempVal = in.nextInt();
		for (Inventory element : elements) {
			if (element.serialNumber.equals(tempSerial)) {
				element.name = tempName;
				element.value = tempVal;
				break;
			}
		}
	}
	else if(input == 4){
		for (Inventory element : elements) {
			System.out.println(element.toString());
		}
	}
}
	}
	public static void questions(){
		System.out.println("Press 1 to add an item.");
		System.out.println("Press 2 to delete an item.");
		System.out.println("Press 3 to update an item.");
		System.out.println("Press 4 to show all items.");
		System.out.println("Press 5 to quit the program.");
	}
}
