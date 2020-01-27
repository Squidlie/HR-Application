package repositories;

import com.astontech.hr.configuration.RepositoryConfiguration;
import com.astontech.hr.domain.Employee;
import com.astontech.hr.repositories.EmployeeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {RepositoryConfiguration.class})
public class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void testSave(){
        Employee employee = new Employee();
        employee.setFirstName("Test");
        employee.setLastName("Testerson");
        employee.setBackground("Java Testing");

        assertNull(employee.getId());
        employeeRepository.save(employee);
        assertNotNull(employee.getId());

        Employee fetchedEmployee = employeeRepository.findOne(employee.getId());
        assertNotNull(fetchedEmployee);
        assertEquals(employee.getId(), fetchedEmployee.getId());

        fetchedEmployee.setFirstName("Updated");
        employeeRepository.save(fetchedEmployee);

        Employee fetchedUpdatedEmployee = employeeRepository.findOne(fetchedEmployee.getId());
        assertEquals("Updated", fetchedUpdatedEmployee.getFirstName());
    }
}

