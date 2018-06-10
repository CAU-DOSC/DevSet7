package IntSetBins;
import java.util.Arrays;

public class IntSetBins {
    private int[] bucket;
    private int element_num;
    private int maxval;
    private int maxelem;


    public IntSetBins(int maxelements, int maxval) {
        this.maxelem = maxelements;
        this.maxval = maxval;
        this.element_num = 0;
        this.bucket = new int[this.maxval+1];
        Arrays.fill(bucket, 0);
    }

    public void insert(int element) {
        if (this.bucket[element] == 0) {
            this.bucket[element]++;
            this.element_num++;
        }
    }

    public int[] report() {
        int[] array = new int[this.maxelem];
        int pos = 0;
        for (int i = 0; i < this.bucket.length; i++) {
            if (this.bucket[i] != 0) {
                array[pos++] = i; 
            }
        }
        return array;
    }

    public int size() {
        return this.element_num;
    }

    public static void main(String[] args) {
        int[] num = {3, 2, 5, 4, 1};
        int m = num.length;

        IntSetBins S = new IntSetBins(5, 5);
        for (int i = 0; i < m; i++) {
            S.insert(num[i]);
        }
        
        System.out.println(S.size());
        int[] result = S.report();
        for (int j = 0; j < result.length; j++) {
            System.out.println(result[j] + " ");
        }
        //System.out.println(result.length);
    }
}
/* 