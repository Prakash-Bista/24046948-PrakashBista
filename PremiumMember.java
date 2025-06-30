public class PremiumMember extends GymMember
{
    private final double premiumCharge = 50000;
    private String personalTrainer;
    private boolean isFullPayment;
    private double paidAmount;
    private double discountAmount;
    
    //constructor
    public PremiumMember(int id, String name, String location, String phone, String email, String gender, String DOB, String membershipStartDate, String personalTrainer )
    {
        super(id, name, location, phone, email, gender, DOB, membershipStartDate);
        this.personalTrainer = personalTrainer;
        this.isFullPayment = false;
        this.discountAmount = 0;
        this.paidAmount = 0;
        
    }
    public double getPremiumCharge()
    {
        return this.premiumCharge;
    }
    
    public double getDiscountAmount()
    {
        return this.discountAmount;
    }
    
    public boolean getIsFullPayment()
    {
        return this.isFullPayment;
    }
    public double getPaidAmount()
    {
        return this.paidAmount;
    }
    
    public String getPersonalTrainer()
    {
        return this.personalTrainer;
    }
    
    //implement the abstract method 
    
    @Override  //we use override because we have already defined markAttendance method in gymMember
    public void markAttendance()
    {
        attendance++;
        loyaltyPoints += 10;  // this is a shorthand of loyaltyPoints = loyaltyPoints + 5
    }
    
    public String payDueAmount(double amount)  
    {
        // if the payment is already full
        if(isFullPayment)  
        {
            return "Payment was already completed";    
        }
        
        // the the money is exceeds the premium charge
        if((paidAmount + amount) > premiumCharge)
        {
            return "Total paid amount more than required amount. ";
        }
        
        //if the amount is less than the total charge
        paidAmount +=amount;
        isFullPayment = (paidAmount == premiumCharge);
        {
            return "Payment is Sucessfully transferred. Remaining amount :" + (premiumCharge - paidAmount);
        }
    }   
        // calculate discount method
        
    public void calculateDiscount()
    {
        if(isFullPayment)
        {
            discountAmount = premiumCharge * 0.1;    //0.1 is equals to 10 %
            System.out.println("Disount amount: "+ discountAmount);
        }
        else
        {
            discountAmount = 0;
        }
    }
    // 
    public void revertPremiumMember()
    {
        resetMember();
        personalTrainer = "";
        isFullPayment = false;
        paidAmount = 0;
        discountAmount = 0;
    }
    
    @Override
    public void display()
    {
        super.display();
        System.out.println("personal trainer: "+ personalTrainer);
        System.out.println("Paid Amount by Member: "+ paidAmount);
        System.out.println("Full payment Status :"+ isFullPayment);
        System.out.println("Remaining amount of the member is : "+ (premiumCharge - paidAmount));
        if(isFullPayment)
        {
            System.out.println("10 % discount on "+ paidAmount + " will be "+discountAmount);
        }
    }
}