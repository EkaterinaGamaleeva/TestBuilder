import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        SnapshotStringBuilder stringBuilder =
                new SnapshotStringBuilder();
        stringBuilder.append("jok");
        System.out.println(stringBuilder.getMassiveCheck().size());;
        stringBuilder.append("jok");
        stringBuilder.append("jok");
        stringBuilder.append('k');
        stringBuilder.getMassiveCheck().stream().forEach(System.out::println);
        stringBuilder.toString();
        stringBuilder.undo();

        stringBuilder.toString();

        }
        ;
    }


