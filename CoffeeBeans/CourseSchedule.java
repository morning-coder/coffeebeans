package CoffeeBeans.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CourseSchedule {

    private static CourseScheduleService courseScheduleService;

    public CourseSchedule() {
    }

    public static void main(String[] args) {
        int numCourses;
        List prerequisites = new ArrayList(); // {{ai,bi}, {ci,di}}

        Scanner scanner = new Scanner(System.in);
        numCourses = scanner.nextInt();
        for(int i = 0; i < numCourses; i++){
            int curr_course = scanner.nextInt();
            int prev_course = scanner.nextInt();
            prerequisites.add(Stream.of(curr_course, prev_course).collect(Collectors.toList()));
        }
        courseScheduleService = new CourseScheduleService(numCourses);
        System.out.println(courseScheduleService.canFinishAllCourses(numCourses, prerequisites));
    }
}
