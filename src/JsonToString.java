import com.google.gson.Gson;

public class JsonToString {
    public static void main(String[] args) {
        // JSON 객체 생성
        MyObject myObject = new MyObject("value1", "value2");

        // Gson 객체 생성
        Gson gson = new Gson();

        // JSON 객체를 문자열로 변환
        String jsonString = gson.toJson(myObject);

        System.out.println(jsonString.toString());
    }

    // 내부 클래스
    static class MyObject {
        private String field1;
        private String field2;

        public MyObject(String field1, String field2) {
            this.field1 = field1;
            this.field2 = field2;
        }

        public String getField1() {
            return field1;
        }

        public String getField2() {
            return field2;
        }
    }
}