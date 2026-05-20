package hust.soict.dsai.aims.store;
import hust.soict.dsai.aims.media.Media;
import java.util.ArrayList;

public class Store {
    
	private ArrayList<Media> itemsInStore = new ArrayList<Media>();
    private static final int MAX_CAPACITY = 100;

    public Store() {
      
    }

    public void addMedia(Media media) {
        if (itemsInStore.size() < MAX_CAPACITY) {
        	if (!itemsInStore.contains(media)) {
        		itemsInStore.add(media);
        		System.out.println("The meida \"" + media.getTitle() + "\" has been added to the store.");
        	} else {
        		System.out.println("The media is already in the store.");
        	}
        }else {
        	System.out.println("The store is full, cannot add more media.");
        }
    }

    public void removeMedia(Media media) {
    	if (itemsInStore.contains(media)) {
            itemsInStore.remove(media);
            System.out.println("The media \"" + media.getTitle() + "\" has been removed from the store.");
        } else {
            System.out.println("The media is not found in the store.");
        }
    }
    
    public ArrayList<Media> getItemsInStore() {
        return itemsInStore;
    }
    
    public Media fetchMedia(String title) {
        for (Media m : itemsInStore) {
            if (m.getTitle().equalsIgnoreCase(title)) {
                return m;
            }
        }
        return null;
    }

}