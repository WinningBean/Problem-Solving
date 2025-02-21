import java.util.*;

class Solution {
    Map<Long, Long> roomMap;
    
    public long[] solution(long k, long[] room_number) {
        long[] checkinRoom = new long[room_number.length];
        roomMap = new HashMap<>();
        
        for (int i = 0; i < room_number.length; i++) {
            checkinRoom[i] = getPossibleRoom(room_number[i]);
        }  
        
        return checkinRoom;
    }
    
    long getPossibleRoom(long wantRoom) {
        if (!roomMap.containsKey(wantRoom)) {
            roomMap.put(wantRoom, wantRoom + 1);
            return wantRoom;
        }
        
        long possibleRoom = getPossibleRoom(roomMap.get(wantRoom));
        roomMap.put(wantRoom, possibleRoom);
        return possibleRoom;
    }
}