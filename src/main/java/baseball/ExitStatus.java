package baseball;

public enum ExitStatus {
    EXIT, REPLAY;

    public static boolean isNotExit(ExitStatus exitStatus) {
        return exitStatus != EXIT;
    }
}
