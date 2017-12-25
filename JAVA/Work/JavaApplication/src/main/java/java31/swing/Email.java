package java31.swing;

public class Email {

    private String name = "";
    private String job = "";
    private String id = "";
    private String email = "";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Email(String name, String job, String id, String email) {
        super();
        this.name = name;
        this.job = job;
        this.id = id;
        this.email = email;
    }

    public Email() {
        super();
    }

    @Override
    public String toString() {
        return "Email [name=" + name + ", job=" + job + ", id=" + id + ", email=" + email + "]";
    }
}
