package ec.com.jmgorduez.ACMEEmployeesPayment.infrastructure;

import ec.com.jmgorduez.ACMEEmployeesPayment.domain.abstractions.IEmployeePaySheet;
import ec.com.jmgorduez.ACMEEmployeesPayment.domain.abstractions.IEmployeePaySheetParser;
import ec.com.jmgorduez.ACMEEmployeesPayment.infrastructure.abstractions.IEmployeeSalaryCalculator;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static ec.com.jmgorduez.ACMEEmployeesPayment.utils.Constants.*;
import static java.util.Optional.ofNullable;

public class EmployeeSalaryCalculator implements IEmployeeSalaryCalculator {

    private IEmployeePaySheetParser employeePaySheetParser;
    private DecimalFormat decimalFormat = new DecimalFormat();

    public EmployeeSalaryCalculator(IEmployeePaySheetParser employeePaySheetParser) {
        this.employeePaySheetParser = employeePaySheetParser;
    }

    @Override
    public void calculateSalary(Supplier<String> readLine, Consumer<String> writeOutput) {
        readAllEmployeesPaySheet(readLine)
                .map(this::calculateEmployeeSalary)
                .forEach(writeOutput);
    }

    private Stream<IEmployeePaySheet> readAllEmployeesPaySheet(Supplier<String> readLine) {
        List<IEmployeePaySheet> lines = new ArrayList<>();
        try {
            while (true) {
                lines.add(
                        ofNullable(readLine.get())
                                .map(employeePaySheetParser::parseEmployeePaySheet)
                                .orElseThrow(UnsupportedOperationException::new));
            }
        } catch (UnsupportedOperationException error) {
            return lines.stream();
        }
    }

    private String calculateEmployeeSalary(IEmployeePaySheet employeePaySheet) {
        return THE_AMOUNT_TO_PAY_EMPLOYEE_IS_SALARY_USD
                .replace(EMPLOYEE, employeePaySheet.employeeName())
                .replace(SALARY, format(employeePaySheet.payment()));
    }

    private String format(Double value) {
        return decimalFormat.format(value);
    }
}
