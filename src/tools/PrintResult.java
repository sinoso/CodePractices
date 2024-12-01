package tools;

public class PrintResult<T> {
    private static final String RED_FAIL = "\u001B[31m";
    private static final String GREEN_SUCCESS = "\u001B[32m";
    public static final String COLOR_EXIT = "\u001B[0m";

    public void checkResult(T expected, T actual) {
        StringBuilder sb = new StringBuilder();
        boolean result = expected == actual;
        sb.append("\nExpected : ");
        sb.append(expected.toString());//todo Array?[]? [][]? [][][]?
        sb.append("\nActual   : ");
        sb.append(actual.toString());
        sb.append("\nResult   : ");
        if (result) {
            sb.append(GREEN_SUCCESS);
            sb.append("SUCCESS");

        }else {
            sb.append(RED_FAIL);
            sb.append("FAIL");
        }
        sb.append(result);
        sb.append(COLOR_EXIT);
        System.out.println(sb);
    }
}
