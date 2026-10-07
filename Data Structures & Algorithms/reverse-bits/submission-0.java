// Reverse Bits
class Solution {
    public int reverseBits(int n) {
        int reverse = n;
        reverse = reverse >>> 16 | reverse << 16;
        reverse = (reverse & 0xff00ff00) >>> 8 | (reverse & 0x00ff00ff) << 8;
        reverse = (reverse & 0xf0f0f0f0) >>> 4 | (reverse & 0x0f0f0f0f) << 4;
        reverse = (reverse & 0xcccccccc) >>> 2 | (reverse & 0x33333333) << 2;
        reverse = (reverse & 0xaaaaaaaa) >>> 1 | (reverse & 0x55555555) << 1;
        return reverse;
    }
}
