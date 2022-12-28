package college.in;

import java.util.*;


public class AcademicCourses {

    private static AcademicCourses academicCourses;
    private static Map<String,AcademicCourses> branches;
    private List<String> courses;

    private AcademicCourses(List<String> courses){
        this.courses=courses;
    }

    public List<String> getCourses() {
        return courses;
    }

    static{
        branches=new HashMap<>();
        List<String> mathematics=new ArrayList<>(Arrays.asList("Statistics","Calculus","Algebra","Geometry"));
        List<String> chemistry=new ArrayList<>(Arrays.asList("Organic chemistry","Thermodynamics"));
        List<String> physics=new ArrayList<>(Arrays.asList("Astrophysics","Quantam Mechanics","Nuclear physics"));

        branches.put("Mathematics",new AcademicCourses(mathematics));
        branches.put("Chemistry",new AcademicCourses(chemistry));
        branches.put("Physics",new AcademicCourses(physics));
    }

    public static AcademicCourses getInstance(String branch){
        if(branches.containsKey(branch)){
            return branches.get(branch);  //returns the instance of AcademicCourses associated with the branch
        }
        return null;
    }

}
class College{

    public static void main(String args[]){

        AcademicCourses physics=AcademicCourses.getInstance("Physics");
        if(physics!=null && physics.getCourses()!=null && physics.getCourses().size()>0) {
            System.out.println("Our college offers " + physics.getCourses() + " courses in Physics");
        }
        AcademicCourses mathematics=AcademicCourses.getInstance("Mathematics");
        if(mathematics!=null && mathematics.getCourses()!=null && mathematics.getCourses().size()>0) {
            System.out.println("Our college offers "+mathematics.getCourses()+" courses in Mathematics");
        }
        AcademicCourses chemistry=AcademicCourses.getInstance("Chemistry");
        if(chemistry!=null && chemistry.getCourses()!=null && chemistry.getCourses().size()>0) {
            System.out.println("Our college offers " + chemistry.getCourses() + " courses in Chemistry");
        }
        AcademicCourses biology=AcademicCourses.getInstance("Biology");
        if(biology==null){
            System.out.println("Our college doesnot offer any courses in Biology");
        }

    }
}
