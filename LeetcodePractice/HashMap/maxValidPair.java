public int maxValidPair(int[] array) {
        Map<Integer, List<Integer>> map1 = new HashMap<>();
        Map<Integer, List<Integer>> map2 = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (!map1.containsKey(array[i] - i)) {
                map1.put(array[i] - i, new ArrayList<>());
            }
            map1.get(array[i] - i).add(i);
            if (!map2.containsKey(array[i] + i)) {
                map2.put(array[i] + i, new ArrayList<>());
            }
            map2.get(array[i] + i).add(i);
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            int size1 = map1.get(array[i] - i).size();
            int pair1 = map1.get(array[i] - i).get(size1 - 1) - map1.get(array[i] - i).get(0);
            max = Math.max(pair1, max);
        }
        for (int i = 0; i < array.length; i++) {
            int size2 = map2.get(array[i] + i).size();
            int pair2 = map2.get(array[i] + i).get(size2 - 1) - map2.get(array[i] + i).get(0);
            max = Math.max(pair2, max);
        }
        return max;
}
