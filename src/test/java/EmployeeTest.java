import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class EmployeeTest {
    Employee employee;

    @BeforeAll
    static void startingTests() {
        System.out.println("Starting tests");
    }

    @BeforeEach
    void printDisplayNames(TestInfo testInfo, TestReporter testReporter) {
        testReporter.publishEntry(testInfo.getDisplayName());
    }

    @AfterAll
    static void testingComplete() {
        System.out.println("Testing Complete");
    }

    @DisplayName("Testing constructor initialisation success")
    @Test
    void testingConstructorSuccess() {
        employee = new Employee("Mr", "Peter Johnson", "G3430897", 888888888, "Part-Time", 22);
        assertEquals("Mr", employee.getTitle());
        assertEquals("Peter Johnson", employee.getName());
        assertEquals("G3430897", employee.getPps());
        assertEquals(888888888, employee.getPhone());
        assertEquals("Part-Time", employee.getEtype());
        assertEquals(22, employee.getAge());
    }

    @DisplayName("Testing invalid Title entry")
    @Test
    void testingInvalidTitle() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> {
            employee = new Employee("M", "Peter Johnson", "G3430897", 888888888, "Part-Time", 22);
        });
        assertEquals("Invalid title (Must be either: |Mr|Mrs|Ms|)", e.getMessage());
    }

    @DisplayName("Testing invalid Name entry")
    @Test
    void testingInvalidName() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> {
            employee = new Employee("Mr", "P", "G3430897", 888888888, "Part-Time", 22);
        });
        assertEquals("Invalid name (Must be >= 2 characters", e.getMessage());
    }

    @DisplayName("Testing invalid PPS entry")
    @Test
    void testingInvalidPps() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> {
            employee = new Employee("Mr", "Peter Johnson", "G343089", 888888888, "Part-Time", 22);
        });
        assertEquals("Invalid PPS number (Must be >= 8 characters", e.getMessage());
    }

    @DisplayName("Testing invalid Employment Type entry")
    @Test
    void testingInvalidEmploymentType() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> {
            employee = new Employee("Mr", "Peter Johnson", "G3430897", 888888888, "part", 22);
        });
        assertEquals("Invalid Employment Type (Must be either: |Full-Time|Part-Time|Contractor|", e.getMessage());
    }

    @DisplayName("Testing invalid Phone Number entry")
    @Test
    void testingInvalidPhoneNumber() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> {
            employee = new Employee("Mr", "Peter Johnson", "G3430897", 82, "Part-Time", 22);
        });
        assertEquals("Invalid Phone Number (Must be in a 9 digits format)", e.getMessage());
    }

    @DisplayName("Testing invalid Age entry")
    @Test
    void testingInvalidAge() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> {
            employee = new Employee("Mr", "Peter Johnson", "G3430897", 888888888, "Part-Time", 15);
        });
        assertEquals("Invalid age (Must be >= 16 years old", e.getMessage());
    }

}
