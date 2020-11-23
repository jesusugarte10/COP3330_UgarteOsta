
public class TaskItem {

    private String title;
    private String description;
    private String date;
    private String complete;

	public TaskItem(String title, String description, String date, String complete) {

        this.complete = complete;

        if(isStringValid(title)){
            this.title = title;
            this.description = description;
        } else {
            throw new IllegalArgumentException("Warning: Title must be at least 1 char long");
        }

        if(isdateValid(date)){
            this.date = date;
        } 
        else{ 
            throw new IllegalArgumentException("Warning: Invalid Date");
        }
    }
    
    private boolean isStringValid(String str){
        return str.length() > 0;
    }

    private boolean isdateValid(String str){
        String datePattern = "\\d{4}-\\d{1,2}-\\d{1,2}";
            return str.matches(datePattern);
    }
    public String getComplete(){
        return this.complete;
    }

    public String getTitle(){
        return this.title;
    }
    public String getDescription(){
        return this.description;
    }
    public String getDate(){
        return this.date;
    }

    public String toString(){
        return complete + " " + title + " " + description + " " + date;
    }
}
