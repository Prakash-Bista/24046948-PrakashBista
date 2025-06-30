public abstract class GymMember
{
    
    // data types with protected access modifier
    
    protected int id;                
    protected String name;
    protected String location;
    protected String phone;                 
    protected String email;
    protected String gender;         
    protected String DOB;
    protected String membershipStartDate;
    protected int attendance;
    protected double loyaltyPoints;
    protected boolean activeStatus;
    
     // All the above variables are instance variables which mean they all are accessed within the whole GymMember class
    
    // This is a part of the constructor and i will pass the formal parameter with with the argument
    public GymMember(int id, String name, String location, String phone, String email, String gender, String DOB, String membershipStartDate)
    {
        this.id = id;
        this.name = name;
        this.location = location;
        this.phone = phone;
        this.email = email;
        this.gender = gender;
        this.DOB = DOB;
        this.membershipStartDate = membershipStartDate;
        this.attendance = 0;
        this.loyaltyPoints = 0.0;
        this.activeStatus = false;
        
        /* this. keyword helps to seperate the variables within the method with the instance varaible
        this.name refers to the instance variable and with this keyword refers to the parameter values */
        
    }
    // corresponding accessor method means get() method
    public int getId()    // i use int because it has a return type which will return the value in integer
    {
        return this.id;
    }
    
    public String getName()
    {
        return this.name;
    }
    
    public String getLocation()
    {
        return this.location;
    }
    
    public String getPhone()
    {
        return this.phone;
    }
    
    public String getEmail()
    {
        return this.email;
    }
    
    public String getGender()
    {
        return this.gender;
    }
    
    public String getDOB()
    {
        return this.DOB;
    }
    
    public String getMembershipStartDate()
    {
        return this.membershipStartDate;
    }
    
    public int getAttendance()
    {
        return this.attendance;
    }
    
    public double getLoyaltyPoints()
    {
        return this.loyaltyPoints;
    }
    
    public boolean getActiveStatus()
    {
        return this.activeStatus;
    }
    
    // To track attendance of the member using abstract method
    public abstract void markAttendance();
    
    //creating activateMembership method and setting activeStatus to true
    public void activateMembership()
    {
        activeStatus = true;
    }
    
    // creating deactivateMembership method and setting activeStatus to false
    public void deactivateMembership()
    {
        if(activeStatus)
        {
            activeStatus = false;
            System.out.println("Yor membership has been deactivated");
        }
        else
        {
            System.out.println("You memebership has already been deactivated");
        }
    }
    
    // creating resetMember() method to set the activeStatus to false, attendance to zero and loyalty points to zero.
    public void resetMember()
    {
        activeStatus = false;
        attendance = 0;
        loyaltyPoints = 0.0;
    }
    
    // creating a method to display using display method
    public void display()
    {
        System.out.println("The id of the member is "+ id);
        System.out.println("The name of the member is "+ name);
        System.out.println("The location of the member is "+ location);
        System.out.println("The phone number of the member is "+ phone);
        System.out.println("The email of the member is "+ email);
        System.out.println("The gender of the member is "+ gender);
        System.out.println("The date of birth of the memeber is "+ DOB);
        System.out.println("The date when the member start his membershipstartdate is "+ membershipStartDate);
        System.out.println("The attendance of the member is "+ attendance);
        System.out.println("The loyaltypoint of the memeber is "+loyaltyPoints);
        System.out.println("The activestatus of the memeber is "+activeStatus);
    }
}