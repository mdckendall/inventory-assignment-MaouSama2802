import java.util.ArrayList;
import java.util.Scanner;
class Inventory {
     String name;
     String serialNumber;
     int value;
	public Inventory(String name, String serialNumber, int value) {
		this.name = name;
		this.serialNumber=serialNumber;
		this.value=value;
	}
	@Override
	public String toString(){
		return name+", "+serialNumber+", "+value;
	}
}

class Main {
	public static void main(String[] args) {
ArrayList<Inventory> elements = new ArrayList<>();
		String userName="";
		String userSerialNumber="";
		int userValue=0;
		Inventory userList = new Inventory(userName, userSerialNumber, userValue);
Scanner in = new Scanner(System.in);
int input=0;
while(input!=5){
	questions();
	input=in.nextInt();
	if(input==1){
		System.out.println("Enter the name:");
        //userList.name=in.next();
        userList.name=inputNewItemName();

		System.out.println("Enter the serial number:");
		//userList.serialNumber=in.next();
		userList.serialNumber=inputNewItemSerial();
		System.out.println("Enter the value in dollars (whole number):");
		//userList.value=in.nextInt();
		userList.value=inputNewItemValue();
		elements.add(new Inventory(userList.name,userList.serialNumber,userList.value));
	}
	else if(input==2){
		System.out.println("Enter the serial number of the item to delete:");
		userList.serialNumber=inputNewItemSerial();
		for(int i=0; i< elements.size();i++) {
			Inventory currentItem = elements.get(i);
			if(currentItem.serialNumber.equals(userList.serialNumber)) {
				elements.remove(i);
				break;
			}
		}
	}
	else if(input == 3){
		System.out.println("Enter the serial number of the item to change:");
        userList.serialNumber= in.next();
		for (Inventory currentItem : elements) {
			if (currentItem.serialNumber.equals(userList.serialNumber)) {
				System.out.println("Enter the new name:");
				userList.name = inputNewItemName();
				System.out.println("Enter the new value in dollars (whole numbers):");
				userList.value = inputNewItemValue();
				currentItem.name = userList.name;
				currentItem.value = userList.value;
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
public static String inputNewItemName(){
		String itemName;
		Scanner scan = new Scanner(System.in);
		itemName=scan.next();
		return itemName;
}
	public static String inputNewItemSerial(){
		String itemSerialNumber;
		Scanner scan = new Scanner(System.in);
		itemSerialNumber=scan.next();
		return itemSerialNumber;
	}
	public static int inputNewItemValue(){
		int itemValue;
		Scanner scan = new Scanner(System.in);
		itemValue=scan.nextInt();
		return itemValue;
	}


	public static void questions(){
		System.out.println("Press 1 to add an item.");
		System.out.println("Press 2 to delete an item.");
		System.out.println("Press 3 to update an item.");
		System.out.println("Press 4 to show all items.");
		System.out.println("Press 5 to quit the program.");
	}
}
