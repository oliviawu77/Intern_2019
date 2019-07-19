package com.java2s;

public class AccountBean implements java.io.Serializable
{

	private String acc = null;
	private String pwd = null;	
	private String msg = null;
	private String sex = null;
	private String mail = null;
	private String name = null;
	
	private String id = null;	
	private String age = null;		
   public String getAcc(){
	      return acc;
	   } 
   public void setAcc(String acc){
	      this.acc = acc;
	   }
   public String getPwd(){
	      return pwd;
	   } 
   public void setPwd(String pwd){
	      this.pwd = pwd;
	   }
   public String getMsg(){
	      return msg;
	   }
   public void setMsg(String msg) {
	      this.msg = msg;
	   } 
   public String getSex(){
	      return sex;
	   }
   public void setSex(String sex) {
	      this.sex = sex;
	   }
   public String getMail(){
	      return mail;
	   }
   public void setMail(String mail) {
	      this.mail = mail;
	   }
   public String getName(){
	      return name;
	   }
   public void setName(String name) {
	      this.name = name;
	   }
   public String getId(){
	      return id;
	   }
   public void setId(String id) {
	      this.id = id;
	   }
   public String getAge(){
	      return age;
	   }
   public void setAge(String age) {
	      this.age = age;
	   }       
}