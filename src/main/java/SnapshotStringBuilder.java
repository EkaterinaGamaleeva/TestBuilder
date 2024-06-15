import java.util.Arrays;

public class SnapshotStringBuilder implements MementoStringBuilder,Comparable<SnapshotStringBuilder> {
    private char[] chars;
    private int count;

    public String toString() {
         Arrays.asList(chars).stream().forEach(System.out::println);
        return null;
    }

    public SnapshotStringBuilder() {
        chars = new char[16];
    }

    public SnapshotStringBuilder(String str) {
        append(str);
    }

    public SnapshotStringBuilder(char ch) {
        append(ch);
    }

    public void append(Object o) {
          append(o.toString());
}

    public void append(char ch){
            if(count+1>chars.length){
            chars =newChars();
            append(ch);
        }
             chars[count]=ch;
             count++;
        }
        private char [] newChars(){
            char[] newChars = new char[chars.length+16];
            for (int i = 0; i < chars.length; i++) {
                 newChars[i]=chars[i];
            }
            return newChars;
        }
        public void insert(int index, Object obj) {
            if (index >= 0 & obj != null) {
                for (int i = 0; i < obj.toString().length(); i++) {
                    chars[index] = obj.toString().charAt(i);
                }
            }
        }
    public void replace(int start, int end, String str){
        if ((start >= 0 & end >= 0) & str != null){
            while (start != end) {
                for (int j = 0; j < str.length(); j++) {
                    chars[start] = str.charAt(j);
                    start++;
                }
            }
        }
    }
    public char charAt(int index){
        return chars[index];
    }
    public String substring(int start, int end) {
        String str = "";
        if (start != 0 & end != 0) {
            while (start != end) {
                str += chars[start];
                start++;
            }
        }
        return str;
    }
    public void setCharAt(int index, char ch){
        if (index!=0){
           if (getChars().length<index){
               System.out.println("такого индекса нет");
           }
            chars[index]=ch;
        }
    }
    public int length(){
        return getChars().length;
    }

    public void delete(int start, int end) {
        if (start >= 0 & end >= 0) {
            while (start != end) {
                chars[start] = 0;
                start++;
            }
        }

    }
    public void deleteCharAt(int index){
        if (index!=0){
            chars[index]=0;
        }
    }
    public void append(String str) {
        if (str.length() + count > chars.length) {
            chars = newChars();
            append(str);
        }
        else if (count==0){
            for (int i = 0; i <str.length(); i++) {
                chars[i]=str.charAt(i);
                    count++;
                }
            }
        else {
                    for (int i = 0; i <str.length(); i++) {
                        chars[count] = str.charAt(i);
                        count++;
                    }
        }

        }

    public char[] getChars() {
        return chars;
    }

    public int getCount() {
        return count;
    }

    @Override
    public void undo() {
       String str="new mothod";
        append(str);
    }
    public char[] reverse(){
       char [] char2= new char[chars.length] ;
        int count=0;
        while (count!=char2.length) {
            for (int i = chars.length - 1; i >= 0; i--) {
                char2[count]=chars[i];
                count++;
            }
        }
        return chars=char2;
    }




    public int lastIndexOf(String str, int index){
        String str2 =" ";
        for (int i = 0; i < chars.length; i++) {
            str2+=chars[i];
        }
        return index=str2.lastIndexOf(str);
    }

    public int indexOf(String str, int index)
    {
       String str2 =" ";
        for (int i = 0; i < chars.length; i++) {
            str2+=chars[i];
        }
        index=str2.indexOf(str);
//        for (int i = 0; i < str.length() ; i++) {
//            char oneChar=str.charAt(i);
//            for (int j = 0; j <chars.length ; j++) {
//               while (chars[j]!=oneChar){
//                   index=chars[j];//индекс первого вхождения нахождение символа
//               }
//            }
//        }
        return index;
    }
    @Override
    public int compareTo(SnapshotStringBuilder o) {
        return this.compareTo(o);
    }
}
