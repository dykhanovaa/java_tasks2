import java.util.Arrays;
import java.util.regex.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(duplicateChars("Barack", "Obama"));

        int[] task2input = {3,12,7,81,52};
        System.out.println(dividedByThree(task2input));

        System.out.println(getInitials("simonov sergei evgenievich"));
        System.out.println(getInitials("kozhevnikova tatiana vitalevna"));

        double[] task4input = {3.5, 7.0, 1.5, 9.0, 5.5};
        double[] task4inputNull = {10.0, 10.0, 10.0, 10.0};
        System.out.println(Arrays.toString(normalizator(task4input)));
        System.out.println(Arrays.toString(normalizator(task4inputNull)));

        double[] task5input = {1.6, 0, 212.3, 34.8, 0, 27.5};
        System.out.println(Arrays.toString(compressedNums(task5input)));

        System.out.println(camelToSnake("helloWorld"));
        System.out.println(camelToSnake2("helloWorld"));

        int[] task7input = {3, 5, 8, 1, 2, 4};
        System.out.println(secondBiggest(task7input));

        System.out.println(localReverse("baobab", 'b'));
        System.out.println(localReverse("Hello, I’m under the water, please help me", 'e'));


        System.out.println(equal(8,1,8));
        System.out.println(equal(5,5,5));
        System.out.println(equal(4,9,6));

        System.out.println(isAnagram("LISTEN", "silent"));
        System.out.println(isAnagram("Eleven plus two?", "Twelve plus one!"));
        System.out.println(isAnagram("hello", "world"));
    }

//    #1

    public static String duplicateChars(String firstWord, String secondWord){
        firstWord = firstWord.toLowerCase();
        secondWord = secondWord.toLowerCase();
        String newWord = "";
        for (int i = 0; i < firstWord.length(); i++) {
            int flag = 0;
            char a = firstWord.charAt(i);
            for(int j = 0; j < secondWord.length(); j++){
                if (a==secondWord.charAt(j)){
                    flag=1;
                    break;
                }
            }
            if(flag==0) {
                newWord = newWord + a;
            }
        }
        return newWord;
    }

//    #2

    public static int dividedByThree(int[] nums){
        int count = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]%2!=0 && nums[i]%3==0){
                count++;
            }
        }
        return count;
    }

//    #3

    public static String getInitials(String fullName){
        String[] dividedNames = fullName.split(" ");
        String surname = dividedNames[0].substring(0,1).toUpperCase() + dividedNames[0].substring(1);
        String initials = dividedNames[1].toUpperCase().charAt(0) + ". " + dividedNames[2].toUpperCase().charAt(0) + ". " + surname;
        return initials;
    }

//    #4

    public static double[] normalizator(double[] before){
        double mmin = before[0];
        double mmax = before[0];
        for(int i=0; i<before.length; i++){
            if(mmin>before[i]){
                mmin=before[i];
            }
            if(mmax<before[i]) {
                mmax = before[i];
            }
        }
        double[] after = new double[before.length];
        for(int i=0; i<before.length; i++){
            if(mmax-mmin != 0) {
                after[i] = (before[i] - mmin) / (mmax - mmin);
            } else {
                Arrays.fill(after, 0.0);
            }
        }
        return after;
    }

//    #5

    public static int[] compressedNums(double[] before){
        int zeroCount = 0;
        for(int i =0; i<before.length; i++){
            if(before[i]==0.0){
                zeroCount++;
            }
        }
        int[] after = new int[before.length-zeroCount];
        Arrays.sort(before);
        for(int i=zeroCount; i<before.length; i++){
            after[i-zeroCount]= (int) before[i];
        }
        Arrays.sort(after);
        return after;
    }

//    #6

    public static String camelToSnake(String s){
        String newS = "";
        Pattern pattern = Pattern.compile("[A-Z]");
        Matcher matcher = pattern.matcher(s);
        while (matcher.find()) {
            newS = s.substring(0, matcher.start())+ "_" + s.substring(matcher.start()).toLowerCase();
        }
        return newS;
    }

    public static String camelToSnake2(String s){
        String newS = "";
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c>64 && c<91){
                newS = newS + "_" + c;
            }else{
                newS = newS + c;
            }
        }
        newS = newS.toLowerCase();
        return newS;
    }

//    #7

    public static int secondBiggest(int[] numbs){
        Arrays.sort(numbs);
        return numbs[numbs.length-2];
    }

//    #8

    public static String reverse(String s){
        String reversedS = "";
        for(int i = 0; i<s.length(); i++){
            reversedS=s.charAt(i)+reversedS;
        }
        return reversedS;
    }

    public static String localReverse(String s, char cc){
        String newS = "";
        String c = ""+cc;
        String[] chunks = s.split(c);
        for(int i=1; i<chunks.length; i+=2){
            chunks[i] = reverse(chunks[i]);
        }
        for(int i=0;i<chunks.length; i++){
            if(i==0){
                newS=newS+chunks[i]+c;
            }else if(i==chunks.length){
                newS=newS+reverse(chunks[i]);
            }else{
                newS=newS+chunks[i]+c;
            }
        }
        return newS;
    }

//    #9
    public static int equal(int a, int b, int c){
        if(a==b && a==c && b==c){
            return 3;
        }else if(a==b || a==c || b==c){
            return 2;
        }else return 0;
    }

//    #10
    public static boolean isAnagram(String s1, String s2){
        String filter = "[^a-z]";
        char[] ch1 = s1.toLowerCase().replaceAll(filter, "").toCharArray();
        Arrays.sort(ch1);
        char[] ch2 = s2.toLowerCase().replaceAll(filter, "").toCharArray();
        Arrays.sort(ch2);
        return Arrays.equals(ch1, ch2);
    }

}