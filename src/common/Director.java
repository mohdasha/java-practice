package common;

public class Director extends Employee {
    private String role;

    public Director(int empId, String name, int age) {
        super(empId, name, age);
        role = "Director";
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
