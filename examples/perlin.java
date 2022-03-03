import java.util.*;

public class main {
    public static List<Float> perlin(){
        Random rand = new Random();

        List<Float> resY = new ArrayList<Float>();
        float bef = 0;
        float off = 0.2f;
        int size = 50;

        for (int i = 0; i < size; i++){
            if (bef - off < 0){
                bef = rand.nextFloat() * (bef + off);
            }else {
                bef = (bef - off) + rand.nextFloat() * ((bef + off) - (bef - off));
            }
            resY.add(bef);
        }
        return resY;
    }

    public static int round(float num){
        float abs = Math.abs(num);
        int i = (int) abs;
        float res = abs - (float) i;
        if (res < 0.5){
            return num < 0 ? -i : i;
        }else{
            return num < 0 ? -(i+1) : i+1;
        }
    }

    public static int min(int[] in){
        int min = in[0];
        for (int value : in){
            if (value < min){
                min = value;
            }
        }
        return min;
    }

    public static int max(int[] in){
        int max = in[0];
        for (int value : in){
            if (value > max){
                max = value;
            }
        }
        return max;
    }

    public static void render(int[] res){
        for (int e = max(res); e >= min(res); e--) {
            System.out.print(e + "\t");
            for (int i = 0; i < res.length; i++) {
                if (res[i] == e) {
                    if (i == 0 || i == res.length - 1){
                        System.out.print("-");
                    }else {
                        if (res[i-1] > res[i]) {
                            if (res[i + 1] > res[i]){
                                System.out.print("v");
                            }else{
                                System.out.print("\\");
                            }
                        }else if (res[i - 1] < res[i]) {
                            if (res[i + 1] < res[i]){
                                System.out.print("^");
                            }else {
                                System.out.print("/");
                            }
                        }else {
                            if (res[i + 1] > res[i]){
                                System.out.print("/");
                            }else if (res[i + 1] < res[i]){
                                System.out.print("\\");
                            }else {
                                System.out.print("-");
                            }
                        }
                    }
                } else {
                    System.out.print(" ");
                }
            }
            System.out.print("\n");
        }
    }

    public static void main(String[] args){
        List<Float> got = perlin();
        System.out.println(got);
        int[] res = new int[got.size()];

        int i = 0;
        for (float value: got){
            res[i++] = round(value * 10);
        }

        //int[] test = {3,2,1,2,3,4,5,4,3,2,1,2,3};

        render(res);
    }
}
