import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.ImageIcon; 
import javax.swing.JOptionPane;

class Verwaltung	{
	
	public static List<User> gymWueUser;
	
	//Anbindung an die Datenbank
	
	public static void main(String[] args)	{	
			
			// Server // port //DB-Name // user-name // passwort
			/*DatabaseConnector connector = new DatabaseConnector("192.162.85.139","3306","h138020_info22a","h138020_info22a","Friedrichgeniesstnun2021!");
			if (connector.getErrorMessage() != null){
			  JOptionPane.showMessageDialog(null,"Verbindung zur Datenbank nicht möglich. \n"+connector.getErrorMessage(),"Fehlermeldung",JOptionPane.ERROR_MESSAGE,null); 
			  System.exit(0);
			}*/    
			
		   //SQL-Anweisung: Statistische Daten aus der DB laden.
		  /*QueryResult result = connector.getCurrentQueryResult();  
		  String anweisung = 
			"SELECT * FROM user";*
		  connector.executeStatement(anweisung);
		  result = connector.getCurrentQueryResult(); 
		  if (result.getData()[0][0] != null){
				System.out.println(result.getData()[0][0]);
		  }

		  if (result.getData()[0][0] != null){
			  System.out.println("Hurra");
		  }*/
			
			// Fülle Userliste mit Daten aus der CSV-Datei
			gymWueUser = csv2UserList("userdata.csv");
			
			// Erstelle GUI-Objekt zur Verwaltung!
			MainFrame meineGui = new MainFrame();
			meineGui.setVisible(true);			          
	}
	
	
	
	
    public static User[] csv2UserArray(String filepath)	{
        
        // Lege Array an...
        User[] usernames = new User[877]; // PROBLEM: was ist wenn die CSV-Datei andere Zeilen hat
       
        try
        {
            // lese Zeilenweise CSV-Datei ein
            Scanner scanner = new Scanner(new File(filepath));
            Scanner dataScanner = null;	//Objekt zum lesen eines Datensatzes
            // solange es einen nächste Zeile mit Text gibt, führe Schleife aus
            int i = 0;
            while(scanner.hasNext()==true)	{
                dataScanner = new Scanner(scanner.nextLine());	//nehme nächste Zeile in Objekt
                dataScanner.useDelimiter(";");	// Trennungszeichen zwischen Daten 
                // lege Array an der Größe 3 an.... 
                String data[] = new String[3];
                // speichere ersten Wert an Stelle 0
                data[0] = dataScanner.next();
                // speichere zweiten Wert an Stelle 1
                data[1] = dataScanner.next();
                // speichere zweiten Wert an Stelle 2
                data[2] = dataScanner.next();
                // Todo: Mache etwas mit den Daten ;-) 
                
                usernames[i] = new Schueler(data[1],data[0],data[2]);
                i++;
            }
            scanner.close();
            // todo
        }
        catch (Exception e)
        {
            System.out.print(e);
        }
        return usernames;
    }
      
    public static List<User> csv2UserList(String filepath)	{
        // Lege List an...
        List<User> usernames = new List<>(); // PROBLEM: was ist wenn die CSV-Datei andere Zeilen hat
        try
        {
            // lese Zeilenweise CSV-Datei ein
            Scanner scanner = new Scanner(new File(filepath));
            Scanner dataScanner = null;	//Objekt zum lesen eines Datensatzes
            // solange es einen nächste Zeile mit Text gibt, führe Schleife aus
            int i = 0;
            while(scanner.hasNext()==true)	{
                dataScanner = new Scanner(scanner.nextLine());	//nehme nächste Zeile in Objekt
                dataScanner.useDelimiter(";");	// Trennungszeichen zwischen Daten 
                // lege Array an der Größe 3 an.... 
                String data[] = new String[3];
                // speichere ersten Wert an Stelle 0
                data[0] = dataScanner.next();
                // speichere zweiten Wert an Stelle 1
                data[1] = dataScanner.next();
                // speichere zweiten Wert an Stelle 2
                data[2] = dataScanner.next();
                // Todo: Mache etwas mit den Daten ;-) 
                usernames.append(new Schueler(data[1], data[0], data[2]));
                i++;
            }
            scanner.close();
            // todo
        }
        catch (Exception e)
        {
            System.out.print(e);
        }
        return usernames;
    }

	public static Queue<User> csv2UserQueue(String filepath)	{
			// Lege Queue an...
			Queue<User> usernames = new Queue<>(); 
			
			try
			{
				// lese Zeilenweise CSV-Datei ein
				Scanner scanner = new Scanner(new File(filepath));
				Scanner dataScanner = null;	//Objekt zum lesen eines Datensatzes
				// solange es einen nächste Zeile mit Text gibt, führe Schleife aus
				int i = 0;
				while(scanner.hasNext()==true)	{
					dataScanner = new Scanner(scanner.nextLine());	//nehme nächste Zeile in Objekt
					dataScanner.useDelimiter(";");	// Trennungszeichen zwischen Daten 
					// lege Array an der Größe 3 an.... 
					String data[] = new String[3];
					// speichere ersten Wert an Stelle 0
					data[0] = dataScanner.next();
					// speichere zweiten Wert an Stelle 1
					data[1] = dataScanner.next();
					// speichere zweiten Wert an Stelle 2
					data[2] = dataScanner.next();
					// Todo: Mache etwas mit den Daten ;-) 
					usernames.enqueue(new Schueler(data[1], data[0], data[2]));
					i++;
				}
				scanner.close();
				// todo
			}
			catch (Exception e)
			{
				System.out.print(e);
			}
			return usernames;
		}

	public static Stack<User> csv2UserStack(String filepath)	{
		// Lege neuen Stack an an...
			Stack<User> usernames = new Stack<>(); 
			
			try
			{
				// lese Zeilenweise CSV-Datei ein
				Scanner scanner = new Scanner(new File(filepath));
				Scanner dataScanner = null;	//Objekt zum lesen eines Datensatzes
				// solange es einen nächste Zeile mit Text gibt, führe Schleife aus
				int i = 0;
				while(scanner.hasNext()==true)	{
					dataScanner = new Scanner(scanner.nextLine());	//nehme nächste Zeile in Objekt
					dataScanner.useDelimiter(";");	// Trennungszeichen zwischen Daten 
					// lege Array an der Größe 3 an.... 
					String data[] = new String[3];
					// speichere ersten Wert an Stelle 0
					data[0] = dataScanner.next();
					// speichere zweiten Wert an Stelle 1
					data[1] = dataScanner.next();
					// speichere zweiten Wert an Stelle 2
					data[2] = dataScanner.next();
					// Todo: Mache etwas mit den Daten ;-) 
					usernames.push(new Schueler(data[1], data[0], data[2]));
					i++;
				}
				scanner.close();
				// todo
			}
			catch (Exception e)
			{
				System.out.print(e);
			}
			return usernames;
		}

	
}
