package test;

import dao.*;
import model.*;

public class DAOTest {
    public static void main(String[] args) {
        Institution institution = new Institution()
                .setName("Name")
                .setLogo("Logo")
                .setSite("Site");
        new InstitutionDAO().save(institution);

        institution = new InstitutionDAO().findOne(Long.valueOf(1));
        System.out.println(institution);

        Campus campus = new Campus()
                .setName("Name")
                .setStreet("Street")
                .setNumber(Long.valueOf(2))
                .setCity("City")
                .setState("State")
                .setTelephone("Telephone")
                .setZip("Zip")
                .setIdInstitution(institution.getIdInstitution());
        new CampusDAO().save(campus);

        campus = new CampusDAO().findOne(Long.valueOf(1));
        System.out.println(campus);

        Building building = new Building()
                .setName("Name")
                .setQuantityOfBathrooms(2)
                .setElevator(false)
                .setAccessibility(true)
                .setIdCampus(campus.getIdCampus())
                .setIdInstitution(institution.getIdInstitution());
        new BuildingDAO().save(building);

        building = new BuildingDAO().findOne(Long.valueOf(1));
        System.out.println(building);

        RoomType roomType = new RoomType().setName("Name").setDescription("Description");
        new RoomTypeDAO().save(roomType);

        roomType = new RoomTypeDAO().findOne(Long.valueOf(1));

        System.out.println(roomType);

        Room room = new Room()
                .setNumber(200)
                .setQuantityOfSeats(40)
                .setRoomType(roomType)
                .setBuilding(building);
        new RoomDAO().save(room);

        room = new RoomDAO().findOne(Long.valueOf(1));

        System.out.println(room);

        Professor professor = new Professor()
                .setFirstName("First Name")
                .setLastName("Last Name")
                .setEmail("Email")
                .setStatus("normal")
                .setHonorifics("dr");
        new ProfessorDAO().save(professor);

        professor = new ProfessorDAO().findOne(Long.valueOf(1));

        System.out.println(professor);

        Department department = new Department()
                .setField("Field")
                .setDescription("Description")
                .setCampus(campus)
                .setInstitution(institution)
                .setProfessor(professor);
        new DepartmentDAO().save(department);

        department = new DepartmentDAO().findOne(Long.valueOf(1));

        System.out.println(department);

        Program program = new Program()
                .setName("Name")
                .setAcademicLevel("undergrad")
                .setDepartment(department)
                .setCampus(campus)
                .setInstitution(institution);
        new ProgramDAO().save(program);

        program = new ProgramDAO().findOne(Long.valueOf(1));

        System.out.println(program);

        Subject subject = new Subject()
                .setName("Name")
                .setQuantityOfCredits(4)
                .setRoomType(roomType)
                .setProgram(program)
                .setDepartment(department)
                .setCampus(campus)
                .setInstitution(institution);
        new SubjectDAO().save(subject);

        subject = new SubjectDAO().findOne(Long.valueOf(1));

        System.out.println(subject);

        Period period = new Period()
                .setStart("Start")
                .setEnd("End")
                .setDayOfTheWeek("Monday")
                .setRoom(room);
        new PeriodDAO().save(period);

        period = new PeriodDAO().findOne(Long.valueOf(1));

        System.out.println(period);

        Course course = new Course()
                .setSemester(true)
                .setYear(2018)
                .setSubject(subject)
                .setProgram(program)
                .setDepartment(department)
                .setCampus(campus)
                .setInstitution(institution)
                .setPeriod(period)
                .setProfessor(professor);
        new CourseDAO().save(course);

        course = new CourseDAO().findOne(Long.valueOf(1));

        System.out.println(course);

        Activity activity = new Activity()
                .setName("Name")
                .setActivityType("research")
                .setArea("Area")
                .setProfessor(professor)
                .setCampus(campus)
                .setDepartment(department)
                .setInstitution(institution)
                .setProgram(program);
        new ActivityDAO().save(activity);

        activity = new ActivityDAO().findOne(Long.valueOf(1));

        System.out.println(activity);

        Student student = new Student()
                .setFirstName("First Name")
                .setLastName("Last Name")
                .setEmail("Email")
                .setActivity(activity);
        new StudentDAO().save(student);

        student = new StudentDAO().findOne(Long.valueOf(1));

        System.out.println(student);

        Event event = new Event()
                .setName("Name")
                .setDate("2018-06-15")
                .setPeriod(period)
                .setProfessor(professor)
                .setRoom(room);
        new EventDAO().save(event);

        event = new EventDAO().findOne(Long.valueOf(1));

        System.out.println(event);

        Meeting meeting = new Meeting()
                .setDay("Day")
                .setTime("Time")
                .setAgenda("Agenda")
                .setMinutes("Minutes")
                .setDepartment(department)
                .setCampus(campus)
                .setInstitution(institution);
        new MeetingDAO().save(meeting);

        meeting = new MeetingDAO().findOne(Long.valueOf(1));

        System.out.println(meeting);

        Request request = new Request()
                .setMotive("Motive")
                .setDescription("Description")
                .setPriority("Normal")
                .setRoom(room);
        new RequestDAO().save(request);

        request = new RequestDAO().findOne(Long.valueOf(1));

        System.out.println(request);

    }
}
