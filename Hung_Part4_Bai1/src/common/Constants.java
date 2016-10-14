package common;

import java.util.Arrays;

/**
 * Created by WataruS on 10/8/2016.
 */
public class Constants {
    public enum Position {
        NOT_DEFINE, ENGINEER, SENIOR_ENGINEER, CONSULTANT, SENIOR_CONSULTANT,
        PRINCIPAL_CONSULTANT, PROJECT_MANAGER, SENIOR_MANAGER
    }

    public static boolean isInPositionEnum(String value) {
        return Arrays.stream(Position.values()).anyMatch(e -> e.name().equals(value));
    }
}
