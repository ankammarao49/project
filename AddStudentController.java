package controllers;

import java.io.IOException;

import dao.EmployeeDAO;
import dao.EmployeeDAOImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.Employee;

@WebServlet("/add-employee")
public class AddStudentController extends HttpServlet {
    EmployeeDAO employeeDAO = new EmployeeDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/add-employee.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Employee student = new Employee();
        HttpSession session = req.getSession();

        student.setName(req.getParameter("name"));
        student.setPhone(req.getParameter("phone"));
        student.setEmail(req.getParameter("email"));
        student.setAddress(req.getParameter("address"));
        student.setPassword(req.getParameter("password"));

        int result = employeeDAO.addEmployee(student);
        System.out.println(result);

        if (result == 1) {
            session.setAttribute("add", true);
            resp.sendRedirect("all-employees");
        } else {
            session.setAttribute("add", false);
            resp.sendRedirect("add-employee");
        }
    }
}
