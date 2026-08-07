public class FileExtensionValidator {
    public static String validateFileExtension(String filename) {
        int lastDot = filename.lastIndexOf('.');
        if (lastDot == -1 || lastDot == filename.length() - 1) {
            return "Rejected - invalid file type";
        }
        String ext = filename.substring(lastDot + 1);
        if (ext.equalsIgnoreCase("pdf") || ext.equalsIgnoreCase("docx") || ext.equalsIgnoreCase("zip")) {
            return "Accepted";
        } else {
            return "Rejected - invalid file type";
        }
    }

    public static void main(String[] args) {
        System.out.println("\"Assignment1.PDF\" | " + validateFileExtension("Assignment1.PDF"));
        System.out.println("\"notes.txt\" | " + validateFileExtension("notes.txt"));
    }
}