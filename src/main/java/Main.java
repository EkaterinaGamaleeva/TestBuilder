import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        SnapshotStringBuilder stringBuilder =
                new SnapshotStringBuilder();

        stringBuilder.append('l');
        stringBuilder.append('l');
        stringBuilder.append('l');
        stringBuilder.append('l');
        stringBuilder.append('k');

        stringBuilder.toString();
        stringBuilder.undo();
        stringBuilder.toString();
        stringBuilder.undo();
        stringBuilder.toString();
        stringBuilder.undo();
        stringBuilder.toString();
        stringBuilder.getMassiveCheck().stream().forEach(System.out::println);
        stringBuilder.undo();
        stringBuilder.toString();
        stringBuilder.undo();
        stringBuilder.toString();
    }
    }


