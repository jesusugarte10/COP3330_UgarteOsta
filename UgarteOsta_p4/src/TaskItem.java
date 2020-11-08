public class TaskItem {

    private String data;
    private String title;
    private String description;
    private String date;
    private int size;

    public TaskItem(String data, String title, String description, String date) throws IllegalAccessException 
    {
        this.data = data;
        this.title = title;
        this.description = description;
        this.date = date;
        Validate();
    }

	public String add() {
        
        if(!Validate())
            return this.data;

        this.data = (this.data + "\n" + getsize() + ")" +"["+ this.date + "] " + this.title + ": " + this.description);
		return this.data;
    }  

    public boolean Validate() 
    {
        
        String datePattern = "\\d{4}-\\d{1,2}-\\d{1,2}";

        if(this.title.length() < 1)
        {
            System.out.println("WARNING: title must be at least 1 character long; task not created");
            return false;
        }
        else if(this.description.length() <= 0)
        {
            System.out.println("WARNING: description must be at least 1 character long; task not created");
            return false;
        }    
        else if(!this.date.matches(datePattern))
        {
            System.out.println("WARNING: invalid due date; task not created");
            return false;
        }
        return true;
    }

	public int getsize() {

        for(int i=0; i < this.data.length();i++)
        {   
            if(this.data.charAt(i) == '\n')
                this.size = this.size+ 1;
        }
		return this.size;
	}

}

