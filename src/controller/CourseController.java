/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import model.Course;

import dao.CourseDAO;
import java.util.List;
import model.Course;

/**
 *
 * @author LENOVO
 */
public class CourseController {
    private CourseDAO courseDAO = new CourseDAO();

    public int create(Course course) {
        return courseDAO.create(course);
    }
    
    public List<Course> getCourse() {
        return courseDAO.getAll();
    }
    public int update(Course course, String courseCode) {
        return courseDAO.update(course, courseCode);
    }

    public int delete(String courseCode) {
        return courseDAO.delate(courseCode);
    }
}