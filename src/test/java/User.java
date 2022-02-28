import lombok.*;

@Getter
public class User {

    @Setter
    private int statusCode;

    private int page;
    private int per_page;
    private int total;
    private int total_pages;
    private Data[] data;
    private Support support;

    @Getter
    public static class Support {
        private String text;
        private String url;
    }

    @Getter
    public static class Data {
        private int id;
        private String email;
        private String first_name;
        private String last_name;
        private String avatar;
    }

}
