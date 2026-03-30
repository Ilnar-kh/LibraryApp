package model;

public class User {
    private Long id;
    private String name;
    private String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public User(Long id, String name, String foundEmail) {
        this.id = id;
        this.name = name;
        this.email = foundEmail;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

}
