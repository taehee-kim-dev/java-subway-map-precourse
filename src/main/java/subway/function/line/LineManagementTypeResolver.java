package subway.function.line;

import java.util.Scanner;
import subway.main.UserSelections;

public class LineManagementTypeResolver {

    public static void resolveUserSelection(LineManagementSelectionType type, Scanner scanner) {
        try {
            if (type == LineManagementSelectionType.LINE_REGISTRATION) {
                LineManagement.registerNewLine(scanner);
            }
            if (type == LineManagementSelectionType.LINE_DELETE) {
                LineManagement.deleteLine(scanner);
            }
            if (type == LineManagementSelectionType.PRINT_ALL_LINES) {
                LineManagement.printLineList();
            }
        } catch (IllegalArgumentException ignored) {
        }
    }

    public static LineManagementSelectionType getLineManagementSelectionType(String userInput) {
        if (userInput.equals(UserSelections.FIRST)) {
            return LineManagementSelectionType.LINE_REGISTRATION;
        }
        if (userInput.equals(UserSelections.SECOND)) {
            return LineManagementSelectionType.LINE_DELETE;
        }
        if (userInput.equals(UserSelections.THIRD)) {
            return LineManagementSelectionType.PRINT_ALL_LINES;
        }
        return LineManagementSelectionType.GO_BACK;
    }
}
