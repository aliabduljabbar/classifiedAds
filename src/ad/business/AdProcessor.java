package ad.business;

import java.util.ArrayList;

import ad.data.AdDataManager;
import ad.beans.AdBean;


public class AdProcessor {

    private static final HashProcessor hp = new HashProcessor();
    private static final AdDataManager adm = new AdDataManager();

    public AdProcessor(){
    }

    public boolean insertAd(AdBean ad){

        /*
         * All of the business logic for processing an ad will go here.
         */
        if(ad.getTitle().equals("") || ad.getCategory().equals("")){
            return false;
        } else {
            ArrayList<String> tags = hp.process(ad.getDescription());
            ad.setTags(tags);

            boolean result = adm.insertAd(ad);
            return result;
        }
    }
}
