public class Main {
    public static void main(String[] args) {
        SnapshotStringBuilder stringBuilder =
                new SnapshotStringBuilder();
        stringBuilder.append('k');
        stringBuilder.append('a');
        stringBuilder.append('t');
        stringBuilder.append('y');
        stringBuilder.append('a');
        stringBuilder.append("Gamaleeva");
        stringBuilder.toString();
        stringBuilder.reverse();
        stringBuilder.toString();

    }

}
