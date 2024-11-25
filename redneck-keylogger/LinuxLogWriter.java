import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
public class LinuxLogWriter {
private static final String LOG_FILE_PATH = "log.txt";
public static void main(String[] args) {
LinuxLogWriter logWriter = new LinuxLogWriter();
logWriter.run();
}
public void run() {
System.out.println("Rozpoczynamy zapis logu do pliku log.txt. Wprowadzaj dane z klawiatury, a program będzie je zapisywał. Wpisz 'quit', aby zakończyć.");
try (Scanner scanner = new Scanner(System.in);
BufferedWriter writer = new BufferedWriter(new FileWriter(LOG_FILE_PATH, true))) {
while (true) {
String input = scanner.nextLine();
if ("quit".equalsIgnoreCase(input)) {
break;
}
writeLogEntry(writer, input);
}
} catch (IOException e) {
System.err.println("Wystąpił błąd podczas zapisu do pliku: " + e.getMessage());
}
System.out.println("Zapis logu zakończony.");
}
private void writeLogEntry(BufferedWriter writer, String logEntry) {
try {
String timestamp = getTimestamp();
writer.write(timestamp + " - " + logEntry);
writer.newLine();
writer.flush();
} catch (IOException e) {
System.err.println("Wystąpił błąd podczas zapisu do pliku: " + e.getMessage());
}
}
private String getTimestamp() {
LocalDateTime now = LocalDateTime.now();
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
return now.format(formatter);
}
}
