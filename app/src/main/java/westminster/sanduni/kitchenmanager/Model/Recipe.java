package westminster.sanduni.kitchenmanager.Model;

import com.google.gson.annotations.SerializedName;

public class Recipe {

    @SerializedName("publisher")
    private String publisher;

    @SerializedName("f2f_url")
    private String f2f_url;

    @SerializedName("title")
    private String title;

    @SerializedName("source_url")
    private String source_url;

    @SerializedName("recipe_id")
    private String recipe_id;

    @SerializedName("image_url")
    private String image_url;

    @SerializedName("social_rank")
    private double social_rank;

    @SerializedName("publisher_url")
    private String publisher_url;

    public Recipe() {
    }

    public Recipe(String publisher, String f2f_url, String title, String source_url,
                  String recipe_id, String image_url, double social_rank, String publisher_url) {
        this.publisher = publisher;
        this.f2f_url = f2f_url;
        this.title = title;
        this.source_url = source_url;
        this.recipe_id = recipe_id;
        this.image_url = image_url;
        this.social_rank = social_rank;
        this.publisher_url = publisher_url;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getF2fUrl() {
        return f2f_url;
    }

    public void setF2fUrl(String f2f_url) {
        this.f2f_url = f2f_url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSourceUrl() {
        return source_url;
    }

    public void setSourceUrl(String source_url) {
        this.source_url = source_url;
    }

    public String getRecipeId() {
        return recipe_id;
    }

    public void setRecipeId(String recipe_id) {
        this.recipe_id = recipe_id;
    }

    public String getImageUrl() {
        return image_url;
    }

    public void setImageUrl(String image_url) {
        this.image_url = image_url;
    }

    public double getSocialRank() {
        return social_rank;
    }

    public void setSocialRank(double social_rank) {
        this.social_rank = social_rank;
    }

    public String getPublisherUrl() {
        return publisher_url;
    }

    public void setPublisherUrl(String publisher_url) {
        this.publisher_url = publisher_url;
    }
}
