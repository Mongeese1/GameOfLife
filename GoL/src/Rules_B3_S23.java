/**
	 * Pra2003
	 * @author mongeese1
	 * i6222534
	 */
public class Rules_B3_S23 implements Rules {
    @Override
    public String name(){
        return "B3/S23";
    }

    // The rules of the Class which tell what happens to each cell
    @Override
    public int result(final int age, final int nbors){
        if(age == 0 && nbors == 3){
            return 1; // A cell is born
        } else if (age != 0 && !(nbors == 2 || nbors == 3)){
            return 0; // The cell dies
        }
        return age;
    }
}