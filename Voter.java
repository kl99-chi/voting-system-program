public class Voter extends VotingSystem {
    private String address;
    private String city;
    private int age;

    private String pollNumber;
    private String idNumber;
    private String gender;

    public Voter(String firstName, String lastName, String idNumber, String gender, int age, String address, String city, String pollNumber) {
        super(firstName, lastName);
        this.idNumber = idNumber;
        this.gender = gender;
        this.age = age;
        this.address = address;
        this.city = city;
        this.pollNumber = pollNumber;
    }

    @Override
    public String toString() {
        return "";
    }

    @Override
    public boolean validateUser() {
        boolean isValid;
        if(age >= 18){
            isValid = true;
        }
        else{
            isValid = false;
        }
        return  isValid;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }
    
    public String getPollNumber() {
        return pollNumber;
    }

    // Method to generate a poll number using the first letter of the first name and last name, and three random numbers
    public void setPollNumber(String pollNumber) {
        this.pollNumber = pollNumber;
    }

    @Override
    public int totalVoteCount() {
        return super.totalVoteCount(); // Returns the total count from the abstract class
    }
    private boolean voted = false;

    public boolean castVote() {
        if (!voted) {
            voted = true;
            return true; // User can vote
        } else {
            return false; // User has already voted
        }
    }
}