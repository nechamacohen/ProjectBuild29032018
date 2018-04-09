package cohen.nechama.projectbuild.obj;

import java.util.ArrayList;

import cohen.nechama.projectbuild.R;

/**
 * Created by 123 on 21/03/2018.
 */

public class ContactDataSource {

    public static ArrayList<Contant> getDataContant(){
        ArrayList<Contant> dataContant = new ArrayList<>();
        dataContant.add(new Contant("נחמי כהן","קומה 5 דירה 22","052-7137036", R.drawable.icon ));
        dataContant.add(new Contant("חיים לוי","קומה 7 דירה 34","052-5674569", R.drawable.icon2 ));
        dataContant.add(new Contant("דני שבתאי","קומה 8 דירה 37","052-3491123", R.drawable.google ));

        return dataContant;

    }
}
