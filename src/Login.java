class Login {
    private String username = "admin";
    private String password = "1234";

    public boolean authenticate(String user, String pass){
        if(username.equals(user) && password.equals(pass)){
            return true;
        }
        else{
            return false;
        }
    }
}