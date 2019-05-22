package ec.com.jmgorduez.ACMEEmployeesPayment.domain;

import ec.com.jmgorduez.ACMEEmployeesPayment.dataGenerator.TestDataGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static ec.com.jmgorduez.ACMEEmployeesPayment.dataGenerator.TestDataGenerator.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class WorkingTimeParserTest {

    private WorkingTimeParser workingTimeParserUnderTest;

    @BeforeEach
    void setUp() {
        workingTimeParserUnderTest = new WorkingTimeParser(LocalTime::parse);
    }

    @Test
    void parse() {
        assertThat(workingTimeParserUnderTest.parse(MO_10_00_12_00_STRING))
                .isEqualToIgnoringGivenFields(MO_10_00_12_00, GET_BASIC_UNIT_OF_TIME, PAYMENT_STRATEGY);
        assertThat(workingTimeParserUnderTest.parse(TH_12_00_14_00_STRING))
                .isEqualToIgnoringGivenFields(TH_12_00_14_00, GET_BASIC_UNIT_OF_TIME, PAYMENT_STRATEGY);
        assertThat(workingTimeParserUnderTest.parse(SU_20_00_21_00_STRING))
                .isEqualToIgnoringGivenFields(SU_20_00_21_00, GET_BASIC_UNIT_OF_TIME, PAYMENT_STRATEGY);
    }
}