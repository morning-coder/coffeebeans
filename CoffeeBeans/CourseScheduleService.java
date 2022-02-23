package CoffeeBeans.day2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseScheduleService {
    private List<List<Integer>> graph;
    private List<Integer> indegree;

    public CourseScheduleService(int numCourses) {
        graph = new ArrayList<>();
        indegree = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            graph.add(new ArrayList<>());
            indegree.add(0);
        }
    }

    public boolean canFinishAllCourses(int numCourses, List<List<Integer>> prerequisites) {
        buildGraph(numCourses, prerequisites);
        int completedCourses = countCoursesCompleted(graph);
        return completedCourses == numCourses;
    }

    private List<List<Integer>> buildGraph(int numCourses, List<List<Integer>> prerequisites){
        for(List<Integer> edge : prerequisites){
            int currCourse = edge.get(0), prevCourse = edge.get(1);
            graph.get(prevCourse).add(currCourse);
            indegree.set(currCourse, indegree.get(currCourse)+1);
        }
        return graph;
    }

    // Kahn's Algorithm
    private int countCoursesCompleted(List<List<Integer>> graph) {
        int coursesCompleted = 0;
        Queue<Integer> queue = new LinkedList<>();
        //indegree = calculateIndegree(graph);

        for(int i = 0; i < indegree.size(); i++){
            if(indegree.get(i) == 0)
                queue.add(i);
        }

        while(!queue.isEmpty()){
            int curr_vertex = queue.poll();
            coursesCompleted++;

            for(int adjacent_vertex : graph.get(curr_vertex)){
                indegree.set(adjacent_vertex, indegree.get(adjacent_vertex) - 1);
                if(indegree.get(adjacent_vertex) == 0)
                    queue.add(adjacent_vertex);
            }
        }
        return coursesCompleted;
    }


}
