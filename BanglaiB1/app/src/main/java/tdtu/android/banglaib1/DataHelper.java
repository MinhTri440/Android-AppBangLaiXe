package tdtu.android.banglaib1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;


public class DataHelper extends SQLiteOpenHelper {
    private static final String TAG = "SQLite";

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "dataB1";
    private static final String TABLE_LYTHUYET = "lythuyets";

    private static final String COLUMN_LYTHUYET_CAU = "cau";
    private static final String COLUMN_LYTHUYET_DE = "de";
    private static final String COLUMN_LYTHUYET_HINH = "hinh";
    private static final String COLUMN_LYTHUYET_A = "a";
    private static final String COLUMN_LYTHUYET_B = "b";
    private static final String COLUMN_LYTHUYET_C = "c";
    private static final String COLUMN_LYTHUYET_D = "d";
    private static final String COLUMN_LYTHUYET_CAUDUNG = "caudung";
    private static final String COLUMN_LYTHUYET_BODE = "bode";
    private static final String COLUMN_LYTHUYET_SOCAU = "socau";
    private static final String COLUMN_LYTHUYET_CAULIET = "cauliet";
    private static final String COLUMN_LYTHUYET_TRALOI = "traloi";

    private static final String TABLE_BIENBAO = "bienbaos";
    private static final String COLUMN_BIENBAO_ID = "id";
    private static final String COLUMN_BIENBAO_HINH = "hinh";
    private static final String COLUMN_BIENBAO_NOIDUNG = "noidung";
    private static final String COLUMN_BIENBAO_LOAI = "loai";











    public DataHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    //tao bang trong database
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // /data/data/packagename/dataB1
        Log.i(TAG, "EventDatabaseHelper.onCreate ... ");
        // Create Lythuyer tables.
        String script = "CREATE TABLE " + TABLE_LYTHUYET + "("
                + COLUMN_LYTHUYET_CAU + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_LYTHUYET_DE + " TEXT NOT NULL,"
                + COLUMN_LYTHUYET_HINH + " TEXT,"
                + COLUMN_LYTHUYET_A + " TEXT,"
                + COLUMN_LYTHUYET_B + " TEXT,"
                + COLUMN_LYTHUYET_C + " TEXT,"
                + COLUMN_LYTHUYET_D + " TEXT,"
                + COLUMN_LYTHUYET_CAUDUNG + " TEXT,"
                + COLUMN_LYTHUYET_BODE + " INTEGER,"
                + COLUMN_LYTHUYET_SOCAU + " INTEGER,"
                + COLUMN_LYTHUYET_TRALOI + " TEXT,"
                + COLUMN_LYTHUYET_CAULIET + " INTEGER)";
        //Create bienbao tables
        String script2= "CREATE TABLE " + TABLE_BIENBAO + "("
                +COLUMN_BIENBAO_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"
                +COLUMN_BIENBAO_HINH+" TEXT,"
                +COLUMN_BIENBAO_NOIDUNG+" TEXT,"
                +COLUMN_BIENBAO_LOAI+" TEXT)";
        // execute the script.
        sqLiteDatabase.execSQL(script);
        sqLiteDatabase.execSQL(script2);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    //lay ra tong so cau
    public int getLythuyetsCount() {
        Log.i(TAG, "EventDatabaseHelper.getNotesCount ... ");

        String countQuery = "SELECT  * FROM " + TABLE_LYTHUYET;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        int count = cursor.getCount();

        cursor.close();

        // return count
        return count;
    }
    public int getLythuyetsLIETCount() {
        Log.i(TAG, "EventDatabaseHelper.getNotesCount ... ");

        String countQuery = "SELECT  * FROM " + TABLE_LYTHUYET+" WHERE "+ COLUMN_LYTHUYET_CAULIET+"=1";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        int count = cursor.getCount();

        cursor.close();

        // return count
        return count;
    }
    //lay ra so bien bao
    public int getBienbaosCount() {
        Log.i(TAG, "EventDatabaseHelper.getNotesCount ... ");

        String countQuery = "SELECT  * FROM " + TABLE_BIENBAO;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        int count = cursor.getCount();

        cursor.close();

        // return count
        return count;
    }
    //them cau lythuyet
    public void addLythuyet(List<Lythuyet> lythuyet) {
        for (Lythuyet e :lythuyet
             ) {


            Log.i(TAG, "EventDatabaseHelper.addEvent ... " + e.getDe());

            SQLiteDatabase db = this.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put(COLUMN_LYTHUYET_DE, e.getDe());
            values.put(COLUMN_LYTHUYET_HINH, e.getHinh());
            values.put(COLUMN_LYTHUYET_A, e.getA());
            values.put(COLUMN_LYTHUYET_B, e.getB());
            values.put(COLUMN_LYTHUYET_C, e.getC());
            values.put(COLUMN_LYTHUYET_D, e.getD());
            values.put(COLUMN_LYTHUYET_CAUDUNG, e.getCaudung());
            values.put(COLUMN_LYTHUYET_BODE, e.getBode());
            values.put(COLUMN_LYTHUYET_SOCAU, e.getSocau());
            values.put(COLUMN_LYTHUYET_CAULIET, e.getCauliet());

            // Insert a new row to table
            db.insert(TABLE_LYTHUYET, null, values);
            db.close();
        }

        // Close database connection.
    }
    //them cau bienbao
    public void addBienbao(List<Bienbao> bienbaos) {
        for (Bienbao e :bienbaos
        ) {


            Log.i(TAG, "EventDatabaseHelper.addEvent ... " );

            SQLiteDatabase db = this.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put(COLUMN_LYTHUYET_DE, e.getHinh());
            values.put(COLUMN_LYTHUYET_HINH, e.getNoidung());
            values.put(COLUMN_LYTHUYET_A, e.getLoai());

            // Insert a new row to table
            db.insert(TABLE_BIENBAO, null, values);
            db.close();
        }

        // Close database connection.
    }
    public void createDefaultLythuyet() {
        int count = this.getLythuyetsCount();
        if (count == 0) {
            List<Lythuyet> a = new ArrayList();
            //Lythuyet cexample = new Lythuyet("","","","","","","",1,3,0);
            //a.add(c3);
            Lythuyet c1 = new Lythuyet("Phần của đường bộ được sử dụng cho các phương tiện giao thông qua lại là gì?","questionimg","Phần mặt đường và lề đường.","Phần đường xe chạy.","Phần đường xe cơ giới.","","Phần đường xe chạy.",1,3,0,"");
            a.add(c1);
            Lythuyet c2 = new Lythuyet("Việc lái xe mô tô, ô tô, máy kéo ngay sai khi uống rượu, bia có được phép không ?","questionimg","Không được phép.","Chỉ được lái ở tốc độ chậm và quãng đường ngắn.","Chỉ được lái nếu trong cơ thể có nồng độ cồn thấp.","","Không được phép.",1,3,0,"");
            a.add(c2);
            Lythuyet c3 = new Lythuyet("Bạn đang lái xe trong khu dân cư, có đông xe qua lại, nếu muốn quay đầu xe bạn cần làm gì để tránh ùn tắc và đảm bảo an toàn giao thông?","questionimg","Đi tiếp đến điểm giao cắt gần nhất hoặc nơi có biển báo cho phép quay đầu xe.","Bấm đèn khẩn cấp và quay đầu xe từ từ bảo đảm an toàn","Bấm còi liên tục khi quay đầu xe để cảnh báo các xe khác","Nhờ một người ra hiệu giao thông trên đường chậm lại trước khi quay đầu xe","Đi tiếp đến điểm giao cắt gần nhất hoặc nơi có biển báo cho phép quay đầu xe.",1,4,0,"");
            a.add(c3);
            Lythuyet c4 = new Lythuyet("Người có giấy phép lái xe mô tô hạng A1 được phép điều khiển các loại xe nào dưới đây ?","questionimg","Xe mô tô có dung tích xi-lanh từ 50 Cm3 đến dưới 175 cm3","Xe mô tô ba bánh dành cho người khuyết tật","Cả ý 1 và ý 2","","Cả ý 1 và ý 2",1,3,0,"");
            a.add(c4);
            Lythuyet c5 = new Lythuyet("Khi sử dụng giấy phép lái xe đã khai báo mất để điều khiển phương tiện cơ giới đường bộ, ngoài việc bị thu hồi giấy phép lái xe, chịu trách nhiệm trước pháp luật, người lái xe không được cấp giấy phép lái xe trong thời gian bao nhiêu năm ?","questionimg","02 Năm.","03 Năm.","05 Năm."," 04 Năm.","05 Năm.",1,4,0,"");
            a.add(c5);
            Lythuyet c6 = new Lythuyet("Trên đường cao tốc, người lái xe phải dừng xe, đỗ xe như thế nào để đảm bảo an toàn giao thông ?","questionimg","Không được dừng xe, đỗ xe hoặc chỉ được dừng xe, đỗ xe ở nơi đường rộng, nếu dừng, đỗ xe ở nơi đường hẹp phải sử dụng còi báo hiệu để người lái xe khác biết.","Chỉ được dừng xe, đỗ xe ở nơi quy định, trường hợp buộc phải dừng xe, đỗ xe không đúng nơi quy định thì người lái xe phải đưa xe ra khỏi phần đường xe chạy, nếu không thể được thì phải báo hiệu để người lái xe khác biết.","Chỉ được dừng xe, đỗ xe ở nơi đường rộng; trường hợp dừng xe, đỗ xe tại nơi đường hẹp phải đặt các chướng ngại vật trên đường để yêu cầu người lái xe khác giảm tốc độ để bảo đảm an toàn.","","Chỉ được dừng xe, đỗ xe ở nơi quy định, trường hợp buộc phải dừng xe, đỗ xe không đúng nơi quy định thì người lái xe phải đưa xe ra khỏi phần đường xe chạy, nếu không thể được thì phải báo hiệu để người lái xe khác biết.",1,3,0,"");
            a.add(c6);
            Lythuyet c7 = new Lythuyet("Khi lái xe trên đường vắng mà cảm thấy buồn ngủ, người lái xe nên chọn cách xử lý như thế nào cho phù hợp ?","questionimg","Tăng tốc độ kết hợp với nghe nhạc và đi tiếp.","Quan sát và dừng xe tại nơi quy định; nghỉ cho đến khi hết buồn ngủ và đi tiếp.","Sử dụng một ít rượu hoặc bia để hết buồn ngủ và đi tiếp.","","Quan sát và dừng xe tại nơi quy định; nghỉ cho đến khi hết buồn ngủ và đi tiếp.",1,3,0,"");
            a.add(c7);
            Lythuyet c8 = new Lythuyet("Khi tham gia giao thông trên đoạn đường không có biển báo “cự ly tối thiểu giữa hai xe”, với điều kiện mặt đường khô ráo, xe cơ giới đang chạy với tốc độ từ trên 60km/h đến 80km/h, người lái xe phải duy trì ở khoảng cách an toàn với xe đang chạy phía trước tối thiểu là bao nhiêu mét ?","questionimg","35 mét."," 55 mét.","70 mét.",""," 55 mét.",1,3,0,"");
            a.add(c8);
            Lythuyet c9 = new Lythuyet("Khi xe gặp sự cố kỹ thuật trên đường cao tốc, bạn phải xử lý theo thứ tự như thế nào dưới đây để đảm bảo an toàn giao thông ?","questionimg","Bật đèn tín hiệu khẩn cấp, dừng xe ngay lập tức và đặt biển báo hiệu nguy hiểm để cảnh báo cho các xe khác.","Bật đèn tín hiệu khẩn cấp, lập tức đưa xe vào làn đường xe chạy bên phải trong cùng, đặt biển báo hiệu nguy hiểm để cảnh báo cho các xe khác.","Bật đèn tín hiệu khẩn cấp, khi đủ điều kiện an toàn nhanh chóng đưa xe vào làn dừng đỗ khẩn cấp , đặt hiển báo hiệu nguy hiểm để cảnh báo cho các xe khác.","","Bật đèn tín hiệu khẩn cấp, khi đủ điều kiện an toàn nhanh chóng đưa xe vào làn dừng đỗ khẩn cấp , đặt hiển báo hiệu nguy hiểm để cảnh báo cho các xe khác.",1,3,0,"");
            a.add(c9);
            Lythuyet c10 = new Lythuyet("Người hành nghề lái xe khi thực hiện tốt việc rèn luyện, nâng cao trách nhiệm, đạo đức nghề nghiệp sẽ thu được kết quả như thế nào ?","questionimg","Được khách hàng, xã hội tôn trọng; được đồng nghiệp quý mến, giúp đỡ; được doanh nghiệp tin dùng và đóng góp nhiều cho xã hội.","Thu hút được khách hàng, góp phần quan trọng trong xây dựng thương hiệu, kinh doanh có hiệu quả cao","Cả ý 1 và ý 2.","","Cả ý 1 và ý 2.",1,3,0,"");
            a.add(c10);
            Lythuyet c11 = new Lythuyet("Khi điều khiển ô tô tự đổ, người lái xe cần chú ý những điểm gì để đảm bảo an toàn ?","questionimg"," Khi chạy trên đường xấu, nhiều ổ gà nên chạy chậm để thùng xe không bị lắc mạnh, không gây hiện tượng lệch “ben”; khi chạy vào đường vòng, cần giảm tốc độ, không lấy lái gấp và không phanh gấp.","Khi chạy trên đường quốc lộ, đường bằng phẳng không cần hạ hết thùng xe xuống.","Khi đổ hàng phải chọn vị trí có nền đường cứng và phẳng, dừng hẳn xe, kéo chặt phanh tay; sau đó mới điều khiển cơ cấu nâng “ben” để đỡ hàng, đổ xong hàng mới hạ thùng xuống.","Cả ý 1 và ý 3.","Cả ý 1 và ý 3.",1,4,0,"");
            a.add(c11);
            Lythuyet c12 = new Lythuyet("Khi điều khiển ô tô có hộp số tự động, người lái xe sử dụng chân như thế nào là đúng để đảm bảo an toàn ?","questionimg","Không sử dụng chân trái; chân phải điều khiển bàn đạp phanh và bàn đạp ga.","Chân trái điều khiển bàn đạp phanh, chân phải điều khiển bàn đạp ga.","Không sử dụng chân phải; chân trái điều khiển bàn đạp phanh và bàn đạp ga.","","Không sử dụng chân trái; chân phải điều khiển bàn đạp phanh và bàn đạp ga.",1,3,0,"");
            a.add(c12);
            Lythuyet c13 = new Lythuyet("Tay ga trên xe mô tô hai bánh có tác dụng gì trong các trường hợp dưới đây ?","questionimg","Để điều khiển xe chạy về phía trước.","Để điều tiết công suất động cơ qua đó điều khiển tốc độ của xe.","Để điều khiển xe chạy lùi."," Cả ý 1 và ý 2."," Cả ý 1 và ý 2.",1,4,0,"");
            a.add(c13);
            Lythuyet c14 = new Lythuyet("Hãy nêu công dụng ly hợp (côn) của ô tô ?","questionimg","Dùng để truyền mô men xoắn giữa các trục không cùng nằm trên một đường thẳng và góc lệch trục luôn thay đổi trong quá trình ô tô chuyển động.","Dùng để truyền hoặc ngắt truyền động từ động cơ đến hộp số của ô tô.","Dùng để truyền truyền động từ hộp số đến bánh xe chủ động của ô tô.","","Dùng để truyền hoặc ngắt truyền động từ động cơ đến hộp số của ô tô.",1,3,0,"");
            a.add(c14);
            Lythuyet c15 = new Lythuyet("Biển nào báo hiệu cấm xe mô tô ba bánh đi vào ?","l15","Biển 1 và 2.","Biển 1 và 3.","Biển 2 và 3.","","Biển 1 và 2.",1,3,0,"");
            a.add(c15);
            Lythuyet c16 = new Lythuyet("Biển nào được phép quay đầu nhưng không được rẽ trái ?","l16","Biển 1.","Biển 2.","Cả 2 biển.","","Biển 1.",1,3,0,"");
            a.add(c16);
            Lythuyet c17 = new Lythuyet("Khi gặp biển này, xe mô tô ba bánh có được phép rẽ trái hoặc rẽ phải hay không ?","l17","Được phép.","Không được phép.","","","Không được phép.",1,2,0,"");
            a.add(c17);
            Lythuyet c18 = new Lythuyet("Số 50 trên biển báo dưới đây có ý nghĩa gì ?","l18","Tốc độ tối đa các xe cơ giới được phép chạy.","Tốc độ tối thiểu các xe cơ giới được phép chạy.","","","Tốc độ tối đa các xe cơ giới được phép chạy.",1,3,0,"");
            a.add(c18);
            Lythuyet c19 = new Lythuyet("Biển nào báo hiệu “Đường bị thu hẹp” ?","l19"," Biển 1 và 2.","Biển 1 và 3.","Biển 2 và 3.","Biển 2 và 3."," Biển 1 và 2.",1,4,0,"");
            a.add(c19);
            Lythuyet c20 = new Lythuyet("Biển nào sau đây là biển “ Kè, vực sâu bên đường phía bên trái” ?","l20","Biển 1.","Biển 2.","Biển 3.","Biển 1 và Biển 2.","Biển 3.",1,4,0,"");
            a.add(c20);
            Lythuyet c21 = new Lythuyet("Gặp biển báo này người lái xe phải xử lý thế nào ?","l21","Đi chậm, quan sát và dừng lại nếu gặp gia súc trên đường.","Bấm còi to để gia súc tránh đường và nhanh chóng di chuyển qua đoạn đường có gia súc.","","","Đi chậm, quan sát và dừng lại nếu gặp gia súc trên đường.",1,2,0,"");
            a.add(c21);
            Lythuyet c22 = new Lythuyet("Biển nào chỉ dẫn tên đường trên các tuyến đường đối ngoại ?","l22","Biển 1.","Biển 2.","Biển 3.","Biển 1 và 2.","Biển 3.",1,4,0,"");
            a.add(c22);
            Lythuyet c23 = new Lythuyet("Biển nào báo hiệu kết thúc đường cao tốc ?","l23"," Biển 1.","Biển 2.","Biển 3.","","Biển 2.",1,3,0,"");
            a.add(c23);
            Lythuyet c24 = new Lythuyet("Thứ tự các xe đi như thế nào là đúng quy tắc giao thông ?","l24","Xe tải, xe khách, xe con, mô tô.","Xe tải, mô tô, xe khách, xe con.","Xe khách, xe tải, xe con, mô tô.","Mô tô, xe khách, xe tải, xe con.","Xe tải, mô tô, xe khách, xe con.",1,4,0,"");
            a.add(c24);
            Lythuyet c25 = new Lythuyet("Theo hướng mũi tên, những hướng nào xe gắn máy đi được ?","l25","Cả ba hướng.","Chỉ hướng 1 và 3.","Chỉ hướng 1.","","Cả ba hướng.",1,3,0,"");
            a.add(c25);
            Lythuyet c26 = new Lythuyet("Những hướng nào ô tô tải được phép đi ?","l26","Chỉ hướng 1.","Hướng 1 và 4.","Hướng 1 và 5.","Hướng 1, 4 và 5.","Hướng 1 và 5.",1,4,0,"");
            a.add(c26);
            Lythuyet c27 = new Lythuyet("Trong hình dưới, những xe nào vi phạm quy tắc giao thông ?","l27","Xe con ( E ), mô tô ( C ).","Xe tải ( A ), mô tô ( D ).","Xe khách ( B ), mô tô ( C ).","Xe khách ( B ), mô tô ( D ).","Xe con ( E ), mô tô ( C ).",1,4,0,"");
            a.add(c27);
            Lythuyet c28 = new Lythuyet("Hành vi đưa xe cơ giới, xe máy chuyên dùng không bảo đảm tiêu chuẩn an toàn kỹ thuật và bảo vệ môi trường vào tham gia giao thông đường bộ có bị nghiêm cấm hay không?","questionimg","Không nghiêm cấm.","Bị nghiêm cấm.","Bị nghiêm cấm tùy theo các tuyến đường.","Bị nghiêm cấm tuỳ theo loại xe.","Bị nghiêm cấm.",1,4,1,"");
            a.add(c28);
            Lythuyet c29 = new Lythuyet("Người điều khiển phương tiện giao thông đường bộ mà trong cơ thể có chất ma tuý có bị nghiêm cấm hay không?","questionimg","Bị nghiêm cấm.","Không bị nghiêm cấm.","Không bị nghiêm cấm, nếu có chất ma tuý ở mức nhẹ, có thể điều khiển phương tiện tham gia giao thông.","","Bị nghiêm cấm.",1,3,1,"");
            a.add(c29);
            Lythuyet c30 = new Lythuyet("Hành vi điều khiển xe cơ giới chạy quá tốc độ quy định, giành đường, vượt ẩu có bị nghiêm cấm hay không?","questionimg","Bị nghiêm cấm tuỳ từng trường hợp.","Không bị nghiêm cấm.","Bị nghiêm cấm.","","Bị nghiêm cấm.",1,3,1,"");
            a.add(c30);


            this.addLythuyet(a);
        }
    }
    public void createDefaultBienbao() {
        int count = this.getBienbaosCount();
        if (count == 0) {
            List<Bienbao> a = new ArrayList();
            Bienbao b1 = new Bienbao("biencam","BIỂN BÁO CẤM DÀNH CHO GIAO THÔNG ĐƯỜNG BỘ","cam");
            Bienbao b2 = new Bienbao("bienchidan","BIỂN BÁO CHỈ DẪN DÀNH CHO GIAO THÔNG ĐƯỜNG BỘ","chi");
            Bienbao b3 = new Bienbao("bienlieulenh","BIỂN BÁO HIỆU LỆNH CẤM DÀNH CHO GIAO THÔNG ĐƯỜNG BỘ","lenh");
            Bienbao b4 = new Bienbao("biennguyhiem","BIỂN BÁO NGUY HIỂM DÀNH CHO GIAO THÔNG ĐƯỜNG BỘ","nguy");
            Bienbao b5 = new Bienbao("bientrencaotoc","BIỂN BÁO TRÊN CAO TỐC DÀNH CHO GIAO THÔNG ĐƯỜNG BỘ","cao");
            Bienbao b6 = new Bienbao("vachkeduong","VẠCH KẺ ĐƯỜNG CŨNG LÀ 1 DẠNG BIỂN BÁO DÀNH CHO NGƯỜI THAM GIA GIAO THÔNG ","duong");

        }
    }
    public List<Lythuyet> getAllLythuyet(){
        Log.i(TAG, "EventDatabaseHelper.getAllNotes ... ");


        List<Lythuyet> LythuyetList = new ArrayList();
        // Select All Query
        String selectQuery = "SELECT * FROM " + TABLE_LYTHUYET;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Lythuyet event = new Lythuyet();
                event.setCau(cursor.getInt(0));
                event.setDe(cursor.getString(1));
                event.setHinh(cursor.getString(2));
                event.setA(cursor.getString(3));
                event.setB(cursor.getString(4));
                event.setC(cursor.getString(5));
                event.setD(cursor.getString(6));
                event.setCaudung(cursor.getString(7));
                event.setBode(cursor.getInt(8));
                event.setSocau(cursor.getInt(9));
                event.setCauliet(cursor.getInt(10));

                LythuyetList.add(event);

            } while (cursor.moveToNext());
        }
        // close db connection
        db.close();

        // return note list
        return LythuyetList;
    }
    public List<Lythuyet> getAllLythuyetliet(){
        Log.i(TAG, "EventDatabaseHelper.getAllNotes ... ");


        List<Lythuyet> LythuyetList = new ArrayList();
        // Select All Query
        String selectQuery = "SELECT * FROM " + TABLE_LYTHUYET+" WHERE "+ COLUMN_LYTHUYET_CAULIET+"=1";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Lythuyet event = new Lythuyet();
                event.setCau(cursor.getInt(0));
                event.setDe(cursor.getString(1));
                event.setHinh(cursor.getString(2));
                event.setA(cursor.getString(3));
                event.setB(cursor.getString(4));
                event.setC(cursor.getString(5));
                event.setD(cursor.getString(6));
                event.setCaudung(cursor.getString(7));
                event.setBode(cursor.getInt(8));
                event.setSocau(cursor.getInt(9));
                event.setCauliet(cursor.getInt(10));

                LythuyetList.add(event);

            } while (cursor.moveToNext());
        }
        // close db connection
        db.close();

        // return note list
        return LythuyetList;
    }

}
