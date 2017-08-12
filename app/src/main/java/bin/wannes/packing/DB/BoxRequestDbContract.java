package bin.wannes.packing.DB;

import android.provider.BaseColumns;

/**
 * Created by wannes on 11-8-2017.
 */

public class BoxRequestDbContract {


    private BoxRequestDbContract() {
    }

    public static class BoxRequestEntry implements BaseColumns {
        public static final String TABLE_NAME = "box_request";
        public static final String REQUEST_NAME = "box_request_name";
        public static final String BOX1_LENGTH = "box1_length";
        public static final String BOX1_WIDTH = "box1_width";
        public static final String BOX1_HEIGHT = "box1_height";
        public static final String BOX2_LENGTH = "box2_length";
        public static final String BOX2_WIDTH = "box2_width";
        public static final String BOX2_HEIGHT = "box2_height";
        public static final String COLUMN_LENGTH = "column_length";
        public static final String COLUMN_WIDTH = "column_width";
        public static final String COLUMN_HEIGHT = "column_height";
        public static final String COLUMN_POCKETS = "column_pockets";
        public static final String COLUMN_AMOUNT = "column_amount";
    }
}
