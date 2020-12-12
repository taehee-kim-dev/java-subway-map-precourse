package subway.main;

import java.util.Scanner;
import subway.function.line.LineManagement;
import subway.function.printsubwaymap.PrintSubwayMap;
import subway.function.section.SectionManagement;
import subway.function.station.StationManagement;
import subway.commonprint.CommonPrinter;

public class SubwayMapProgram {
    public void start(Scanner scanner) {
        Initializer.initialize();
        while (true) {
            PrintMainScreen.printMainScreen();
            CommonPrinter.printUserFunctionSelectionMessage();
            String mainInput = scanner.nextLine();
            if (mainInput.equals(UserSelections.QUIT)) {
                break;
            }
            MainScreenSelectionType type = getMainScreenUserSelectionType(mainInput);
            resolveUserSelection(type, scanner);
        }
    }

    private MainScreenSelectionType getMainScreenUserSelectionType(String mainInput) {
        if (mainInput.equals(UserSelections.FIRST)) {
            return MainScreenSelectionType.STATION_MANAGEMENT;
        }
        if (mainInput.equals(UserSelections.SECOND)) {
            return MainScreenSelectionType.LINE_MANAGEMENT;
        }
        if (mainInput.equals(UserSelections.THIRD)) {
            return MainScreenSelectionType.SECTION_MANAGEMENT;
        }
        return MainScreenSelectionType.PRINT_SUBWAY_MAP;
    }

    private void resolveUserSelection(MainScreenSelectionType type, Scanner scanner) {
        if (type == MainScreenSelectionType.STATION_MANAGEMENT) {
            StationManagement.start(scanner);
        }
        if (type == MainScreenSelectionType.LINE_MANAGEMENT) {
            LineManagement.start(scanner);
        }
        if (type == MainScreenSelectionType.SECTION_MANAGEMENT) {
            SectionManagement.start(scanner);
        }
        if (type == MainScreenSelectionType.PRINT_SUBWAY_MAP) {
            PrintSubwayMap.start();
        }
    }
}
