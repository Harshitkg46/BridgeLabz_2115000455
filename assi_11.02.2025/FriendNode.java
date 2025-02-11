import java.util.*;

class FriendNode {
    int friendId;
    FriendNode next;

    public FriendNode(int friendId) {
        this.friendId = friendId;
        this.next = null;
    }
}

class UserNode {
    int userId;
    String name;
    int age;
    FriendNode friendListHead; // Head of the friend's linked list
    UserNode next;

    public UserNode(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friendListHead = null;
        this.next = null;
    }
}

class SocialMedia {
    private UserNode userListHead = null;

    // Add a new user to the user list
    public void addUser(int userId, String name, int age) {
        UserNode newUser = new UserNode(userId, name, age);
        if (userListHead == null) {
            userListHead = newUser;
        } else {
            UserNode temp = userListHead;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newUser;
        }
        System.out.println("User added: " + name);
    }

    // Find a user by User ID
    private UserNode findUserById(int userId) {
        UserNode temp = userListHead;
        while (temp != null) {
            if (temp.userId == userId) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    // Add a friend connection between two users
    public void addFriend(int userId1, int userId2) {
        UserNode user1 = findUserById(userId1);
        UserNode user2 = findUserById(userId2);

        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }

        addFriendToList(user1, userId2);
        addFriendToList(user2, userId1);
        System.out.println("Friend connection added between " + user1.name + " and " + user2.name);
    }

    // Add a friend to the friend's list
    private void addFriendToList(UserNode user, int friendId) {
        FriendNode newFriend = new FriendNode(friendId);
        if (user.friendListHead == null) {
            user.friendListHead = newFriend;
        } else {
            FriendNode temp = user.friendListHead;
            while (temp.next != null) {
                if (temp.friendId == friendId) return; // Avoid duplicate connections
                temp = temp.next;
            }
            temp.next = newFriend;
        }
    }

    // Remove a friend connection
    public void removeFriend(int userId1, int userId2) {
        UserNode user1 = findUserById(userId1);
        UserNode user2 = findUserById(userId2);

        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }

        removeFriendFromList(user1, userId2);
        removeFriendFromList(user2, userId1);
        System.out.println("Friend connection removed between " + user1.name + " and " + user2.name);
    }

    // Remove a friend from the friend's list
    private void removeFriendFromList(UserNode user, int friendId) {
        FriendNode temp = user.friendListHead, prev = null;

        while (temp != null && temp.friendId != friendId) {
            prev = temp;
            temp = temp.next;
        }

        if (temp == null) return; // Friend not found

        if (prev == null) {
            user.friendListHead = temp.next; // Remove head
        } else {
            prev.next = temp.next; // Remove intermediate or tail node
        }
    }

    // Find mutual friends between two users
    public void findMutualFriends(int userId1, int userId2) {
        UserNode user1 = findUserById(userId1);
        UserNode user2 = findUserById(userId2);

        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }

        List<Integer> mutualFriends = new ArrayList<>();
        FriendNode friend1 = user1.friendListHead;

        while (friend1 != null) {
            FriendNode friend2 = user2.friendListHead;
            while (friend2 != null) {
                if (friend1.friendId == friend2.friendId) {
                    mutualFriends.add(friend1.friendId);
                }
                friend2 = friend2.next;
            }
            friend1 = friend1.next;
        }

        System.out.println("Mutual Friends:");
        for (int id : mutualFriends) {
            System.out.println("Friend ID: " + id);
        }
    }

    // Display all friends of a specific user
    public void displayFriends(int userId) {
        UserNode user = findUserById(userId);

        if (user == null) {
            System.out.println("User not found.");
            return;
        }

        System.out.println("Friends of " + user.name + ":");
        FriendNode temp = user.friendListHead;

        while (temp != null) {
            System.out.println("Friend ID: " + temp.friendId);
            temp = temp.next;
        }
    }

    // Search for a user by Name or User ID
    public void searchUser(String nameOrId) {
        UserNode temp = userListHead;

        while (temp != null) {
            if (temp.name.equals(nameOrId) || String.valueOf(temp.userId).equals(nameOrId)) {
                System.out.println("User found: " + temp.name + ", ID: " + temp.userId + ", Age: " + temp.age);
                return;
            }
            temp = temp.next;
        }
        System.out.println("User not found.");
    }

    // Count the number of friends for each user
    public void countFriends() {
        UserNode temp = userListHead;

        while (temp != null) {
            int count = 0;
            FriendNode friendTemp = temp.friendListHead;

            while (friendTemp != null) {
                count++;
                friendTemp = friendTemp.next;
            }

            System.out.println("User " + temp.name + " has " + count + " friend(s).");
            temp = temp.next;
        }
    }
}

class Main {
    public static void main(String[] args) {
        SocialMedia socialMedia = new SocialMedia();

        // Add users
        socialMedia.addUser(1, "Alice", 25);
        socialMedia.addUser(2, "Bob", 28);
        socialMedia.addUser(3, "Charlie", 22);

        // Add friend connections
        socialMedia.addFriend(1, 2);
        socialMedia.addFriend(1, 3);

        // Display friends
        socialMedia.displayFriends(1);
        socialMedia.displayFriends(2);

        // Find mutual friends
        socialMedia.findMutualFriends(1, 2);

        // Search user
        socialMedia.searchUser("Alice");
        socialMedia.searchUser("3");

        // Count friends for each user
        socialMedia.countFriends();

        // Remove friend connection
        socialMedia.removeFriend(1, 2);

        // Display friends after removal
        socialMedia.displayFriends(1);
        socialMedia.displayFriends(2);

        // Count friends after removal
        socialMedia.countFriends();
    }
}
