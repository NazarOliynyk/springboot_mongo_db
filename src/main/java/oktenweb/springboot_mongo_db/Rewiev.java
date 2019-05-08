package oktenweb.springboot_mongo_db;

public class Rewiev {
    private String userName;
    private int rating;
    private boolean approved;

    public Rewiev(String userName, int rating, boolean approved) {
        this.userName = userName;
        this.rating = rating;
        this.approved = approved;
    }

    public Rewiev() {}

    public String getUserName() {
        return userName;
    }

    public int getRating() {
        return rating;
    }

    public boolean isApproved() {
        return approved;
    }
}
