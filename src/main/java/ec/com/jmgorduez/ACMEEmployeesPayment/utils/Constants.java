package ec.com.jmgorduez.ACMEEmployeesPayment.utils;

import java.time.LocalTime;

public class Constants {

    public static final Integer ZERO = 0;
    public static final Integer ONE = 1;
    public static final Integer TWO = 2;

    public static final Float _15 = 15F;
    public static final Float _20 = 20F;
    public static final Float _25 = 25F;
    public static final Float _30 = 30F;
    public static final Float _60 = 60F;

    public static final String ASSIGNMENT_CHARACTER = "=";
    public static final String COMMA_CHARACTER = ",";
    public static final String MINUS_CHARACTER = "-";

    public static final String MO = "MO";
    public static final String TU = "TU";
    public static final String WE = "WE";
    public static final String TH = "TH";
    public static final String FR = "FR";
    public static final String SA = "SA";
    public static final String SU = "SU";

    public static final String THE_AMOUNT_TO_PAY_EMPLOYEE_IS_SALARY_USD = "The amount to pay EMPLOYEE is: SALARY USD";
    public static final String EMPLOYEE = "EMPLOYEE";
    public static final String SALARY = "SALARY";

    public static final LocalTime _00_00 = LocalTime.parse("00:00");
    public static final LocalTime _09_00 = LocalTime.parse("09:00");
    public static final LocalTime _18_00 = LocalTime.parse("18:00");
    public static final LocalTime _23_59 = LocalTime.parse("23:59");

    public static final String MESSAGE_ILLEGAL_FORMAT
            = "File with illegal format. The correct format should be 'EMPLOYEE_NAME=WDhh:mm,WDhh:mm,...,WDhh:mm'.";
    public static final String MESSAGE_INVALID_FILE
            = "Input file does not exist.";
    public static final String MESSAGE_PARAMETER_IS_NECESSARY
            = "You need to provide a input file name.";

}
