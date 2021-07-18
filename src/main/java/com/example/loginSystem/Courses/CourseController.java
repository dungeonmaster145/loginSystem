package com.example.loginSystem.Courses;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class CourseController {
    @Autowired

    private final CourseRepository courseRepository;
    private final CourseService courseService;

    @PostMapping("/Course/{id}")
    public Course addCourse(@RequestBody Course course)
    {
        return courseRepository.save(course);
    }
    @GetMapping("/Course/{id}")
    public Course findCourseById(@PathVariable Long id) throws Exception
    {
        return courseRepository.findById(id)
                .orElseThrow(()->new Exception("The Course is not found"));
    }
    @GetMapping("/Courses")
    public List<Course> findAllCourses()
    {
        return courseRepository.findAll();
    }
    @PutMapping("/Courses/{id}")
    public Optional<Course> updateCourse(@RequestBody Course course, @PathVariable Long id)throws Exception
    {

        return courseService.courseUpdate(id,course);
    }
    @DeleteMapping("/Courses/{id}")
    public void deleteCourse(@PathVariable Long id)
    {
        courseRepository.deleteById(id);
    }
}
