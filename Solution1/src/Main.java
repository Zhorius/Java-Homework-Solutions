public class Main {

    public static void main(String[] args) {
        for(int i = 1; i <= 100; i++){
            String s = "";
            if(i % 2 != 0 && i % 7 !=0){
                s = Integer.toString(i);
            }
            else {
                if(i % 2 == 0) s = "Two";
                if(i % 7 == 0) s += "Seven";
            }
            System.out.println(s);
        }
    }
}
