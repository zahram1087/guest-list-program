import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static String[] guests = new String[10]; //creating an array that holds 10 elements and making static so all methods can access
    static Scanner scanner = new Scanner(System.in);

    public static void main (String[] args){

        insertTestNames();


        do {
            displayGuestList();
            System.out.println(); //adding space btwn menue and guests
            displayMenue();

           int option = getOptions(); //method that allows you to pick an option

             if(option == 1){ //adding guest
                 addGuest();
            }
            else if(option == 2){ //removing guest
                 removeGuest();
            }
            else if(option == 3){
                renameGuest();
             }

             else if(option ==4){
                 addGuestToExistingPosition();
             }

            else if(option ==5){ //leaving the program
                System.out.println("Exiting...");
                break;
            }

        } while(true);


    }
     static void displayGuestList(){

        System.out.println("--Guests-- ");
        boolean isEmpty = true; //using this variable as a flag to tell me if the list is empty or not. initially setting it to true thus making the assumption it is empty
        for (int i = 0; i < guests.length; i++) {
            // turnary statement
            //condition ? a : b
            if(guests[i] != null) { //removing the nulls stored inside the space not used in the array (recall length is 10)
                System.out.println(((i + 1) + ". " + guests[i]));
                isEmpty = false; //when the if condition is met isTrue is now false
                //if the if statement never runs isEmpty remains true and thus the otherif statement runs

//                    if(guests[i] == null){
//                        System.out.println("--");
//                    }else {
//                        System.out.println(guests[i]);
//                    }
            }

        }
        if(isEmpty){
            System.out.println("THE GUEST LIST IS EMPTY");
        }

    }
    static void displayMenue(){
        System.out.println("--Menu--");
        System.out.println("1-Add Guest");
        System.out.println("2-Remove Guest");
        System.out.println("3-Rename Guest");
        System.out.println("4-Add New Guest To Existing Position");
        System.out.println("5-Exit");
    }
    static int getOptions(){
        System.out.println();//adding space between Menue and options
        System.out.print("Options: ");
        int option = scanner.nextInt();
        System.out.println(); //space between numGuests to add && Name To add
        return option;


    }
    static void addGuest(){
        int numGuest; //allowing for multi additions of guests
        System.out.println("Number of Guests to ADD: ");
        numGuest= scanner.nextInt();
        scanner.nextLine(); //required or the enter from numGuest is read as an inout to the first name to add. It consumes the enter or new line and then the nextLine coming with cature user input

        for(int i = 0; i < guests.length; i++){

            if (guests[i] == null && numGuest!=0) {
                System.out.print("Name To Add: ");
                String name = scanner.nextLine();
                guests[i] = name;
                numGuest--;

//                        break;
            }


        }
    }
    static void removeGuest() {

        System.out.print("Number to Remove: ");
        int num = scanner.nextInt();
        if (num >= 1 && num <= guests.length) {
            guests[num - 1] = null;

            //THIS WORKS
//        for(int i = 0; i<guests.length; i++){
//            if(i+1 == num){
//                guests[i] = null;
//                break;
//            }
//        }
            //THIS WORKS

            //THIS REMOVES BY STRING INPUT
//        System.out.print("Name To Remove: ");
//        String name = scanner.next();
//        for(int i = 0; i<guests.length-1; i++){
//            if(guests[i] != null && guests[i].equals(name)){
//                guests[i] = null;
//                break;
//
//            }
//
//        }
            //THIS REMOVES BY STRING INPUT
            String[] temp = new String[guests.length];
            int ti = 0; //temp index (ti);
            for (int i = 0; i < guests.length; i++) {
                if (guests[i] != null) {
                    temp[ti] = guests[i];
                    ti++;

                }
            }

            guests = temp; //reassighning guest as temp
        }
        else{

                System.out.println();
                System.out.println("Error: There is no guest with that number.");
                System.out.println();

        }



    }

    static void renameGuest(){
        System.out.println("Guest number: ");
        int guestNumToEdit = scanner.nextInt();
        scanner.nextLine();
        for(int i = 0; i<guests.length; i++) {
            if (guestNumToEdit == (i+1)){
                System.out.println("Name: ");
                String name = scanner.nextLine();
                guests[i] = name;
            }
        }
    }
    static void addGuestToExistingPosition(){
        System.out.println("What position number name is Replacing: ");
        int posNum = scanner.nextInt();
        scanner.nextLine();
        for(int i = 0 ; i<guests.length; i++){
            if((i+1)==posNum){
                for(int j = guests.length-1; j> posNum-1; j-- ){
                    guests[j] =  guests[j-1]; //shift ele an index back
                    // ie index 4 is set to index 5 etc.. 
                }
                System.out.println("Name: ");
                String name = scanner.nextLine();
                guests[i]= name;


            }
        }

    }
    static void insertTestNames(){
        guests[0] = "zahra";
        guests[1] = "habiba";
        guests[2] = "hannah";
        guests[3] = "big habiba";
        guests[4] = "mommy";
    }

}

