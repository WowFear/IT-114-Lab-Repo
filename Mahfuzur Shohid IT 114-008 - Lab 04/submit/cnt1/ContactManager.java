import java.util.ArrayList;
import java.util.Scanner;

public class ContactManager {

    // --- TODO: REGEX HELPER METHOD ---
    public static String formatPhoneNumber(String raw) {
        // 1. Strip non-digits   
        String onlyDigits = raw.replaceAll("[^0-9]", "");
        
        //From what I can tell, we want to just take out the extra info, spaces, and other things, and only have the numbers. We use the ^ to filter within the list of 0-9 
        //I had to search up for what raw meant but its just the unfiltered numbers, pretty sure

        // 2. Check length and format
            // Regex to group: (3 digits)(3 digits)(4 digits) -> $1-$2-$3
        if (onlyDigits.length() == 10){ //The size of a phone nummber 
            return onlyDigits.replaceAll("(\\d{3})(\\d{3})(\\d{4})", "$1-$2-$3");
        }
        //Honestly, I had to ask some AI to help with the formating of the digitis... Wasn't sure how to do it
        //I do understand it does, we want to validate the number we just filtered for it to be the right formating for a US number. We use ther 1 2 and 3 to fit them into their own sections with the groups of 3, 3, and 4 which makes sense. 

        
       //If not valid format, return invalid number
        return "Invalid Number";
    }

    
    public static void main(String[] args) {
        ArrayList<Contact> contacts = new ArrayList<>();

        // Contacts to be sanitized and sorted
        contacts.add(new Contact("Zack Morris", "zack@bayside.edu", "555.123.4567"));
        contacts.add(new Contact("Alice Smith", "alice@test.com", "(555) 999-8888"));
        contacts.add(new Contact("Bob Jones", "bob@test.com", "5551112222"));

        System.out.println("--- Cleaning Data ---");
       
        //TODO: CLEAN DATA (Loop and Format)
        for (Contact c : contacts){
            c.setPhone(formatPhoneNumber(c.getPhone()));
        }
        //We would use the method we just made, the one kinda just orginizing the muble jumble numbers to workable phone numbers, to now grabing those muble numbers from our contact array 
        //To format it and then just setting the new one in replacement of the old one. 
        //This is done in a for loops we can do that for allll the numbers. 
        
        
        System.out.println("--- Sorting Data ---");
        
        //TODO: SORT DATA (Bubble Sort)
        int n = contacts.size();
            for(int i = 0; i < n - 1; i++){
                for(int k = 0; k < n - 1 - i; k++){
                    String nameA = contacts.get(k).getName();
                    String nameB = contacts.get(k+1).getName();
                
                    if (nameA.compareTo(nameB) > 0) {
                        Contact temp = contacts.get(k);
                        contacts.set(k, contacts.get(k + 1));
                        contacts.set(k + 1, temp);
                    }
                }
            }
        
        //Had some trouble with this one as well ngl, but I think I kinda understand the bubble sort
        //We want to use the contact size, which is 3, just for ease of not calling the size function over and over again
        //Our first loop just counts the total loops, we use the n-1 for when every pass goes through and has sorted it self to the right spot
        //That next loop is just for the individual comparrisons, where every time the right contact is sorted, the overall size of the list shrinks. We wouldnt have to look back for the correct contacts, which is why the size of it decreases. 
        //The compare function just comapres the strings in terms of alphebetically, where if we return a number larger than 0, that means we know that the contacts are not in order.

        
        // Print sorted list
        for (Contact c : contacts) {
            System.out.println(c);
        }

        //Input name to search for
        System.out.println("\n--- Search ---");
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a name to find: ");
        String searchName = scan.nextLine();
        
        boolean found = false;
        
        //TODO: Search Data for name inputted
        
        for (Contact c : contacts) {
            if (c.getName().equalsIgnoreCase(searchName)) {
                System.out.println("Found: " + c);
                found = true;
                break;
    }   
}
        //So we would get the name, ignoring any of the casings, uper or lower, from whatever the user typed in.
        //The last bit is just either, we found the match, we make the found statment true, which breaks the loop since we dont need to continue to look.

        
        if (!found) { //Print not found if name is misspelled or not in list
            System.out.println("Contact not found.");
        }
    }
}
    //If we couldnt find it within our list, then found is not true and fits this criteria