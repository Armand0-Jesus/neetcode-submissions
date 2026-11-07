// Koko Eating Bananas
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int minSpeed = 1;
        int maxSpeed = 0;

        for (int pile : piles) {
            maxSpeed = Math.max(maxSpeed, pile);
        }

        while (minSpeed < maxSpeed) {
            int middle = minSpeed + (maxSpeed - minSpeed) / 2;

            if (canEatInTime(piles, h, middle)) {
                maxSpeed = middle;
            } else {
                minSpeed = middle + 1;
            }
        }

        return minSpeed;
    }

    public boolean canEatInTime(int[] piles, int h, int speed) {
        int hours = 0;

        for (int pile : piles) {
            hours += Math.ceil((double) pile / speed);
        }

        return hours <= h;
    }
}
