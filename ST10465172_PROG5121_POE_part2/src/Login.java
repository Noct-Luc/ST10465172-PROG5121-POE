
public class Login extends Main {
   private String username;
   private String password;
   private String cellphoneNumber;
    public Login (String username,String password,String cellphoneNumber){
        this.username=username;
        this.cellphoneNumber=cellphoneNumber;
        this.password=password;
    }

    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }
    public String getCellphoneNumber(){
        return cellphoneNumber;
    }
}
