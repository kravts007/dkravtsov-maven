package homework_30;


import homework_30.DAO.StudentDAO;
import homework_30.DAO.StudentGroupDAO;
import homework_30.entity.Student;
import homework_30.entity.StudentGroup;

public class Main {
    public static final String SEPARATOR = "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";

    public static void main(String[] args) {
        StudentDAO studentDAO = new StudentDAO();
        StudentGroupDAO studentGroupDAO = new StudentGroupDAO();

        System.out.println(studentGroupDAO.getAll());
        System.out.println(SEPARATOR);

        StudentGroup group = new StudentGroup(null, "ТФ-1016", null);
        studentGroupDAO.saveOrUpdate(group);
        System.out.println(studentGroupDAO.getAll());
        System.out.println(SEPARATOR);

        System.out.println(studentDAO.getAll());
        System.out.println(SEPARATOR);

        Student student = new Student(null, "Ostapa Sergei Sergeich", studentGroupDAO.get(3), 2008);
        student = studentDAO.saveOrUpdate(student);
        System.out.println(studentDAO.getAll());
        System.out.println(SEPARATOR);

        Student student1 = new Student(18, "Ostapa Sergei Sergeich", studentGroupDAO.get(5), 2008);
        student = studentDAO.saveOrUpdate(student1);
        System.out.println(studentDAO.getAll());
        System.out.println(SEPARATOR);

        System.out.println(studentDAO.findByNameContaining("Koza4214124"));
        System.out.println(SEPARATOR);
    }
}
