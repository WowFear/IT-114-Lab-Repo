public class Contact {
    //TODO: Create fields
    private String name;
    private String email;
    private String phone;
    
    //Create constructor

     public Contact(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
     }
    
    //Add getters and setters
    //Getters
    public String getName()  { return name; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }

    //Setters 
    public void setName(String name)   { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    public void setPhone(String phone) { this.phone = phone; }

    
    //TODO: Return formatted string.
    public String toString() {
    return String.format("Name: %-15s | Email: %-20s | Phone: %s", name, email, phone);
    }
}
