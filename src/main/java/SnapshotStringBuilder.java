import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

public class SnapshotStringBuilder implements MementoStringBuilder,Comparable<SnapshotStringBuilder> {
    private char[] chars;
    private int count;
    private int index=0;
    private int countCharsInString;

    private ArrayList<Integer>massiveCheck ;

    {
        massiveCheck=new ArrayList<>();
    }
    public String toString() {
         Arrays.asList(chars).stream().forEach(System.out::println);
        return null;
    }

    public SnapshotStringBuilder() {
        chars = new char[16];
    }

    public SnapshotStringBuilder(String str) {
        append(str);
        for (int i = 0; i < str.length(); i++) {
            countCharsInString++;
            createMassiveCheck(countCharsInString);
        }
        ;
    }

    public SnapshotStringBuilder(char ch) {
        append(ch);
        createMassiveCheck(1);
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
        createMassiveCheck(1);
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

    public ArrayList<Integer> getMassiveCheck() {
        return massiveCheck;
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
            chars[index]=0;
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
                countCharsInString++;
                }
            }
        else {
                    for (int i = 0; i <str.length(); i++) {
                        chars[count] = str.charAt(i);
                        count++;
                        countCharsInString++;
                    }
        }

        createMassiveCheck(countCharsInString);
        countCharsInString=0;

        }

    public char[] getChars() {
        return chars;
    }

    public int getCount() {
        return count;
    }


    @Override
    public void undo() {
        for (int i = getMassiveCheck().size()-1; i>=0; i--) {
            if(getMassiveCheck().get(i)==0){
                getMassiveCheck().remove(i);
                continue;
            }
            if (getMassiveCheck().get(i)>1){
                 int quantityCharInString=getMassiveCheck().get(i);
                 int start=count-quantityCharInString;
                 delete(start,count);
                 count=count-quantityCharInString;
                 getMassiveCheck().remove(i);
                break;
            }
            if (getMassiveCheck().get(i)==1){
                deleteCharAt(count-1);
                count=count-1;
                getMassiveCheck().remove(i);
                break;
            }
        }
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

public ArrayList<Integer> createMassiveCheck(int count){
         massiveCheck.add(index,count);
         index++;
        return massiveCheck;
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
