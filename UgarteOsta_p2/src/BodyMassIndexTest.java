import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class BodyMassIndexTest{

    @Test
    public void testingForGivenPositiveValuesOne(){

        BodyMassIndex bmi = new BodyMassIndex(69,200);
        double answer = bmi.getSum();

        assertEquals(29.531611006091158, answer);
    }

    @Test
    public void testingForGivenPositiveValuesTwo(){

        BodyMassIndex bmi = new BodyMassIndex(55,60);
        double answer = bmi.getSum();

        assertEquals(13.943801652892562, answer);
    }

    @Test
    public void testingForUnderWeight(){

        BodyMassIndex bmi = new BodyMassIndex(69,120);

        String answer = bmi.getCategory();

        assertEquals("->Underweight", answer);
        
    }

    @Test
    public void testingForNormalWeight(){

        BodyMassIndex bmi = new BodyMassIndex(69,150);

        String answer = bmi.getCategory();

        assertEquals("->Normal weight", answer);
        
    }

    @Test
    public void testingForOverWeight(){

        BodyMassIndex bmi = new BodyMassIndex(69,200);

        String answer = bmi.getCategory();

        assertEquals("->Overweight", answer);
        //This is my personal category, I have to workout more
        
    }

    @Test
    public void testingForObesity(){

        BodyMassIndex bmi = new BodyMassIndex(69,220);

        String answer = bmi.getCategory();

        assertEquals("->Obesity", answer);
        //This is Danger Zone!!!
    }
}