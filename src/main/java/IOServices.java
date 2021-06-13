import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class IOServices {
    public static String PAYROLL_FILE_NAME = "J:\\Payroll.txt";

    public void writeData(List<EmployeePayrollData> employeeDataList) {
        StringBuffer buffer = new StringBuffer();
        employeeDataList.forEach(emp -> {
            String empDataString = emp.toString().concat("\n");
            buffer.append(empDataString);
        });

        try {
            Files.write(Paths.get(PAYROLL_FILE_NAME), buffer.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printData() {
        try {
            Files.lines((new File(PAYROLL_FILE_NAME).toPath())).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public long countEntries() {
        long entries = 0;
        try {
            entries = Files.lines(new File(PAYROLL_FILE_NAME).toPath()).count();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return entries;
    }

    public List<String> readFileInList() {
        List<String> lines = Collections.emptyList();
        try {
            lines =
                    Files.readAllLines(Paths.get(PAYROLL_FILE_NAME), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

}
