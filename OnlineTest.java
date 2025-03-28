import java.util.*;

class Account {
    String user;
    String pass;
    String details;
    
    Account(String user, String pass, String details) {
        this.user = user;
        this.pass = pass;
        this.details = details;
    }
    
    boolean signIn(String u, String p) {
        return user.equals(u) && pass.equals(p);
    }
    
    void modifyProfile(String newDetails) {
        this.details = newDetails;
        System.out.println("Profile updated.");
    }
    
    void modifyPassword(String newPass) {
        this.pass = newPass;
        System.out.println("Password changed.");
    }
}

class Quiz {
    private Map<String, String> qs;
    private Map<String, String> ua;
    private int time;
    
    Quiz() {
        qs = new HashMap<>();
        ua = new HashMap<>();
        qs.put("Capital of USA?", "Washington");
        qs.put("Largest ocean?", "Pacific");
        qs.put("Speed of light in vacuum?", "299792458 m/s");
        time = 30;
    }
    
    void begin() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Quiz started! Time: " + time + " seconds.");
        for (String q : qs.keySet()) {
            System.out.println(q);
            System.out.print("Answer: ");
            String ans = sc.nextLine();
            ua.put(q, ans);
        }
        submit();
    }
    
    void submit() {
        System.out.println("Submitting answers...");
        int score = 0;
        for (String q : qs.keySet()) {
            if (qs.get(q).equalsIgnoreCase(ua.get(q))) {
                score++;
            }
        }
        System.out.println("Score: " + score + "/" + qs.size());
    }
}

public class OnlineTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Account acc = new Account("admin", "1234", "Student");
        
        System.out.print("Username: ");
        String u = sc.nextLine();
        System.out.print("Password: ");
        String p = sc.nextLine();
        
        if (acc.signIn(u, p)) {
            System.out.println("Login successful!");
            Quiz qz = new Quiz();
            qz.begin();
            
            System.out.print("Update profile? (yes/no): ");
            if (sc.nextLine().equalsIgnoreCase("yes")) {
                System.out.print("New profile: ");
                acc.modifyProfile(sc.nextLine());
            }
            
            System.out.print("Change password? (yes/no): ");
            if (sc.nextLine().equalsIgnoreCase("yes")) {
                System.out.print("New password: ");
                acc.modifyPassword(sc.nextLine());
            }
            
            System.out.println("Logging out...");
        } else {
            System.out.println("Invalid credentials!");
        }
        sc.close();
    }
}