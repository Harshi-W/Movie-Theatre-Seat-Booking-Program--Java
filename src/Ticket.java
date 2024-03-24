
public class Ticket  {
    public  int row;
    public  int seat;
    public  double price;
    public  Person person;//object created using the class Person.
    public Ticket(int rowNum,int seatNum,double price,Person person){
        this.row = rowNum;
        this.seat = seatNum;
        this.price = price;
        this.person=person;

    }

    public double getPrice() {

        return price;
    }
    public int getRow(){

        return row;
    }
    public int getSeat(){

        return seat;
    }

    //prints all the information from a ticket.
    public  void  Print(){

        System.out.println("-------Ticket-------");
        System.out.println("Person name: " + person.name);
        System.out.println("Person surname: " + person.surname);
        System.out.println("Person email: " + person.email);
        System.out.println("Row: " + row);
        System.out.println("Seat: " + seat);
        System.out.println("Price: " + price);

    }
}




