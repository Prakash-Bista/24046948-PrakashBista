public class RegularMember extends GymMember
{
    // access modifier and data types
    private final int attendanceLimit = 30;
    private boolean isEligibleForUpgrade;
    private String removalReason;
    private String referralSource;
    private String plan;
    private double price;
    
    // constructor part
    public RegularMember(int id, String name, String location, String phone, String email, String gender, String DOB, String membershipStartDate, String referralSource)
    {
        //i have call me parent class using the super constructor
        super(id, name, location, phone, email, gender, DOB, membershipStartDate);
        this.isEligibleForUpgrade = false;
        this.plan = "Basic";
        this.price = 6500;
        this.removalReason = "";
        this.referralSource = referralSource;
    }
    // accessor method means get() method
    public boolean getIsEligibleForUpgrade()
    {
        return this.isEligibleForUpgrade;
    }
    
    public int getAttendanceLimit()
    {
        return this.attendanceLimit;
    }
    
    public String getRemovalReason()
    {
        return removalReason;
    }
    
    public String getReferralSource()
    {
        return this.referralSource;
    }
    
    public String getPlan()
    {
        return this.plan;
    }
    
    public double getPrice()
    {
        return this.price;
    
    }
    
    
    //implementing abstract method to increament the attendence by 1
    @Override    // the markAttendance is already decleared as abstract method in gym memeber so i just override it
    public void markAttendance()
    {
        attendance++;
        loyaltyPoints += 5;  //  this is a shorthand of loyaltypoint =loyaltypoint + 5; it first add and then updates the value
        
        // to make the increament the value incerement value by 1 i use loop
        if(attendance >= attendanceLimit)
        {
            isEligibleForUpgrade = true;
        }
    }
    //getPlanPrice method with the return type double with the plan as the parameter and return its corresponding value which is string
    public double getPlanPrice(String plan)
    {
        // to return the corresponding value use switch statement
       /*// in this senerio i'am not using the case 1;
        * case 2 because Plan accepts string as a parameter and .toLoweCase to accepts */
        
        switch(plan.toLowerCase())  
        {
            case "basic" : return 6500; 
            case "standard" : return 12500;
            case "deluxe" : return 18500;
            default : return -1;
        }
    }
    //method upgradePlan()
    public String upgradePlan(String newPlan)  //here i used newPlan because if the same plan is choosen the memeber is already subscribe too
    {
        if(newPlan.equalsIgnoreCase(plan))  // i use .euqualsIgnoreCase to treat lowercase and uppercase equivalent
        {
            return "This member is already subsribed.";
        }
        if(!isEligibleForUpgrade)
        {
            return "This member is not eligible.";
        }
        
        double newPrice = getPlanPrice(newPlan);
        if(newPrice == -1)
        {
            return "This is not a vaild plan";
        }
        //the value should be updated by the according to getPlanPrice()
        this.plan = newPlan;
        this.price = newPrice;
        return "Plan has been sucessfully updated to " + newPlan + "to price" + newPrice; 
    }
    // revertRegualrMember() method
    public void revertRegularMember(String removalReason)
    {
        resetMember();
        this.isEligibleForUpgrade = false;
        this.plan = "Basic";
        this.price = 6500;
        this.removalReason = removalReason;
    }
    @Override
    public void display()
    {
        super.display();
        System.out.println("Ther plan for Member is "+ plan);
        System.out.println("The price of Member is "+ price);
        if(!removalReason.isEmpty())
        {
            System.out.println("The removalReason is "+ removalReason);
        }
    }
}