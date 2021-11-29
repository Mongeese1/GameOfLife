/**
	 * Pra2003
	 * @author mongeese1
	 * i6222534
	 */
public interface Rules{
    public String name();
    /** 
     * @param age Number of iterations cell has been alive, reset to 0 when dead. 
     * @param nbors Number of live neighbors.
     * @return Result of applying these rules to a cell. 
     **/
    public int result(final int age, final int nbors);
}