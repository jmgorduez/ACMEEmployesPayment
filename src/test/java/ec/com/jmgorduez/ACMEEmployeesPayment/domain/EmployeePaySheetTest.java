package ec.com.jmgorduez.ACMEEmployeesPayment.domain;

import ec.com.jmgorduez.ACMEEmployeesPayment.dataGenerator.TestDataGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static ec.com.jmgorduez.ACMEEmployeesPayment.dataGenerator.TestDataGenerator.*;
import static ec.com.jmgorduez.ACMEEmployeesPayment.domain.enums.TypeBasicUnitOfTime.HOUR;
import static org.assertj.core.api.Assertions.assertThat;

class EmployeePaySheetTest {

    private EmployeePaySheet employeePaySheetUnderTest;

    @BeforeEach
    void setUp() {
        employeePaySheetUnderTest = new EmployeePaySheet(ASTRID);
    }

    @Test
    void payment() {
        employeePaySheetUnderTest.addPayableItem(new WorkingTime(_09_00, _11_30, HOUR::basicUnitOfTime,
                TestDataGenerator::_15_USD_Per_Hours));
        employeePaySheetUnderTest.addPayableItem(new WorkingTime(_09_00, _11_30, HOUR::basicUnitOfTime,
                TestDataGenerator::_20_USD_Per_Hours));
        assertThat(employeePaySheetUnderTest.payment())
                .isEqualByComparingTo(_87_USD_50_c);
    }

    @Test
    void employeeName() {
        assertThat(employeePaySheetUnderTest.employeeName())
                .isEqualTo(ASTRID);
    }

    @Test
    void addPayableItem() {
        assertThat(employeePaySheetUnderTest.workingTimes.isEmpty())
                .isTrue();
        employeePaySheetUnderTest.addPayableItem(new WorkingTime(_09_00, _11_30, HOUR::basicUnitOfTime,
                TestDataGenerator::_15_USD_Per_Hours));
        assertThat(employeePaySheetUnderTest.workingTimes.size())
                .isEqualTo(ONE);
    }
}