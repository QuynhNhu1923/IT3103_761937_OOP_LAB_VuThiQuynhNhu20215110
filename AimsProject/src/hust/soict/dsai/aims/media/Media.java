package hust.soict.dsai.aims.media;
import java.util.Comparator;

public abstract class Media {
    private int id;
    private String title;
    private String category;
    private float cost;
    
    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();

    public Media() {}

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public float getCost() { return cost; }
    public void setCost(float cost) { this.cost = cost; }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null ||!(obj instanceof Media)) return false;
        Media media = (Media) obj;
        return this.title != null && this.title.equals(media.getTitle());
    }
    
    @Override
    public String toString() {
        return "Media [id=" + id + ", title=" + title + ", category=" + category + ", cost=" + cost + "$]";
    }
}