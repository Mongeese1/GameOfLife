class BadFileFormatException extends Exception{//class to throw an error if trying to read non txt
    /**
	 * 
	 */
	private static final long serialVersionUID = -6224208101317037549L;
	private final String message;

    public BadFileFormatException(final String problem) {
        this.message = problem;
    } 

    @Override
    public String toString() 
    {
        return "BadFileFormatException: " + message;
    }
}