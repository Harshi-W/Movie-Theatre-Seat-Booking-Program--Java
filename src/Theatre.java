import java.io.*;
import java.util.*;
public class Theatre{
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int[] Row_1 = new int[12];
        int[] Row_2 = new int[16];
        int[] Row_3 = new int[20];
        int[][] SeatingArea = {Row_1,Row_2,Row_3};

        boolean quit = false;
        System.out.println("Welcome to the New Theatre" );
        while (!quit) {
        System.out.println("------------------------------------------------");
        System.out.println("Please select an option:");
        System.out.println("1) Buy a ticket");
        System.out.println("2) Print seating area ");
        System.out.println("3) Cancel ticket");
        System.out.println("4) List available seats");
        System.out.println("5) Save to file ");
        System.out.println("6) Load from file ");
        System.out.println("7) Print ticket information and total price ");
        System.out.println("8) Sort tickets by price ");
        System.out.println("0) Quit ");
        System.out.println("------------------------------------------------");
        System.out.print("Enter option: ");
        int option;
        try {
            option = Integer.parseInt(input.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number between 0 and 8.");
            continue;
        }
        switch (option) {
            case 0:
                quit=true;
                break;
            case 1:
                buy_ticket(Row_1, Row_2, Row_3);
                break;
            case 2:
                print_seating_area(Row_1, Row_2, Row_3);
                break;
            case 3:
                cancel_ticket(Row_1, Row_2, Row_3);
                break;
            case 4:
                show_available(SeatingArea);
                break;
            case 5:
                Save(SeatingArea);
                break;
            case 6:
                load();
                break;
            case 7:
                show_tickets_info(Tickets);
                break;
            case 8:
                sort_tickets();
                break;
            default:
                System.out.println("Incorrect option.");
                break;
            }
        }
    }
    //input validator to avoid repetition when taking inputs.
    public static int inputValidator(String prompt,int min , int max){
        Scanner input = new Scanner(System.in);
        int data;
        while (true){
            try {
                System.out.print(prompt);
                data =input.nextInt();
                if (min<=data && data<=max){
                    return data;
                }else {
                    System.out.println("Please enter a number between "+min+" and "+max);
                }
            }catch (InputMismatchException e){
                input.nextLine();
                System.out.println("Enter a valid Integer");
            }
        }
    }

    public static  String userDetails(String prompt){
        String data=null ;
        Scanner input = new Scanner(System.in);
        System.out.print(prompt);
        data=input.nextLine();
        return data;
    }
    static ArrayList<Ticket> Tickets = new ArrayList<>();
    // an array list of tickets to save all the Tickets.
    public static void buy_ticket(int[] row1, int[] row2, int[] row3) {

        String name, surname, email;
        int seatNum, rowNum;
        boolean continueSeatBooking = true;
        while (continueSeatBooking) {
            rowNum = inputValidator("Enter the row number:", 1, 3);

            if (rowNum == 1) {
                seatNum = inputValidator("Enter the seat number:", 1, 12);
                if (row1[seatNum - 1] == 0) {
                    row1[seatNum - 1] = 1;//Record the seat as occupied.
                    name = userDetails("Enter your name:");
                    surname = userDetails("Enter your surname:");
                    email = userDetails("Enter your Email:");
                    double price= 500.00;
                    Person person = new Person(name, surname, email);
                   Ticket ticket  = new Ticket(rowNum, seatNum, price, person);
                    Tickets.add(ticket);//add the ticket in the new array list of tickets.
                    System.out.println("Seat booked successfully!");

                } else {
                    System.out.println("Seat is not available");
                }
            } else if (rowNum == 2) {
                seatNum = inputValidator("Enter the seat number:", 1, 16);

                if (row2[seatNum - 1] == 0) {
                    row2[seatNum - 1] = 1;//Record the seat as occupied.
                    name = userDetails("Enter your name:");
                    surname = userDetails("Enter your surname:");
                    email = userDetails("Enter your Email:");
                    double price= 600.00;
                    Person person = new Person(name, surname, email);
                    Ticket ticket = new Ticket(rowNum, seatNum, price, person);
                    Tickets.add(ticket);//add the ticket in the new array list of tickets.
                    System.out.println("Seat booked successfully!");

                } else {
                    System.out.println("Seat is not available");
                }
            } else {
                seatNum = inputValidator("Enter the seat number:", 1, 20);

                if (row3[seatNum - 1] == 0) {
                    row3[seatNum - 1] = 1;//Record the seat as occupied.
                    name = userDetails("Enter your name:");
                    surname = userDetails("Enter your surname:");
                    email = userDetails("Enter your Email:");
                    double price= 800.00;
                    Person person = new Person(name, surname, email);
                    Ticket ticket = new Ticket(rowNum, seatNum, price, person);
                    Tickets.add(ticket);//add the ticket in the new array list of tickets.
                    System.out.println("Seat booked successfully!");

                } else {
                    System.out.println("Seat is not available");
                }
            }
            while (true){
            int input2;
            while (true) {
                try {
                    Scanner input = new Scanner(System.in);
                    System.out.println("Do you want to buy more tickets?\n 01)yes\n 02)No");
                    input2 = Integer.parseInt(input.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter 1 0r 2...");
                }
            }
            if (input2 == 1) {
                continueSeatBooking = true;
                break;
            } else if(input2 == 2){
                continueSeatBooking = false;
                break;
            }else{
                System.out.println("Invalid integer.");
            }
            }
        }
    }

    public static void print_seating_area(int[] x, int[] y, int[] z) {
        System.out.println("    *********** \n" +
                "    *  STAGE  * \n" +
                "    *********** ");
        System.out.print("    ");
        for (int i = 0; i < x.length; i++) {
            if (i==6){
                System.out.print(" ");
            }
            if (x[i]==0) {
                System.out.print("O");
            }else{
                System.out.print("X");
            }
        }
        System.out.println("");
        System.out.print("  ");
        for (int i = 0; i < y.length; i++) {
            if (i==8){
                System.out.print(" ");
            }
            if (y[i]==0) {
                System.out.print("O");
            }else{
                System.out.print("X");
            }
        }
        System.out.println("");
        for (int i = 0; i < z.length; i++) {
            if (i==10){
                System.out.print(" ");
            }
            if (z[i]==0) {
                System.out.print("O");
            }else{
                System.out.print("X");
            }
        }
        System.out.println("");
    }

    public static void cancel_ticket(int[] row1,int[] row2,int[] row3) {

        int seatNumToCancel, rowNumToCancel;
        rowNumToCancel = inputValidator("Enter the row number:", 1, 3);
        seatNumToCancel = inputValidator("Enter the seat number to cancel:", 1, 20);

        if (rowNumToCancel == 1) {
            if (row1[seatNumToCancel - 1] == 1) {
                row1[seatNumToCancel - 1] = 0;//makes a seat available again.
                for (int i = 0; i < Tickets.size(); i++) {
                    Ticket ticket = Tickets.get(i);
                    if (ticket.getRow() == rowNumToCancel && ticket.getSeat() == seatNumToCancel) {
                        Tickets.remove(i);//remove the ticket from the array list of tickets.
                        System.out.println("Ticket cancelled successfully!");
                    }
                }
            }else {
                System.out.println("Seat is available to book");
            }
        } else if (rowNumToCancel == 2) {
            if (row2[seatNumToCancel - 1] == 1) {
                row2[seatNumToCancel - 1] = 0;//makes a seat available again.
                for (int i = 0; i < Tickets.size(); i++) {
                    Ticket ticket = Tickets.get(i);
                    if (ticket.getRow() == rowNumToCancel && ticket.getSeat() == seatNumToCancel) {
                        Tickets.remove(i);//remove the ticket from the array list of tickets.
                        System.out.println("Ticket cancelled successfully!");
                    }
                }
            }else {
                System.out.println("Seat is available to book");
            }
        } else {
            if (row3[seatNumToCancel - 1] == 1) {
                row3[seatNumToCancel - 1] = 0;//makes a seat available again.
                for (int i = 0; i < Tickets.size(); i++) {
                    Ticket ticket = Tickets.get(i);
                    if (ticket.getRow() == rowNumToCancel && ticket.getSeat() == seatNumToCancel) {
                        Tickets.remove(i);//remove the ticket from the array list of tickets.
                        System.out.println("Ticket cancelled successfully");
                    }
                }
            } else {
                System.out.println("Seat is available to book");
            }
        }
    }
    public static void show_available(int[][] SeatingArea){
        for(int s=0;s<SeatingArea.length;s++){

            System.out.print("Seats available in row "+(s+1)+": ");
            //loops through each row of the array and checks for seats with a value of 0.
            for(int i=0;i<SeatingArea[s].length;i++){
                if(SeatingArea[s][i]==0){
                    System.out.print(i+1+",");
                }
            }
            System.out.println();
        }
    }
    public static void Save(int[][] SeatingArea){

        File infoFile= new File("File.txt");
        try{
            if (infoFile.createNewFile()) {
                System.out.println("File created: " + infoFile.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        try{
            // saves the 3 arrays with the row’s information in a file.
            BufferedWriter writeArray= new BufferedWriter(new FileWriter("File.txt"));
            for (int i = 0; i < 3; i++) {
                writeArray.write(String.format("Row"+ (i+1)+"-"+ Arrays.toString(SeatingArea[i])));
                writeArray.newLine();
            }writeArray.close();
        }catch (IOException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public static void load(){
        File arrayFile= new File("File.txt");
        try{
            Scanner reader=new Scanner(arrayFile);
            while(reader.hasNextLine()){
                // loads the saved file and restores the 3 arrays with the row’s information.
                System.out.println(reader.nextLine());
            }
            reader.close();
        }catch(IOException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public static void  show_tickets_info(ArrayList<Ticket> Tickets) {
        int TotalPrice=0;
        // Loop through the ArrayList using the iterator
        for (Ticket ticket : Tickets) {
            TotalPrice += ticket.getPrice();
            ticket.Print();//prints all the information for all tickets.
        }
        System.out.println("Total price: Rs." + TotalPrice);
        System.out.println("------------------------------------");
    }
    public static void sort_tickets() {
        ArrayList<Ticket> sortedTickets = new ArrayList<>(Tickets);
        sortedTickets.sort(Comparator.comparingDouble(Ticket::getPrice));
        //returns a new list of Tickets sorted by Ticket price in ascending order.
        show_tickets_info(sortedTickets);
    }
}

