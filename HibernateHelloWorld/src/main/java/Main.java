import dto.Employee;
import org.hibernate.Session;

public class Main {

    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();
        Employee employee = new Employee();
        employee.setFirstName("Kaushik");
        employee.setLastName("Sekar");
        employee.setEmail("kaushik3993@gmail.com");

        session.save(employee);
        session.getTransaction().commit();

        int empId = employee.getId();
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Employee employee1 = session.load(Employee.class, empId);

        HibernateUtil.shutdown();
    }

}
