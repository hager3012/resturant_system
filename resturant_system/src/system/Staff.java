/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system;

/**
 *
 * @author popos
 */
public class Staff {
    private String Userid;  
  private String username;
  private String password;
  private String role;
private String meals_id, meal_title, descriptions, prices;
private String Customer_id ,Customer_adress ,Customer_phone ,Customer_genter;
private String  order_id,order_title ,total_bill,uo_id ;
private String name_type;
private String offer ,offer_id,dates ,statues,range;
private int count_offer;

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public String getStatues() {
        return statues;
    }

    public void setStatues(String statues) {
        this.statues = statues;
    }

    public int getCount_offer() {
        return count_offer;
    }

    public void setCount_offer(int count_offer) {
        this.count_offer = count_offer;
    }
    

    public String getOffer_id() {
        return offer_id;
    }

    public String getDates() {
        return dates;
    }

    public void setOffer_id(String offer_id) {
        this.offer_id = offer_id;
    }

    public void setDates(String dates) {
        this.dates = dates;
    }

    public String getOffer() {
        return offer;
    }

    public void setOffer(String offer) {
        this.offer = offer;
    }

    public String getUo_id() {
        return uo_id;
    }

    public void setUo_id(String uo_id) {
        this.uo_id = uo_id;
    }

    public String getName_type() {
        return name_type;
    }

    public void setName_type(String name_type) {
        this.name_type = name_type;
    }

    public String getOrder_id() {
        return order_id;
    }

    public String getOrder_title() {
        return order_title;
    }

    public String getTotal_bill() {
        return total_bill;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public void setOrder_title(String order_title) {
        this.order_title = order_title;
    }

    public void setTotal_bill(String total_bill) {
        this.total_bill = total_bill;
    }
 

    public String getCustomer_id() {
        return Customer_id;
    }

    public String getCustomer_adress() {
        return Customer_adress;
    }

    public String getCustomer_phone() {
        return Customer_phone;
    }

    public String getCustomer_genter() {
        return Customer_genter;
    }

    public void setCustomer_id(String Customer_id) {
        this.Customer_id = Customer_id;
    }

    public void setCustomer_adress(String Customer_adress) {
        this.Customer_adress = Customer_adress;
    }

    public void setCustomer_phone(String Customer_phone) {
        this.Customer_phone = Customer_phone;
    }

    public void setCustomer_genter(String Customer_genter) {
        this.Customer_genter = Customer_genter;
    }

    public Staff() {
    }

    public String getMeals_id() {
        return meals_id;
    }

    public String getMeal_title() {
        return meal_title;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public String getPrices() {
        return prices;
    }

    public void setMeals_id(String meals_id) {
        this.meals_id = meals_id;
    }

    public void setMeal_title(String meal_title) {
        this.meal_title = meal_title;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public void setPrices(String prices) {
        this.prices = prices;
    }

    public void setUserid(String Userid) {
        this.Userid = Userid;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUserid() {
        return Userid;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }
    

    
    
}
