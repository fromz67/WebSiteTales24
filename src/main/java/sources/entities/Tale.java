package sources.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Tale implements Serializable {
    private static final long serialVersionUID = 1L;

    private String title;
    private int likes;
    private String taleText;
    private Set<String> likedUsers = new HashSet<>();
    private Set<String> favoriteUsers = new HashSet<>();


    public Tale() {
        this.title = "";
        this.likes = 0;
        this.taleText = "";
    }

    public Tale(String title, int likes, String taleText) {
        this.title = title;
        this.likes = likes;
        this.taleText = taleText;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public String getTaleText() {
        return taleText;
    }

    public void setTaleText(String taleText) {
        this.taleText = taleText;
    }

    public Set<String> getLikedUsers() {
        return likedUsers;
    }

    public Set<String> getFavoriteUsers() {
        return favoriteUsers;
    }
    
    public void like(String user) {
        if (likedUsers.contains(user)) {
            likedUsers.remove(user);
            likes--;
        } else {
            likedUsers.add(user);
            likes++;
        }
    }

    public void addToFavorites(String user) {
        favoriteUsers.add(user);
    }

    public void removeFromFavorites(String user) {
        favoriteUsers.remove(user);
    }
}
