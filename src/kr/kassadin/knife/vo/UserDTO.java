package kr.kassadin.knife.vo;

public class UserDTO {
    // 회원번호
    private int userNum; //인덱스
    // 회원아이디
    private String userId;
    // 회원비밀번호
    private String userPassword;
    // 회원성함
    private String userName;
    // 회원주소
    private String userAddress;
    // 회원전화번호
    private String userPhonenumber;
    // 회원등급 (일반회원 1, 관리자 0)
    private int grade;
    
    // Getter, Setter    
    public int getUserNum() {
        return userNum;
    }
    public void setUserNum(int userNum) {
        this.userNum = userNum;
    }
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getUserPassword() {
        return userPassword;
    }
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getUserAddress() {
        return userAddress;
    }
    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }
    public String getUserPhonenumber() {
        return userPhonenumber;
    }
    public void setUserPhonenumber(String userPhonenumber) {
        this.userPhonenumber = userPhonenumber;
    }
    public int getGrade() {
        return grade;
    }
    public void setGrade(int grade) {
        this.grade = grade;
    }
    
    // equals() User
    public boolean equals(Object o) {
        if(o instanceof UserDTO) {
            UserDTO u = (UserDTO)o;
            if(userNum == u.userNum) {
                return true;
            }
        }
        return false;
    }
}
