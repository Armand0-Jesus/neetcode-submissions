/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

// Guess Number Higher or Lower
public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int left = 0;
        int right = n;

        while (left <= right) {
            int middle = left + (right - left) / 2;
            int guess = guess(middle);

            if (guess < 0) {
                right = middle - 1;
            } else if (guess > 0) {
                left = middle + 1;
            } else {
                return middle;
            }
        }

        return 0; 
    }
}