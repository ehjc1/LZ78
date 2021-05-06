public class LZpack {
    private byte buffer = 0;
    private int buffIndex = 7;
    public static void main(String[] args) {
        
    }

    private void bitWriter(int bit) {
        buffer |= bit << (buffIndex);
        buffIndex--; 
        if(buffIndex == -1) { // reset buffIndex
            System.out.write(buffer);
            buffIndex = 7;
            buffer = 0;
        }
    } 
}
