import javax.swing.JOptionPane;
import java.io.*;
import java.util.Random;
import java.util.ArrayList;

public class ElectionTest {

    public static void main(String[] args) {
        // Check if user is registered
        boolean registered = false;
        while (!registered) {
            String registeredUser = JOptionPane.showInputDialog(null, "Are you a registered user? (yes/no)").trim().toLowerCase();

            if (registeredUser.equals("yes")) {
                if (login()) {
                    registered = true;
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password. Please try again.");
                }
            } else if (registeredUser.equals("no")) {
                register();
            } else {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter 'yes' or 'no'.");
            }
        }

        // Proceed with voting process
        JOptionPane.showMessageDialog(null, "*******You are now logged in********");

        // Prompt user to enter voter information
        JOptionPane.showMessageDialog(null, "Please enter your Information to be registerd to vote:");
        String firstName = JOptionPane.showInputDialog("First Name:");
        String lastName = JOptionPane.showInputDialog("Last Name:");
        String idNumber = JOptionPane.showInputDialog("ID Number:");
        String gender = JOptionPane.showInputDialog("Gender:");
        int age = Integer.parseInt(JOptionPane.showInputDialog("Age:"));
        String address = JOptionPane.showInputDialog("Address:");
        String city = JOptionPane.showInputDialog("City:");

        Random rand = new Random();
        int randomNumber = rand.nextInt(1000); // Generate a random 3-digit number
        String pollNumber = Character.toUpperCase(firstName.charAt(0)) + "" + Character.toUpperCase(lastName.charAt(0)) + String.format("%03d", randomNumber);

        // Create Voter object with user-entered information
        Voter voter = new Voter(firstName, lastName, idNumber, gender, age, address, city, pollNumber);

        FileHandler fileWriter = new FileHandler();
        String fileName = "voters.txt";
        fileWriter.writeVoterInfo(fileName, voter);

        JOptionPane.showMessageDialog(null, "Voter:" + firstName + " " + lastName
                + "\nPoll number: " + pollNumber
                + "\nYour details have been captured and are now eligable to vote");

        // Display parties participating in the elections
        JOptionPane.showMessageDialog(null, "Parties Participating in the Elections:\n" + readPartiesFromFile("parties.txt"));

        // Allow the user to vote for a party
        int partyIndex = Integer.parseInt(JOptionPane.showInputDialog("Enter the index of the party you want to vote for:"));
        castVote(voter, partyIndex);
        
        // Display the party with the most votes and the total number of voters
        displayResults("parties.txt");
    }

    private static ArrayList<String> readPartiesFromFile(String fileName) {
        ArrayList<String> parties = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                parties.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return parties;
    }

    private static void displayResults(String fileName) {
        ArrayList<String> parties = readPartiesFromFile(fileName);
        int maxVotes = 0;
        String winningParty = "";
        for (String party : parties) {
            String[] partyInfo = party.split(",");
            int votes = Integer.parseInt(partyInfo[1].trim());
            if (votes > maxVotes) {
                maxVotes = votes;
                winningParty = partyInfo[0];
            }
        }
        JOptionPane.showMessageDialog(null, "Leading Party with the Most Votes is " + winningParty + " with " + maxVotes);
    }

    private static void castVote(Voter voter, int partyIndex) {
        if (voter.castVote()) {
            updateVoteCount("parties.txt", partyIndex - 1);
            JOptionPane.showMessageDialog(null, "Thank you for voting. Your vote has been counted.");
        } else {
            JOptionPane.showMessageDialog(null, "You have already cast your vote.");
        }
    }

    private static boolean login() {
        String username = JOptionPane.showInputDialog("Enter username:");
        String password = JOptionPane.showInputDialog("Enter password:");

        try (BufferedReader br = new BufferedReader(new FileReader("credentials.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2 && parts[0].equals(username) && parts[1].equals(password)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    private static void register() {
        String username = JOptionPane.showInputDialog("Create username:");
        String password = JOptionPane.showInputDialog("Create password:");

        boolean validAge = false;
        boolean validCitizenship = false;
        while (!validAge || !validCitizenship) {
            String ageResponse = JOptionPane.showInputDialog("Are you 18 years old or above? (yes/no)").trim().toLowerCase();
            String citizenshipResponse = JOptionPane.showInputDialog("Are you a South African citizen? (yes/no)").trim().toLowerCase();
            if (ageResponse.equals("yes")) {
                validAge = true;
            }
            if (citizenshipResponse.equals("yes")) {
                validCitizenship = true;
            }
            if (!validAge || !validCitizenship) {
                JOptionPane.showMessageDialog(null, "You are not eligible to vote. You must be 18 years and older and a South African citizen to be eligable to vote.");
            }
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("credentials.txt", true))) {
            writer.write(username + "," + password + "\n");
            JOptionPane.showMessageDialog(null, "Account created successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void updateVoteCount(String fileName, int partyIndex) {
        ArrayList<String> parties = readPartiesFromFile(fileName);
        String[] partyInfo = parties.get(partyIndex).split(",");
        int currentVotes = Integer.parseInt(partyInfo[1].trim());
        partyInfo[1] = String.valueOf(currentVotes + 1); // Increment vote count
        parties.set(partyIndex, String.join(",", partyInfo));
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (String party : parties) {
                writer.write(party + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}