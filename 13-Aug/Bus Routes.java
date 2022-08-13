//https://leetcode.com/problems/bus-routes/

class Solution {
            
    public int numBusesToDestination(int[][] routes, int S, int T) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            for (int j = 0; j < routes[i].length; j++) {
                int busStop = routes[i][j];

                ArrayList<Integer> busNo = map.getOrDefault(busStop, new ArrayList<>());
                busNo.add(i);
                map.put(busStop, busNo);
            }
        }

        Queue<Integer> qu = new ArrayDeque<>();
        qu.add(S);
        HashSet<Integer> busStopVis = new HashSet<>();
        HashSet<Integer> busNoVis = new HashSet<>();
        busStopVis.add(S);

        int level = 0;
        while (qu.size() > 0) {
            int size = qu.size();
            while (size-- > 0) {
                int rem = qu.remove();
                if (rem == T) {
                    return level;
                }

                ArrayList<Integer> buses = map.get(rem);
                for (int busNo : buses) {
                    if (busNoVis.contains(busNo) == true) {
                        continue;
                    }

                    int[] arr = routes[busNo];
                    for (int busStopNo : arr) {
                        if (busStopVis.contains(busStopNo) == true) {
                            continue;
                        }
                        qu.add(busStopNo);
                        busStopVis.add(busStopNo);
                    }
                    busNoVis.add(busNo);
                }
            }
            level++;
        }
        return -1;

    }
}
