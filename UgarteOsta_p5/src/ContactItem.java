
public class ContactItem {

    private String name;
    private String lastName;
    private String phone;
    private String email;

    public ContactItem( String name, String lastName, String phone, String email){

        if(isStringValid(name) || isStringValid(lastName)){
            this.name = name;
            this.lastName = lastName;
        } else {
            throw new IllegalArgumentException("Warning: Please enter at least one name or Last Name");
        }

        if(isPhoneValid(phone) || isEmailValid(email)){
            this.phone = phone;
            this.email = email;
        } else {
            throw new IllegalArgumentException("Warning: Please enter at least one Phone or Email");
        }
    }

    public String toString(){
        return name + " " + lastName + " " + phone + " " + email ;
    }

    public String getName(){
        return this.name;
    }

    public String getLastName(){
        return this.lastName;
    }

    public String getPhone(){
        return this.phone;
    }

    public String getEmail(){
        return this.email;
    }

    private boolean isPhoneValid(String phone){
        String phonePattern = "\\d{3}-\\d{4}-\\D{4}";
        return phone.matches(phonePattern);
    }

    private boolean isEmailValid(String email){
        String emailPattern = "^([_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*(\\.[a-zA-Z]{1,6}))?$";
        return email.matches(emailPattern);
    }

    private boolean isStringValid(String name){
        return name.length() > 0;
    }
}