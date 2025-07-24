
import java.io.*;

public class FileHandler{
    public void writeVoterInfo(String fileName, Voter voter) {
        try{
            FileWriter writer = new FileWriter(fileName, true);
            writer.write(voter.getFirstName() + "," + voter.getLastName() + "," + voter.getIdNumber() + "," + voter.getGender() + "," + voter.getPollNumber() + "\n");
            writer.close();
            System.out.println("Registered voter: " + voter.getFirstName());
        } catch (IOException err) {
            err.printStackTrace();
        }
    }
}