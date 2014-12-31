package ad.business;

import java.util.ArrayList;

import ad.data.AdDataManager;


public class AdProcessor {

    private static final HashProcessor hp = new HashProcessor();
    private static final AdDataManager adm = new AdDataManager();

    public AdProcessor(){
    }

    public boolean insertAd(String ad_title, String ad_category, String ad_description, ArrayList<String> filesList, String ad_location){

        /*
         * All of the business logic for processing an ad will go here.
         */
        if(ad_title.equals("") || ad_category.equals("") || ad_description.equals("") || filesList.isEmpty() || ad_location.equals(""))
            return false;
        else{
            ArrayList<String> hashtags = hp.process(ad_description);
            adm.insertAd(ad_title, ad_category, ad_description, filesList, ad_location, hashtags);
        }
        return true;
    }
}
