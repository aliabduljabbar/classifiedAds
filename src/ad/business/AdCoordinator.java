package ad.business;


public class AdCoordinator {

    public AdCoordinator() {
    }

    public boolean Create(String title, int quality, int price) {
        /*
         * Here I would implement the business logic that will validate the input, query from data class i-e: AdDataManager,
         * which will contact the database layer.
         */
        if (title.equals("HP core i7") && quality >= 7 && price>1000)
            return true;
        return false;
    }

}
