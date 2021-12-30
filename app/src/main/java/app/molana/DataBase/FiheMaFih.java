package app.molana.DataBase;

public class FiheMaFih {

    public int id, favorite;
    public String title, content;

    public FiheMaFih(int id, int favorite, String title, String content) {
        this.id = id;
        this.favorite = favorite;
        this.title = title;
        this.content = content;
    }

    public FiheMaFih() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFavorite() {
        return favorite;
    }

    public void setFavorite(int favorite) {
        this.favorite = favorite;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
