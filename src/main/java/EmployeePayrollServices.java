import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class EmployeePayrollServices {
    public enum IOService {CONSOLE_IO, FILE_IO, DB_IO, REST_IO}

    private List<EmployeePayrollData> employeeDataList;

    public EmployeePayrollServices(List<EmployeePayrollData> employeeDataList) {
        this.employeeDataList = employeeDataList;
    }

    public static void main(String[] args) {
        ArrayList<EmployeePayrollData> employeeDataList = new ArrayList<>();
        EmployeePayrollServices employeePayrollService = new EmployeePayrollServices(employeeDataList);
        Scanner consoleInputReader = new Scanner(System.in);
        employeePayrollService.readEmployeeData(consoleInputReader);
        employeePayrollService.writeEmployeeData(IOService.CONSOLE_IO);
    }

    public void readEmployeeData(Scanner consoleInputReader) {
        System.out.println("Enter Employee Id");
        int id = consoleInputReader.nextInt();
        System.out.println("Enter Employee Name");
        String name = consoleInputReader.next();
        System.out.println("Enter Employee Salary");
        double salary = consoleInputReader.nextDouble();
        employeeDataList.add(new EmployeePayrollData(id, name, salary));
    }

    public void writeEmployeeData(IOService ioService) {
        if (ioService.equals(IOService.CONSOLE_IO))
            System.out.println(employeeDataList);
        else if (ioService.equals(IOService.FILE_IO))
            new IOServices().writeData(employeeDataList);
    }

    public void printData(IOService ioService) {
        if (ioService.equals(IOService.FILE_IO))
            new IOServices().printData();
    }

    public long countEntries(IOService ioService) {
        if (ioService.equals(IOService.FILE_IO))
            return new IOServices().countEntries();
        return 0;
    }

    public List<String> readEmployee(IOService ioService) {
        if(ioService.equals(IOService.FILE_IO))
            return new IOServices().readFileInList();
        return null;
    }
}
