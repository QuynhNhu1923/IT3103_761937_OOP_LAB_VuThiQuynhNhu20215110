package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {
	
	private static int nbDigitalVideoDiscs = 0;
	
	public DigitalVideoDisc(String title) {
        super();
        this.setTitle(title);
        nbDigitalVideoDiscs++;        
        this.setId(nbDigitalVideoDiscs); // Dùng setter của lớp Media
    }
	
    public DigitalVideoDisc(String title, String category, float cost) {
        super();
        this.setTitle(title);
        this.setCategory(category);
        this.setCost(cost);
        nbDigitalVideoDiscs++;        
        this.setId(nbDigitalVideoDiscs);
    }
    
	public DigitalVideoDisc(String title, String category, String director, float cost) {
        super();
        this.setTitle(title);
        this.setCategory(category);
        this.setDirector(director); // Dùng setter của lớp Disc
        this.setCost(cost);
        nbDigitalVideoDiscs++;        
        this.setId(nbDigitalVideoDiscs);
    }
    
    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super();
        this.setTitle(title);
        this.setCategory(category);
        this.setDirector(director);
        this.setLength(length);
        this.setCost(cost);
        nbDigitalVideoDiscs++;        
        this.setId(nbDigitalVideoDiscs);
    }
    
    public boolean isMatch(String title) {
        return this.getTitle().equalsIgnoreCase(title);
    }
    
    @Override
    public void play() {
        if (this.getLength() > 0) {
            System.out.println("Playing DVD: " + this.getTitle());
            System.out.println("DVD length: " + this.getLength());
        } else {
            System.out.println("Cannot play DVD: " + this.getTitle() + " (Length <= 0)");
        }
    }

    @Override
    public String toString() {
        return "DVD - " + getTitle() + " - " + getCategory() + " - Director: " + getDirector() + " - Length: " + getLength() + " - " + getCost() + "$";
    }
}