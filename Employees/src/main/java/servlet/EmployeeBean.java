package servlet;

/**
 * Created by Vaio on 18.04.2017.
 */
public class EmployeeBean {

    EmployeeBean(int emp_id, String name, String city , String job) {
        this.emp_id=emp_id;
        this.name=name;
        this.city=city;
        this.job=job;
    }

    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {this.name = name;}

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getJob() { return job;}

    public void setJob(String job) { this.job = job;}

    private int emp_id;
    private String name;
    private String city;
    private String job;
}
