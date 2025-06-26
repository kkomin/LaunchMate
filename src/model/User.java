package model;

public class User {
    private final String name;
    private final String id;
    private final String pw;

    public User(String name, String id, String pw) {
        this.name = name;
        this.id = id;
        this.pw = pw;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getPw() {
        return pw;
    }
}
