/*
    c - csis
    a - acct
    b - busn
    p - phys

*/
class CourseInfo
{

  private String courseTitle;
  private double coursePrice;
  private int courseSeatsAvail;
  private String courseDesc;
  private char courseType;
      
  private static String empPassword = "1234";
  
  CourseInfo(String crseTitle, double crsePrice,int crseSeats,String crseDesc, char type)
  {
  
      courseTitle = crseTitle;
      coursePrice = crsePrice;
      courseSeatsAvail = crseSeats;
      courseDesc = crseDesc; 
      courseType = type; 

  }
  
  public void setCrsSeats(int a)
  {
      courseSeatsAvail = a;
  }
  
  public String getCrsTitle()
  {
      return courseTitle;
  }
  
  public double getCrsPrice()
  {
      return coursePrice;
  }
  
  public int getCrsSeats()
  {
      return courseSeatsAvail;
  }
  
  public String getCrsDesc()
  {
      return courseDesc;
  }
  
  public char getCrsChar()
  {
      return courseType;
  }
  
  public void setEmpPass(String a)
  {
      CourseInfo.empPassword = a;
  }
  
  public String getEmpPass()
  {
      return CourseInfo.empPassword;
  }
  /*
  Finish the class with the set/get methods
  */  
    
}

///////////////////////////////

class CourseList
{

  CourseInfo[] courseList;
  
  public void createList()
  {
  
      courseList = new CourseInfo[11];
      
		courseList[0] = new CourseInfo("acct110",375.49, 35,"this course teaches \nbasic accounting practice",'a');
		courseList[1] = new CourseInfo("busn110",375.49, 35,"this course teaches \nbasic business pratice",'b');
		courseList[2] = new CourseInfo("busn240",375.49, 35,"this course teaches \nadvance business pratice",'b');
		courseList[3] = new CourseInfo("csis110",375.49, 2,"this course teaches \nbasic computing pratice",'c');
      courseList[4] = new CourseInfo("csis220",375.49, 35,"this course teaches \nR language",'c');
		courseList[5] = new CourseInfo("csis290",375.49, 25,"this course teaches \nbasic hardware pratice",'c');
      courseList[6] = new CourseInfo("csis340",375.49, 35,"this course teaches \nadvance CPU tech",'c');
		courseList[7] = new CourseInfo("csis420",375.49, 17,"this course teaches \nbasic computer graphics",'c');
		courseList[8] = new CourseInfo("csis491",375.49, 3,"this course teaches \nbasic game programming",'c');
		courseList[9] = new CourseInfo("phys120",499.19, 30,"this course teaches \nbasic physics theory",'p');
		courseList[10] = new CourseInfo("phys240",399.99, 35,"this course teaches \nbasic quantum mechanics",'p');
  }
} 