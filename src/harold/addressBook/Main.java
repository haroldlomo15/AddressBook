package harold.addressBook;

import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		
		String name,address = "";
		System.out.println("Welcome to Your Address Book\n-------------------------------\n");
		System.out.println("Press 1 To Add Entry.\nPress 2 To Delete Entry.\nPress 3 To Get Address. \nPress 4 To Change Person's Address\n");
		int option;
		
		addressDirectory object = new addressDirectory("infile.txt", "|");
		
		System.out.println("Enter your option : ");
		Scanner in_stream = new Scanner(System.in);
		option=in_stream.nextInt();
		if(option ==1){
			Scanner name_object = new Scanner(System.in);
			Scanner address_object= new Scanner(System.in);
			System.out.println("Enter the name : ");
			name=name_object.nextLine();
			System.out.println("Enter the Street Name : ");
			address += (address_object.nextLine() );
			System.out.println("Enter the City : ");
			address+=(" " + address_object.nextLine() );
			System.out.println("Enter the State : ");
			address+=(" " + address_object.nextLine() );
			System.out.println("Enter the ZipCode : ");
			address+=(" " + address_object.nextLine() );
			System.out.println("Enter the Tel. No : ");
			address+=("\tTel No. " + address_object.nextLine() );
			
			
			object.openFile();
			object.addRecords(name, address);
			object.closeFile();
			object.addEntry(name, address);
			
			
			
		}
		else if(option==2){
						
					Scanner name_object= new Scanner(System.in);
					System.out.println("Enter the name to be deleted : ");
					name=name_object.nextLine();
					object.DeleteEntry(name);
			}
		else if(option==3){
				Scanner name_object= new Scanner(System.in);
				System.out.println("Enter the name to search : ");
				name = name_object.nextLine();
	
				address=object.getAddress(name);
				
				
				if(address.equals(null)){
					System.out.println("ERROR! The name entered is not found");
				}
				else{
					System.out.println("\nThe Address is : \n" + address);
				}
			}
		else if(option==4){
				Scanner name_object= new Scanner(System.in);
				Scanner address_object= new Scanner(System.in);
				System.out.println("Enter the name update : ");
				name=name_object.nextLine();
				System.out.println("Enter the street address to be updated : ");
				address += (address_object.nextLine() );
				System.out.println("Enter the City : ");
				address+=(" " + address_object.nextLine() );
				System.out.println("Enter the State : ");
				address+=(" " + address_object.nextLine() );
				System.out.println("Enter the ZipCode : ");
				address+=(" " + address_object.nextLine() );
				System.out.println("Enter the Tel. No : ");
				address+=("\tTel No. " + address_object.nextLine() );
				
				object.openFile();
				object.addRecords(name, address);
				object.closeFile();
				object.changeEntry(name, address);						
			}
		else{
			System.out.println("Wrong option entered");
		}
	}
	
	public static String getRandChars(){
        final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        final int N = alphabet.length();

        Random r = new Random();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            builder.append(alphabet.charAt(r.nextInt(N)));
        }
        return builder.toString();
    }
}