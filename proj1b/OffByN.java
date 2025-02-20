public class OffByN implements CharacterComparator {
    private int n;
    public OffByN(int N) {
        n = N;
    }

    @Override
    public boolean equalChars(char x, char y) {
        int diff = Math.abs(x - y);
        if (diff == n) {
            return true;
        }
        return false;
    }
}
