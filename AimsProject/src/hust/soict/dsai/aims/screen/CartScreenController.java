package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class CartScreenController {
    private Cart cart;
    private FilteredList<Media> filteredData;

    @FXML private TableView<Media> tblMedia;
    @FXML private TableColumn<Media, String> colMediaTitle;
    @FXML private TableColumn<Media, String> colMediaCategory; 
    @FXML private TableColumn<Media, Float> colMediaCost;
    
    @FXML private Button btnPlay;
    @FXML private Button btnRemove;
    @FXML private Button btnDetails; 
    
    @FXML private TextField tfFilter;
    @FXML private RadioButton radioBtnFilterId;
    @FXML private RadioButton radioBtnFilterTitle;
    @FXML private ToggleGroup filterCategory;
    
    @FXML private Label lblCost; 
    @FXML private Button btnPlaceOrder;

    public CartScreenController(Cart cart) {
        super();
        this.cart = cart;
    }

    @FXML
    private void initialize() {
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));
        
        filteredData = new FilteredList<>(this.cart.getItemsOrdered(), p -> true);
        tblMedia.setItems(filteredData);
        
        updateTotalCost();
        
        btnPlay.setVisible(false);
        btnRemove.setVisible(false);
        btnDetails.setVisible(false); 
        
        tblMedia.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Media>() {
            @Override
            public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
                if (newValue != null) {
                    updateButtonBar(newValue);
                } else {
                    btnPlay.setVisible(false);
                    btnRemove.setVisible(false);
                    btnDetails.setVisible(false);
                }
            }
        });

        tfFilter.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                showFilteredMedia(newValue);
            }
        });
    }

    void updateButtonBar(Media media) {
        btnRemove.setVisible(true);
        btnDetails.setVisible(true);
        if (media instanceof Playable) {
            btnPlay.setVisible(true);
        } else {
            btnPlay.setVisible(false);
        }
    }

    private void showFilteredMedia(String newValue) {
        filteredData.setPredicate(media -> {
            if (newValue == null || newValue.isEmpty()) return true;
            String lowerCaseFilter = newValue.toLowerCase();
            
            if (radioBtnFilterTitle.isSelected()) {
                return media.getTitle().toLowerCase().contains(lowerCaseFilter);
            } else if (radioBtnFilterId.isSelected()) {
                return String.valueOf(media.getId()).equals(lowerCaseFilter);
            }
            return false;
        });
    }
    
    private void updateTotalCost() {
        lblCost.setText(cart.totalCost() + " $");
    }

    @FXML
    void btnRemovePressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        if (media != null) {
            cart.removeMedia(media);
            updateTotalCost(); 
        }
    }

    @FXML
    void btnPlayPressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        if (media != null && media instanceof Playable) {
            try {
                ((Playable) media).play();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    void btnDetailsPressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        if (media != null) {
            System.out.println("Viewing details of: " + media.getTitle());
        }
    }

    @FXML
    void btnSortPressed(ActionEvent event) {
        Button btn = (Button) event.getSource();
        if (btn.getText().equals("Sort by Title")) {
            FXCollections.sort(cart.getItemsOrdered(), Media.COMPARE_BY_TITLE_COST);
        } else {
            FXCollections.sort(cart.getItemsOrdered(), Media.COMPARE_BY_COST_TITLE);
        }
    }

    @FXML
    void btnPlaceOrderPressed(ActionEvent event) {
        System.out.println("Order Placed!");
        cart.emptyCart(); 
        updateTotalCost(); 
    }

    @FXML
    void menuAddBook(ActionEvent event) {
        System.out.println("Add Book menu clicked");
    }

    @FXML
    void menuAddCd(ActionEvent event) {
        System.out.println("Add CD menu clicked");
    }

    @FXML
    void menuAddDvd(ActionEvent event) {
        System.out.println("Add DVD menu clicked");
    }

    @FXML
    void menuViewStore(ActionEvent event) {
        System.out.println("View Store menu clicked");
    }
}