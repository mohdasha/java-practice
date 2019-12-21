package common;

public class Manager extends Employee {
    private String role;

    public Manager(int empId, String name, int age) {
        super(empId, name, age);
        role = "Manager";
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
