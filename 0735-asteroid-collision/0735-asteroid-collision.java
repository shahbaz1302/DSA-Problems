class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < asteroids.length; i++) {
            if (asteroids[i] > 0) list.add(asteroids[i]);
            else {
                while (!list.isEmpty() && list.getLast() > 0 && list.getLast() < Math.abs(asteroids[i]))
                    list.remove(list.size()-1);
                if (!list.isEmpty() && list.getLast() == Math.abs(asteroids[i])) list.remove(list.size()-1);
                else if(list.isEmpty() ||  list.getLast() < 0)
                    list.add(asteroids[i]);
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}