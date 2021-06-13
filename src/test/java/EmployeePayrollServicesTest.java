import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class EmployeePayrollServicesTest {
    @Test
    public void given3EmployeeWhenWrittenToFile_ShouldMatchEmployeesEntry() {
        EmployeePayrollData[] employeeData = {
                new EmployeePayrollData(1, "Daniel", 2000000),
                new EmployeePayrollData(2, "Bella", 120000),
                new EmployeePayrollData(3, "Rose", 90000)
        };
        EmployeePayrollServices employeePayrollService = new EmployeePayrollServices(Arrays.asList(employeeData));
        employeePayrollService.writeEmployeeData(EmployeePayrollServices.IOService.FILE_IO);
        employeePayrollService.printData(EmployeePayrollServices.IOService.FILE_IO);
        long entries = employeePayrollService.countEntries(EmployeePayrollServices.IOService.FILE_IO);
        Assert.assertEquals(3, entries);
    }
}