/**
 * Pra2003
 * @author mongeese1
 * i6222534
 * 
 * untested */
public class Rules_B2_S implements Rules{//attempt implemation of chatoic seeds rules where dead cells
	//with 2 neighbors turn on and all cells die each iteration

	@Override
	public String name() {
		// TODO Auto-generated method stub
		return "B2/S";
	}

	@Override
	public int result(int age, int nbors) {
		if(age==0 && nbors ==2) {
			return 1;	
		}
		return 0;
		
	}

}
