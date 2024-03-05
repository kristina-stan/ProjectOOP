public class Discount {

    private User user;
    private Ticket ticket;

    Discount(User user, Ticket ticket){
        this.user = user;
        this.ticket = ticket;
    }

    public void checkDiscount(){
        double ticketPrice = ticket.getPrice();
        ticket.setPrice(ticketPrice - halfDiscount());
    }


    public double halfDiscount(){
        if(user.getAge() >= 7 && user.getAge() <= 12){
            return ticket.getPrice() * 50/100;
        }
        else if(user.getAge() >= 64 && user.getSex() == 'M'){
            return 50/100;
        }
        else if(user.getAge() >= 61 && user.getSex() == 'W'){
            return 50/100;
        }
        // student document
        return ticket.getPrice();

    }

}
