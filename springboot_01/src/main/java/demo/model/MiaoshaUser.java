package demo.model;

import java.util.Date;

public class MiaoshaUser {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column miaosha_user.id
     *
     * @mbggenerated Fri May 15 11:28:40 CST 2020
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column miaosha_user.nickname
     *
     * @mbggenerated Fri May 15 11:28:40 CST 2020
     */
    private String nickname;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column miaosha_user.password
     *
     * @mbggenerated Fri May 15 11:28:40 CST 2020
     */
    private String password;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column miaosha_user.salt
     *
     * @mbggenerated Fri May 15 11:28:40 CST 2020
     */
    private String salt;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column miaosha_user.head
     *
     * @mbggenerated Fri May 15 11:28:40 CST 2020
     */
    private String head;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column miaosha_user.register_date
     *
     * @mbggenerated Fri May 15 11:28:40 CST 2020
     */
    private Date registerDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column miaosha_user.last_login_date
     *
     * @mbggenerated Fri May 15 11:28:40 CST 2020
     */
    private Date lastLoginDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column miaosha_user.login_count
     *
     * @mbggenerated Fri May 15 11:28:40 CST 2020
     */
    private Integer loginCount;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column miaosha_user.id
     *
     * @return the value of miaosha_user.id
     *
     * @mbggenerated Fri May 15 11:28:40 CST 2020
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column miaosha_user.id
     *
     * @param id the value for miaosha_user.id
     *
     * @mbggenerated Fri May 15 11:28:40 CST 2020
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column miaosha_user.nickname
     *
     * @return the value of miaosha_user.nickname
     *
     * @mbggenerated Fri May 15 11:28:40 CST 2020
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column miaosha_user.nickname
     *
     * @param nickname the value for miaosha_user.nickname
     *
     * @mbggenerated Fri May 15 11:28:40 CST 2020
     */
    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column miaosha_user.password
     *
     * @return the value of miaosha_user.password
     *
     * @mbggenerated Fri May 15 11:28:40 CST 2020
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column miaosha_user.password
     *
     * @param password the value for miaosha_user.password
     *
     * @mbggenerated Fri May 15 11:28:40 CST 2020
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column miaosha_user.salt
     *
     * @return the value of miaosha_user.salt
     *
     * @mbggenerated Fri May 15 11:28:40 CST 2020
     */
    public String getSalt() {
        return salt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column miaosha_user.salt
     *
     * @param salt the value for miaosha_user.salt
     *
     * @mbggenerated Fri May 15 11:28:40 CST 2020
     */
    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column miaosha_user.head
     *
     * @return the value of miaosha_user.head
     *
     * @mbggenerated Fri May 15 11:28:40 CST 2020
     */
    public String getHead() {
        return head;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column miaosha_user.head
     *
     * @param head the value for miaosha_user.head
     *
     * @mbggenerated Fri May 15 11:28:40 CST 2020
     */
    public void setHead(String head) {
        this.head = head == null ? null : head.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column miaosha_user.register_date
     *
     * @return the value of miaosha_user.register_date
     *
     * @mbggenerated Fri May 15 11:28:40 CST 2020
     */
    public Date getRegisterDate() {
        return registerDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column miaosha_user.register_date
     *
     * @param registerDate the value for miaosha_user.register_date
     *
     * @mbggenerated Fri May 15 11:28:40 CST 2020
     */
    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column miaosha_user.last_login_date
     *
     * @return the value of miaosha_user.last_login_date
     *
     * @mbggenerated Fri May 15 11:28:40 CST 2020
     */
    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column miaosha_user.last_login_date
     *
     * @param lastLoginDate the value for miaosha_user.last_login_date
     *
     * @mbggenerated Fri May 15 11:28:40 CST 2020
     */
    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column miaosha_user.login_count
     *
     * @return the value of miaosha_user.login_count
     *
     * @mbggenerated Fri May 15 11:28:40 CST 2020
     */
    public Integer getLoginCount() {
        return loginCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column miaosha_user.login_count
     *
     * @param loginCount the value for miaosha_user.login_count
     *
     * @mbggenerated Fri May 15 11:28:40 CST 2020
     */
    public void setLoginCount(Integer loginCount) {
        this.loginCount = loginCount;
    }


}