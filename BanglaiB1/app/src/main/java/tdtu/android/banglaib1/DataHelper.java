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
            Lythuyet c18 = new Lythuyet("Số 50 trên biển báo dưới đây có ý nghĩa gì ?","l18","Tốc độ tối đa các xe cơ giới được phép chạy.","Tốc độ tối thiểu các xe cơ giới được phép chạy.","","","Tốc độ tối đa các xe cơ giới được phép chạy.",1,2,0,"");
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
            Lythuyet c31 = new Lythuyet("“Làn đường” là gì?","questionimg","Là một phần của phần đường xe chạy được chai theo chiều dọc của đường, sử dụng cho xe chạy.","Là một phần của phần đường xe chạy được chia theo chiều dọc của đường, có bề rộng đủ cho xe chạy an toàn.","Là đường cho xe ô tô chạy, dừng, đỗ an toàn.","","Là một phần của phần đường xe chạy được chia theo chiều dọc của đường, có bề rộng đủ cho xe chạy an toàn.",2,3,1,"");
            a.add(c31);
            //Lythuyet c32= new Lythuyet("","questionimg","","","","","",2,3,0,"");
            //a.add(c33);
            Lythuyet c32= new Lythuyet("Người điều khiển ô tô, mô tô, máy kéo trên đường mà trong máu hoặc hơi thở có nồng độ cồn có bị nghiêm cấm không ?","questionimg","Bị nghiêm cấm.","","","","Bị nghiêm cấm.",2,3,1,"");
            a.add(c32);
            Lythuyet c33= new Lythuyet("Người lái xe không được lùi xe ở những khu vực nào dưới đây ?","","Ở khu vực cho phép đỗ xe.","Ở khu vực cấm dừng và trên phần đường dành cho người đi bộ qua đường.","Nơi đường bộ giao nhau, đường bộ giao nhau cùng mức với đường sắt, nơi tầm nhìn bị che khuất, trong hầm đường bộ, đường cao tốc.","Cả ý 2 và ý 3.","Cả ý 2 và ý 3.",2,4,0,"");
            a.add(c33);
            Lythuyet c34= new Lythuyet("Người có giấy phép lái xe mô tô hạng A2 được phép điều khiển loại xe nào dưới đây ?","questionimg","Xe mô tô ba bánh.","Xe mô tô hai bánh có dung tích xi-lanh từ 175 cm3 trở lên và các loại xe quy định cho giấy phép lái xe hạng A1.","Các loại máy kéo nhỏ có trọng tải đến 1000kg.","","Xe mô tô hai bánh có dung tích xi-lanh từ 175 cm3 trở lên và các loại xe quy định cho giấy phép lái xe hạng A1.",2,3,0,"");
            a.add(c34);
            Lythuyet c35= new Lythuyet("Khi gặp hiệu lệnh như dưới đây của cảnh sát giao thông thì người tham gia giao thông phải đi như thế nào là đúng quy tắc giao thông ?","l35","Người tham gia giao thông ở các hướng phải dừng lại.","Người tham gia giao thông ở các hướng được đi theo chiều gậy chỉ của cảnh sát giao thông.","Người tham gia giao thông ở phía trước và phía sau người điều khiển được đi tất cả các hướng giao thông ở phía bên phải và phía bên trái người điều khiển phải dừng lại.","Người tham gia giao thông ở phía trước và phía sau người điều khiển phải dừng lại; giao thông ở phía bên phải và bên trái người điều khiển được đi tất cả các hướng.","Người tham gia giao thông ở phía trước và phía sau người điều khiển phải dừng lại; giao thông ở phía bên phải và bên trái người điều khiển được đi tất cả các hướng.",2,4,0,"");
            a.add(c35);
            Lythuyet c36= new Lythuyet("Người lái xe phải làm gì khi điều khiển xe vào đường cao tốc ?","questionimg","Phải có tín hiệu xin vào và phải nhường đường cho xe đang chạy trên đường; khi thấy an toàn mới cho xe nhập và dòng xe ở làn đường sát mép ngoài nếu có làn đường tăng tốc thì phải cho xe chạy trên làn đường đó trước khi vào làn đường của đường cao tốc.","Phải có tín hiệu xin vào và phải nhanh chóng vượt xe đang chạy trên đường để nhập vào dòng xe ở làn đường sát mép ngoài; nếu có làn đường tăng tốc thì phải cho xe chạy qua làn đường đó để vào làn đường của đường cao tốc.","","","Phải có tín hiệu xin vào và phải nhường đường cho xe đang chạy trên đường; khi thấy an toàn mới cho xe nhập và dòng xe ở làn đường sát mép ngoài nếu có làn đường tăng tốc thì phải cho xe chạy trên làn đường đó trước khi vào làn đường của đường cao tốc.",2,2,0,"");
            a.add(c36);
            Lythuyet c37= new Lythuyet("Trong các trường hợp dưới đây, để đảm bảo an toàn khi tham gia giao thông, người lái xe mô tô cần thực hiện như thế nào ?","questionimg","Phải đội mũ bảo hiểm đạt chuẩn, có cài quai đúng quy cách, mặc quần áo gọn gàng; không sử dụng ô, điện thoại di động, thiết bị âm thanh (trừ thiết bị trợ thính).","Phải đội mũ bảo hiểm khi trời mưa gió hoặc trời quá nắng; có thể sử dụng ô, điện thoại di động thiết bị âm thanh nhưng đảm bảo an toàn.","Phải đội mũ bảo hiểm khi cảm thấy mất an toàn giao thông hoặc khi chuẩn bị di chuyển quãng đường xa.","","Phải đội mũ bảo hiểm đạt chuẩn, có cài quai đúng quy cách, mặc quần áo gọn gàng; không sử dụng ô, điện thoại di động, thiết bị âm thanh (trừ thiết bị trợ thính).",2,3,0,"");
            a.add(c37);
            Lythuyet c38= new Lythuyet("Khi tham gia giao thông trên đoạn đường không có biển báo “cự ly tối thiểu giữa hai xe”, với điều kiện mặt đường khô ráo, xe cơ giới đang chạy với tốc độ từ trên 80km/h đến 100km/h, người lái xe phải duy trì ở khoảng cách an toàn với xe đang chạy phía trước tối thiểu là bao nhiêu mét ?","questionimg","35 mét.","55 mét.","70 mét.","","70 mét.",2,3,0,"");
            a.add(c38);
            Lythuyet c39= new Lythuyet("Khi người lái xe ô tô dừng, đỗ sát theo lề đường, hè phố phía bên phải theo chiều đi của mình, bánh xe gần nhất không được cách xa lề đường, hè phố qua bao nhiêu mét trong các trường hợp dưới đây để không gây cản trở, nguy hiểm cho giao thông ?","questionimg","0.25 mét.","0.3 mét.","0.4 mét.","0.5 mét.","0.25 mét.",2,4,0,"");
            a.add(c39);
            Lythuyet c40= new Lythuyet("Khi xảy ra tai nạn giao thông, những hành vi nào dưới đây bị nghiêm cấm ?","questionimg","Xâm phạm tính mạng, sức khỏe, tài sản của người bị nạn và người gây tai nạn.","Bỏ trốn sau khi gây tai nạn để trốn tránh trách nhiệm.","Cả ý 1 và ý 2.","","Bỏ trốn sau khi gây tai nạn để trốn tránh trách nhiệm.",2,3,0,"");
            a.add(c40);
            Lythuyet c41= new Lythuyet("Khi điều khiển xe tăng số, người lái xe cần chú ý những điểm gì để đảm bảo an toàn ?","questionimg","Không được nhìn xuống buồng lái, cần phải tăng thứ tự từ thấp đến cao, phối hợp các động tác phải nhịp nhàng, chính xác.","Nhìn xuống buồng lái để biết chính xác vị trí các tay số, cần phải tăng thứ tự từ thấp đến cao, phối hợp các động tác phải nhịp nhàng, vù ga phải phù hợp với tốc độ.","","","Không được nhìn xuống buồng lái, cần phải tăng thứ tự từ thấp đến cao, phối hợp các động tác phải nhịp nhàng, chính xác.",2,2,0,"");
            a.add(c41);
            Lythuyet c42= new Lythuyet("Khi đèn pha của xe đi ngược chiều gây chói mắt, làm giảm khả năng quan sát trên đường, người lái xe xử lý như thế nào để đảm bảo an toàn ?","questionimg","Giảm tốc độ, nếu cần thiết có thể dừng xe lại.","Bật đèn pha chiếu xa và giữ nguyên tốc độ.","Tăng tốc độ, bật đèn pha đối diện xe phía trước.","","Giảm tốc độ, nếu cần thiết có thể dừng xe lại.",2,3,0,"");
            a.add(c42);
            Lythuyet c43= new Lythuyet("Gương chiếu hậu của xe mô tô hai bánh, có tác dụng gì trong các trường hợp dưới đây ?","questionimg","Để quan sát an toàn phía bên trái khi xe chuẩn bị rẽ trái.","Để quan sát an toàn phía bên phải khi xe chuẩn bị rẽ phải.","Để quan sát an toàn phía sau và cả bên trái và bên phải trước khi chuyển hướng.","Để quan sát an toàn phía trước cả bên trái và bên phải trước khi chuyển hướng.","",2,4,0,"");
            a.add(c43);
            Lythuyet c44= new Lythuyet("Hãy nêu công dụng hộp số của ô tô ?","questionimg","Truyền và tăng mô men xoắn giữa các trục vuông góc nhau, đảm bảo cho các bánh xe chủ động quay với tốc độ khác nhau khi sức cản chuyển động ở bánh xe hai bên không bằng nhau.","Truyền và thay đổi mô men xoắn giữa các trục không cùng nằm trên một đường thẳng và góc lệch trục luôn thay đổi trong quá trình ô tô chuyển động, chuyển số êm dịu, dễ điều khiển.","Truyền và thay đổi mô men từ động cơ đến bánh xe chủ động, cắt truyền động từ động cơ đến bánh xe chủ động, đảm bảo cho ô tô chuyển động lùi.","","Truyền và thay đổi mô men từ động cơ đến bánh xe chủ động, cắt truyền động từ động cơ đến bánh xe chủ động, đảm bảo cho ô tô chuyển động lùi.",2,3,0,"");
            a.add(c44);
            Lythuyet c45= new Lythuyet("Biển nào dưới đây xe gắn máy được phép đi vào ?","l45","Biển 1.","Biển 2.","Cả 2 biển.","","Cả 2 biển.",2,3,0,"");
            a.add(c45);
            Lythuyet c46= new Lythuyet("Biển nào là biển ”Cấm đi ngược chiều” ?","l46","Biển 1.","Biển 2.","Cả ba biển.","","Biển 2.",2,3,0,"");
            a.add(c46);
            Lythuyet c47= new Lythuyet("Biển này có hiệu lực đối với xe mô tô hai, ba bánh không ?","l47","Có.","Không.","","","Có.",2,2,0,"");
            a.add(c47);
            Lythuyet c48= new Lythuyet("Trong các biển báo dưới đây biển nào chỉ dẫn bắt đầu đường cao tốc ?","l48","Biển 1.","Biển 2.","Cả biển 1 và biển 2.","","Biển 2.",2,3,0,"");
            a.add(c48);
            Lythuyet c49= new Lythuyet("Khi gặp biển nào, người lái xe phải giảm tốc độ, chú ý xe đi ngược chiều, xe đi ở phía đường bị hẹp phải nhường đường cho xe đi ngược chiều ?","l49","Biển 1.","Biển 1 và 3.","Biển 2 và 3.","Cả ba biển.","Biển 2 và 3.",2,4,0,"");
            a.add(c49);
            Lythuyet c50= new Lythuyet("Biển nào sau đây là biển “ Kè, vực sâu bên đường phía bên phải” ?","l50","Biển 1.","Biển 2.","Biển 3.","","Biển 2.",2,3,0,"");
            a.add(c50);
            Lythuyet c51= new Lythuyet("Biển báo này có ý nghĩa gì ?","l51","Báo hiệu khu vực nguy hiểm thường xuyên có sét đánh.","Báo hiệu khu vực có đường dây điện cắt ngang phía trên tuyến đường.","","","Báo hiệu khu vực có đường dây điện cắt ngang phía trên tuyến đường.",2,2,0,"");
            a.add(c51);
            Lythuyet c52= new Lythuyet("Biển số 1 có ý nghĩa gì ?","l52","Biển chỉ dẫn hết cấm đỗ xe theo giờ trong khu vực.","Biển chỉ dẫn hết hiệu lực khu vực đỗ xe trên các tuyến đường đối ngoại.","Biển chỉ dẫn khu vực đỗ xe trên các tuyến đường đối ngoại.","","Biển chỉ dẫn hết cấm đỗ xe theo giờ trong khu vực.",2,3,0,"");
            a.add(c52);
            Lythuyet c53= new Lythuyet("Biển này có ý nghĩa gì ?","l53","Chỉ dẫn sắp đến vị trí nhập làn xe.","Chỉ dẫn vị trí nhập làn xe cách 250m.","Chỉ dẫn vị trí nhập làn cách trạm thu phí 250m.","","Chỉ dẫn vị trí nhập làn xe cách 250m.",2,3,0,"");
            a.add(c53);
            Lythuyet c54= new Lythuyet("Thứ tự các xe đi như thế nào là đúng quy tắc giao thông ?","l54","Xe công an, xe con, xe tải, xe khách","Xe công an, xe khách, xe con, xe tải.","Xe công an, xe tải, xe khách, xe con.","Xe con, xe công an, xe tải, xe khách.","Xe công an, xe con, xe tải, xe khách.",2,4,0,"");
            a.add(c54);
            Lythuyet c55= new Lythuyet("Xe nào đỗ vi phạm quy tắc giao thông ?","l55","Cả hai xe.","Không xe nào vi phạm.","Chỉ xe mô tô vi phạm.","Chỉ xe tải vi phạm.","Cả hai xe.",2,4,0,"");
            a.add(c55);
            Lythuyet c56= new Lythuyet("Những hướng nào ô tô tải được phép đi ?","l56","Cả bốn hướng.","Trừ hướng 2.","Hướng 2, 3 và 4.","Trừ hướng 4.","Trừ hướng 2.",2,4,0,"");
            a.add(c56);
            Lythuyet c57= new Lythuyet("Để điều khiển cho xe đi thẳng, người lái xe phải làm gì là đúng quy tắc giao thông ?","l57","Nhường xe con rẽ trái trước.","Đi thẳng không nhường.","","","Nhường xe con rẽ trái trước.",2,2,0,"");
            a.add(c57);
            Lythuyet c58= new Lythuyet("Hành vi vượt xe tại các vị trí có tầm nhìn hạn chế, đường vòng, đầu dốc có bị nghiêm cấm hay không?","questionimg","Không bị nghiêm cấm","Không bị nghiêm cấm khi rất vội.","Bị nghiêm cấm.","Không bị nghiêm cấm khi khẩn cấp.","Bị nghiêm cấm.",2,4,1,"");
            a.add(c58);
            Lythuyet c59= new Lythuyet("Việc sản xuất, mua bán, sử dụng biển số xe cơ giới, xe máy chuyên dùng được quy định như thế nào trong Luật Giao thông đường bộ?","questionimg","Được phép sản xuất, sử dụng khi bị mất biển số.","Được phép mua bán, sử dụng khi bị mất biển số.","Nghiêm cấm sản xuất, mua bán, sử dụng trái phép.","","Nghiêm cấm sản xuất, mua bán, sử dụng trái phép.",2,3,1,"");
            a.add(c59);
            Lythuyet c60= new Lythuyet("Hành vi bỏ trốn sau khi gây tai nạn để trốn tránh trách nhiệm hoặc khi có điều kiện mà cố ý không cứu giúp người bị tai nạn giao thông có bị nghiêm cấm hay không?","questionimg","Không bị nghiêm cấm.","Nghiêm cấm tuỳ từng trường hợp cụ thể.","Bị nghiêm cấm.","","Bị nghiêm cấm.",2,3,1,"");
            a.add(c60);

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
                event.setCauliet(cursor.getInt(11));

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
                event.setCauliet(cursor.getInt(11));

                LythuyetList.add(event);

            } while (cursor.moveToNext());
        }
        // close db connection
        db.close();

        // return note list
        return LythuyetList;
    }
    public List<Lythuyet> getAllLythuyetDe2(){
        Log.i(TAG, "EventDatabaseHelper.getAllNotes ... ");


        List<Lythuyet> LythuyetList = new ArrayList();
        // Select All Query
        String selectQuery = "SELECT * FROM " + TABLE_LYTHUYET+" WHERE "+ COLUMN_LYTHUYET_BODE+"=2";
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
                event.setCauliet(cursor.getInt(11));

                LythuyetList.add(event);

            } while (cursor.moveToNext());
        }
        // close db connection
        db.close();

        // return note list
        return LythuyetList;
    }

}
