public class DeleteUserApi {

    private String token;

    public DeleteUserApi(String token){
        this.token = token;
    }

    public String getUserToken() {
        return token;
    }

    public void setUserToken(String token) {
        this.token = token;
    }
}
