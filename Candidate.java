public class Candidate extends VotingSystem {
    private String partyName;
    private int votesCount;

    public Candidate(String firstName, String lastName, String partyName, int votesCount) {
        super(firstName, lastName);
        this.partyName = partyName;
        this.votesCount = votesCount;
    }

    public String getPartyName() {
        return partyName;
    }

    public int getVotesCount() {
        return votesCount;
    }
    
    public void setVotesCount(int votesCount) {
        this.votesCount = votesCount;
    }

    @Override
    public String toString() {
        return String.format("%-10s   %-10s    %-10s  %-10d", getFirstName(), getLastName(), partyName, votesCount);
    }

    @Override
    public boolean validateUser() {
        return false;
    }

    @Override
    public int totalVoteCount() {
        return super.totalVoteCount(); // Returns the total count from the abstract class
    }
}