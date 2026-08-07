public class BankTransactionValidator {
    public static String normalizeReference(String raw) {
        String trimmed = raw.trim();
        if (trimmed.length() < 3) return trimmed;
        String bankCode = trimmed.substring(0, 3).toUpperCase();
        String body = trimmed.substring(3);
        return bankCode + body;
    }

    public static String validateAndFormat(String reference) {
        if (reference.length() != 14) {
            return "Invalid: wrong length";
        }
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(reference.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }
        for (int i = 3; i < 14; i++) {
            if (!Character.isDigit(reference.charAt(i))) {
                return "Invalid: non-digit body";
            }
        }

        String bankCode = reference.substring(0, 3);
        String dd = reference.substring(3, 5);
        String mm = reference.substring(5, 7);
        String yy = reference.substring(7, 9);
        String seq = reference.substring(9, 14);

        StringBuilder sb = new StringBuilder();
        sb.append("[").append(bankCode).append("] DATE: ")
          .append(dd).append("/").append(mm).append("/").append(yy)
          .append(" | SEQ: ").append(seq);

        return sb.toString();
    }

    public static void main(String[] args) {
        String ref1 = " hdf03022600042 ";
        String norm1 = normalizeReference(ref1);
        System.out.println("\"" + ref1 + "\" | " + validateAndFormat(norm1));

        String ref2 = "12F03022600042";
        String norm2 = normalizeReference(ref2);
        System.out.println("\"" + ref2 + "\" | " + validateAndFormat(norm2));
    }
}