class Solution {
    public int[] solution(int[] sequence, int k) {

        int seq_len = sequence.length - 1;
        Pointer pointer = new Pointer(seq_len);
        int tempSum = k;

        while(true) {
            tempSum -= sequence[pointer.p1];
            if(tempSum == 0) {
                break;
            }
            else if(tempSum < 0) {
                tempSum = tempSum + sequence[pointer.p2] + sequence[pointer.p1];
                pointer.discountP2();
            }
            else {
                pointer.discountP1();
            }
        }

        while(pointer.p1 > 0) {
            if (sequence[pointer.p1 - 1] == sequence[pointer.p2]) {
                pointer.discountP2();
                pointer.discountP1();
            }
            else {
                break;
            }
        }

        int[] answer = new int [] {pointer.p1, pointer.p2};

        return answer;
    }

}


class Pointer {
    int p1;
    int p2;

    public Pointer(int len) {
        p1 = len;
        p2 = len;
    }
    public void discountP1() {
        p1 = p1 - 1;
    }
    public void discountP2() {
        p2 = p2 - 1;
    }

    public void addP1() {
        p1 = p1 + 1;
    }
}