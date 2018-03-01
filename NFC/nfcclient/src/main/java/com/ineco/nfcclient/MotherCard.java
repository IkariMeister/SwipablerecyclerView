package com.ineco.nfcclient;

import com.ineco.nfc.entities.Card;
import com.ineco.nfc.entities.FakeCard;

/**
 * Created by jcgarcia on 11/04/2017.
 */

public class MotherCard {

    public Card getFakeCard(){
        return new FakeCard(1,2.2f,"Fake Card","Darth Vader");
    }

}
