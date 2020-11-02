package dongho.woowacource.javaconvention.ex1;

public class Member {
    private int num;
    private int [] space;

    public Member(int num) {
        this.num = num;
        space = new int[num];
    }

    int[] getSpaceList() {
        return space;
    }

    void setSpace(int index, int value) {
        space[index] = value;
    }
}
