import java.util.ArrayList;
import javax.swing.JScrollPane;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

//awt package
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//swing package
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JDialog;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JOptionPane;

public class GymGUI implements ActionListener
{
    //instance variable
    private JFrame frame, regularFrame, premiumFrame , pdisplay, rdisplay;
    private JCheckBox checkBox;

    private JLabel nameLabel, gymName, agreeStatement,info, message, termsAndCondition, title, greeding,guidLine, id, phone, firstName, lastName, middleName,
                   email, gender,plan, date, membershipStartDate, refferal, location, button,planPrice, planChange, discount , status, labelrevert, dlabel,
                   regularmarkattendance, premiummarkattendance,ddlabel,reglabel,pldlabel,
                   //premium
                   premiumTitle, premiumGreeding, premiumGuildLine, premiumId, premiumPhone, premiumFirstName,premiumLastName,premiumMiddleName,
                   premiumDate,premiumGender, premiumEmail, premiumMembershipStartDate, premiumTrainer, premiumLocation, premiumPlanCharge,
                   premiumDiscount,premiumLabelButton, premiumStatus,premiumrevertlabel,labelread,premiumlabel,ppremiumlabel, enter,prelabel,
                   paylabel,paylabelamount,dislabel;
                   
    private JTextField idText, phoneText, firstNameText, lastNameText, middleNameText, emailText, locationText,dlabelfield,regulartextfield,ddlabelfield,reglabeltext,premiumIdText, premiumPhoneText,
                        premiumFirstNameText, premiumLastNameText, premiumMiddleNameText, premiumEmailText, premiumTrainerText,premiumLocationText, premiumlabeltext, ppremiumlabeltext,
                        premiumtextfield, enterfield, prelabeltext,paylabeltext,paylabelamounttext,dislabelfield,pldlabelfield;
                        
    private JButton regularButton, premiumButton, markAttendance,clearButton, display,activeMembership,deactiveMembership, addButton, submit,backregular, dueButton, premiumDueButton, premiumMarkAttendance,
                               premiumClearButton, premiumDisplay, premiumAddButton , premiumSubmit, premiumActiveMembership,premiumDeactiveMembership, revert,prerevert, calculateDiscount,dsubmit,
                               premiumsubmit,markregularsubmit,markpremiumsubmit,ddsubmit,ppremiumsubmit,enterbutton, regbutton, prebutton, paybutton, click, rclick, backpremium,rsavefile,rreadfile,
                               psavefile,preadfile,dissubmit,upgradePlan,pldsubmit;
                               
    private JDialog dialog, premiumdialog, markattendanceregular,markattendancepremium,ddialog,ppremiumdialog, premiumdiscount,regularvert,premiumvert,
                    paydue,disc,pldialog;
    
    private JPanel panel, panelName, panelHeader, panelButton, premiumPanel, premiumPanelHeader, sidePanel, premiumSidePanel;
    private JRadioButton male, female, premiumMale, premiumFemale;
    
    private ButtonGroup genderButtonGroup, premiumGenderButtonGroup;
    
    private JComboBox dayComboBox, monthComboBox, yearComboBox, membershipStartDay, membershipStartMonth, membershipStartYear, planComboBox,premiumDay,
                        premiumMonth,premiumYear, premiumMembershipStartDay,premiumMembershipStartMonth,premiumMembershipStartYear;
                        
    private JTextArea planPriceArea,refferalArea, planChangeArea, discountArea,premiumPlanChargeArea, premiumDiscountArea, text, rtext;
    //arraylist
    ArrayList<GymMember> member = new ArrayList<>();  //this is to store objects made for classes
    
    
    public GymGUI()
    {
        
        //frame
        frame = new JFrame("Gym GUI");
        frame.setLayout(null);
        frame.setSize(1080,650);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        
        //name of the gym center
        nameLabel = new JLabel("Welcome !");
        nameLabel.setBounds(120,40,400,70);
        nameLabel.setFont(new Font("Times New Roman", Font.ITALIC, 65));
        nameLabel.setForeground(Color.decode("#00008B"));
        
        //gym name
        gymName = new JLabel("to LIGHT Health & Fitness");
        gymName.setBounds(270,140,400,40);
        gymName.setFont(new Font("Times New Roman", Font.ITALIC, 30));
        gymName.setForeground(Color.decode("#00008B"));
        
        
        
        //panel to store the welcome and gym name
        panelName = new JPanel();
        panelName.setLayout(null);
        panelName.setVisible(true);
        panelName.setBounds(0,40,830,240);
        panelName.setBackground(Color.decode("#FF7F7F"));
        panelName.add(nameLabel);
        panelName.add(gymName);
        //checkbox
        checkBox = new JCheckBox();
        checkBox.setBounds(120,334,20,20);
        checkBox.addActionListener(this); // this is won't be added the if won't actually perform
        
        //agree statement
        agreeStatement = new JLabel(" By selecting this, you accept our");
        agreeStatement.setForeground(Color.decode("#FFFFFF"));
        agreeStatement.setFont(new Font("Arial", Font.PLAIN, 14));
        agreeStatement.setBounds(140,330,207,30);
        
        //terms and conditions
        termsAndCondition = new JLabel(" terms and conditions.");
        termsAndCondition.setBounds(350,330,158,30);
        termsAndCondition.setFont(new Font("Times New Roman", Font.ITALIC, 17));
        termsAndCondition.setForeground(Color.decode("#0000FF"));
        
        
        //information
        info = new JLabel(" ! Please agree to terms and conditions First. ");
        info.setBounds(120,385,550,30);
        info.setForeground(Color.decode("#FF0000"));
        info.setFont(new Font("Arial", Font.PLAIN, 17));
        
        //regular membershipbutton
        regularButton = new JButton("Regular Member");
        regularButton.setBounds(120,450,200,40);
        regularButton.setFont(new Font("Arial", Font.BOLD,15));
        regularButton.setForeground(Color.decode("#ffffff"));
        regularButton.setBackground(Color.decode("#0000CD"));
        regularButton.setEnabled(false);  // this will disabled the button temporarly
        //add/ register
        regularButton.addActionListener(this); 
        
        
        
        //premium member
        premiumButton = new JButton("Premium Member");
        premiumButton.setBounds(450,450,200,40);
        premiumButton.setFont(new Font("Arial", Font.BOLD,15));
        premiumButton.setForeground(Color.decode("#ffffff"));
        premiumButton.setBackground(Color.decode("#0000CD"));
        premiumButton.setEnabled(false);// this will disabled the button 
        //add / register
        premiumButton.addActionListener(this);
        
        //display        
        //panel name
        frame.add(panelName);
        
        
        //checkbox
        frame.add(checkBox);
        
        //information
        frame.add(info);
        
        //agree statement
        frame.add(agreeStatement);
        
        //terrms and conditions
        frame.add(termsAndCondition);
    
        
        //regular button
        frame.add(regularButton);
        
        //premium button
        frame.add(premiumButton);
        frame.setVisible(true);
        frame.getContentPane().setBackground(Color.decode("#f1c27d"));
        }
    
    @Override
    public void actionPerformed(ActionEvent obj)
    {
        //this is a agreestatement
        // what to disply if this button is pressed
        if (obj.getSource() == checkBox) 
        {
            boolean isChecked = checkBox.isSelected();
            premiumButton.setEnabled(isChecked);
            regularButton.setEnabled(isChecked);
            if (isChecked) 
            {
                info.setText("Now you can choose your preferred option ");
                info.setForeground(Color.decode("#FFFFFF"));
            } else 
            {
                info.setText("! Please agree to terms and conditions First. ");
                info.setForeground(Color.decode("#FF0000"));
                premiumButton.setEnabled(false);
                regularButton.setEnabled(false);
            }
        } 
        else if (obj.getSource() == premiumButton) 
        {
            premiumMemberForm();
            return;
        } 
        else if (obj.getSource() == regularButton) 
        {
            regularMemberForm();
            return;
        }
        
        
        
        //this is for the clear button part
        if(obj.getSource()==clearButton)
        {
            idText.setText("");
            phoneText.setText("");
            firstNameText.setText("");
            emailText.setText("");
            refferalArea.setText("");
            locationText.setText("");
            JOptionPane.showMessageDialog(null, "All fields have been  cleared!", "Cleared !", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        //displaybutton for regular
        if(obj.getSource() == display)
        {
            regdisplay();
            return;
        }
        if (obj.getSource() == rclick) {
            String result = ""; 
            int count = 0;
                
            for (GymMember members : member) 
            { 
                if (members instanceof RegularMember)
                {
                    RegularMember gs = (RegularMember) members;
                    rtext.setFont(new Font("Courier New", Font.BOLD, 14));
                    count++;
                    
                                
                    result += "\n             Regular Member \n\n";
                    result += count + "\n";
                    result += "ID of the member is                     : " + gs.getId() + "\n";
                    result += "Name of the member is                   : " + gs.getName() + "\n";
                    result += "Gender of the member                    : " + gs.getGender() + "\n";
                    result += "Date of Birth of the member             : " + gs.getDOB() + "\n";
                    result += "Membership Start date of the member is  : " + gs.getMembershipStartDate() + "\n";
                    result += "Attendance of the member is             : " + gs.getAttendance() + "\n";
                    result += "Email Address of the member is          : " + gs.getEmail() + "\n";
                    result += "Phone Number of the member is           : " + gs.getPhone() + "\n";
                    result += "Active Status of the member is          : " + (gs.getActiveStatus() ? "Yes" : "No") + "\n";
                }
            }
                
            if (count == 0) 
            {
                result += "No Members found.";
            }
            
            rtext.setText(result);
        }
        
        
        //addButton for regular button
        if(obj.getSource()==addButton)
        {
            int rid;
            String id = idText.getText().trim();
            long rphone;
            String phone = phoneText.getText().trim();
            String name = firstNameText.getText().trim();
            String email = emailText.getText().trim();
            String refferal = refferalArea.getText().trim();
            String location = locationText.getText().trim();
            String gender = male.isSelected() ? "male" : "female";
            String tdate = dayComboBox.getSelectedItem()+"-"+ monthComboBox.getSelectedItem()+"-"+ yearComboBox.getSelectedItem();
            String mdate = membershipStartDay.getSelectedItem()+"-"+ membershipStartMonth.getSelectedItem()+"-"+ membershipStartDay.getSelectedItem();
            // ID
            if (id.isEmpty()) 
            {
                idText.setBackground(Color.decode("#ADD8E6"));
                JOptionPane.showMessageDialog(null, "ID cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            else
            {
                idText.setBackground(Color.decode("#ffffff"));
            }
            
            rid = Integer.parseInt(id); //innitializing rid for this for each loop
            for(GymMember checkDup : member)
            {
                if(checkDup.getId() == rid)
                {
                    JOptionPane.showMessageDialog(null, "ID entered is duplicate", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            
            try 
            {
                rid = Integer.parseInt(id);
            } 
            catch (NumberFormatException e) 
            {
                idText.setBackground(Color.decode("#ADD8E6"));
                idText.setText("");
                JOptionPane.showMessageDialog(null, "ID must be a number!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            if (name.isEmpty()) 
            {
                firstNameText.setBackground(Color.decode("#ADD8E6"));
                JOptionPane.showMessageDialog(null, "Name field is Empty!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            else
            {
                firstNameText.setBackground(Color.decode("#ffffff"));
            }
            if (email.isEmpty()) 
            {
                emailText.setBackground(Color.decode("#ADD8E6"));
                JOptionPane.showMessageDialog(null, "Email is missing!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            else
            {
                emailText.setBackground(Color.decode("#ffffff"));
            }
            if (location.isEmpty()) 
            {
                locationText.setBackground(Color.decode("#ADD8E6"));
                JOptionPane.showMessageDialog(null, "location is Empty!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            else
            {
                locationText.setBackground(Color.decode("#ffffff"));
            }
            //phone
            if (phone.isEmpty()) 
            {
                phoneText.setBackground(Color.decode("#ADD8E6"));
                JOptionPane.showMessageDialog(null, "Phone cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            else
            {
                phoneText.setBackground(Color.decode("#ffffff"));
            }
            
            try 
            {
                rphone = Long.parseLong(phone);
            } catch (NumberFormatException e) 
            {
                phoneText.setBackground(Color.decode("#ADD8E6"));
                phoneText.setText("");
                JOptionPane.showMessageDialog(null, "Phone must be a number!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (dayComboBox.getSelectedItem() == null || monthComboBox.getSelectedItem() == null || 
                yearComboBox.getSelectedItem() == null) 
            {
                JOptionPane.showMessageDialog(null, "Select a valid date!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            if (membershipStartDay.getSelectedItem() == null || membershipStartMonth.getSelectedItem() == null || 
                membershipStartYear.getSelectedItem() == null) 
            {
                JOptionPane.showMessageDialog(null, "Select the valid membership date!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            if (refferal.isEmpty()) 
            {
                refferalArea.setBackground(Color.decode("#ADD8E6"));
                JOptionPane.showMessageDialog(null, "Refferal source is missing!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            else
            {
                refferalArea.setBackground(Color.decode("#ffffff"));
            }
            RegularMember regular = new RegularMember(rid,name,location,phone,email,gender,tdate,mdate,refferal);
            member.add(regular);
            JOptionPane.showMessageDialog(null, "Information recorded Scucessfully!", "Scucess", JOptionPane.INFORMATION_MESSAGE);
            idText.setText("");
            phoneText.setText("");
            firstNameText.setText("");
            emailText.setText("");
            refferalArea.setText("");
            locationText.setText("");
            return;
        }
        //activate membership of regular
        if(obj.getSource() == activeMembership)
        {
            regularIdDialog();
            return;
        }
        if(obj.getSource() == dsubmit)
        {
            String rid = dlabelfield.getText().trim();
            if(rid.isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Id field is Empty", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            try
            {
                int regularid = Integer.parseInt(rid);
                boolean found = false;
                for (GymMember members : member) 
                 {
                    if (members.getId() == regularid) 
                    {
                        members.activateMembership(); // this Call the method from GymMember
                        JOptionPane.showMessageDialog(null, "Membership has been activated","Success", JOptionPane.INFORMATION_MESSAGE);
                        dlabelfield.setText("");
                        found = true;
                        break;
                    }
                }
                
                if(!found)
                {
                    JOptionPane.showMessageDialog(null, "Member Id not found !","Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            catch(NumberFormatException e)
                {
                    JOptionPane.showMessageDialog(null, "Id only accept number value", "Error", JOptionPane.ERROR_MESSAGE);
                }
        }
        
        //deactive action for regularbutton
        if(obj.getSource() == deactiveMembership)
        {
            regularDeactive();
            return;
        }
        if(obj.getSource() == ddsubmit)
        {
            String hid = ddlabelfield.getText().trim();
            if(hid.isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Id field is Empty", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            try
            {
                int regularId = Integer.parseInt(hid);
                boolean found = false;
                for(GymMember members : member)
                {
                    if(members.getId()==regularId) //the the gym member constructor of id
                    {
                        found = true;
                        if(members.getActiveStatus())
                        {
                            members.deactivateMembership();
                            JOptionPane.showMessageDialog(null, "Member ID has been Deactivated", "Deativatioin info !", JOptionPane.INFORMATION_MESSAGE);
                            ddlabelfield.setText("");
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null, "Activate the member first !", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                        break;
                    }
                }
                
                if(!found)
                {
                    JOptionPane.showMessageDialog(null, "Members Id is not found !", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            catch(NumberFormatException a)
            {
                ddlabelfield.setBackground(Color.decode("#ff0000"));
                ddlabelfield.setForeground(Color.decode("#ffffff"));
                JOptionPane.showMessageDialog(null, "Member should be integer value !", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        //revertMember for regular
        if(obj.getSource() == revert)
        {
            regrev();
            return;
        }
        if(obj.getSource() == regbutton )
        {
            String toy = reglabeltext.getText().trim();
            if(toy.isEmpty())
            {
                reglabeltext.setBackground(Color.decode("#ADD8E6"));
                JOptionPane.showMessageDialog(null,"ID Field is Empty!","Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            else
            {
                reglabeltext.setBackground(Color.decode("#ffffff"));
            }
            try
            {
                int ptoy = Integer.parseInt(toy);
                boolean know = false;
                for(GymMember members : member)
                {
                    if(members.getId() == ptoy)
                    {
                        know = true;
                        if(members instanceof RegularMember)
                        {
                            ((RegularMember)members).revertRegularMember(toy);
                            JOptionPane.showMessageDialog(null,"Member has been removed scucessfully!","Removed", JOptionPane.INFORMATION_MESSAGE);
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null,"This is a not a Regular Member !","Error", JOptionPane.ERROR_MESSAGE);
                        }
                        break;
                    }
                }
                if(!know)
                {
                    JOptionPane.showMessageDialog(null,"Member ID not found!","Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            catch(NumberFormatException f)
            {
                JOptionPane.showMessageDialog(null,"This field required the Integer value","Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        
        
        //markattendance of regular
        if(obj.getSource()==markAttendance)
        {
            regularMark();
            return;
        }
        if(obj.getSource() == markregularsubmit)
        {
            String aid = regulartextfield.getText().trim();
            if(aid.isEmpty())
            {
                JOptionPane.showMessageDialog(null,"Mark attendance field is Empty!","Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            try
            {
                int preaid = Integer.parseInt(aid);
                boolean rost = false;
                for(GymMember members : member)
                {
                    if(members.getId() == preaid)
                    {
                        rost = true;
                        if(members.getActiveStatus())
                        {
                            members.markAttendance();
                            JOptionPane.showMessageDialog(null,"Attendance have been marked !","Attendance", JOptionPane.INFORMATION_MESSAGE);
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null,"Member is not active !","Error", JOptionPane.ERROR_MESSAGE);
                        }
                        break;
                    }
                }
                if(!rost)
                {
                    JOptionPane.showMessageDialog(null,"Member ID has not been found !","Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            catch(NumberFormatException d)
            {
                JOptionPane.showMessageDialog(null,"Member ID should be in Integer!","Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        
        //filewriter for regular
        if (obj.getSource() == rsavefile) 
        {
            try 
            {
                FileWriter writer = new FileWriter("MemberDetails.txt");
                writer.write(String.format("%-5s %-15s %-15s %-15s %-25s %-20s %-10s %-10s %-10s %-15s %-10s %-15s %-15s %-15s\n",
                    "ID", "Name", "Location", "Phone", "Email", "Membership Start Date",
                    "Plan", "Price", "Attendance", "Loyalty Points", "Active Status", "Full Payment", "Discount Amount", "Net Amount Paid"));
        
                boolean anyWritten = false;
        
                for (GymMember members : member) 
                {
                    if (members instanceof RegularMember) 
                    {
                        RegularMember r = (RegularMember) members;
        
                        int id = r.getId();
                        String name = r.getName();
                        String location = r.getLocation();
                        String phone = r.getPhone();
                        String email = r.getEmail();
                        String startDate = r.getMembershipStartDate();
                        String plan = r.getPlan();
                        double price = r.getPrice();
                        int attendance = r.getAttendance();
                        double loyalty = r.getLoyaltyPoints();
                        boolean active = r.getActiveStatus();
        
                        // For regular members, these don't apply, so we use defaults
                        boolean fullPayment = false;
                        double discount = 0.0;
                        double paidAmount = 0.0;
        
                        writer.write(String.format("%-5d %-15s %-15s %-15s %-25s %-20s %-10s %-10.2f %-10d %-15.2f %-10b %-15b %-15.2f %-15.2f\n",
                            id, name, location, phone, email, startDate, plan, price, attendance, loyalty,
                            active, fullPayment, discount, paidAmount));
                        
                        anyWritten = true;
                    }
                }
        
                writer.close();
        
                if (anyWritten) 
                {
                    JOptionPane.showMessageDialog(null, "Regular member details saved to MemberDetails.txt", "Success", JOptionPane.INFORMATION_MESSAGE);
                } 
                else 
                {
                    JOptionPane.showMessageDialog(null, "No regular members found to save.", "Info", JOptionPane.INFORMATION_MESSAGE);
                }
        
            } 
            catch (IOException e) 
            {
                JOptionPane.showMessageDialog(null, "Error writing to file: " , "File Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        //upgrade plan for regularmember
        if(obj.getSource()==upgradePlan)
        {
            plan();
            return;
        }
        if (obj.getSource() == pldsubmit) 
        {
            try 
            {
                int enteredId = Integer.parseInt(pldlabelfield.getText().trim());
                boolean found = false;
        
                for (GymMember members : member) 
                {
                    if (members.getId() == enteredId) 
                    {
                        found = true;
        
                        if (members instanceof RegularMember) 
                        {
                            RegularMember regMember = (RegularMember) members;
        
                            if (regMember.getActiveStatus()) 
                            {
                                if (regMember.getIsEligibleForUpgrade()) 
                                {
                                    String newPlan = JOptionPane.showInputDialog(pldialog, "Enter the new plan (Basic/Standard/Deluxe):");
        
                                    if (newPlan != null) 
                                    {
                                        String result = regMember.upgradePlan(newPlan);
                                        JOptionPane.showMessageDialog(pldialog, result);
                                    }
                                } 
                                else 
                                {
                                    JOptionPane.showMessageDialog(pldialog, "Member is not eligible for upgrade. Attendance must be 30 or more.");
                                }
                            } 
                            else 
                            {
                                JOptionPane.showMessageDialog(pldialog, "Member is not active. Upgrade not allowed.");
                            }
                        }
                        else 
                        {
                            JOptionPane.showMessageDialog(pldialog, "Only Regular Members can upgrade their plans.");
                        }
        
                        break;
                    }
                }
        
                if (!found) {
                    JOptionPane.showMessageDialog(pldialog, "Member ID not found.");
                }
        
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(pldialog, "Please enter a valid numeric Member ID.");
            }

        }


        
        
        
        //activate button for premium
        if(obj.getSource()==premiumActiveMembership)
        {
            premiumIdDialog();
            return;
        }
        if(obj.getSource() ==premiumsubmit)
        {
            String pid = premiumlabeltext.getText().trim();
            if(pid.isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Id field is Empty", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            try
            {
                int premid = Integer.parseInt(pid);
                boolean found = false;
                for (GymMember members : member) 
                 {
                    if (members.getId() == premid) 
                    {
                        members.activateMembership(); // this Call the method from GymMember
                        JOptionPane.showMessageDialog(null, " Your Membership has been activated Scucessfully","Wohoo !", JOptionPane.INFORMATION_MESSAGE);
                        premiumlabeltext.setText("");
                        found = true;
                        break;
                    }
                }
                if(!found)
                {
                    JOptionPane.showMessageDialog(null, "Member Id not found !","Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            catch(NumberFormatException e)
            {
                JOptionPane.showMessageDialog(null, "Id only accept number value", "Error", JOptionPane.ERROR_MESSAGE);
                premiumlabeltext.setText("");
                return;
            }
        }
        
        
        //deactiveMembership button for premium
        if(obj.getSource() == premiumDeactiveMembership)
        {
            premiumdeactive();
            return;
        }
        if(obj.getSource() == ppremiumsubmit)
        {
            String gid = ppremiumlabeltext.getText().trim();
            if(gid.isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Id field is Empty", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            try 
            {
                int premiumId = Integer.parseInt(gid);
                boolean good = false;
                
                for (GymMember members : member) 
                {
                    if (members.getId() == premiumId) // checks that the all the id matches or not
                    { 
                        good = true;
                        if (members.getActiveStatus()) 
                        {
                            members.deactivateMembership(); // deactives if it is active
                            JOptionPane.showMessageDialog(null,"Membership has been Deactivated","Deactivation Info",JOptionPane.INFORMATION_MESSAGE);
                            ppremiumlabeltext.setText("");
                        } else 
                        {
                            JOptionPane.showMessageDialog(null, "Activate the member first!","Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        break;
                    }
                }
                if (!good) 
                {
                    JOptionPane.showMessageDialog(null, "Member ID not found !", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } 
            catch (NumberFormatException e) 
            {
                JOptionPane.showMessageDialog(null,"Invalid ID format (must be a number)!","Error", JOptionPane.ERROR_MESSAGE);
                ppremiumlabeltext.setText("");
            }
        }
        
        
        
        //revert for premium
        if(obj.getSource() == prerevert)
        {
            prerev();
            return;
        }
        if(obj.getSource() == prebutton )
        {
            String joy = prelabeltext.getText().trim();
            if(joy.isEmpty())
            {
                prelabeltext.setBackground(Color.decode("#ADD8E6"));
                JOptionPane.showMessageDialog(null," ID Field is Empty!","Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            else
            {
                prelabeltext.setBackground(Color.decode("#ffffff"));
            }
            try
            {
                int ptoy = Integer.parseInt(joy);
                boolean now = false;
                for(GymMember members : member)
                {
                    if(members.getId() == ptoy)
                    {
                        now = true;
                        if(members instanceof PremiumMember)
                        {
                            ((PremiumMember)members).revertPremiumMember();
                            JOptionPane.showMessageDialog(null,"Member has been removed scucessfully!","Removed", JOptionPane.INFORMATION_MESSAGE);
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null,"This is a not a Regular Member !","Error", JOptionPane.ERROR_MESSAGE);
                        }
                        break;
                    }
                }
                if(!now)
                {
                    JOptionPane.showMessageDialog(null,"Member ID not found!","Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            catch(NumberFormatException f)
            {
                JOptionPane.showMessageDialog(null,"This field required the Integer value","Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        
                
                //disount button for premium
        if (obj.getSource() == calculateDiscount) 
        {
            dis();  // show the discount input dialog
        }
                if (obj.getSource() == dissubmit)
        {
            String did = dislabelfield.getText().trim();  
            try 
            {
                int id = Integer.parseInt(did);
                for (GymMember members : member) 
                {
                    if (members.getId() == id && members instanceof PremiumMember) 
                    {
                        PremiumMember pm = (PremiumMember) members;
        
                        pm.calculateDiscount();  
                        double discount = pm.getDiscountAmount();  
                        premiumDiscountArea.setText("Discount for Member ID " + id + " is: " + discount);
                        JOptionPane.showMessageDialog(null, "Discount for Member ID " + id + " is: " + discount, "Discount Info", JOptionPane.INFORMATION_MESSAGE);
                        return;
                    }
                }
        
                // No member found
                premiumDiscountArea.setText("No Premium Member found with ID: " + id);
                JOptionPane.showMessageDialog(null, "No Premium Member found with ID: " + id, "Not Found", JOptionPane.WARNING_MESSAGE);
            } 
            catch (NumberFormatException e) 
            {
                premiumDiscountArea.setText("Invalid input: Please enter a numeric ID.");
                JOptionPane.showMessageDialog(null, "Please enter a valid Member ID.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
            } 
            catch (Exception ex) 
            {
                premiumDiscountArea.setText("An unexpected error occurred.");
                JOptionPane.showMessageDialog(null, "An unexpected error occurred.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        
        }




        
        //markattendance of premium
        if(obj.getSource()==premiumMarkAttendance)
        {
            premiumMark();
        }
        if(obj.getSource() == markpremiumsubmit)
        {
            String did = premiumtextfield.getText().trim();
            if(did.isEmpty())
            {
                JOptionPane.showMessageDialog(null,"Mark attendance field is Empty!","Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            try
            {
                int reaid = Integer.parseInt(did);
                boolean host = false;
                for(GymMember members : member)
                {
                    if(members.getId() == reaid)
                    {
                        host = true;
                        if(members.getActiveStatus())
                        {
                            members.markAttendance(); // call the method fromt the gym member
                            JOptionPane.showMessageDialog(null,"Attendance have been marked !","Attendance", JOptionPane.INFORMATION_MESSAGE);
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null,"Member is not active !","Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    break;
                }
                if(!host)
                {
                    JOptionPane.showMessageDialog(null,"Member ID has not been found !","Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            catch(NumberFormatException d)
            {
                JOptionPane.showMessageDialog(null,"Member ID should be in Integer!","Error", JOptionPane.ERROR_MESSAGE);
                premiumtextfield.setText("");
            }
        }
        
        //payDue
        if(obj.getSource() == premiumDueButton)
        {
            payDue();
            return;
        }
        if (obj.getSource() == paybutton) 
        {
            String idText = paylabeltext.getText().trim();
            String amountText = paylabelamounttext.getText().trim();
        
            if (idText.isEmpty() || amountText.isEmpty()) 
            {
                JOptionPane.showMessageDialog(null, "Fields can't be empty", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        
            try 
            {
                int id = Integer.parseInt(idText);
                double amount = Double.parseDouble(amountText);
                boolean found = false;
        
                for (GymMember memberObj : member) 
                {
                    if (memberObj.getId() == id) 
                    {
                        found = true;
        
                        if (memberObj instanceof PremiumMember) 
                        {
                            PremiumMember premium = (PremiumMember) memberObj;
                            premium.payDueAmount(amount); 
        
                            double totalPaid = premium.getPaidAmount();  // You need a method to get total paid
                            double dueAmount = 50000 - premium.getPaidAmount()- premium.getDiscountAmount();
        
                            if (totalPaid > 50000) 
                            {
                                JOptionPane.showMessageDialog(null,
                                    "Amount exceeded. You have paid more than required!",
                                    "Excess Payment", JOptionPane.WARNING_MESSAGE);
                            } else 
                            {
                                JOptionPane.showMessageDialog(null,
                                    "Successful payment.\nRemaining amount: Rs. " + dueAmount,
                                    "Payment Info", JOptionPane.INFORMATION_MESSAGE);
                            }
                        } else 
                        {
                            JOptionPane.showMessageDialog(null,
                                "This member is not a Premium Member.",
                                "Invalid Member Type", JOptionPane.ERROR_MESSAGE);
                        }
                        break;
                    }
                }
        
                if (!found) 
                {
                    JOptionPane.showMessageDialog(null,
                        "Member ID not found!",
                        "Error", JOptionPane.ERROR_MESSAGE);
                }
        
            } 
            catch (NumberFormatException e) 
            {
                JOptionPane.showMessageDialog(null, "Enter valid numbers for ID and amount!", "Invalid Input", JOptionPane.ERROR_MESSAGE);
            }
        }

        //clearButton for premium
        if(obj.getSource() == premiumClearButton)
        {
            premiumIdText.setText("");
            premiumPhoneText.setText("");
            premiumFirstNameText.setText("");
            premiumEmailText.setText("");
            premiumTrainerText.setText("");
            premiumLocationText.setText("");
            JOptionPane.showMessageDialog(null, "All fields have been  cleared !", "Cleared !", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        //premium display
        if (obj.getSource() == premiumDisplay)
        {
            predisplay();
        }
        
        //premium display
        if (obj.getSource() == premiumDisplay) {
            predisplay();
        }
        if(obj.getSource() == click) 
        {
            String result = "";  
            int count = 0;
        
            for (GymMember members : member) 
            {
                if (members instanceof PremiumMember) 
                {
                    PremiumMember gs = (PremiumMember) members;
                    count++;
                    text.setFont(new Font("Courier New", Font.BOLD, 12));
            
                    // Using String concatenation (+=)
                    result += "             Premium Member  \n\n";
                    result += " \n";
                    result += "ID of the member is                      : " + gs.getId() + "\n";
                    result += "Name of the member is                    : " + gs.getName() + "\n";
                    result += "Gender of the member is                  : " + gs.getGender() + "\n";
                    result += "Date of Birth of the member is           : " + gs.getDOB() + "\n";
                    result += "Membership Start of the member is        : " + gs.getMembershipStartDate() + "\n";
                    result += "Email Address of the member is           : " + gs.getEmail() + "\n";
                    result += "Attendance of the member is             : " + gs.getAttendance() + "\n";
                    result += "Phone Number of the member is            : " + gs.getPhone() + "\n";
                    result += "Active Status of the member is           : " + (gs.getActiveStatus() ? "Yes" : "No") + "\n";
                }
            }
        
            if (count == 0) 
            {
                result += "No Members found.";
            }
            
            text.setText(result); 
        }

        
        //Add button for premium
        if(obj.getSource() == premiumAddButton)
        {
            int pid;
            String id = premiumIdText.getText().trim();
            long prephone;
            String phone = premiumPhoneText.getText().trim();
            String name = premiumFirstNameText.getText().trim();
            String email = premiumEmailText.getText().trim();
            String trainer = premiumTrainerText.getText().trim();
            String location = premiumLocationText.getText().trim();
            String gender = premiumMale.isSelected() ? "male" : "female";
            String tdate = premiumDay.getSelectedItem()+"-"+ premiumMonth.getSelectedItem()+"-"+ premiumYear.getSelectedItem();
            String mdate = premiumMembershipStartDay.getSelectedItem()+"-"+ premiumMembershipStartMonth.getSelectedItem()+"-"+ 
            premiumMembershipStartYear.getSelectedItem();
            if (id.isEmpty()) 
            {
                premiumIdText.setBackground(Color.decode("#ADD8E6"));
                JOptionPane.showMessageDialog(null, "ID cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            else
            {
                premiumIdText.setBackground(Color.decode("#ffffff"));
            }
            try 
            {
                pid = Integer.parseInt(id);
            } catch (NumberFormatException e) 
            {
                premiumIdText.setBackground(Color.decode("#ADD8E6"));
                premiumIdText.setText("");
                JOptionPane.showMessageDialog(null, "ID must be a number!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            for(GymMember checkDup : member)
            {
                if(checkDup.getId() == pid)
                {
                    JOptionPane.showMessageDialog(null, "ID entered is duplicate", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            
            if (name.isEmpty()) 
            {
                premiumFirstNameText.setBackground(Color.decode("#ADD8E6"));
                JOptionPane.showMessageDialog(null, "Name is Empty!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            else
            {
                premiumFirstNameText.setBackground(Color.decode("#ffffff"));
            }
            
            if (email.isEmpty()) 
            {
                premiumEmailText.setBackground(Color.decode("#ADD8E6"));
                JOptionPane.showMessageDialog(null, "Email is missing!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            else
            {
                premiumEmailText.setBackground(Color.decode("#ffffff"));
            }
            
            if (location.isEmpty()) 
            {
                premiumLocationText.setBackground(Color.decode("#ADD8E6"));
                JOptionPane.showMessageDialog(null, "location is Empty!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            else
            {
                premiumLocationText.setBackground(Color.decode("#ffffff"));
            }
            //phone
            if (phone.isEmpty()) 
            {
                premiumPhoneText.setBackground(Color.decode("#ADD8E6"));
                JOptionPane.showMessageDialog(null, "Phone cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            else
            {
                premiumPhoneText.setBackground(Color.decode("#ffffff"));
            }
            try 
            {
                prephone = Long.parseLong(phone);
            } catch (NumberFormatException e) 
            {
                premiumPhoneText.setBackground(Color.decode("#ADD8E6"));
                premiumPhoneText.setText("");
                JOptionPane.showMessageDialog(null, "Phone must be a number!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (premiumDay.getSelectedItem() == null || premiumMonth.getSelectedItem() == null || 
                premiumYear.getSelectedItem() == null) 
            {
                JOptionPane.showMessageDialog(null, "Select a valid date!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            if (premiumMembershipStartDay.getSelectedItem() == null || premiumMembershipStartMonth.getSelectedItem() == null || 
                premiumMembershipStartYear.getSelectedItem() == null) 
            {
                JOptionPane.showMessageDialog(null, "Select the valid membership date!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            PremiumMember premium = new PremiumMember(pid,name,location, phone,email,gender,tdate,mdate,trainer);
            member.add(premium);
            JOptionPane.showMessageDialog(null, "Information recorded Scucessfully!", "Scucess", JOptionPane.INFORMATION_MESSAGE);
            premiumIdText.setText("");
            premiumPhoneText.setText("");
            premiumFirstNameText.setText("");
            premiumEmailText.setText("");
            premiumTrainerText.setText("");
            premiumLocationText.setText("");
            return;
        }
        
        //filewriter in premium
        if (obj.getSource() == psavefile) 
        {
            try 
            {
                FileWriter writer = new FileWriter("MemberDetails.txt");
                writer.write(String.format("%-5s %-15s %-15s %-15s %-25s %-20s %-10s %-10s %-10s %-15s %-10s %-15s %-15s %-15s\n",
                    "ID", "Name", "Location", "Phone", "Email", "Membership Start Date",
                    "Plan", "Price", "Attendance", "Loyalty Points", "Active Status", "Full Payment", "Discount Amount", "Net Amount Paid"));
        
                boolean anyWritten = false;
                for (GymMember members : member) 
                {
                    if (members instanceof PremiumMember) 
                    {
                        PremiumMember p = (PremiumMember) members;
        
                        int id = p.getId();
                        String name = p.getName();
                        String location = p.getLocation();
                        String phone = p.getPhone();
                        String email = p.getEmail();
                        String startDate = p.getMembershipStartDate();
                        String plan = "Premium";
                        double price = 50000;
                        int attendance = p.getAttendance();
                        double loyalty = p.getLoyaltyPoints();
                        boolean active = p.getActiveStatus();
                        boolean fullPayment = p.getIsFullPayment();
                        double discount = p.getDiscountAmount();
                        double paidAmount = p.getPaidAmount();
        
                        writer.write(String.format("%-5d %-15s %-15s %-15s %-25s %-20s %-10s %-10.2f %-10d %-15.2f %-10b %-15b %-15.2f %-15.2f\n",
                            id, name, location, phone, email, startDate, plan, price, attendance, loyalty,
                            active, fullPayment, discount, paidAmount));
                        
                        anyWritten = true;
                    }
                }
        
                writer.close();
        
                if (anyWritten) 
                {
                    JOptionPane.showMessageDialog(null, "Premium member details saved to MemberDetails.txt", "Success", JOptionPane.INFORMATION_MESSAGE);
                } else 
                {
                    JOptionPane.showMessageDialog(null, "First add the premium member.", "Info", JOptionPane.INFORMATION_MESSAGE);
                }
        
            } catch (IOException e) 
            {
                JOptionPane.showMessageDialog(null, "Error while writing to file", "File Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        //filereader for regular
        if (obj.getSource() == rreadfile) 
        {
            try 
            {
                File file = new File("MemberDetails.txt");
                if (!file.exists()) 
                {
                    JOptionPane.showMessageDialog(null, "The file 'MemberDetails.txt' does not exist.", "File Not Found", JOptionPane.WARNING_MESSAGE);
                    return;
                }
        
                // Use Scanner to read file content
                Scanner scanner = new Scanner(file);
                String data = "";
                while (scanner.hasNextLine()) 
                {
                    data += scanner.nextLine() + "\n";
                }
                scanner.close();
        
                // Create a new JFrame to display content
                JFrame readFrame = new JFrame("Member Details");
                readFrame.setSize(900, 500);
                readFrame.setLocationRelativeTo(null);
                readFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
                JTextArea textrea = new JTextArea();
                textrea.setText(data);
                textrea.setEditable(false);
                textrea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        
                JScrollPane scrollPane = new JScrollPane(textrea);
                readFrame.add(scrollPane);
                readFrame.setVisible(true);
        
            } 
            catch (FileNotFoundException e) 
            {
                JOptionPane.showMessageDialog(null, "Error: " , "File Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        //filereader for premium
        if (obj.getSource() == preadfile) 
        {
            try 
            {
                File readFile = new File("MemberDetails.txt");
                if (!readFile.exists()) 
                {
                    JOptionPane.showMessageDialog(null, "The file 'MemberDetails.txt' does not exist.", "File Not Found", JOptionPane.WARNING_MESSAGE);
                    return;
                }
        
                Scanner fileScanner = new Scanner(readFile);
                String fileData = "";
                while (fileScanner.hasNextLine()) 
                {
                    fileData += fileScanner.nextLine() + "\n";
                }
                fileScanner.close();
        
                // Create display frame
                JFrame readFrame = new JFrame("All Member Details");
                readFrame.setSize(900, 500);
                readFrame.setLocationRelativeTo(null);
                readFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
                JTextArea textArea = new JTextArea(fileData);
                textArea.setEditable(false);
                textArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        
                JScrollPane scrollPane = new JScrollPane(textArea);
                readFrame.add(scrollPane);
                readFrame.setVisible(true);
        
            } 
            catch (FileNotFoundException e) 
            {
                JOptionPane.showMessageDialog(null, "Error reading file: ", "File Error", JOptionPane.ERROR_MESSAGE);
            }
        }


    }



    
    
    //regular mark attendance
    private void regularMark()
    {
        //dialog
        markattendanceregular = new JDialog();
        markattendanceregular.setBounds(200,200,400,200);
        markattendanceregular.setLayout(null);
        
        //label
        regularmarkattendance = new JLabel("Enter ID ");
        regularmarkattendance.setBounds(30,10,150,25);
        regulartextfield = new JTextField();
        regulartextfield.setBounds(30,45,130,25);
        
        //mark submit
        markregularsubmit = new JButton("Submit");
        markregularsubmit.setBounds(50,120,170,25);
        //add/register
        markregularsubmit.addActionListener(this);
        
        
        //dispaly
        markattendanceregular.add(regularmarkattendance);
        markattendanceregular.add(regulartextfield);
        markattendanceregular.add(markregularsubmit);
        markattendanceregular.setVisible(true);
        
    }
    
    //payDue
    private void payDue()
    {
        //dialog
        paydue = new JDialog();
        paydue.setBounds(200,200,400,200);
        paydue.setLayout(null);
        
        //label
        paylabel = new JLabel("Enter ID: ");
        paylabel.setBounds(30,10,150,25);
        paylabeltext = new JTextField();
        paylabeltext.setBounds(200,10,130,25);
        
        paylabelamount = new JLabel("Pay Due Amount : ");
        paylabelamount.setBounds(30,55,150,25);
        paylabelamounttext = new JTextField();
        paylabelamounttext.setBounds(200,55,100,25);
        
        //mark submit
        paybutton = new JButton("Submit");
        paybutton.setBounds(50,120,170,25);
        //add/register
        paybutton.addActionListener(this);
        
        
        //dispaly
        paydue.add(paylabel);
        paydue.add(paylabeltext);
        paydue.add(paybutton);
        paydue.add(paylabelamounttext);
        paydue.add(paylabelamount);
        paydue.setVisible(true);
        
    }
    
    
    //mark attendance for premium member
    private void premiumMark()
    {
        //dialog
        markattendancepremium = new JDialog();
        markattendancepremium.setBounds(200,200,400,200);
        markattendancepremium.setLayout(null);
        
        //label
        premiummarkattendance = new JLabel("Enter ID : ");
        premiummarkattendance.setBounds(30,10,150,25);
        premiumtextfield = new JTextField();
        premiumtextfield.setBounds(50,45,130,25);
        
        //submit
        markpremiumsubmit = new JButton("Submit");
        markpremiumsubmit.setBounds(50,120,170,25);
        //add/register
        markpremiumsubmit.addActionListener(this);
        
        //dispaly
        markattendancepremium.add(premiummarkattendance);
        markattendancepremium.add(premiumtextfield);
        markattendancepremium.add(markpremiumsubmit);
        markattendancepremium.setVisible(true);
    }
    
    //regularrevert
    private void regrev()
    {
        regularvert = new JDialog();
        regularvert.setBounds(200,200,400,200);
        regularvert.setLayout(null);
        
        //label
        reglabel = new JLabel("Enter ID");
        reglabel.setBounds(30,10,150,25);
        reglabeltext = new JTextField();
        reglabeltext.setBounds(50,45,120,25);
        //submit
        regbutton = new JButton("Submit");
        regbutton.setBounds(50,120,170,25);
        //add/register
        regbutton.addActionListener(this);
        
        //dispaly
        regularvert.add(reglabel);
        regularvert.add(reglabeltext);
        regularvert.add(regbutton);
        regularvert.setVisible(true);
    }
    
    //premiumrevert
    private void prerev()
    {
        premiumvert = new JDialog();
        premiumvert.setBounds(200,200,400,200);
        premiumvert.setLayout(null);
        
        //label
        prelabel = new JLabel("Enter Id :");
        prelabel.setBounds(30,10,150,25);
        prelabeltext = new JTextField();
        prelabeltext.setBounds(50,45,120,25);
        //submit
        prebutton = new JButton("Submit");
        prebutton.setBounds(50,120,170,25);
        //add/register
        prebutton.addActionListener(this);
        
        //dispaly
        premiumvert.add(prelabel);
        premiumvert.add(prelabeltext);
        premiumvert.add(prebutton);
        premiumvert.setVisible(true);
    }
    
    
    
    //regularmemberform 
    private void regularMemberForm()
    {
        //frame part of the regular member
        regularFrame = new JFrame();
        regularFrame.setSize(1040,591);
        regularFrame.setLayout(null);
        regularFrame.setResizable(false);
        panel = new JPanel();
        panel.setSize(820,550);
        panel.setLayout(null);
        
                
        //title
        title = new JLabel("Regular Member");
        title.setBounds(320,15,200,30);
        title.setFont(new Font("Arial",Font.BOLD,20));
        title.setForeground(Color.decode("#FFFFFF"));
        
        //greeding
        greeding = new JLabel("Congratulations !");
        greeding.setBounds(20,75,160,25);
        greeding.setForeground(Color.decode("#0000CD"));
        greeding.setFont(new Font("Times New Roman", Font.ITALIC,20));
        
        //guidline
        guidLine = new JLabel("You have choosen the Regular Package, please fill the form below :");
        guidLine.setBounds(170,75,500,25);
        guidLine.setFont(new Font("Arial",Font.BOLD,13));
    
        //panelheader
        panelHeader = new JPanel();
        panelHeader.setBounds(0,0,840,60);
        panelHeader.setLayout(null);
        panelHeader.setBackground(Color.decode("#102770"));
        //add which you want to add
        panelHeader.add(title);
        panelHeader.setVisible(true);
        
        
        //sidepanel
        sidePanel = new JPanel();
        sidePanel.setBounds(822,0,591,200);
        sidePanel.setSize(200,550);
        sidePanel.setLayout(null);
        sidePanel.setBackground(Color.decode("#102770"));
        
        status = new JLabel("Status :");
        status.setBounds(7,120,100,25);
        status.setForeground(Color.decode("#ffffff"));
        
        //active membership
        activeMembership = new JButton("Activate Membership  ");
        activeMembership.setBounds(7,165,180,25);
        activeMembership.setForeground(Color.decode("#FFFFFF"));
        activeMembership.setBackground(Color.decode("#00FF00"));
        // add/ register
        activeMembership.addActionListener(this);
        
        //deactive membership
        deactiveMembership = new JButton("Deactivate Membership");
        deactiveMembership.setBounds(7,215,180,25);
        deactiveMembership.setForeground(Color.decode("#FFFFFF"));
        deactiveMembership.setBackground(Color.decode("#00FF00"));
        //add/register
        deactiveMembership.addActionListener(this);
        
        //label revert
        labelrevert = new JLabel("Revert and Plan: ");
        labelrevert.setBounds(7,285,180,25);
        labelrevert.setForeground(Color.decode("#ffffff"));
        
        //revert button
        revert = new JButton("Revert");
        revert.setBounds(7,325,180,25);
        revert.setForeground(Color.decode("#FFFFFF"));
        revert.setBackground(Color.decode("#00FF00"));
        //add/register
        revert.addActionListener(this);
        
        upgradePlan = new JButton("Upgrade Plan");
        upgradePlan.setBounds(7,367,180,25);
        upgradePlan.setForeground(Color.decode("#FFFFFF"));
        upgradePlan.setBackground(Color.decode("#00FF00"));
        //add/register
        upgradePlan.addActionListener(this);
        
        //frameof sidepanel
        sidePanel.add(status);
        sidePanel.add(activeMembership);
        sidePanel.add(deactiveMembership);
        sidePanel.add(labelrevert);
        sidePanel.add(revert);
        sidePanel.add(upgradePlan);
        
        sidePanel.setVisible(true);
        
        // id / textfield
        id = new JLabel("ID:");
        id.setBounds(83,120,17,25);
        idText = new JTextField();
        idText.setBounds(110,120,100,25);
        
        //phone
        phone = new JLabel("Phone:");
        phone.setBounds(610,120,60,25);
        phoneText = new JTextField();
        phoneText.setBounds(665,120,120,25);
        
        //firstname/textfield
        firstName = new JLabel("Full Name:");
        firstName.setBounds(35,160,80,25);
        firstNameText = new JTextField();
        firstNameText.setBounds(110,160,200,25);
        
        //DOB
        date = new JLabel("Date Of Birth:");
        date.setBounds(460,160,80,25);
        String [] day = {"31","30", "29", "28", "27", "26", "25", "24", "23", "22", "21",
                         "20", "19", "18", "17", "16", "15", "14", "13", "12", "11",
                         "10", "9", "8", "7", "6", "5", "4", "3", "2", "1"};
        dayComboBox = new JComboBox(day);
        dayComboBox.setBounds(555,160,50,30);
        String [] month = {"January", "February", "March", "April", "May", "June", 
                   "July", "August", "September", "October", "November", "December"};
        monthComboBox = new JComboBox(month);
        monthComboBox.setBounds(605,160,115,30);
        String [] year = {"1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979",
                         "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989",
                         "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999",
                         "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007"};
        yearComboBox = new JComboBox(year);
        yearComboBox.setBounds(720,160,70,30);
        
        //plan 
        plan = new JLabel("Plan:");
        plan.setBounds(345,200,40,25);
        String [] planBox = {"Basic","Standard","Deluxe"};
        planComboBox = new JComboBox(planBox);
        planComboBox.setBounds(390,200,100,25);
    
        
        //gender
        gender = new JLabel("Gender:");
        gender.setBounds(50,200,50,25);
        male = new JRadioButton("Male");
        male.setSelected(true);
        male.setBounds(110,200,58,25);
        female = new JRadioButton("Female");
        female.setBounds(170,200,70,25);
        genderButtonGroup = new ButtonGroup();
        genderButtonGroup.add(male);
        genderButtonGroup.add(female);
        
        
        //email/textfield
        email = new JLabel("Email:");
        email.setBounds(63,240,37,25);
        emailText = new JTextField();
        emailText.setBounds(110,240,210,25);
        
        //membership start date
        membershipStartDate = new JLabel("Membership Start Date:");
        membershipStartDate.setBounds(400,240,140,25);
        String [] membershipDay = {"31","30", "29", "28", "27", "26", "25", "24", "23", "22", "21",
                                          "20", "19", "18", "17", "16", "15", "14", "13", "12", "11",
                                          "10", "9", "8", "7", "6", "5", "4", "3", "2", "1"};
        membershipStartDay = new JComboBox(membershipDay);
        membershipStartDay.setBounds(555,240,50,25);
        String[] membershipMonth = {"January", "February", "March", "April", "May", "June", 
                   "July", "August", "September", "October", "November", "December"};
        membershipStartMonth = new JComboBox(membershipMonth);
        membershipStartMonth.setBounds(605,240,110,25);
        String [] membershipYear = {"1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999",
                                       "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009",
                                       "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019",
                                       "2020", "2021", "2022", "2023", "2024"};
        membershipStartYear = new JComboBox(membershipYear);
        membershipStartYear.setBounds(715,240,60,25);
        
        
        //referral source
        refferal = new JLabel("Refferal Source:");
        refferal.setBounds(413,280,100,25);
        refferalArea = new JTextArea();
        refferalArea.setBounds(520,280,275,50);
        
        
        //Status
        location = new JLabel("Location:");
        location.setBounds(48,280,60,25);
        locationText = new JTextField();
        locationText.setBounds(110,280,210,25);
        
        //plan price
        planPrice = new JLabel("Amount");
        planPrice.setBounds(50,320,60,25);
        planPriceArea = new JTextArea("Basic   :  6500\n" + "Standard   :  12500\n" + "Deluxe  :  18500");
        planPriceArea.setEditable(false);
        planPriceArea.setBounds(110,320,210,50);
        
        //button label part
        button = new JLabel("Buttons :");
        button.setBounds(30,30,100,25);
        button.setFont(new Font("Arial", Font.BOLD,15));
        button.setForeground(Color.decode("#FFFFFF"));
        
        //mark attendance
        markAttendance = new JButton("Mark Attendance");
        markAttendance.setBounds(150,45,170,25);
        markAttendance.setForeground(Color.decode("#FFFFFF"));
        markAttendance.setBackground(Color.decode("#00FF00"));
        //add/register
        markAttendance.addActionListener(this);
        
        //save to file
        rsavefile = new JButton("Save To File");
        rsavefile.setBounds(370,45,170,25);
        rsavefile.setForeground(Color.decode("#FFFFFF"));
        rsavefile.setBackground(Color.decode("#00ff00"));
        //add/register
        rsavefile.addActionListener(this);
        
        
        //read form file
        rreadfile = new JButton("Read From File");
        rreadfile.setBounds(370,95,170,25);
        rreadfile.setForeground(Color.decode("#FFFFFF"));
        rreadfile.setBackground(Color.decode("#00ff00"));
        rreadfile.addActionListener(this);
        
        //clearButton
        clearButton = new JButton("Clear");
        clearButton.setBounds(585,45,180,25);
        clearButton.addActionListener(this);
        clearButton.setForeground(Color.decode("#FFFFFF"));
        clearButton.setBackground(Color.decode("#00FF00"));
        
        //display button
        display = new JButton("Display");
        display.setBounds(150,95,170,25);
        display.setForeground(Color.decode("#FFFFFF"));
        display.setBackground(Color.decode("#00FF00"));
        //add/register
        display.addActionListener(this);
        
        //addbuttton
        addButton = new JButton("Add");
        addButton.setBounds(585,95,180,25);
        addButton.setForeground(Color.decode("#FFFFFF"));
        addButton.setBackground(Color.decode("#00FF00"));
        addButton.addActionListener(this);
        
        //button panel
        panelButton = new JPanel();
        panelButton.setBounds(0,400,840,240);
        panelButton.setLayout(null);
        panelButton.setBackground(Color.decode("#102770"));
        panelButton.add(button);
        panelButton.add(clearButton);
        panelButton.add(markAttendance);
        panelButton.add(rsavefile);
        panelButton.add(rreadfile);
        panelButton.add(display);
        panelButton.add(addButton);
        panelButton.setVisible(true);
        
        //display
        
        //panel
        panel.add(panelHeader);
        panel.add(panelButton);
        
        //greeding
        panel.add(greeding);
        
        //Guildline
        panel.add(guidLine);
        
        //Member
        panel.add(id);
        panel.add(idText);
        
        //phone
        panel.add(phone);
        panel.add(phoneText);
        
        //first name
        panel.add(firstName);
        panel.add(firstNameText);
        
        //DOB
        panel.add(date);
        panel.add(dayComboBox);
        panel.add(monthComboBox);
        panel.add(yearComboBox);
        
        //plan
        panel.add(plan);
        panel.add(planComboBox);
        
        //gender
        panel.add(gender);
        panel.add(male);
        panel.add(female);
        
        //email
        panel.add(email);
        panel.add(emailText);
        
        //membership start date
        panel.add(membershipStartDate);
        panel.add(membershipStartDay);
        panel.add(membershipStartMonth);
        panel.add(membershipStartYear);
        
        //refferal source
        panel.add(refferal);
        panel.add(refferalArea);
        
        //location
        panel.add(location);
        panel.add(locationText);
        
        //plan price
        panel.add(planPrice);
        panel.add(planPriceArea);
        
        
        panel.setBackground(Color.decode("#FFFFF0"));
        panel.setVisible(true);
        
        regularFrame.add(panel);
        regularFrame.add(sidePanel);
        regularFrame.setVisible(true);
    }
    
    //plan
    private void plan()
    {
        pldialog = new JDialog();
        pldialog.setBounds(200,200,400,200);
        pldialog.setLayout(null);
        
        pldlabel = new JLabel("Enter the ID :");
        pldlabel.setBounds(30,10,100,25);
        pldlabelfield = new JTextField();
        pldlabelfield.setBounds(30,45,200,25);
        
        
        //submit
        pldsubmit = new JButton("Submit");
        pldsubmit.setBounds(50,120,130,25);
        pldsubmit.setBackground(Color.decode("#A020F0"));
        //add/register
        pldsubmit.addActionListener(this);
        //frame part of dialog
        pldialog.add(pldlabel);
        pldialog.add(pldlabelfield);
        pldialog.add(pldsubmit);
        pldialog.setVisible(true);
    }
    
    //regular id Dialog active
    private void regularIdDialog()
    {
        //dialog
        dialog = new JDialog();
        dialog.setBounds(200,200,400,200);
        dialog.setLayout(null);
        
        dlabel = new JLabel("Enter the ID :");
        dlabel.setBounds(30,10,100,25);
        dlabelfield = new JTextField();
        dlabelfield.setBounds(30,45,200,25);
        
        
        //submit
        dsubmit = new JButton("Submit");
        dsubmit.setBounds(50,120,130,25);
        dsubmit.setBackground(Color.decode("#A020F0"));
        //add/register
        dsubmit.addActionListener(this);
        //frame part of dialog
        dialog.add(dlabel);
        dialog.add(dlabelfield);
        dialog.add(dsubmit);
        dialog.setVisible(true);
        
    }
    
    //deactive button of regular
    private void regularDeactive()
    {
        //dialog
        ddialog = new JDialog();
        ddialog.setResizable(false);
        ddialog.setBounds(200,200,400,200);
        ddialog.setLayout(null);
        
        ddlabel = new JLabel("Enter the ID :");
        ddlabel.setBounds(30,10,100,25);
        ddlabelfield = new JTextField();
        ddlabelfield.setBounds(30,45,200,25);
        
        
        //submit
        ddsubmit = new JButton("Submit");
        ddsubmit.setBounds(50,120,130,25);
        ddsubmit.setBackground(Color.decode("#A020F0"));
        //add/register
        ddsubmit.addActionListener(this);
        //frame part of dialog
        ddialog.add(ddlabel);
        ddialog.add(ddlabelfield);
        ddialog.add(ddsubmit);
        ddialog.setVisible(true);
        
    }
    
    //premiumDisplay
    private void predisplay()
    {
        //frame
        pdisplay = new JFrame();
        pdisplay.setLayout(null);  
        pdisplay.setSize(700, 400);
        
        click = new JButton("Click me!");
        click.setBounds(40, 20, 140, 30);
        click.setBackground(Color.decode("#0000ff"));
        click.setForeground(Color.decode("#FFFFFF"));
        click.addActionListener(this);
        
        // Create the text area first
        text = new JTextArea();
        text.setEditable(false);
        
        // scrollpane with the text area
        JScrollPane scrollPane = new JScrollPane(text);
        scrollPane.setBounds(50, 70, 600, 230);  
        
        // Display
        pdisplay.add(click);
        pdisplay.add(scrollPane);  
        
        pdisplay.setVisible(true);
    }
    
    
    // regular display
    private void regdisplay()
    {
        //frame
        rdisplay = new JFrame();
        rdisplay.setLayout(null); 
        rdisplay.setSize(700, 400);
        
        //Button
        rclick = new JButton("Click me!");
        rclick.setBounds(40, 20, 140, 30);
        rclick.setBackground(Color.decode("#0000ff"));
        rclick.setForeground(Color.decode("#FFFFFF"));
        rclick.addActionListener(this);
        
        // Textarea
        rtext = new JTextArea();
        rtext.setEditable(false);
        
        // ScrollPane
        JScrollPane scrollPane = new JScrollPane(rtext);
        scrollPane.setBounds(50, 70, 600, 230); 
        
        //Display
        rdisplay.add(rclick);
        rdisplay.add(scrollPane); 
        
        rdisplay.setVisible(true);
    }
    
    
    
    //method for premium
    private void premiumIdDialog()
    {
        //dialog
        premiumdialog = new JDialog();
        premiumdialog.setBounds(200,200,400,200);
        premiumdialog.setLayout(null);
        
        premiumlabel = new JLabel("Enter the ID :");
        premiumlabel.setBounds(30,10,100,25);
        premiumlabeltext = new JTextField();
        premiumlabeltext.setBounds(30,45,200,25);
        
        
        //submit
        premiumsubmit = new JButton("Submit");
        premiumsubmit.setBounds(50,120,130,25);
        premiumsubmit.setBackground(Color.decode("#A020F0"));
        //add/register
        premiumsubmit.addActionListener(this);
        //frame part of dialog
        premiumdialog.add(premiumlabel);
        premiumdialog.add(premiumlabeltext);
        premiumdialog.add(premiumsubmit);
        premiumdialog.setVisible(true);
        
    }
    //premium Deactive
    private void premiumdeactive()
    {
        //dialog
        ppremiumdialog = new JDialog();
        ppremiumdialog.setBounds(200,200,400,200);
        ppremiumdialog.setLayout(null);
        
        ppremiumlabel = new JLabel("Enter the ID :");
        ppremiumlabel.setBounds(30,10,100,25);
        ppremiumlabeltext = new JTextField();
        ppremiumlabeltext.setBounds(30,45,200,25);
        
        
        //submit
        ppremiumsubmit = new JButton("Submit");
        ppremiumsubmit.setBounds(50,120,130,25);
        ppremiumsubmit.setBackground(Color.decode("#A020F0"));
        //add/register
        ppremiumsubmit.addActionListener(this);
        //frame part of dialog
        ppremiumdialog.add(ppremiumlabel);
        ppremiumdialog.add(ppremiumlabeltext);
        ppremiumdialog.add(ppremiumsubmit);
        ppremiumdialog.setVisible(true);
        
    }
    
    private void dis()
    {
        //dialog
        disc = new JDialog();
        disc.setBounds(200,200,400,200);
        disc.setLayout(null);
        
        dislabel = new JLabel("Enter the ID :");
        dislabel.setBounds(30,10,100,25);
        dislabelfield = new JTextField();
        dislabelfield.setBounds(30,45,200,25);
        
        
        //submit
        dissubmit = new JButton("Submit");
        dissubmit.setBounds(50,120,130,25);
        dissubmit.setBackground(Color.decode("#A020F0"));
        //add/register
        dissubmit.addActionListener(this);
        //frame part of dialog
        disc.add(dislabel);
        disc.add(dislabelfield);
        disc.add(dissubmit);
        disc.setVisible(true);
    }
    
    private void premiumMemberForm()
    {
        //frame part of the regular member
        premiumFrame = new JFrame();
        premiumFrame.setSize(1040,591);
        premiumFrame.setResizable(false);
        premiumFrame.setLayout(null);
    
        
        //panel
        premiumPanel = new JPanel();
        premiumPanel.setSize(820,550);
        premiumPanel.setLayout(null);
        
        
        //title
        premiumTitle = new JLabel("Premium Member");
        premiumTitle.setBounds(320,15,200,30);
        premiumTitle.setFont(new Font("Arial",Font.BOLD,20));
        premiumTitle.setForeground(Color.decode("#FFFFF0"));
        
        //greeding
        premiumGreeding = new JLabel("Welcome !");
        premiumGreeding.setBounds(20,75,120,25);
        premiumGreeding.setFont(new Font("Times New Roman", Font.ITALIC,20));
        premiumGreeding.setForeground(Color.decode("#0000CD"));
        
        //guidline
        premiumGuildLine = new JLabel("You have choosen the Premium Package of LIGHT Fitness, please fill the form below: ");
        premiumGuildLine.setBounds(130,75,780,25);
        premiumGuildLine.setFont(new Font("Arial",Font.BOLD,13));
        
        //panelheader
        premiumPanelHeader = new JPanel();
        premiumPanelHeader.setBounds(0,0,840,60);
        premiumPanelHeader.setLayout(null);
        premiumPanelHeader.setBackground(Color.decode("#102770"));
        //add which you want to add
        premiumPanelHeader.add(premiumTitle);
        premiumPanelHeader.setVisible(true);
        
        //premiumSide panel
        premiumSidePanel = new JPanel();
        premiumSidePanel.setBounds(822,0,591,200);
        premiumSidePanel.setSize(200,550);
        premiumSidePanel.setLayout(null);
        premiumSidePanel.setBackground(Color.decode("#102770"));
        
        //status
        premiumStatus = new JLabel("Status :");
        premiumStatus.setBounds(7,120,100,25);
        premiumStatus.setForeground(Color.decode("#ffffff"));
        
        //active membership
        premiumActiveMembership = new JButton("Activate Membership");
        premiumActiveMembership.setBounds(7,165,180,25);
        premiumActiveMembership.setForeground(Color.decode("#FFFFFF"));
        premiumActiveMembership.setBackground(Color.decode("#FFA500"));
        //add/register
        premiumActiveMembership.addActionListener(this);
        
        //deactive membership
        premiumDeactiveMembership = new JButton("Deactivate Membership");
        premiumDeactiveMembership.setBounds(7,215,180,25);
        premiumDeactiveMembership.setForeground(Color.decode("#FFFFFF"));
        premiumDeactiveMembership.setBackground(Color.decode("#FFA500"));
        //add/register
        premiumDeactiveMembership.addActionListener(this);
        
        
        //label part of revert
        premiumrevertlabel = new JLabel("Revert And Discount:");
        premiumrevertlabel.setBounds(7,276,200,25);
        premiumrevertlabel.setForeground(Color.decode("#ffffff"));
        
        
        //Button
        prerevert = new JButton("Revert");
        prerevert.setBounds(7,318,180,25);
        prerevert.setForeground(Color.decode("#ffffff"));
        prerevert.setBackground(Color.decode("#FFA500"));
        //add/register button
        prerevert.addActionListener(this);
        
        
        
        //discount button
        calculateDiscount = new JButton("Calculate Discount");
        calculateDiscount.setBounds(7,368,180,25);
        calculateDiscount.setForeground(Color.decode("#ffffff"));
        calculateDiscount.setBackground(Color.decode("#FFA500"));
        //add/register
        calculateDiscount.addActionListener(this);
        
        //discount label
        labelread = new JLabel("Read From File :");
        labelread.setBounds(7,418,200,25);
        labelread.setForeground(Color.decode("#ffffff"));
        
        //read from file
        preadfile = new JButton("Read From File");
        preadfile.setBounds(7,458,180,25);
        preadfile.setForeground(Color.decode("#ffffff"));
        preadfile.setBackground(Color.decode("#FFA500"));
        preadfile.addActionListener(this);
        
        //frame of premiumsidepanel
        premiumSidePanel.add(premiumStatus);
        premiumSidePanel.add(premiumActiveMembership);
        premiumSidePanel.add(premiumDeactiveMembership);
        premiumSidePanel.add(premiumrevertlabel);
        premiumSidePanel.add(prerevert);
        premiumSidePanel.add(labelread);
        premiumSidePanel.add(calculateDiscount);
        premiumSidePanel.add(preadfile);
                
        // id / textfield
        premiumId = new JLabel("ID:");
        premiumId.setBounds(83,120,17,25);
        premiumIdText = new JTextField();
        premiumIdText.setBounds(110,120,100,25);
        
        //phone
        premiumPhone = new JLabel("Phone:");
        premiumPhone.setBounds(610,120,60,25);
        premiumPhoneText = new JTextField();
        premiumPhoneText.setBounds(665,120,120,25);
        
        //firstname/textfield
        premiumFirstName = new JLabel("Full Name:");
        premiumFirstName.setBounds(35,160,70,25);
        premiumFirstNameText = new JTextField();
        premiumFirstNameText.setBounds(110,160,250,25);
        //DOB
        premiumDate = new JLabel("Date Of Birth:");
        premiumDate.setBounds(410,160,80,25);
        String [] day = {"31","30", "29", "28", "27", "26", "25", "24", "23", "22", "21",
                         "20", "19", "18", "17", "16", "15", "14", "13", "12", "11",
                         "10", "9", "8", "7", "6", "5", "4", "3", "2", "1"};
        premiumDay = new JComboBox(day);
        premiumDay.setBounds(500,160,70,30);
        String [] month = {"January", "February", "March", "April", "May", "June", 
                   "July", "August", "September", "October", "November", "December"};
        premiumMonth = new JComboBox(month);
        premiumMonth.setBounds(570,160,115,30);
        String [] year = {"1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979",
                         "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989",
                         "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999",
                         "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007"};
        premiumYear = new JComboBox(year);
        premiumYear.setBounds(685,160,78,30);
    
        
        //gender
        premiumGender = new JLabel("Gender:");
        premiumGender.setBounds(50,200,50,25);
        premiumMale = new JRadioButton("Male");
        premiumMale.setBounds(110,200,60,25);
        premiumMale.setSelected(true);
        premiumFemale = new JRadioButton("Female");
        premiumFemale.setBounds(180,200,70,25);
        premiumGenderButtonGroup = new ButtonGroup();
        premiumGenderButtonGroup.add(premiumMale);
        premiumGenderButtonGroup.add(premiumFemale);
        
        
        //email/textfield
        premiumEmail = new JLabel("Email:");
        premiumEmail.setBounds(63,240,37,25);
        premiumEmailText = new JTextField();
        premiumEmailText.setBounds(110,240,210,25);
        
        //membership start date
        premiumMembershipStartDate = new JLabel("Membership Start Date:");
        premiumMembershipStartDate.setBounds(350,240,140,25);
        String [] membershipDay = {"31","30", "29", "28", "27", "26", "25", "24", "23", "22", "21",
                                          "20", "19", "18", "17", "16", "15", "14", "13", "12", "11",
                                          "10", "9", "8", "7", "6", "5", "4", "3", "2", "1"};
        premiumMembershipStartDay = new JComboBox(membershipDay);
        premiumMembershipStartDay.setBounds(500,240,70,25);
        String[] membershipMonth = {"January", "February", "March", "April", "May", "June", 
                   "July", "August", "September", "October", "November", "December"};
        premiumMembershipStartMonth = new JComboBox(membershipMonth);
        premiumMembershipStartMonth.setBounds(570,240,115,25);
        String [] membershipYear = {"1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999",
                                       "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009",
                                       "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019",
                                       "2020", "2021", "2022", "2023", "2024"};
        premiumMembershipStartYear = new JComboBox(membershipYear);
        premiumMembershipStartYear.setBounds(685,240,80,25);
        
        
        //referral source
        premiumTrainer = new JLabel("Personal Trainer:");
        premiumTrainer.setBounds(387,280,107,25);
        premiumTrainerText = new JTextField();
        premiumTrainerText.setBounds(500,280,285,25);
        
        
        //Status
        premiumLocation = new JLabel("Location:");
        premiumLocation.setBounds(48,280,60,25);
        premiumLocationText = new JTextField();
        premiumLocationText.setBounds(110,280,210,25);
        
        //planchange
        premiumPlanCharge = new JLabel("Payment:"); 
        premiumPlanCharge.setBounds(45,320,60,25);
        premiumPlanChargeArea = new JTextArea("Total Amount  :  50000");
        premiumPlanChargeArea.setEditable(false);
        premiumPlanChargeArea.setBounds(110,320,150,25);
        
        //discountAmount
        premiumDiscount = new JLabel("Discount:");
        premiumDiscount.setBounds(430,320,70,25);
        premiumDiscountArea = new JTextArea("if payment  ==  fullPayment  (i.e 50000)\n"+"discount == 10%\n" + "totalDiscount == 5000");
        premiumDiscountArea.setBounds(500,320,285,50);
        premiumDiscountArea.setEditable(false);
        
        //button label part
        premiumLabelButton = new JLabel("Buttons :");
        premiumLabelButton.setBounds(40,30,100,25);
        premiumLabelButton.setFont(new Font("Arial", Font.BOLD,15));
        premiumLabelButton.setForeground(Color.decode("#FFFFFF"));
        
        //due button
        premiumDueButton = new JButton("Due Payment");
        premiumDueButton.setBounds(360,55,150,25);
        premiumDueButton.setForeground(Color.decode("#FFFFFF"));
        premiumDueButton.setBackground(Color.decode("#FFA500"));
        //add/ register
        premiumDueButton.addActionListener(this);
        
        //mark attendance
        premiumMarkAttendance = new JButton("Mark Attendance");
        premiumMarkAttendance.setBounds(110,55,150,25);
        premiumMarkAttendance.setForeground(Color.decode("#FFFFFF"));
        premiumMarkAttendance.setBackground(Color.decode("#FFA500"));
        //add/register
        premiumMarkAttendance.addActionListener(this);
        
        
        //clearButton
        premiumClearButton = new JButton("Clear");
        premiumClearButton.setBounds(625,55,150,25);
        premiumClearButton.setForeground(Color.decode("#FFFFFF"));
        premiumClearButton.setBackground(Color.decode("#FFA500"));
        //actionListener
        premiumClearButton.addActionListener(this);
        
        //display button
        premiumDisplay = new JButton("Display");
        premiumDisplay.setBounds(110,100,150,25);
        premiumDisplay.setForeground(Color.decode("#FFFFFF"));
        premiumDisplay.setBackground(Color.decode("#FFA500"));
        //add/register
        premiumDisplay.addActionListener(this);
        
        
        //addbuttton
        premiumAddButton = new JButton("Add");
        premiumAddButton.setBounds(360,100,150,25);
        premiumAddButton.setForeground(Color.decode("#FFFFFF"));
        premiumAddButton.setBackground(Color.decode("#FFA500"));
        //addlistener
        premiumAddButton.addActionListener(this);
        
        //save to file
        psavefile = new JButton("Save To File");
        psavefile.setBounds(625,100,150,25);
        psavefile.setForeground(Color.decode("#ffffff"));
        psavefile.setBackground(Color.decode("#FFA500"));
        //add/register
        psavefile.addActionListener(this);
        
        //button panel
        panelButton = new JPanel();
        panelButton.setBounds(0,400,840,240);
        panelButton.setLayout(null);
        panelButton.setVisible(true);
        panelButton.setBackground(Color.decode("#102770"));
        panelButton.add(premiumLabelButton);
        panelButton.add(premiumClearButton);
        panelButton.add(premiumMarkAttendance);
        panelButton.add(premiumDueButton);
        panelButton.add(premiumDisplay);
        panelButton.add(premiumAddButton);
        panelButton.add(psavefile);
        
        //display
        
        //panel
        premiumPanel.add(premiumPanelHeader);
        premiumPanel.add(panelButton);
        
        //greeding
        premiumPanel.add(premiumGreeding);
        
        //Guildline
        premiumPanel.add(premiumGuildLine);
        
        //Member
        premiumPanel.add(premiumId);
        premiumPanel.add(premiumIdText);
        
        //phone
        premiumPanel.add(premiumPhone);
        premiumPanel.add(premiumPhoneText);
        
        //first name
        premiumPanel.add(premiumFirstName);
        premiumPanel.add(premiumFirstNameText);
        //DOB
        premiumPanel.add(premiumDate);
        premiumPanel.add(premiumDay);
        premiumPanel.add(premiumMonth);
        premiumPanel.add(premiumYear);
        
        //gender
        premiumPanel.add(premiumGender);
        premiumPanel.add(premiumMale);
        premiumPanel.add(premiumFemale);
        
        //email
        premiumPanel.add(premiumEmail);
        premiumPanel.add(premiumEmailText);
        
        //membership start date
        premiumPanel.add(premiumMembershipStartDate);
        premiumPanel.add(premiumMembershipStartDay);
        premiumPanel.add(premiumMembershipStartMonth);
        premiumPanel.add(premiumMembershipStartYear);
        
        //refferal source
        premiumPanel.add(premiumTrainer);
        premiumPanel.add(premiumTrainerText);
        
        //location
        premiumPanel.add(premiumLocation);
        premiumPanel.add(premiumLocationText);
        
        //planchange
        premiumPanel.add(premiumPlanCharge);
        premiumPanel.add(premiumPlanChargeArea);
        
        //discount
        premiumPanel.add(premiumDiscount);
        premiumPanel.add(premiumDiscountArea);
        
        premiumPanel.setBackground(Color.decode("#f1c27d"));
        premiumPanel.setVisible(true);
        
        premiumFrame.add(premiumPanel);
        premiumFrame.add(premiumSidePanel);
        premiumFrame.setVisible(true);
    }
    
    public static void main(String []args)
    {
        new GymGUI();
    }
}