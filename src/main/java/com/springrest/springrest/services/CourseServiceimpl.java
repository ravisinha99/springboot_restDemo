package com.springrest.springrest.services;

import com.springrest.springrest.entities.Course;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceimpl implements CourseService {


    List<Course> list;

    public CourseServiceimpl() {

        list = new ArrayList<>();
        list.add(new Course(145, "Java Core Course", "This course contains basics of Java"));
        list.add(new Course(4343, "Spring boot Course", "Creating rest api using spring boot"));
    }


    public List<Course> getCourses() {
        return list;
    }

    public Course getCourse(long courseId) {
        Course c = null;
        for (Course course : list) {
            if (course.getId() == courseId) {
                c = course;
                break;
            }
        }
        return c;
    }

        public Course addCourse (Course course){
            list.add(course);
            return course;

        }

    @Override
    public Course updateCourse(Course course) {
        list.forEach(e -> {
            if (e.getId() == course.getId()) {
                e.setTitle(course.getTitle());
                e.setDescription(course.getDescription());
            }
        });
        //list.add(course);
        return course;
    }

    @Override
    public Course deleteCourse(long CourseId) {
        Course c = null;
        for (Course course : list) {
            if (course.getId() == CourseId) {
                c = course;
                list.remove(course);
                break;
            }
        }
        return c;
    }
}

