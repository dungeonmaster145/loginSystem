package com.example.loginSystem.Courses;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;

    public Optional<Course> courseUpdate(Long id, Course course)
    {
        return courseRepository.findById(id)
                .map(c->{c.setName("BTECH With Computer Scince");
        course.setDescription("Deals with Programming and Algorithms");
            return courseRepository.save(c);}
        );
    }

}
