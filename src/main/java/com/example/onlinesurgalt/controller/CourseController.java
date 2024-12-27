package com.example.onlinesurgalt.controller;

import com.example.onlinesurgalt.model.Course;
import com.example.onlinesurgalt.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class CourseController {
    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    // List all courses
    @GetMapping("/courses")
    public String listCourses(Model model) {
        model.addAttribute("courses", courseService.getAllCourses());
        return "courses"; // Refers to "courses.html" in templates
    }

    // View course details
    @GetMapping("/courses/{id}")
    public String viewCourse(@PathVariable Long id, Model model) {
        Optional<Course> course = courseService.getCourseById(id);
        if (course.isPresent()) {
            model.addAttribute("course", course.get());
            return "course-detail"; // Refers to "course-detail.html" in templates
        } else {
            return "redirect:/courses"; // Redirect to course list if not found
        }
    }
}
