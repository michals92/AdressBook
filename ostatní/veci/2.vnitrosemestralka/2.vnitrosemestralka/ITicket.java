public interface ITicket {

    /**
     * @return Id of this ticket
     */
    int getId();
    
    /**
     * Method counts how many ticket numbers are equal to numbers 
     * in the given parameter.
     * 
     * @param numbers Array of numbers I want to compare
     * @return number of ticket numbers matching given array parametr
     */
    int getMatch(int[] numbers);
    
}
