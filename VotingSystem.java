public abstract class VotingSystem implements VoteInfo {
    private static int totalCount = 0;

    @Override
    public abstract boolean validateUser();

    @Override
    public int totalVoteCount() {
        return totalCount;
    }

    public static void incrementTotalCount() {
        totalCount++;
    }

    private String firstName;
    private String lastName;

    public VotingSystem() {}

    public VotingSystem(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        incrementTotalCount(); // Increment total count when a new voter or candidate is created
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
