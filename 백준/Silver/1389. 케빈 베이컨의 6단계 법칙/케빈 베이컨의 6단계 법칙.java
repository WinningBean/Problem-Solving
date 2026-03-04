import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Main{
    static int uesrLength;
    static User[] users;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        uesrLength = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        users = new User[uesrLength + 1];
        for (int i = 1; i <= uesrLength; i++) {
            users[i] = new User(i, uesrLength);
        }

        while (M-- > 0) {
            String[] connection = br.readLine().split(" ");
            User userA = users[Integer.parseInt(connection[0])];
            User userB = users[Integer.parseInt(connection[1])];

            userA.addFriend(userB);
            userB.addFriend(userA);
        }

        int minBaconNum = Integer.MAX_VALUE;
        int minBaconNumUser = 0;
        for (int i = 1; i <= uesrLength; i++) {
            setUserBaconNums(i);
            int baconNum = users[i].getBaconNum();

            if (baconNum < minBaconNum) {
                minBaconNum = baconNum;
                minBaconNumUser = i;
            }
        }

        System.out.print(minBaconNumUser);
        br.close();
    }

    static void setUserBaconNums(int id) {
        boolean[] visited = new boolean[uesrLength + 1];
        User user = users[id];
        Queue<User> userQueue = new LinkedList<User>();
        userQueue.add(user);
        visited[id] = true;

        while (!userQueue.isEmpty()) {
            User connectUser = userQueue.poll();

            for (int i = 1; i <= uesrLength; i++) {
                // 방문 안 한 직접 친구인 경우를 통해서만 관계 계산
                if (visited[i] || connectUser.baconNums[i] != 1) continue;
                visited[i] = true;
                userQueue.add(users[i]);
                // 현재 i는 연결된 user와 관계 + 1
                user.baconNums[i] = user.baconNums[connectUser.id] + 1;
            }
        }
    }
}

class User {
    int id;
    int[] baconNums;

    User(int id, int userNum) {
        this.id = id;
        baconNums = new int[userNum + 1];
    }

    void addFriend(User friend) {
        baconNums[friend.id] = 1;
    }

    int getBaconNum() {
        int sum = 0;
        for (int i = 1; i < baconNums.length; i++) {
            sum += baconNums[i];
        }
        return sum;
    }
}