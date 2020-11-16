import java.io.File;
import java.io.IOException;
import java.nio.file.*;;

public class TaskList {

    private String Data;
    private int size;

    public TaskList(String Data) {
        this.Data = Data;
    }

    public void viewList() {
        if (this.Data != null)
            System.out.print(this.Data);
    }

    public String editList(int placeToedit, String editTitle, String editDescription, String editDate) {

        String[] lines = this.Data.split("\\n");

        if(validateLenght(placeToedit + 1) && !Emptydata())
            lines[placeToedit + 1] = (placeToedit + ")" + "[" + editDate + "] " + editTitle + ": " + editDescription);

        return toString(lines);
    }

    public String uncomplete(int placeToUncomplete) {

        String[] lines = this.Data.split("\\n");
        if(validateLenght(placeToUncomplete + 1) && !Emptydata())
        { 
            if (lines[placeToUncomplete + 1].contains("***"))
                lines[placeToUncomplete + 1] = lines[placeToUncomplete + 1].substring(3);
            else
                System.out.println("WARNING: UNABLE TO MARK AS NOT COMPLETE");
        }
        return toString(lines);
    }

    public String complete(int placeToComplete) {

        String[] lines = this.Data.split("\\n");

        if(validateLenght(placeToComplete + 1) && !Emptydata())
        { 
            if (!lines[placeToComplete + 1].contains("***") && validateLenght(placeToComplete))
                lines[placeToComplete + 1] = ("***" + lines[placeToComplete + 1]);
            else
                System.out.println("WARNING: UNABLE TO MARK AS COMPLETE");
        }
        return toString(lines);
    }

    public String delete(int placeToDelete) {

        String[] lines = this.Data.split("\\n");

        if(validateLenght(placeToDelete + 1) && !Emptydata())
            lines[placeToDelete + 1] = "";

        this.size = getListSize(placeToDelete + 1);

        return toString(lines);
    }

    private String toString(String[] lines) {

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < lines.length; i++) {

            if (i == 0) {
                sb.append(lines[i]);
                i++;
            }
            sb.append("\n" + lines[i]);
        }
        return sb.toString();
    }

    public String LoadFile(String fileName) throws IOException
    {
        File f = new File(fileName);
        String String = new String();

        if((fileName.endsWith(".txt") && f.exists()))
            try {
                String = new String(Files.readAllBytes(Paths.get(fileName)));
                System.out.print("\ntask list has been loaded");
                
            } catch (Exception e) {
                System.out.print("\nWARNING: INVALID INPUT");
                String = null;
        }
        
        return String;
    }

    public boolean validateLenght(int value) {

        int size = 0;

        for(int i=0; i < this.Data.length(); i++) {
            if (this.Data.charAt(i) == '\n')
                size = size+ 1;
        }

        if(size >= value)
            return true;

        else
            System.out.println("WARNING: INDEX OUT OF BOUNDS");
        return false;
    }

    public boolean Emptydata() {

        if(this.Data.isEmpty())
        {
            System.out.println("WARNING: DATA IS EMPTY");
            return true;
        }

        return false;
    }

    public int getListSize(int deletingPlace) {
        for(int i=0; i < this.Data.length();i++)
        {   
            if(this.Data.charAt(i) == '\n')
                this.size = this.size+ 1;
        }
		return this.size - deletingPlace;
	}
}
