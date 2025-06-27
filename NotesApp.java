package elevatelab_intern;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class NotesApp {

	private static final String FILE_NAME = "notes.txt";
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choice;
		do {
			System.out.println("\n --- Notes App --- ");
			System.out.println("1. Add Notes.");
			System.out.println("2. View Notes. ");
			System.out.println("3. Exit ");
			System.out.println("Enter your choice : ");
			choice = sc.nextInt();
			sc.nextLine();
			
			switch(choice) {
			
			case 1:
				addNote(sc);
				break;
			
			case 2:
				viewNote();
				break;
				
			case 3:
				System.out.println("Exiting . ");
				break;
				
			default:
				System.out.println("Invalid choice. try again");
			}
			
		}while(choice !=3);
			sc.close();
				
			
				
				
		
		}	
		
		private static void viewNote() {
			
			File file = new File(FILE_NAME);
			if(!file.exists()) {
				System.out.println("note not found");
				
			}
			try(BufferedReader reader = new BufferedReader(new FileReader(file))){
				String line;
					System.out.println("\n Your Notes:");
					while((line = reader.readLine()) !=null) {
						System.out.println("- "+ line);
			}
		}catch(IOException e ) {
			System.out.println("error reading : "+e.getMessage());
		}
		// TODO Auto-generated method stub
		
	}

		// TODO Auto-generated method stub

	
	private static void addNote(Scanner sc) {
		System.out.println("ENter your note: ");
		String note = sc.nextLine();
		
		try(FileWriter writer = new FileWriter(FILE_NAME, true)){
			writer.write(note+ System.lineSeparator());
			System.out.println("Note added successfully");
		}catch(IOException e) {
			System.out.println("Error writing : "+ e.getMessage());
			
		}
	
		// TODO Auto-generated method stub
		
	}

}
