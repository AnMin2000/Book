import org.json.JSONObject;

public class StringToJson {

    private String[] key;
    private String[] value;

    public StringToJson(String[] key, String[] value) {
        this.key = key;
        this.value = value;
    }

    public String convertToJsonString() {
        JSONObject json = new JSONObject(); // JSON 객체 생성
        for(int i =0; i<key.length; i++){
            json.put(key[i], value[i]);
        }
        return json.toString(4);
    }
}
